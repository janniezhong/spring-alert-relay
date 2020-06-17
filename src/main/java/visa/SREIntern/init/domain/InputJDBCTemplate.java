package visa.SREIntern.init.domain;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import visa.SREIntern.init.mappers.InputMapper;
import visa.SREIntern.init.repositories.InputRecordDAO;

public class InputJDBCTemplate implements InputRecordDAO {
    private DataSource dataSource;
    private SimpleJdbcCall jdbcCall;
    private  JdbcTemplate jdbcTemplateObject;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcCall =  new SimpleJdbcCall(dataSource).withProcedureName("getRecord");
    }

    @Override
    public void create(String test_name, String test_run_id, Boolean result, Date started_at, Date finished_at, Integer response_time_ms, Integer test_origin) {
        jdbcTemplateObject = new JdbcTemplate(dataSource);
        String SQL = "insert into input (test_name, test_run_id, result, started_at, finished_at, response_time_ms, test_origin) values (?, ?, ?, ?, ?, ?, ?)";

        jdbcTemplateObject.update( SQL, test_name, test_run_id, result, started_at, finished_at, response_time_ms, test_origin);
        System.out.println("Created Record Test Name = " + test_name + " Result = " + result + ", Start Time = " + started_at + ", End Time = " + finished_at + ", Response Time = " + response_time_ms + ", Test Type = " + test_origin);
        return;
    }

    @Override
    public InputRecord getRecord(Integer id) {

        SqlParameterSource in = new MapSqlParameterSource().addValue("in_id", id);
        Map<String, Object> out = jdbcCall.execute(in);


        InputRecord input = new InputRecord();
        input.setId(id);
        input.setTest_name((String) out.get("test_name"));
        input.setTest_run_id((String) out.get("test_run_id"));
        input.setResult((Boolean) out.get("result"));
        input.setStarted_at((Date) out.get("started_at"));
        input.setFinished_at((Date) out.get("finished_at"));
        input.setResponse_time_ms((Integer) out.get("response_time_ms"));
        input.setTest_origin((Integer) out.get("test_origin"));
        return input;

    }

    @Override
    public List<InputRecord> listRecords() {
        String SQL = "select * from Student";
        List <InputRecord> records = jdbcTemplateObject.query(SQL, new InputMapper());
        return records;
    }


}

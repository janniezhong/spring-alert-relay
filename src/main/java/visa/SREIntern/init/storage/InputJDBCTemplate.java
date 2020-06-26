package visa.SREIntern.init.storage;
import java.sql.Timestamp;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.object.StoredProcedure;
import visa.SREIntern.init.mappers.InputMapper;

/**
 * Represents a template to interact with the database.
 */
public class InputJDBCTemplate implements InputRecordDAO {
    private DataSource dataSource;
    private SimpleJdbcCall jdbcCall;
    private  JdbcTemplate jdbcTemplateObject;

    /**
     * @param dataSource the DataSource to interact with.
     */
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);

        this.jdbcCall =  new SimpleJdbcCall(dataSource)
                .withProcedureName("RP_INST_ALERT")
                .withoutProcedureColumnMetaDataAccess()
                .declareParameters(
                    new SqlParameter("v_alert_id", Types.BIGINT),
                    new SqlParameter("v_category", Types.VARCHAR),
                    new SqlParameter("v_component", Types.VARCHAR),
                    new SqlParameter("v_priority", Types.VARCHAR),
                    new SqlParameter("v_source", Types.VARCHAR),
                    new SqlParameter("v_alert_time", Types.TIMESTAMP),
                    new SqlParameter("v_title", Types.VARCHAR),
                    new SqlParameter("v_link", Types.VARCHAR),
                    new SqlParameter("v_result_count", Types.DOUBLE),
                        new SqlOutParameter("RETURN_CODE", Types.INTEGER),
                        new SqlOutParameter("ERR_MSG", Types.VARCHAR)
                );
    }

    @Override
    public void create(Long alert_id,
                       String category,
                       String component,
                       String priority,
                       String alert_source,
                       Timestamp alert_time,
                       String alert_title,
                       String results_link,
                       Double error_count) {

//        try {
//            InputProcedure inputProcedure = new InputProcedure(dataSource, "RP_INST_ALERT");
//            inputProcedure.execute(alert_id, category, component, priority, alert_source, alert_time, alert_title, results_link, error_count);
//        } catch(Exception e){
//            System.out.println(e);
//        }



        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("v_alert_id", alert_id)
                .addValue("v_category", category)
                .addValue("v_component", component)
                .addValue("v_priority", priority)
                .addValue("v_source", alert_source)
                .addValue("v_alert_time", alert_time)
                .addValue("v_title", alert_title)
                .addValue("v_link", results_link)
                .addValue("v_result_count", error_count);

        Map<String, Object> out = jdbcCall.execute(in);
        int return_code = (int) out.get("RETURN_CODE");
        String err_msg = (String) out.get("ERR_MSG");
        System.out.println("Return code: " + return_code + ", error message: " + err_msg);

//        jdbcTemplateObject = new JdbcTemplate(dataSource);
//        String SQL = "insert into input (test_name, test_run_id, result, started_at, finished_at, response_time_ms, test_origin) values (?, ?, ?, ?, ?, ?, ?)";
//
//        jdbcTemplateObject.update( SQL, test_name, test_run_id, result, started_at, finished_at, response_time_ms, test_origin);
//        System.out.println("Created Record Test Name = " + test_name + " Result = " + result + ", Start Time = " + started_at + ", End Time = " + finished_at + ", Response Time = " + response_time_ms + ", Test Type = " + test_origin);
//        return;
    }

//    class InputProcedure extends StoredProcedure {
//        public InputProcedure(DataSource dataSource, String procedureName) {
//            super(dataSource,procedureName);
//
//            declareParameter(new SqlParameter("v_alert_id", Types.BIGINT));
//            declareParameter(new SqlParameter("v_category", Types.VARCHAR));
//            declareParameter(new SqlParameter("v_component", Types.VARCHAR));
//            declareParameter(new SqlParameter("v_priority", Types.VARCHAR));
//            declareParameter(new SqlParameter("v_source", Types.VARCHAR));
//            declareParameter(new SqlParameter("v_alert_time", Types.TIMESTAMP));
//            declareParameter(new SqlParameter("v_title", Types.VARCHAR));
//            declareParameter(new SqlParameter("v_link", Types.VARCHAR));
//            declareParameter(new SqlParameter("v_result_count", Types.DOUBLE));
//            compile();
//        }
//        public void execute(Long alert_id,
//                            String category,
//                            String component,
//                            String priority,
//                            String alert_source,
//                            Timestamp alert_time,
//                            String alert_title,
//                            String results_link,
//                            Double error_count){
////            SqlParameterSource in = new MapSqlParameterSource()
////                    .addValue("v_alert_id", alert_id)
////                    .addValue("v_category", category)
////                    .addValue("v_component", component)
////                    .addValue("v_priority", priority)
////                    .addValue("v_source", alert_source)
////                    .addValue("v_alert_time", alert_time)
////                    .addValue("v_title", alert_title)
////                    .addValue("v_link", results_link)
////                    .addValue("v_result_count", error_count);
//
//            Map<String, Object> in = new HashMap<>();
//            in.put("v_alert_id", alert_id);
//            in.put("v_category", category);
//            in.put("v_component", component);
//            in.put("v_priority", priority);
//            in.put("v_source", alert_source);
//            in.put("v_alert_time", alert_time);
//            in.put("v_title", alert_title);
//            in.put("v_link", results_link);
//            in.put("v_result_count", error_count);
//
//            Map<String, Object> out = super.execute(in);
//            int return_code = (int) out.get("RETURN_CODE");
//            String err_msg = (String) out.get("ERR_MSG");
//            System.out.println("Return code: " + return_code + ", error message: " + err_msg);
//
//        }
//    }




//    @Override
//    public InputRecord getRecord(Integer id) {
//
//        SqlParameterSource in = new MapSqlParameterSource().addValue("in_id", id);
//        Map<String, Object> out = jdbcCall.execute(in);
//
//
//        InputRecord input = new InputRecord();
//        input.setId(id);
//        input.setTest_name((String) out.get("test_name"));
//        input.setTest_run_id((String) out.get("test_run_id"));
//        input.setResult((Boolean) out.get("result"));
//        input.setStarted_at((Timestamp) out.get("started_at"));
//        input.setFinished_at((Timestamp) out.get("finished_at"));
//        input.setResponse_time_ms((Integer) out.get("response_time_ms"));
//        input.setTest_origin((Integer) out.get("test_origin"));
//        return input;
//
//    }
//
//    @Override
//    public List<InputRecord> listRecords() {
//        String SQL = "select * from Input";
//        List <InputRecord> records = jdbcTemplateObject.query(SQL, new InputMapper());
//        return records;
//    }


}

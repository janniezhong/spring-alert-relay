package visa.SREIntern.init.mappers;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import visa.SREIntern.init.domain.InputRecord;

public class InputMapper implements RowMapper<InputRecord>{

    @Override
    public InputRecord mapRow(ResultSet rs, int i) throws SQLException {
        InputRecord input = new InputRecord();
        input.setId(rs.getInt("id"));
        input.setTest_name(rs.getString("test_name"));
        input.setTest_run_id(rs.getString("test_run_id"));
        input.setResult(rs.getBoolean("result"));
        input.setStarted_at(rs.getTimestamp("started_at"));
        input.setFinished_at(rs.getTimestamp("finished_at"));
        input.setResponse_time_ms(rs.getInt("response_time_ms"));
        input.setTest_origin(rs.getInt("test_origin"));

        return input;
    }
}

package visa.SREIntern.init.mappers;


import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;


import org.springframework.jdbc.core.RowMapper;
import visa.SREIntern.init.storage.InputRecord;

/**
 * Maps a MySQL row to an InputRecord object.
 */
public class InputMapper implements RowMapper<InputRecord>{

    @Override
    public InputRecord mapRow(ResultSet rs, int i) throws SQLException {
        InputRecord input = new InputRecord();

        input.setAlert_id(new BigInteger(Integer.valueOf(rs.getInt("ALERT_ID")).toString()));
        input.setCategory(rs.getString("CATEGORY"));
        input.setComponent(rs.getString("COMPONENT"));
        input.setPriority(rs.getString("PRIORITY"));
        input.setAlert_source(rs.getString("ALERT_SOURCE"));
        input.setAlert_time(rs.getTimestamp("ALERT_TIME"));
        input.setAlert_title(rs.getString("ALERT_TITLE"));
        input.setResults_link(rs.getString("RESULTS_LINK"));
        input.setError_count(rs.getDouble("ERROR_COUNT"));

        return input;
    }
}

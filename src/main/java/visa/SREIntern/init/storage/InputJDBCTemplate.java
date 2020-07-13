package visa.SREIntern.init.storage;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.object.StoredProcedure;
import visa.SREIntern.init.AlertRelayApplication;
import visa.SREIntern.init.domain.Input;
import visa.SREIntern.init.mappers.InputMapper;

/**
 * Represents a template to interact with the database.
 */
public class InputJDBCTemplate implements InputRecordDAO {
    private static final Logger LOGGER = LogManager.getLogger(InputJDBCTemplate.class);

    private DataSource dataSource;
    private SimpleJdbcCall jdbcCall;
    private  JdbcTemplate jdbcTemplateObject;

    /**
     * Method to set the data source of this template.
     * @param dataSource the DataSource to interact with.
     * Also sets the jdbcCall variable to have access to a certain stored procedure.
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
    public void create(BigInteger alert_id,
                       String category,
                       String component,
                       String priority,
                       String alert_source,
                       Timestamp alert_time,
                       String alert_title,
                       String results_link,
                       Double error_count) {

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

        if (return_code == 0){
            LOGGER.info("Database entry successful, with no errors. Input was: "+ in.toString());
        } else {
            LOGGER.error("Database entry attempted, and unsuccessful. Results were: return code: "+ return_code + ", error message: " + err_msg);

        }

    }


}

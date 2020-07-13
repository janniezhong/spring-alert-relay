package visa.SREIntern.init.domain;

import visa.SREIntern.init.storage.InputJDBCTemplate;
import java.math.BigInteger;

import java.sql.Timestamp;

/**
 * Abstract class representing any input payload.
 * @author janniezhong
 */
public abstract class Input {

    private BigInteger alert_id;
    private String category;
    private String component;
    private String priority;
    private String alert_source;
    private Timestamp alert_time;
    private String alert_title;
    private String results_link;
    private Double error_count;

    /**
     * Constructs an empty instance of the Input class.
     */
    public Input() {
    }


    /**
     * Inputs given data into {@link InputJDBCTemplate}
     * @param inputJDBCTemplate template in which to insert this class' data.
     */
    public void inputData(InputJDBCTemplate inputJDBCTemplate) {
        inputJDBCTemplate.create(alert_id,
                category,
                component,
                priority,
                alert_source,
                alert_time,
                alert_title,
                results_link,
                error_count);

    }

    public BigInteger getAlert_id() {
        return alert_id;
    }

    public void setAlert_id(BigInteger alert_id) {
        this.alert_id = alert_id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getAlert_source() {
        return alert_source;
    }

    public void setAlert_source(String alert_source) {
        this.alert_source = alert_source;
    }

    public Timestamp getAlert_time() {
        return alert_time;
    }

    public void setAlert_time(Timestamp alert_time) {
        this.alert_time = alert_time;
    }

    public String getAlert_title() {
        return alert_title;
    }

    public void setAlert_title(String alert_title) {
        this.alert_title = alert_title;
    }

    public String getResults_link() {
        return results_link;
    }

    public void setResults_link(String results_link) {
        this.results_link = results_link;
    }

    public Double getError_count() {
        return error_count;
    }

    public void setError_count(Double error_count) {
        this.error_count = error_count;
    }

    @Override
    public String toString() {
        return "Input {" +
                "alert_id=" + alert_id +
                ", category='" + category + '\'' +
                ", component='" + component + '\'' +
                ", priority='" + priority + '\'' +
                ", alert_source='" + alert_source + '\'' +
                ", alert_time=" + alert_time +
                ", alert_title='" + alert_title + '\'' +
                ", results_link='" + results_link + '\'' +
                ", error_count=" + error_count +
                '}';
    }


}

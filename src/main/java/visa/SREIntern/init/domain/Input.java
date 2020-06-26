package visa.SREIntern.init.domain;

import visa.SREIntern.init.storage.InputJDBCTemplate;

import java.sql.Timestamp;

/**
 * Abstract class representing any input payload.
 * @author janniezhong
 */
public abstract class Input {

    private Long alert_id;
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
     * Creates an instance of the Input class with the given parameters.
     * @param alert_id
     * @param category
     * @param component
     * @param priority
     * @param alert_source
     * @param alert_time
     * @param alert_title
     * @param results_link
     * @param error_count
     */
    public Input(Long alert_id, String category, String component, String priority, String alert_source, Timestamp alert_time, String alert_title, String results_link, Double error_count) {
        this.alert_id = alert_id;
        this.category = category;
        this.component = component;
        this.priority = priority;
        this.alert_source = alert_source;
        this.alert_time = alert_time;
        this.alert_title = alert_title;
        this.results_link = results_link;
        this.error_count = error_count;
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

    public Long getAlert_id() {
        return alert_id;
    }

    public void setAlert_id(Long alert_id) {
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
        return "Input{" +
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

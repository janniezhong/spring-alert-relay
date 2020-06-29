package visa.SREIntern.init.exceptions;


/**
 * Class to use as an intermediary between the {@link CustomException} and {@link ExceptionInterceptor}
 */
public class CustomExceptionSchema {

    private String message;

    /**
     * Creates an empty instance of the CustomExceptionSchema
     */
    protected CustomExceptionSchema() {}

    /**
     * Creates an instance of the CustomExceptionSchema containing the message.
     * @param message message from the exception
     */
    public CustomExceptionSchema(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
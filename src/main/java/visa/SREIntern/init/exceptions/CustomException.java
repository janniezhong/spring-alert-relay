package visa.SREIntern.init.exceptions;

import org.springframework.http.*;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

//@ResponseStatus(HttpStatus.BAD_REQUEST)

/**
 * Custom exception class to make returned exceptions more readable.
 */
public class CustomException extends RuntimeException {
    private String message;


    /**
     * Creates an exception with the given message.
     * @param message The message that the exception will display.
     */
    public CustomException(String message){
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
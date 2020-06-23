package visa.SREIntern.init.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Class to intercept the ResponseEntityExceptionHandler.
 */
@ControllerAdvice
public class ExceptionInterceptor extends ResponseEntityExceptionHandler {
    /**
     * Redirects all ResponseEntityExceptionHandler calls to {@link visa.SREIntern.init.exceptions.CustomException}
     * @param ex the CustomException to redirect to.
     * @return a ResponseEntity containing the CustomException and a HTTP status code.
     */
    @ExceptionHandler(CustomException.class)
    public final ResponseEntity<Object> handleAllExceptions(CustomException ex) {
        CustomExceptionSchema exceptionResponse =
                new CustomExceptionSchema(ex.getMessage());
        return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
}

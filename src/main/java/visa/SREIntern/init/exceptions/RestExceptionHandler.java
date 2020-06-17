package visa.SREIntern.init.exceptions;

import org.springframework.http.*;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
//    @ExceptionHandler(NoHandlerFoundException.class)
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    public @ResponseBody ResponseEntity<ErrorResponse> handleNoMethodException(HttpServletRequest request,
//                                                                               NoHandlerFoundException ex) {
//        ErrorResponse errorResponse = new ErrorResponse(ex);
//        errorResponse.setErrorMessage("resource not found with exception");
//        return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.NOT_FOUND);
//    }
//
//    @ExceptionHandler(Throwable.class)
//    public @ResponseBody ResponseEntity<ErrorResponse> handleDefaultException(Throwable ex) {
//        ErrorResponse errorResponse = new ErrorResponse(ex);
//        errorResponse.setErrorMessage("request has empty body  or exception occured");
//        return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
//    }
//    @Override
//    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
//        MyErrorResponse errorResponse = new MyErrorResponse("request has empty body");
//        return new ResponseEntity<MyErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
//    }
}
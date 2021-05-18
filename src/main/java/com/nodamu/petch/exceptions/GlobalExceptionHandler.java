package com.nodamu.petch.exceptions;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Objects;

/**
 * @author profnick
 * 5/13/21
 **/

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    public static final String TRACE = "trace";

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Value("${petch.trace:false}")
    private boolean printStackTrace;

    @Override
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.UNPROCESSABLE_ENTITY.value(),
                "Validation error. Check 'errors' field for details."
        );

        for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
            errorResponse.addValidationError(fieldError.getField(),
                    fieldError.getDefaultMessage());
        }
        return ResponseEntity.unprocessableEntity().body(errorResponse);

    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Object> handleAllUncaughtException(Exception exception, WebRequest request) {
        log.error("Unknown error occurred", exception);
        return buildErrorResponse(exception, "Unknown error occurred", HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    @ExceptionHandler(PropertyDoesNotExistException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Object> handleNoPropertyFound(Exception exception,WebRequest request){
        log.error("Property with ID : {}, does not exist {}",request.getParameterValues("propertyId"),exception);
        return buildErrorResponse(exception, "Property does not exist", HttpStatus.NOT_FOUND, request);

    }

    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ResponseEntity<Object> handleAccessDenied(AccessDeniedException e, WebRequest request){
        log.error("User forbidden to make request");
        return  buildErrorResponse(e,HttpStatus.FORBIDDEN,request);
    }

//    @ExceptionHandler(.class)
//    @ResponseStatus(HttpStatus.FORBIDDEN)
//    public ResponseEntity<Object> handleUnAuthorized(AccessDeniedException e, WebRequest request){
//        log.error("User unauthorized to make request");
//        return  buildErrorResponse(e,HttpStatus.UNAUTHORIZED,request);
//    }

    @Override
    public ResponseEntity<Object> handleExceptionInternal(Exception ex,
                                                         Object body,
                                                         HttpHeaders headers,
                                                         HttpStatus status,
                                                         WebRequest request) {
        return buildErrorResponse(ex,status,request);
    }

    private ResponseEntity<Object> buildErrorResponse(Exception exception,
                                                      HttpStatus httpStatus,
                                                      WebRequest request) {
        return buildErrorResponse(exception, exception.getMessage(), httpStatus, request);
    }

    private ResponseEntity<Object> buildErrorResponse(Exception exception,
                                                      String message,
                                                      HttpStatus httpStatus,
                                                      WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(httpStatus.value(), message);
        if (printStackTrace && isTraceOn(request)) {
            errorResponse.setStackTrace(ExceptionUtils.getStackTrace(exception));
        }
        return ResponseEntity.status(httpStatus).body(errorResponse);
    }

    private boolean isTraceOn(WebRequest request) {
        String [] value = request.getParameterValues(TRACE);
        if (!Objects.nonNull(value)) return false;
        // Check for null pointer
        assert value != null;
        return value.length > 0
                && value[0].contentEquals("true");
    }


}

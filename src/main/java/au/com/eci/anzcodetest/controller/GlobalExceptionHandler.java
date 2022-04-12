package au.com.eci.anzcodetest.controller;

import au.com.eci.anzcodetest.api.ErrorResponse;
import au.com.eci.anzcodetest.model.UserAccountNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

/**
 * Global setup to provide API responses for error scenarios.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    static final String NOT_FOUND_ID = "NotFound";
    static final String SYSTEM_ERROR_ID = "SystemError";

    @ExceptionHandler(UserAccountNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorResponse handleUserAccountNotFound(UserAccountNotFoundException ex, WebRequest request) {
        return new ErrorResponse(NOT_FOUND_ID, ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleServerError(Exception ex, WebRequest request) {
        return new ErrorResponse(SYSTEM_ERROR_ID, ex.getMessage());
    }

}

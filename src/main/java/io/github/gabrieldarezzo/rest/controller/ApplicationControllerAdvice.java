package io.github.gabrieldarezzo.rest.controller;
import io.github.gabrieldarezzo.exception.BusinessRuleException;
import io.github.gabrieldarezzo.exception.CustomException;
import io.github.gabrieldarezzo.rest.ApiErrors;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(CustomException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors handleCustomException(CustomException ex) {
        String messageError = ex.getMessage();
        return new ApiErrors(messageError);
    }

    @ExceptionHandler(BusinessRuleException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiErrors handleBusinessException(BusinessRuleException ex) {
        String messageError = ex.getMessage();
        return new ApiErrors(messageError);
    }

}

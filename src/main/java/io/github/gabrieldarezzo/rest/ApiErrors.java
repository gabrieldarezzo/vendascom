package io.github.gabrieldarezzo.rest;


import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Arrays;
import java.util.List;


public class ApiErrors {

    @Getter
    private List<String> errors;
    public ApiErrors(String messageError) {
        this.errors = Arrays.asList(messageError);
    }


}

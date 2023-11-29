package com.example.demo.model.exception;

import com.example.demo.model.domain.EValidation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ResourceNotFoundException extends ExceptionAbstract {
    public ResourceNotFoundException(EValidation validation, String... params) {
        super(validation, params);
    }
}

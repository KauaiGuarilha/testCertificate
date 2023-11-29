package com.example.demo.model.exception;

import com.example.demo.model.domain.EValidation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class PasswordNotFoundException extends ExceptionAbstract{
    public PasswordNotFoundException(EValidation validation, String... params) {
        super(validation, params);
    }
}

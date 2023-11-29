package com.example.demo.model.exception;

import com.example.demo.model.domain.EValidation;
import lombok.Getter;

import java.util.List;

@Getter
public abstract class ExceptionAbstract extends RuntimeException {

    private List<String> msgs;
    private EValidation validation;
    @Getter private String[] params;

    private Integer code;
    private String message;

    public Integer getCode() {
        return this.validation.getCode();
    }

    public String getMessage() {
        return this.validation.getDescription(this.params);
    }

    public ExceptionAbstract(EValidation validation, String... params) {
        super(validation.getDescription());
        this.validation = validation;
        this.params = params;
    }
}

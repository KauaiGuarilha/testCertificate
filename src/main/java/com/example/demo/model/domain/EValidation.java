package com.example.demo.model.domain;

import lombok.Getter;

@Getter
public enum EValidation implements IEnumLabel<EValidation> {
    PASSWORD_NOT_IDENTIFIED(5),
    NOT_IDENTIFIED(-999);

    private final Integer code;

    EValidation(Integer code) {
        this.code = code;
    }
}

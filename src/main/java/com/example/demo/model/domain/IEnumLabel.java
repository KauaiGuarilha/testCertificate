package com.example.demo.model.domain;


import com.example.demo.util.MessageUtils;

public interface IEnumLabel<E extends Enum<E>> {

    default String getDescription() {
        return MessageUtils.getEnumLabel(this);
    }

    default String getDescription(String[] message) {
        return MessageUtils.getEnumLabel(this, message);
    }
}

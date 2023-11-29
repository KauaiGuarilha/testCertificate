package com.example.demo.util;

import com.example.demo.model.domain.IEnumLabel;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

@Component
public class MessageUtils {

    @Autowired private MessageSource resourceBundle;

    private static MessageSource MESSAGE_SOURCE;

    @PostConstruct
    public void init() {
        MESSAGE_SOURCE = resourceBundle;
    }

    public static String getMessage(String chave) {
        var locale = LocaleContextHolder.getLocale();
        return MESSAGE_SOURCE.getMessage(chave, null, locale);
    }

    public static <E extends Enum<E>> String getEnumLabel(IEnumLabel<E> e) {
        var locale = LocaleContextHolder.getLocale();
        var messageKey = "enum." + e.getClass().getSimpleName() + "." + ((Enum) e).name();
        return MESSAGE_SOURCE.getMessage(messageKey, null, locale);
    }

    public static <E extends Enum<E>> String getEnumLabel(IEnumLabel<E> e, String... params) {
        var locale = LocaleContextHolder.getLocale();
        var messageKey = "enum." + e.getClass().getSimpleName() + "." + ((Enum) e).name();
        return MESSAGE_SOURCE.getMessage(messageKey, params, locale);
    }
}

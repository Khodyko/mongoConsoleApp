package org.example.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.util.Locale;

public class MessageBundle {
    private static ResourceBundleMessageSource messageSource;

    @Autowired
    public MessageBundle(ResourceBundleMessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public static String getStr(String code) {
        Locale locale = new Locale("ru", "RUS");
        return messageSource.getMessage(code, null, locale);
    }
}

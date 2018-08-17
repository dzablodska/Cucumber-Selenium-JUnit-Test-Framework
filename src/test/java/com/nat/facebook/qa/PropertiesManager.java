package com.nat.facebook.qa;

import com.nat.facebook.qa.annotation.QAComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.util.Locale;

@QAComponent
public class PropertiesManager {

    @Autowired
    private ResourceBundleMessageSource messageSource;

    public String get(String key) {
        Object message = messageSource.getMessage(key, null, Locale.ENGLISH);
        String value = message != null ? message.toString() : null;
        return value;
    }

    public String get(String key, String... values) {
        Object o = messageSource.getMessage(key, values, Locale.ENGLISH);
        return o != null ? o.toString() : null;
    }

}

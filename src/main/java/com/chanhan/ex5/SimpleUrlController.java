package com.chanhan.ex5;

import org.springframework.stereotype.Controller;

import java.lang.annotation.Annotation;

public class SimpleUrlController implements Controller {
    @Override
    public String value() {
        return null;
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }
}

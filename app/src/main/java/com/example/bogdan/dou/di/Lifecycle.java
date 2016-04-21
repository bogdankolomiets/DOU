package com.example.bogdan.dou.di;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 21.04.2016
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface Lifecycle {

    String value() default "";
}

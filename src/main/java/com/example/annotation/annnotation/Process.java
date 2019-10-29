package com.example.annotation.annnotation;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;

/**
 * description
 *
 * @author yan.kang@hand-china.com
 * @date 2019/10/29 16:29
 */
@Target({METHOD, TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Process {
    String name();
    boolean flag();
}

package com.opencejav.LibMaster.annotations;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.TYPE;

@Inherited
@Documented
@Target({TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface UtilityClass {
    String className() default "UtilityClass";
}

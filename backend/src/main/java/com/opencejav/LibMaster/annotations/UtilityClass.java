package com.opencejav.LibMaster.annotations;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.TYPE;

/**
 * Single Member Annotation to Signify that Certain Class is a Utility Class.
 * @require className:String = "UtilityClass"
 */
@Inherited
@Documented
@Target({TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface UtilityClass {
    String className() default "UtilityClass";
}

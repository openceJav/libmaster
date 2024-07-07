package com.opencejav.LibMaster.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.ElementType.TYPE_USE;

/**
 * Single Member Annotation to Signify that Certain Class is a Base Class.
 * @require className:String = "Base"
 */
@Documented
@Target({TYPE, TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Base {
    String className() default "Base";
}

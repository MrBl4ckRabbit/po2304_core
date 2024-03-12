package lesson29_annotation._01_base;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface  MyAnnotation {
    String name() default "";
    int value() ;
}

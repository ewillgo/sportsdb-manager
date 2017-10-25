package cc.sportsdb.manager.annotation;

import java.lang.annotation.*;

/**
 * Change datasource
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface DataSource {
    String value() default "";
}

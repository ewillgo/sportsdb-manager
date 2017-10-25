package cc.sportsdb.manager.aspect;

import cc.sportsdb.manager.annotation.DataSource;
import cc.sportsdb.manager.support.DynamicDataSourceHolder;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DataSourceSwitchAspect implements Ordered {

    @Value("10")
    private int order;

    @Pointcut("execution(public * cc.sportsdb..*.service..*.*(..))")
    public void pointcut() {
    }

    @Around("@annotation(dataSource)")
    public Object proceed(ProceedingJoinPoint joinPoint, DataSource dataSource) throws Throwable {
        try {
            DynamicDataSourceHolder.setCurrentDataSourceName(dataSource.value());
            return joinPoint.proceed();
        } finally {
            DynamicDataSourceHolder.removeCurrentDataSourceName();
        }
    }

    @Override
    public int getOrder() {
        return order;
    }
}

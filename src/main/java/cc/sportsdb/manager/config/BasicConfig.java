package cc.sportsdb.manager.config;

import cc.sportsdb.common.config.WebConfig;
import cc.sportsdb.common.database.DataSourceList;
import cc.sportsdb.common.security.XSSFilter;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

import static cc.sportsdb.manager.constant.DataSourceConstant.DS_TEST;

@Configuration
@ImportAutoConfiguration({WebConfig.class})
@ServletComponentScan(basePackageClasses = {XSSFilter.class})
public class BasicConfig {

    @Bean
    public DataSourceList dataSourceList() {
        return new DataSourceList(Arrays.asList(DS_TEST));
    }

//    @Bean
//    public HandlerInterceptorList handlerInterceptorList() {
//        HandlerInterceptorList handlerInterceptorList = new HandlerInterceptorList();
//        return handlerInterceptorList;
//    }

}

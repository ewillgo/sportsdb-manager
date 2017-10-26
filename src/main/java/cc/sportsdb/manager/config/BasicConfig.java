package cc.sportsdb.manager.config;

import cc.sportsdb.common.config.WebConfig;
import cc.sportsdb.common.database.config.DataSourceConfig;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

import static cc.sportsdb.manager.constant.DataSourceConstant.DS_TEST;

@Configuration
@ImportAutoConfiguration({WebConfig.class})
public class BasicConfig {

    @Bean
    public DataSourceConfig.DataSourceNameContainer dataSourceNameContainer() {
        return new DataSourceConfig.DataSourceNameContainer(Arrays.asList(DS_TEST));
    }

}

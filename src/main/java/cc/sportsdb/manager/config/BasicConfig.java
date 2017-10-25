package cc.sportsdb.manager.config;

import cc.sportsdb.manager.util.JsonUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.util.Arrays;

@Configuration
public class BasicConfig {

    @Bean
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
        return new MappingJackson2HttpMessageConverter(JsonUtil.OBJECT_MAPPER);
    }

    @Bean
    @Primary
    public ObjectMapper objectMapper() {
        return JsonUtil.OBJECT_MAPPER;
    }

    @Bean
    public DataSourceConfig.DataSourceNameContainer dataSourceNameContainer() {
        return new DataSourceConfig.DataSourceNameContainer(Arrays.asList("ds.test"));
    }

}

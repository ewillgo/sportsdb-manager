package cc.sportsdb.manager;

import cc.sportsdb.common.test.AbstractApplicationTest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SportsdbManagerApplication extends AbstractApplicationTest {

    public static void main(String[] args) {
        SpringApplication.run(SportsdbManagerApplication.class, args);
    }
}

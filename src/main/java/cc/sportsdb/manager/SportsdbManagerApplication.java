package cc.sportsdb.manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SportsdbManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SportsdbManagerApplication.class, args);
	}
}

package tujuh.suganda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
public class SpringMongoTemplateApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMongoTemplateApplication.class, args);
	}
}

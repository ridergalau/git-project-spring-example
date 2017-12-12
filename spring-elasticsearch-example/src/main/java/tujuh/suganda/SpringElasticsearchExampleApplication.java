package tujuh.suganda;
/*
 * 
 * Just Try This Tutorial
https://www.mkyong.com/spring-boot/spring-boot-spring-data-elasticsearch-example/

*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;

@SpringBootApplication
public class SpringElasticsearchExampleApplication {

 
	public static void main(String[] args) {
		SpringApplication.run(SpringElasticsearchExampleApplication.class, args);
	}
}

package tujuh.suganda.conf;

import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean(name = "SwaggerBean")
	public Docket myApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(getApiInfo());
	}

	private Predicate<String> paths() {
		return Predicates.not(PathSelectors.regex("/basic-error-controller.*"));
	}

	private ApiInfo getApiInfo() {

		// We do not use all info
		ApiInfo info = new ApiInfo("Hbase Spring BIASA", "Hbase Spring biasa (Bukan Hbase Template)", "1.0", "", "", "",
				"");
		return info;
	}
}

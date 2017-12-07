package edu.hm.cs.cnj.cnjbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.Cloud;
import org.springframework.cloud.CloudFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.sql.DataSource;


@SpringBootApplication
@EnableSwagger2
public class CnjBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(CnjBackendApplication.class, args);
	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build();
	}

	@Configuration
	@Profile("default") // or "!cloud"
	public class LocalDataSourceConfiguration {

		@Bean
		@ConfigurationProperties("spring.datasource")
		public DataSource dataSource() {
			return DataSourceBuilder.create().build();
		}

	}

	@Configuration
	@Profile("cloud")
	public class DataSourceConfiguration {

		@Bean
		public Cloud cloud() {
			return new CloudFactory().getCloud();
		}

		@Bean
		@ConfigurationProperties("spring.datasource")
		public DataSource dataSource() {
			return cloud().getSingletonServiceConnector(DataSource.class, null);
		}

	}
}

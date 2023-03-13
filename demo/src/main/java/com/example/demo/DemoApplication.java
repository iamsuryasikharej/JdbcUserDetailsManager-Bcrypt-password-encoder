package com.example.demo;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages={"com.surya.controllers","com.surya.userdetailsconfig"})
//@EnableJpaRepositories(basePackages = {"com.surya.repositories"})
//@EntityScan("com.surya.repositories")
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@Bean
	public DataSource getDataSource()
	{
		DataSourceBuilder dsb=DataSourceBuilder.create();
		dsb.driverClassName("com.mysql.jdbc.Driver");
		dsb.url("jdbc:mysql://localhost:3306/jdbcuserdetailsmanager");
		dsb.username("root");
		dsb.password("admin");
		return dsb.build();
	}

}

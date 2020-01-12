package com.adammateusz.spoldzielniamikro;

import com.adammateusz.spoldzielniamikro.utils.AppUserRoleConverter;
import com.adammateusz.spoldzielniamikro.utils.AppUserRoleListConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class SpoldzielniamikroApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(SpoldzielniamikroApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpoldzielniamikroApplication.class);
	}
	@Bean
	public AppUserRoleConverter getMyUserRoleConverter() {
		return new AppUserRoleConverter();
	}

	@Bean
	public AppUserRoleListConverter getMyUserRoleListConverter() {
		return new AppUserRoleListConverter();
	}

}

package com.codetutr.config.dispatcher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.codetutr.config.database.AppConfig_Persistance;
import com.codetutr.config.springSecurity.SecurityConfig;

@SpringBootApplication(scanBasePackages={"com.codetutr"})
@Import(value={AppConfig_Persistance.class, SecurityConfig.class})
public class ServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ServletInitializer.class, args);
	}
}

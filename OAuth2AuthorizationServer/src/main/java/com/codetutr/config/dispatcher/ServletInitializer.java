package com.codetutr.config.dispatcher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.codetutr.config.database.AppConfig_Persistance;
import com.codetutr.config.server.AppConfig_Server;
import com.codetutr.config.springSecurity.AppConfig_Security;

@SpringBootApplication(scanBasePackages={"com.codetutr"})
@Import(value={AppConfig_Persistance.class, AppConfig_Security.class, AppConfig_Server.class})
public class ServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ServletInitializer.class, args);
	}
}

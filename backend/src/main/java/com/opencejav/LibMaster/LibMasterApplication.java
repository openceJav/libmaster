package com.opencejav.LibMaster;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.tinylog.Logger;


@EnableEncryptableProperties
@SpringBootApplication
public class LibMasterApplication {
	public static void main(String[] args) {
		SpringApplication.run(LibMasterApplication.class, args);
		Logger.info("LibMasterApplication Started Successfully, Server on http://localhost:8080/");
		Logger.info("LibMasterApplication Swagger UI on http://localhost:8080/swagger-ui.html");
		Logger.info("LibMasterApplication Live Reload Server on http://localhost:35729/");
    System.out.println("LibMasterApplication Started Successfully, Server on http://localhost:35729/");
	}
}
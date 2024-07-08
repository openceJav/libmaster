package com.opencejav.LibMaster;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.tinylog.Logger;


@EnableCaching
@SpringBootApplication
@EnableEncryptableProperties
public class LibMasterApplication {
	public static void main(String[] args) {
		Logger.info("LibMasterApplication Started Successfully, Server on http://localhost:8080/");
		Logger.info("LibMasterApplication Live Reload Server on http://localhost:35729/");
		SpringApplication.run(LibMasterApplication.class, args);
		System.out.println("LibMasterApplication Started Successfully, Server on http://localhost:35729/");
	}
}
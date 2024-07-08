package com.opencejav.LibMaster;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@EnableEncryptableProperties
@SpringBootApplication
public class LibMasterApplication {
	public static void main(String[] args) {
		SpringApplication.run(LibMasterApplication.class, args);
		System.out.println("LibMasterApplication Started Successfully, Server on http://localhost:8080/");
		System.out.println("LibMasterApplication Live Reload Server on http://localhost:35729/");
	}
}
package com.opencejav.LibMaster;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


@EnableCaching
@SpringBootApplication
@EnableEncryptableProperties
public class LibMasterApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibMasterApplication.class, args);
	}

}

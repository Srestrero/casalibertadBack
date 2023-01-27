package com.scj.casa_libertad_aco;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication//(scanBasePackages ="com.scj.casa_libertad_aco" )
public class CasaLibertadAcoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CasaLibertadAcoApplication.class, args);
	}

}


//"com.spring.beans"
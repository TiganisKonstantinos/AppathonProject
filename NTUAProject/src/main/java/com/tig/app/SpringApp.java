package com.tig.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"com.tig.app"})
@SpringBootApplication
public class SpringApp{

	public static void main(String[] args) {
		SpringApplication.run(SpringApp.class,args);
		
	}
	

	
}

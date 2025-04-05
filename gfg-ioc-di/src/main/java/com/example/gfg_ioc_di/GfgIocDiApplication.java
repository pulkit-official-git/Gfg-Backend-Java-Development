package com.example.gfg_ioc_di;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GfgIocDiApplication {

	Logger logger = LoggerFactory.getLogger(GfgIocDiApplication.class);

	private int a=10;
	private String b;

	public GfgIocDiApplication() {
		logger.info("Inside Conastructor: a = {},b = {}",a,b);
		this.b="xyz";
	}
	public void doS(){
		logger.info("created id-{},name-{}",a,b);

	}

	public static void main(String[] args) {
//		GfgIocDiApplication gfgIocDiApplication = new GfgIocDiApplication();
//		gfgIocDiApplication.doS();
		SpringApplication.run(GfgIocDiApplication.class, args);

	}

}

//scope - singleton

//com.example.gfg_ioc_di.Student@30e9ca13
//created student - com.example.gfg_ioc_di.Student@30e9ca13

//scope - prototype

//created student - com.example.gfg_ioc_di.Student@216e0771
//created student - com.example.gfg_ioc_di.Student@51288417
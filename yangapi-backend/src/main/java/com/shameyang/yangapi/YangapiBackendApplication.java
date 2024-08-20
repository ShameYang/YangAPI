package com.shameyang.yangapi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.shameyang.yangapi.mapper")
public class YangapiBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(YangapiBackendApplication.class, args);
	}

}

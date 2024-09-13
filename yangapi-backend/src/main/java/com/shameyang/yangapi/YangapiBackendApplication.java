package com.shameyang.yangapi;

import com.shameyang.yangapiclientsdk.YangApiClientConfig;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@MapperScan("com.shameyang.yangapi.mapper")
@Import(YangApiClientConfig.class)
@EnableDubbo
public class YangapiBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(YangapiBackendApplication.class, args);
	}

}
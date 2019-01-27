package com.tensquare.gathering;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import util.IdWorker;


@SpringBootApplication
@EnableCaching //开启spring的缓存，真正用的是java虚拟机的缓存
public class Gathering_Application {

	public static void main(String[] args) {
		SpringApplication.run(Gathering_Application.class, args);
	}

	@Bean
	public IdWorker idWorkker(){
		return new IdWorker(1, 1);
	}
	
}

package cn.hfbin.house.web;

import cn.hfbin.house.web.autoconfig.EnableHttpClient;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication()
@EnableHttpClient
@EnableAsync
@MapperScan(basePackages = "cn.hfbin.house.core.mapper")
@ComponentScan(basePackages = "cn.hfbin.house")
public class HousePropertyWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(HousePropertyWebApplication.class, args);
	}
}

package com.lzwing;

import com.lzwing.importselector.annotation.EnableLog;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
//@EnableMQConfiguration
@EnableRetry
@ServletComponentScan
//测试自定义enable
@EnableLog(name = "custom-enable-test")
public class SpringBootTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootTestApplication.class, args);
	}
}

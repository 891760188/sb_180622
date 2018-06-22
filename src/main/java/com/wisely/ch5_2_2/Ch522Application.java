package com.wisely.ch5_2_2;

import com.wisely.ch5_2_2.config.AuthorSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication//springboot 核心注解，主要目的是开启自动配置。会扫描该包下的所有注解文件，
public class Ch522Application {
	
	 @Value("${book.author}")
	 private String bookAuthor;
	 @Value("${book.name}")
	 private String bookName;

	@Autowired
	private AuthorSettings authorSettings ;
	
	 @RequestMapping("/")
	    String index() {
			System.out.print(authorSettings.getName()+"__"+authorSettings.getAge());
	        return "book name is:"+bookName+" and book author is:" + bookAuthor+"_____"+authorSettings.getName()+"__"+authorSettings.getAge();
	    }

	/**
	 * 项目启动的入口
	 * @param args
     */
    public static void main(String[] args) { 
        SpringApplication.run(Ch522Application.class, args);
    }
}

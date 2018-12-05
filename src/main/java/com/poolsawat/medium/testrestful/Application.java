package com.poolsawat.medium.testrestful;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.poolsawat.medium.testrestful.entity.Blog;
import com.poolsawat.medium.testrestful.repository.BlogRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BlogRepository blogRepository) {
		return (args) -> {				
			blogRepository.save(new Blog(Long.valueOf("1"), "SPA สร้าง Web Site Universal ด้วย Nuxt.js (EP.2) “Nuxt Directory Structure”", 
					"SPA สร้าง Web Site Universal ด้วย Nuxt.js (EP.2) “Nuxt Directory Structure”","poolsawat"));
			blogRepository.save(new Blog(Long.valueOf("2"), "SPA สร้าง Web Site Universal ด้วย Nuxt.js (EP.1) “Setup Nuxt Project”", 
					"SPA สร้าง Web Site Universal ด้วย Nuxt.js (EP.1) “Setup Nuxt Project”","poolsawat"));
			blogRepository.save(new Blog(Long.valueOf("3"), "สร้าง Project JSF Primeface ด้วย Maven พร้อมกับสอนทำระบบ Template Layout", 
					"สร้าง Project JSF Primeface ด้วย Maven พร้อมกับสอนทำระบบ Template Layout","poolsawat"));
		};
	}
}
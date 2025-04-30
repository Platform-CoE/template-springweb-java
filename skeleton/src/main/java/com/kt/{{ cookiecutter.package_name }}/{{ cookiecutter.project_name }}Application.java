package com.kt.{{ cookiecutter.package_name }};

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;;
import org.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("{{ cookiecutter.package_name }}.mapper")
public class {{ cookiecutter.project_name }}Application {

	public static void main(String[] args) {
		SpringApplication.run({{ cookiecutter.project_name }}Application.class, args);
	}

}

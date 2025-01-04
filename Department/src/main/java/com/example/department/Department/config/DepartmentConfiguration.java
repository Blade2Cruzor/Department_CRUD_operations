package com.example.department.Department.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DepartmentConfiguration
{
	@Bean
	public ModelMapper modelMapper()
	{
		return new ModelMapper();
	}
}

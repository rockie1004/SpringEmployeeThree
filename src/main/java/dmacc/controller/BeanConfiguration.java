package dmacc.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dmacc.beans.Employee;

@Configuration
public class BeanConfiguration {
	
	@Bean
	public Employee employee() {
		Employee bean = new Employee("Eric","Carle");
		return bean;
	}

}

package br.com.zup.jaeger.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CustomerService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);

	public CustomerDto findCustomer(String id){
		LOGGER.info(String.format("Finding customer with id: %s", id));

		return new CustomerDto("Joao", id);
	}

}

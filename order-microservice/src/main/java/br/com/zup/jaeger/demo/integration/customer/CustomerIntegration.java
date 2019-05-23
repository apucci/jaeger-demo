package br.com.zup.jaeger.demo.integration.customer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CustomerIntegration {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerIntegration.class);

    private final CustomerClient customerClient;

    private final RestTemplate restTemplate;

    @Autowired
    public CustomerIntegration(CustomerClient customerClient,
                               RestTemplate restTemplate) {
        this.customerClient = customerClient;
        this.restTemplate = restTemplate;
    }

    public CustomerResponse withFeign(String id) {
        LOGGER.info(String.format("Finding customer with id: %s using feign", id));
        return customerClient.getCustomer(id);
    }

    public CustomerResponse withRestTemplate(String id) {
        LOGGER.info(String.format("Finding customer with id: %s using rest template", id));
        return restTemplate.getForObject("http://localhost:8081/test", CustomerResponse.class);
    }

}

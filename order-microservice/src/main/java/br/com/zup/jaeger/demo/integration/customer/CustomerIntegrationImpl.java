package br.com.zup.jaeger.demo.integration.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerIntegrationImpl implements CustomerIntegration{

    private final CustomerClient customerClient;

    @Autowired
    public CustomerIntegrationImpl(CustomerClient customerClient) {
        this.customerClient = customerClient;
    }
}

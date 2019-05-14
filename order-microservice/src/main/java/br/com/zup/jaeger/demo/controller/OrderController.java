package br.com.zup.jaeger.demo.controller;

import br.com.zup.jaeger.demo.integration.customer.CustomerClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController("/order")
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CustomerClient client;

    @GetMapping
    public String test() {
//        ResponseEntity<String> customer = restTemplate.getForEntity("http://localhost:8081/test", String.class);
        var customer = client.getCustomer();
        return customer.concat(" Order test");
    }

    @GetMapping("/another")
    public String anotherTest() {
        var customer = restTemplate.getForEntity("http://localhost:8081/test", String.class);
        return customer.getBody().concat(" Another Test");
    }

}

package br.com.zup.jaeger.demo.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController("/test")
public class TestController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public String test() {
        ResponseEntity<String> customer = restTemplate.getForEntity("http://localhost:8081/test", String.class);
        return customer.getBody().concat(" Order test");
    }

    @GetMapping("/another")
    public String anotherTest() {
        ResponseEntity<String> customer = restTemplate.getForEntity("http://localhost:8080/test", String.class);
        return customer.getBody().concat(" Another Test");
    }

}

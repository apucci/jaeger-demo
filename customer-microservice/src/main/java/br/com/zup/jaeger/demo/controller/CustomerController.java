package br.com.zup.jaeger.demo.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController("/customer")
public class CustomerController {

    @GetMapping
    public String test(@RequestHeader HttpHeaders headers){
        return "Customer Test";
    }

}

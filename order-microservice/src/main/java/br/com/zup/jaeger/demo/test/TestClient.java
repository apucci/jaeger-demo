package br.com.zup.jaeger.demo.test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface TestClient {

    @RequestMapping(method = RequestMethod.GET, value = "/test")
    String getCustomer();

}

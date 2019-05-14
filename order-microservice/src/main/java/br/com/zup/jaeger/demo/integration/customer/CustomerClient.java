package br.com.zup.jaeger.demo.integration.customer;

import br.com.zup.jaeger.demo.configuration.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "customer",
        url = "${customer.endpoint}",
        configuration = FeignConfiguration.class)
public interface CustomerClient {

    @RequestMapping(method = RequestMethod.GET, value = "/test")
    String getCustomer();

}

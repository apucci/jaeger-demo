package br.com.zup.jaeger.demo.controller;

import br.com.zup.jaeger.demo.representation.response.CustomerResponse;
import br.com.zup.jaeger.demo.service.CustomerDto;
import br.com.zup.jaeger.demo.service.CustomerService;
import io.opentracing.util.GlobalTracer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController("/customer")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{id}")
    public CustomerResponse test(@PathVariable String id){
        CustomerDto dto = customerService.findCustomer(id);

        GlobalTracer.get().activeSpan().setTag("clientId", id);

        return new CustomerResponse(dto.getName(), dto.getId());
    }

}

package br.com.zup.jaeger.demo.controller;

import br.com.zup.jaeger.demo.presenter.request.CreateOrderRequest;
import br.com.zup.jaeger.demo.presenter.response.CreateOrderResponse;
import br.com.zup.jaeger.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController("/order")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateOrderResponse create(@RequestBody CreateOrderRequest orderRequest) {
        var order = orderService.createOrderFeing(orderRequest.getClientId());
        return new CreateOrderResponse(order.getOrderId(), order.getClientName(), order.getClientId());
    }

    @PostMapping("/another")
    @ResponseStatus(HttpStatus.CREATED)
    public CreateOrderResponse anotherCreate(@RequestBody CreateOrderRequest orderRequest) {
        var order = orderService.createOrderRestTemplate(orderRequest.getClientId());
        return new CreateOrderResponse(order.getOrderId(), order.getClientName(), order.getClientId());
    }

}

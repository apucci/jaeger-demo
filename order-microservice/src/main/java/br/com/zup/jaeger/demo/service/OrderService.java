package br.com.zup.jaeger.demo.service;

import br.com.zup.jaeger.demo.integration.customer.CustomerIntegration;
import io.opentracing.util.GlobalTracer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class OrderService {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrderService.class);

	private final CustomerIntegration customerIntegration;

	@Autowired
	public OrderService(CustomerIntegration customerIntegration) {
		this.customerIntegration = customerIntegration;
	}

	public OrderDto createOrderFeing(String id) {
		LOGGER.info(String.format("Creating order for client: %s", id));

		String orderId = UUID.randomUUID().toString();
		var customer = customerIntegration.withFeign(id);

		GlobalTracer.get().activeSpan().setTag("clientId", id);
		GlobalTracer.get().activeSpan().setTag("orderId", orderId);

		return new OrderDto(orderId, customer.getName(), customer.getId());
	}

	public OrderDto createOrderRestTemplate(String id) {
		LOGGER.info(String.format("Creating order for client: %s", id));

		String orderId = UUID.randomUUID().toString();
		var customer = customerIntegration.withRestTemplate(id);

		GlobalTracer.get().activeSpan().setTag("clientId", id);
		GlobalTracer.get().activeSpan().setTag("orderId", orderId);

		return new OrderDto(orderId, customer.getName(), customer.getId());
	}

}

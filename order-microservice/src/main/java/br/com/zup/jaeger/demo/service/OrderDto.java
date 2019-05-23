package br.com.zup.jaeger.demo.service;

public class OrderDto {

	private String orderId;

	private String clientName;

	private String clientId;

	public OrderDto() {
	}

	public OrderDto(String orderId, String clientName, String clientId) {
		this.orderId = orderId;
		this.clientName = clientName;
		this.clientId = clientId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
}

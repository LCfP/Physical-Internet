package physicalInternet;

import java.util.ArrayList;

public class Container {
	private int customerNumber;
	private int orderNumber;
	private int containerNumber;
	private String adress;
	private ArrayList<Order> orders;

	public Container(Order order) {
		this.customerNumber = order.getCustomerNumber();
		this.orderNumber = order.getCustomerNumber();
		this.containerNumber = order.getCustomerNumber();
		this.adress = order.getAddress();
	}
	
	public ArrayList<Order> getOrders() {
		return orders;
	}

	public void setOrders(ArrayList<Order> orders) {
		this.orders = orders;
	}

	public int getCustomerNumber() {
		return customerNumber;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public int getContainerNumber() {
		return containerNumber;
	}

	public String getAdress() {
		return adress;
	}
}

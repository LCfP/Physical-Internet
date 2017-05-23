package transport;

import java.util.ArrayList;
import java.util.Scanner;

public class Receiver {

	private  ArrayList<Order> orders = new ArrayList<Order>();

	public void getOrder(Order order) {

		orders.add(order);
		showOrdersinReceiver();
		removerOrder(order);

	}

	public void showOrdersinReceiver() {
		System.out.println("In Receiver:");
		for (Order order : orders) {
			System.out.println("Address:" + order.getAddress());
			System.out.println("Customer Number:" + order.getCustomerNumber());
			System.out.println("time" + order.getTimeOfOrder());
		}

	}

	public Order placeOrder(int i) {
		Order order = new Order();		
		order.setAddress("Adress"+i);
		order.setCustomerNumber(i);
		order.setTimeOfOrder(i);
		return order;

	}
	

	public void sendOrderToShipper(Order order, Shipper shipper) {

		shipper.getOrder(order);
		

	}

	private void removerOrder(Order order) {
		orders.remove(order);
		

	}

}
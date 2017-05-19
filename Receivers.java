import java.util.ArrayList;
import java.util.Scanner;

public class Receivers {

	private static ArrayList<Order> orders = new ArrayList<Order>();

	public void getOrder(Order order) {

		orders.add(order);
		showOrdersinReceivers();
		//removerOrder(order);

	}

	public void showOrdersinReceivers() {
		System.out.println("In Receiver:");
		for (Order order : orders) {
			System.out.println("Address:" + order.getAddress());
			System.out.println("Customer Number:" + order.getCustomerNumber());
		}

	}

	public Order placeOrder() {
		Scanner scan = new Scanner(System.in);
		Order order = new Order();
		System.out.println("Customer Number");
		order.setCustomerNumber(scan.nextInt());
		System.out.println("Enter address");
		order.setAddress(scan.next());
		return order;

	}

	public void sendOrderToShipper(Order order, Shipper shipper) {

		shipper.getOrder(order);
		

	}

	private void removerOrder(Order order) {
		orders.remove(order);

	}

}
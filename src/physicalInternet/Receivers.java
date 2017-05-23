package physicalInternet;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Receivers {

	private static ArrayList<Order> orders = new ArrayList<Order>();

	public void getOrder(Order order) {

		orders.add(order);
		showOrdersinReceivers();
		// removerOrder(order);

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

		ArrayList<Product> products = new ArrayList<Product>();

		int randomNum = ThreadLocalRandom.current().nextInt(1, 32 + 1);
		for (int i = 1; i < randomNum; i++) {
			Product product = new Product(10, 5, 3, 2, "Iphone"); // We create a new product.
			products.add(product);
		}

		order.setProducts(products); // Connect product to order.

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
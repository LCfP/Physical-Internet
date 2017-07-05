package physicalInternet;

import java.util.ArrayList;

import java.util.concurrent.ThreadLocalRandom;

public class Receiver {

	private ArrayList<Order> orders = new ArrayList<Order>();
	private int customerNumber;
	private int x;
	private int y;

	/**
	 * Constructor
	 *
	 * @param region
	 *            The region identifier (as an integer).
	 */
	public Receiver(int x, int y, int customerNumber) {
		this.customerNumber = customerNumber;
		this.x = x;
		this.y = y;
	}

	public int getCustomerNumber() {
		return customerNumber;
	}

	public void setustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
	}

	public void getOrder(Order order, Transit transit) {
		orders.add(order);
		transit.ordersToBeRemovedFromTransit.add(order);
		showOrdersinReceiver();
		// removeOrder(order);
	}

	public void showOrdersinReceiver() {
		System.out.println("Customer " + customerNumber);

		for (Order order : orders) {
			System.out.println("Order:");
			System.out.print("Customer Number:" + order.getCustomerNumber());
			System.out.println("  time" + order.getTimeOfOrder());
		}
	}

	public Order placeOrder(int i) {
		Order order = new Order();
		order.setAddress("Adress" + i);
		order.setCustomerNumber(customerNumber);
		order.setTimeOfOrder(i);

		ArrayList<Product> products = new ArrayList<Product>();

		int randomNum = ThreadLocalRandom.current().nextInt(1, 32 + 1);
		for (int j = 1; j < randomNum; j++) {
			// We create a new product.
			Product product = new Product(10, 5, 3, 2, "Iphone");
			products.add(product);
		}

		order.setProducts(products); // Connect product to order.
		return order;
	}

	public void sendOrderToShipper(Order order, Shipper shipper) {
		shipper.getOrder(order);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

}
package physicalInternet;

import java.util.ArrayList;

import java.util.concurrent.ThreadLocalRandom;

public class Receiver {

	private ArrayList<Order> orders = new ArrayList<Order>();
	private int receiverId;
	private int x;
	private int y;

	/**
	 * Constructor
	 *
	 * @param region
	 *            The region identifier (as an integer).
	 */
	public Receiver(int x, int y,int receiverId) {
        this.receiverId=receiverId;
		this.x = x;
		this.y = y;
	}

	public int getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(int receiverId) {
		this.receiverId = receiverId;
	}

	public void getOrder(Order order) {
		orders.add(order);
		showOrdersinReceiver();
		removeOrder(order);
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
		order.setAddress("Adress" + i);
		order.setCustomerNumber(receiverId);
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

	private void removeOrder(Order order) {
		orders.remove(order);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

}
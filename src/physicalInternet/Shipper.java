package physicalInternet;

import java.util.ArrayList;

public class Shipper {

	private ArrayList<Order> orders = new ArrayList<Order>();
	private int x;
	private int y;

	/**
	 * Constructor
	 *
	 * @param region
	 *            The region identifier (as an integer).
	 */
	public Shipper(int x, int y) {

		this.x = x;
		this.y = y;
	}

	public void getOrder(Order order) {
		orders.add(order);
		//showOrdersinShipper();
	}

	public void showOrdersinShipper() {
		System.out.println("In Shipper:");

		for (Order order : orders) {
			System.out.println("Address:" + order.getAddress());
			System.out.println("Customer Number" + order.getCustomerNumber());
		}
	}

	public void sendOrderToHub(Order order, Transit transit) {
		transit.getOrderFromShipper(order);
		removeOrder(order);
	}

	private void removeOrder(Order order) {
		orders.remove(order);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}

package physicalInternet;

import java.util.ArrayList;
import java.util.Iterator;

public class Truck {
	private static ArrayList<Order> ordersToHub = new ArrayList<Order>();
	private static ArrayList<Order> ordersToReceiver = new ArrayList<Order>();
	private static int transitTime = 2;
	private double weight = 1000;
	private int height = 30;
	private int width = 30;
	private int depth = 40;
	private double speed = 20.0;
	private Trailer trailer;

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public void coupleTrailer() {
		this.trailer = new Trailer();
	}

	public void decoupleTrailer() {
		this.trailer = null;
	}

	public void speedOfTruck() {
		if (this.trailer != null) {
			setSpeed(speed - 10);
		} else {
			setSpeed(speed);

		}

	}

	public void getOrderFromShipper(Order order) {
		ordersToHub.add(order);
		showOrdersinTransitToHub();
	}

	public void getOrderFromHub(Order order) {
		ordersToReceiver.add(order);
		showOrdersinTransitToReceiver();
	}

	public void showOrdersinTransitToHub() {
		System.out.println("In Transit:");

		for (Order order : ordersToHub) {
			System.out.println("Address:" + order.getAddress());
			System.out.println("Customer Number:" + order.getCustomerNumber());
			System.out.println("time" + order.getTimeOfOrder());
		}
	}

	public void showOrdersinTransitToReceiver() {
		System.out.println("In Transit:");

		for (Order order : ordersToReceiver) {
			System.out.println("Address:" + order.getAddress());
			System.out.println("Customer Number:" + order.getCustomerNumber());
			System.out.println("time" + order.getTimeOfOrder());
		}
	}

	public void transitToHub(int time, Hub hub) {
		for (Iterator<Order> iterator = ordersToHub.iterator(); iterator.hasNext();) {
			Order order = iterator.next();

			if (order.getTimeOfOrder() + transitTime == time) {
				sendOrderToHub(order, hub);
				iterator.remove();
			}
		}
	}

	public void sendOrderToHub(Order order, Hub hub) {
		hub.getOrder(order);
	}

	public void transitToReceiver(int time, Receiver receiver) {
		for (Iterator<Order> iterator = ordersToReceiver.iterator(); iterator.hasNext();) {
			Order order = iterator.next();

			if (order.getTimeOfOrder() + 2 * transitTime == time) {
				sendOrderToReceiver(order, receiver);
				iterator.remove();
			}
		}
	}

	public void sendOrderToReceiver(Order order, Receiver receiver) {
		receiver.getOrder(order);
	}
}

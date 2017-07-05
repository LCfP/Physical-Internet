package physicalInternet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Simulation {
	private final int noRegions;
	private static int transitTime = 1;
	public static int currentTime;
	private int noShippers;
	private ArrayList<Hub> regionalHubs;
	private ArrayList<Receiver> receivers = new ArrayList<Receiver>();
	private ArrayList<Shipper> shippers;
	public final static String REGIONAL_HUB_NEAR_SHIPPER = "RegionalHubNearShipper";
	public final static String MAIN_HUB = "MainHub";
	public final static String REGIONAL_HUB_NEAR_RECEIVER = "RegionalHubNearReceiver";
	public final static String RECEIVER = "Receiver";

	/**
	 * Constructor
	 */
	public Simulation() {
		this.noRegions = 10;
		this.noShippers = 10;
		this.regionalHubs = new ArrayList<>(this.noRegions);
		this.shippers = new ArrayList<>(this.noShippers);

	}

	public void runSimulation() {

		Hub mainHub = new Hub(50, 50); // Main hub at coordinates 50,50
		Transit transit = new Transit();
		Random randomGenerator = new Random();

		int randomXCordinate;
		int randomYCordinate;
		// Regional Hub Creation
		for (int i = 1; i <= this.noRegions; i++) {
			// Note that coordinate (50 ,50) is reserved for the main hub!
			randomXCordinate = randomGenerator.nextInt(100);
			randomYCordinate = randomGenerator.nextInt(100);
			this.regionalHubs.add(new Hub(randomXCordinate, randomYCordinate));

		}
		// Shipper Creation
		for (int i = 1; i <= this.noShippers; i++) {
			randomXCordinate = randomGenerator.nextInt(100);
			randomYCordinate = randomGenerator.nextInt(100);
			this.shippers.add(new Shipper(randomXCordinate, randomYCordinate));
		}

		for (int time = 0; time <= 100; time++) // As time passes by new demand
		// is formed form the receiver
		{

			randomXCordinate = randomGenerator.nextInt(100);
			randomYCordinate = randomGenerator.nextInt(100);
			// Create new shipper and receivers with a random (uniformly
			// distributed) region.
			Receiver receiver = new Receiver(randomXCordinate, randomYCordinate, time);// time
																						// parameter
																						// is
																						// used
																						// as
																						// customer
																						// number
			// Store Receivers into array
			receivers.add(receiver);
			// Receiver places an order
			Order order = receiver.placeOrder(time);
			// Receiver places an order at a random shipper.
			int index = randomGenerator.nextInt(shippers.size());
			Shipper shipper = shippers.get(index);
			receiver.sendOrderToShipper(order, shipper);
			// shipper sets the order in transit after receiving the order
			shipper.sendOrder(order, transit);

			for (Order ordersinTransit : transit.getOrders()) {

				switch (ordersinTransit.getNextDestination()) {
				case REGIONAL_HUB_NEAR_SHIPPER:
					// lead time
					if (ordersinTransit.getTimeOfOrder() + transitTime == time) {
						ordersinTransit.setNextDestination(MAIN_HUB);
						// Find the closest regional hub to shipper
						Hub regionalHub = findClosestHub(shipper.getX(), shipper.getY());
						regionalHub.getOrder(ordersinTransit, transit);
						regionalHub.sendOrder(transit);
					}
					break;

				case MAIN_HUB:
					// lead time
					if (ordersinTransit.getTimeOfOrder() + transitTime * 2 == time) {
						ordersinTransit.setNextDestination(REGIONAL_HUB_NEAR_RECEIVER);
						mainHub.getOrder(ordersinTransit, transit);
						mainHub.sendOrder(transit);
					}
					break;

				case REGIONAL_HUB_NEAR_RECEIVER:
					// lead time
					if (ordersinTransit.getTimeOfOrder() + transitTime * 3 == time) {
						ordersinTransit.setNextDestination(RECEIVER);
						receiver = findReceiver(ordersinTransit);
						// Find the closest regional hub to receiver
						Hub regionalHub = findClosestHub(receiver.getX(), receiver.getY());
						regionalHub.getOrder(ordersinTransit, transit);
						regionalHub.sendOrder(transit);
					}
					break;

				case RECEIVER:
					// lead time
					if (ordersinTransit.getTimeOfOrder() + transitTime * 4 == time) {
						receiver = findReceiver(ordersinTransit);
						ordersinTransit.setNextDestination(null);
						System.out.println("Time" + time);
						receiver.getOrder(ordersinTransit, transit);
					
					}
					break;

				}

			}
			transit.setOrders(removeAddOrdersToTransit(transit));
			

		}
	}

	private Receiver findReceiver(Order ordersinTransit) {

		for (Receiver receiver : receivers) {
			if (receiver.getCustomerNumber() == ordersinTransit.getCustomerNumber()) {
				return receiver;
			}
		}
		return null;

	}

	private ArrayList<Order> removeAddOrdersToTransit(Transit transit) {
		ArrayList<Order> orders = transit.getOrders();
		ArrayList<Order> ordersToBeRemovedFromTransit = transit.ordersToBeRemovedFromTransit;
		ArrayList<Order> ordersToBeAddedToTransit = transit.ordersToBeAddedToTransit;
		for (Order removeOrder : ordersToBeRemovedFromTransit) {
			for (Iterator<Order> iterator = orders.iterator(); iterator.hasNext();) {
				Order order = iterator.next();
				if (removeOrder.getCustomerNumber() == order.getCustomerNumber())
					iterator.remove();
			}

		}
		for (Order order : ordersToBeAddedToTransit) {
			orders.add(order);
		}
		//reseting following parameters
		transit.ordersToBeAddedToTransit = new ArrayList<>();
		transit.ordersToBeRemovedFromTransit = new ArrayList<>();

		return orders;

	}

	private Hub findClosestHub(int x, int y) {
		double shortestDistance = 1000;
		Hub closestHub = null;
		for (Hub hub : regionalHubs) {
			double distance = Math.sqrt(Math.pow(x - hub.getX(), 2) + Math.pow(y - hub.getY(), 2));
			if (distance < shortestDistance) {
				shortestDistance = distance;
				closestHub = hub;
			}
		}
		return closestHub;
	}

}

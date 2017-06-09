package physicalInternet;

import java.util.ArrayList;
import java.util.Random;

public class Simulation {
	private final int noRegions;
	public static int currentTime;
	private int noShippers;
	private ArrayList<Hub> regionalHubs;
	private ArrayList<Receiver> receivers = new ArrayList<Receiver>();
	private ArrayList<Shipper> shippers;

	/**
	 * Constructor
	 */
	public Simulation() {
		this.noRegions = 10; // TODO: this is a parameter and thus needs to go
								// in a config file.
		this.noShippers = 10;// TODO: this is a parameter and thus needs to go
								// in a config file.
		this.regionalHubs = new ArrayList<>(this.noRegions);
		this.shippers = new ArrayList<>(this.noShippers);
		this.currentTime = 0;
	}

	public void runSimulation() {
		Random rand = new Random();

		Hub mainHub = new Hub(50, 50); // Main hub at coordinates 50,50
		Transit transit = new Transit();
		Random randomGenerator = new Random();

		int randomInt;
		// Regional Hub Creation
		for (int i = 1; i <= this.noRegions; i++) {
			// Note that coordinate (50 ,50) is reserved for the main hub!
			randomInt = randomGenerator.nextInt(100);
			this.regionalHubs.add(new Hub(randomInt, randomInt));

		}
		// Shipper Creation
		for (int i = 1; i <= this.noShippers; i++) {
			randomInt = randomGenerator.nextInt(100);
			this.shippers.add(new Shipper(randomInt, randomInt));
		}

		for (int time = 0; time < 100; time++) // As time passes by new demand
												// is formed form the receiver
		{
			currentTime++;
			randomInt = randomGenerator.nextInt(100);
			// Create new shipper and receivers with a random (uniformly
			// distributed) region.
			Receiver receiver = new Receiver(randomInt, randomInt,time);
			Order order = receiver.placeOrder(time);
			// Store Receivers into array
			receivers.add(receiver);

			Shipper closestShipper = findClosestShippertoHub(receiver.getX(), receiver.getY());
			receiver.sendOrderToShipper(order, closestShipper);

			closestShipper.sendOrderToHub(order, transit);
			// Find the closest regional hub
			Hub regionalHub = findClosestHub(closestShipper.getX(), closestShipper.getY());//?
			// transfer to the Shipper's regional hub
			transit.transitToHub(time, regionalHub);
			// Regional hub sends order to the main hub
			regionalHub.sendOrderToMainHub(mainHub, transit);
			// transfer to the main hub
			regionalHub = findClosestHub(receiver.getX(), receiver.getY());
			mainHub.sendOrderToRegionalHub(regionalHub, transit);

			// regionalHub to receiever
			regionalHub.findReceiverandSentOrder(receivers, transit);

		}
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

	private Shipper findClosestShippertoHub(int x, int y) {
		double shortestDistance = 1000;
		Shipper closestShipper = null;
		for (Shipper shipper : shippers) {
			double distance = Math.sqrt(Math.pow(x - shipper.getX(), 2) + Math.pow(y - shipper.getY(), 2));
			if (distance < shortestDistance) {
				shortestDistance = distance;
				closestShipper = shipper;
			}
		}
		return closestShipper;
	}
}

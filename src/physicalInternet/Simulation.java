package physicalInternet;

import java.util.Random;
import java.util.ArrayList;

public class Simulation {
	private final int noRegions;
	private ArrayList<Hub> regionalHubs;

	/**
	 * Constructor
	 */
	public Simulation() {
		this.noRegions = 10; // TODO: this is a parameter and thus needs to go
								// in a config file.
		this.regionalHubs = new ArrayList<>(this.noRegions);
	}

	public void runSimulation() {
		Random rand = new Random();

		Hub hub = new Hub(); // Main hub
		

		for (int i = 1; i <= this.noRegions; i++) {
			// Hubs in regions 1, 2, 3, etc.. Note that 0 is reserved for the
			// main hub!
			this.regionalHubs.add(new Hub(i));
		}

		for (int time = 0; time < 10; time++) // no of minutes
		{
			// Create new shipper and receivers with a random (uniformly
			// distributed) region.

			Receiver receiver = new Receiver(rand.nextInt(this.noRegions));
			// create new product
			Product product = new Product(10.0, 3, 4, 5, "iphone");

			Shipper shipper = new Shipper(rand.nextInt(this.noRegions));

			Order order = receiver.placeOrder(time);
			receiver.sendOrderToShipper(order, shipper);
	
			Truck truck = new Truck();
			Container container = new Container();
			shipper.sendOrderToHub(order, truck);
			// transfer to the Shipper's regional hub
			shipper.putOrderInContainer(order, container);
			// Check if this works container.showOrdersInContainer();
			truck.transitToHub(time, this.regionalHubs.get(shipper.region));

			truck.coupleTrailer();
			
			this.regionalHubs.get(shipper.region).sendOrderToHub(order, hub);
			// transfer to the main hub
			truck.transitToHub(time, hub);

			// main hub to regional hub
			hub.sendOrderToHub(order, this.regionalHubs.get(receiver.region));
			truck.transitToHub(time, hub);

			this.regionalHubs.get(receiver.region).sendOrderToReceiver(order, truck);
			truck.transitToReceiver(time, receiver);
		}
	}
}

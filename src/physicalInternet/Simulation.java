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
        this.noRegions = 10; // TODO: this is a parameter and thus needs to go in a config file.
        this.regionalHubs = new ArrayList<>(this.noRegions);
    }

    public void runSimulation() {
        Random rand = new Random();

        Hub hub = new Hub(); // Main hub
        Transit transit = new Transit();

        for (int i = 1; i <= this.noRegions; i++) {
            // Hubs in regions 1, 2, 3, etc.. Note that 0 is reserved for the main hub!
            this.regionalHubs.add(new Hub(i));
        }

        for (int time = 0; time < 10; time++) //no of minutes
        {
            // Create new shipper and receivers with a random (uniformly distributed) region.
            Receiver receiver = new Receiver(rand.nextInt(this.noRegions));
            Shipper shipper = new Shipper(rand.nextInt(this.noRegions));

            Order order = receiver.placeOrder(time);
            receiver.sendOrderToShipper(order, shipper);

            shipper.sendOrderToHub(order, transit);
            // transfer to the Shipper's regional hub
            transit.transitToHub(time, this.regionalHubs.get(shipper.region));

            this.regionalHubs.get(shipper.region).sendOrderToHub(order, hub);
            // transfer to the main hub
            transit.transitToHub(time, hub);

            // main hub to regional hub
            hub.sendOrderToHub(order, this.regionalHubs.get(receiver.region));
            transit.transitToHub(time, hub);

            this.regionalHubs.get(receiver.region).sendOrderToReceiver(order, transit);
            transit.transitToReceiver(time, receiver);
        }
    }
}

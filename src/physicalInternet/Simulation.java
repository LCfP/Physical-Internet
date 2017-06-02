package physicalInternet;

import java.util.ArrayList;
import java.util.Random;

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

        Hub hub = new Hub(50,50); // Main hub at coordinates 50,50
        Transit transit = new Transit();
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(100);
       
        for (int i = 1; i <= this.noRegions; i++) {
            // Hubs in regions 1, 2, 3, etc.. Note that 0 is reserved for the main hub!
        	  randomInt = randomGenerator.nextInt(100);
            this.regionalHubs.add(new Hub(i,randomInt,randomInt));
        }

        for (int time = 0; time < 10; time++) //no of minutes
        {
        	randomInt = randomGenerator.nextInt(100);
            // Create new shipper and receivers with a random (uniformly distributed) region.
            Receiver receiver = new Receiver(randomInt,randomInt);
            Shipper shipper = new Shipper(rand.nextInt(this.noRegions),randomInt,randomInt);

            Order order = receiver.placeOrder(time);
            receiver.sendOrderToShipper(order, shipper);

            shipper.sendOrderToHub(order, transit);
            //Find the closest regional hub
            Hub regionalHub=findClosestHub(shipper.getX(),shipper.getY());
            // transfer to the Shipper's regional hub
             transit.transitToHub(time, regionalHub);

             regionalHub.sendOrderToHub(order, hub);
            // transfer to the main hub
            transit.transitToHub(time, hub);

            // main hub to regional hub
            regionalHub=findClosestHub(receiver.getX(),receiver.getY());
            hub.sendOrderToHub(order,regionalHub);
            transit.transitToHub(time, hub);

            regionalHub.sendOrderToReceiver(order, transit);
            transit.transitToReceiver(time, receiver);
        }
    }

	private Hub findClosestHub(int x, int y) {
		int shortestDistance=1000;
		Hub closestHub = null;
		for(Hub hub:regionalHubs){
			int distance= (int) Math.sqrt((x-hub.getX())^2+(y-hub.getY())^2);
			if(distance<shortestDistance){
				shortestDistance=distance;
				closestHub=hub;
			}
		}
		return closestHub;
	}
}

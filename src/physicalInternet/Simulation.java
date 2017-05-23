package transport;

public class Simulation {
	
	public void runSimulation() {
		Hub hub = new Hub();
		 Transit transit =new Transit();
		
		for (int time=0;time <10;time++)//no of minutes
		{
			Receiver receiver = new Receiver();
			Shipper shipper = new Shipper();
			Order order =receiver.placeOrder(time);			
			receiver.sendOrderToShipper(order, shipper);
			shipper.sendOrderToHub(order,transit);			
			transit.transitToHub(time, hub);
			hub.sendOrderToReceiver(order, transit);
			transit.transitToReceiver(time, receiver);
			
		
	}
	
}}

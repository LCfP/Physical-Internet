package physicalInternet;

import java.util.ArrayList;

public class Transit {
	private ArrayList<Order> orders = new ArrayList<Order>();
	public ArrayList<Order> ordersToBeRemovedFromTransit = new ArrayList<Order>();
	public ArrayList<Order> ordersToBeAddedToTransit = new ArrayList<Order>();

	public void getOrder(Order order) {
		orders.add(order);
		// showOrdersinTransitToHub();
	}

	public ArrayList<Order> getOrders() {
		return orders;
	}

	public void setOrders(ArrayList<Order> orders) {
		this.orders = orders;
	}

}

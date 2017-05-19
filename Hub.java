
import java.util.ArrayList;

public class Hub {
	private static ArrayList<Order> orders = new ArrayList<Order>();

	public void getOrder(Order order) {

		orders.add(order);
		showOrdersinHub();

	}

	public void showOrdersinHub() {
		System.out.println("In Hub:");
		for (Order order : orders) {
			System.out.println("Address:" + order.getAddress());
			System.out.println("Customer Number:" + order.getCustomerNumber());
		}

	}

	public void sendOrderToReceiver(Order order, Receivers receiver) {
		receiver.getOrder(order);
		removerOrder(order);

	}

	private void removerOrder(Order order) {
		orders.remove(order);

	}

}
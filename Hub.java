package physicalInternet;

import java.util.ArrayList;
import java.util.List;

public class Hub {
	private static  ArrayList<Order> orders=new ArrayList<Order>();

	public void getOrder(Order order) {
		/*System.out.println("In Hub: address"+order.getAddress());
		System.out.println("IN Hub: Order Number"+order.getCustomerNumber());*/
		orders.add(order);
		showOrdersinHub();
	}

	private void showOrdersinHub() {
		for(Order order:orders){
			System.out.println("In Hub: address"+order.getAddress());
			System.out.println("IN Hub: Order Number"+order.getCustomerNumber());
		}
		
	}

}

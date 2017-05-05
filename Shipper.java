package physicalInternet;

public class Shipper {

	public void getOrder(Order order) {
		
		System.out.println("In Shipper:address"+order.getAddress());
		System.out.println("In Shipper:Order Number"+order.getCustomerNumber());
		Hub hub=new Hub();
		hub.getOrder(order);
	}
	
	/*Receiver receiver = new Receiver();

	private  int customerNumber = receiver.getCustomerNumber();
	private  int orderNumber = receiver.getOrderNumber();

	public int getCustomerNumber() {
		return customerNumber;
	}

	public int getOrderNumber() {
		return orderNumber;

	}
	public void reportShipperProgress(){
		System.out.println("Shipper"+customerNumber);
		System.out.println("Order Number"+orderNumber);
	}*/

}

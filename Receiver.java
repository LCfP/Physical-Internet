package physicalInternet;

public class Receiver {
	
	/*private int customerNumber = 10;
	private int orderNumber = 20;
	
	public int getCustomerNumber(){
		return customerNumber;
	}
	public int getOrderNumber(){
		return orderNumber;
	}

	public void reportReceiverProgress() {
		System.out.println(customerNumber);
		System.out.println(orderNumber);
	}*/
	public Receiver(){
	
	for(int i=0;i<2;i++){
		Order order=new Order();
		order.setAddress("Groningen"+i);
		order.setCustomerNumber(i);
		order.setOrderNumber(i*10);
		Shipper shipper = new Shipper();
		shipper.getOrder(order);
	}
	
	
	}
	
}

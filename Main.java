
public class Main {
	
	public static void main(String[] args) {
		Receivers receiver = new Receivers();
		Shipper shipper = new Shipper();
		Hub hub=new Hub();
		for(int i=0;i<=1;i++){
		Order order1 =receiver.placeOrder();	
		receiver.sendOrderToShipper(order1,shipper);		
		//shipper.showOrdersinShipper();
		shipper.sendOrderToHub(order1,hub);
		//hub.showOrdersinHub();
		hub.sendOrderToReceiver(order1,receiver);
		//receiver.showOrdersinReceivers();
		}

	}

}
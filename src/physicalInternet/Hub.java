package physicalInternet;


import java.util.ArrayList;

public class Hub {
   
    private ArrayList<Order> orders = new ArrayList<Order>();
private int x;
private int y;

    /**
     * Constructor
     */
    public Hub(int x,int y) {
      
        this.x=x;
        this.y=y;
    }

    /**
     * Constructor
     *
     * @param region The region identifier (as an integer).
     */
    public Hub(int region,int x ,int y) {
      
        this.x=x;
        this.y=y;
    }

    public void getOrder(Order order) {
        orders.add(order);
        showOrdersinHub();
    }

    public void showOrdersinHub() {
        System.out.println("In Hub:");

        for (Order order : orders) {
            System.out.println("Address:" + order.getAddress());
            System.out.println("Customer Number:" + order.getCustomerNumber());
            System.out.println("time" + order.getTimeOfOrder());
        }
    }

    public void sendOrderToHub(Order order, Hub other) {
        other.getOrder(order);
        removeOrder(order);
    }

    public void sendOrderToReceiver(Order order, Transit transit) {
        transit.getOrderFromHub(order);
        removeOrder(order);
    }

    public void sendOrderToReceiver(Order order, Receiver receiver) {
        receiver.getOrder(order);
        removeOrder(order);
    }

    private void removeOrder(Order order) {
        orders.remove(order);
    }

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}

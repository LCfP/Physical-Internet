package physicalInternet;


import java.util.ArrayList;

public class Shipper {
    public final int region;
    private ArrayList<Order> orders = new ArrayList<Order>();
    private ArrayList<Container> containers = new ArrayList<Container>();

    /**
     * Constructor
     */
    public Shipper() {
        this.region = 0;
    }

    /**
     * Constructor
     *
     * @param region The region identifier (as an integer).
     */
    public Shipper(int region) {
        this.region = region;
    }

    public void getOrder(Order order) {
        orders.add(order);
        showOrdersinShipper();
    }

    public void showOrdersinShipper() {
        System.out.println("In Shipper:");

        for (Order order : orders) {
            System.out.println("Address:" + order.getAddress());
            System.out.println("Customer Number" + order.getCustomerNumber());
        }
    }
    public void Container(Container container) {
        containers.add(container);
        container.setOrders(orders);
    }

    public void sendOrderToHub(Order order, Transit transit, Container container) {
        transit.getOrderFromShipper(order);
        removeOrder(order);
    }


    private void removeOrder(Order order) {
        orders.remove(order);
    }
}

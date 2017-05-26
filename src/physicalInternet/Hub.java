package physicalInternet;


import java.util.ArrayList;

public class Hub {
    private ArrayList<Order> orders = new ArrayList<Order>();

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
}

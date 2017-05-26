package physicalInternet;


import java.util.ArrayList;

public class Order {
    private int customerNumber;
    private int orderNumber;
    private String address;
    private ArrayList<Product> products;
    private int timeOfOrder;

    public int getCustomerNumber() {
        return this.customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public int getOrderNumber() {
        return this.orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ArrayList<Product> getProducts() {
        return this.products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public int getTimeOfOrder() {
        return timeOfOrder;
    }

    public void setTimeOfOrder(int timeOfOrder) {
        this.timeOfOrder = timeOfOrder;
    }
}


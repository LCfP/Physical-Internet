package physicalInternet;

public class Container {
    private double weight;
    private int volume;
    private int customerNumber;
    private int orderNumber;
    private int containerNumber;
    private String adress;
    
    public Container (double weight, int volume, int customerNumber, int orderNumber, int containerNumber, String adress){
    	this.weight = weight;
    	this.volume = volume;
    	this.customerNumber = customerNumber;
    	this.orderNumber = orderNumber;
    	this.containerNumber = containerNumber;
    	this.adress = adress;
    	
    }

	public double getWeight() {
		return weight;
	}

	public int getVolume() {
		return volume;
	}

	public int getCustomerNumber() {
		return customerNumber;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public int getContainerNumber() {
		return containerNumber;
	}

	public String getAdress() {
		return adress;
	}
}

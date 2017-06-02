package physicalInternet;

public class Trailor {
	private double trailorWeight = 100;
	
	
	
	public double getTotalWeight() {
		return trailorWeight;
	}

	public void setTrailorWeight(int trailorWeight,Product product) {
		 this.trailorWeight=  this.trailorWeight + product.getWeight();

}
}
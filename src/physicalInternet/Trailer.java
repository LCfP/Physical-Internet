package physicalInternet;

import java.util.ArrayList;

public class Trailer {
	private double trailerWeight = 100;
	private ArrayList<Product> productsOnTrailer;
	private ArrayList<Container> containersOnTrailer;

	// put products on trailer
	public ArrayList<Product> getProducts() {
		return this.productsOnTrailer;
	}

	public void setProducts(ArrayList<Product> productsOnTrailer) {
		this.productsOnTrailer = productsOnTrailer;
	}

	public double getTotalWeight() {
		return trailerWeight;
	}

	public void setTrailerWeight(int trailerWeight, Order order) {
		//this.trailerWeight = trailerWeight + order.getWeightOrder();

	}

	public void setContainersOnTrailer(Container container) {
		containersOnTrailer.add(container);
	} // Have to call total amount of shippers.
}
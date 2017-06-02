package physicalInternet;

import java.util.ArrayList;

public class Trailer {
	private double trailerWeight = 100;
	private ArrayList<Product> productsOnTrailer;

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

	public void setTrailorWeight(int trailorWeight, Product product) {
		this.trailerWeight = this.trailerWeight + product.getWeight();

	}
}
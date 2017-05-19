package physicalInternet;

public class Product {

	private double weight = 5.0;
	private int height = 1;
	private int width = 1;
	private int depth = 1;
	private String productName;
	private int[][][] dimensionArray = new int[10][10][10];
	private int dimension = dimensionArray[height][width][depth]; // something goes wrong here

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int[][][] getDimensionArray() {
		return dimensionArray;
	}

	public void setDimensionArray(int[][][] dimensionArray) {
		this.dimensionArray = dimensionArray;
	}

	public int getDimension() {
		return dimension;
	}

	public void setDimension(int dimension) {
		this.dimension = dimension;
	}

	/*
	 * public Product( double weight, int height, int width, int depth, String
	 * productName){ this.weight = weight; this.height = height; this.width =
	 * width; this.depth = depth; this.productName = productName; }
	 */

}

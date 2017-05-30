package physicalInternet;

public class Product {
    private double weight;
    private int height;
    private int width;
    private int depth;
    private String productName;

    /**
     * Constructor
     *
     * @param weight      This is the weight of the product.
     * @param height      This is the height of the product.
     * @param width       This is the width of the product.
     * @param depth       This is the depth of the product.
     * @param productName This is the name of the product.
     */
    public Product(double weight, int height, int width, int depth, String productName) {
        this.weight = weight;

        this.height = height;
        this.width = width;
        this.depth = depth;

        this.productName = productName;
    }

    public double getWeight() {
        return weight;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getDepth() {
        return depth;
    }

    public String getProductName() {
        return productName;
    }
}

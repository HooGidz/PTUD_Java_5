package db;

public class CartItem {
	private int productId;
	private String name;
	private double price;
	private String image;
	private int quantity;

	public CartItem(int productId, String name, double price, String image, int quantity) {
		this.productId = productId;
		this.name = name;
		this.price = price;
		this.image = image;
		this.quantity = quantity;
	}

	public double getTotalPrice() {
		return this.price * this.quantity;
	}

	// Constructor mặc định
	public CartItem() {
	}

	// Getters and Setters
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "CartItem{" + "productId=" + productId + ", name=" + name + ", quantity=" + quantity + '}';
	}
}
package db;



public class tbl_OrderDetail {
    private int orderDetailId;
    private int orderId;
    private int productId;
    private double price;
    private int quantity;
	public tbl_OrderDetail(int orderDetailId, int orderId, int productId, double price, int quantity) {
		super();
		this.orderDetailId = orderDetailId;
		this.orderId = orderId;
		this.productId = productId;
		this.price = price;
		this.quantity = quantity;
	}
	public int getOrderDetailId() {
		return orderDetailId;
	}
	public void setOrderDetailId(int orderDetailId) {
		this.orderDetailId = orderDetailId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "tbl_OrderDetail [orderDetailId=" + orderDetailId + ", orderId=" + orderId + ", productId=" + productId
				+ ", price=" + price + ", quantity=" + quantity + "]";
	}
	
	
}
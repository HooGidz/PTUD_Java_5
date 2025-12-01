package db;

public class tbl_OrderStatus {
	private int orderStatusId;
	private int orderId;
	private String name;
	private String description;

	public tbl_OrderStatus(int orderStatusId, int orderId, String name, String description) {
		super();
		this.orderStatusId = orderStatusId;
		this.orderId = orderId;
		this.name = name;
		this.description = description;
	}

	public int getOrderStatusId() {
		return orderStatusId;
	}

	public void setOrderStatusId(int orderStatusId) {
		this.orderStatusId = orderStatusId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "tbl_OrderStatus [orderStatusId=" + orderStatusId + ", orderId=" + orderId + ", name=" + name
				+ ", description=" + description + "]";
	}

}
package db;
import java.util.Date;;
public class tbl_Order {
	private int orderId;
	private String customerName;
	private String phone;
	private String address;
	private int totalAmount;
	private int quantity;
	private Date createdDate;
	private String createdBy;
	private Date modifiedDate;
	private String modifiedBy;
	private String note;
	private String paymentMethod;
	public tbl_Order(int orderId, String customerName, String phone, String address, int totalAmount, int quantity,
			Date createdDate, String createdBy, Date modifiedDate, String modifiedBy, String note,
			String paymentMethod) {
		super();
		this.orderId = orderId;
		this.customerName = customerName;
		this.phone = phone;
		this.address = address;
		this.totalAmount = totalAmount;
		this.quantity = quantity;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.modifiedDate = modifiedDate;
		this.modifiedBy = modifiedBy;
		this.note = note;
		this.paymentMethod = paymentMethod;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	@Override
	public String toString() {
		return "tbl_Order [orderId=" + orderId + ", customerName=" + customerName + ", phone=" + phone + ", address="
				+ address + ", totalAmount=" + totalAmount + ", quantity=" + quantity + ", createdDate=" + createdDate
				+ ", createdBy=" + createdBy + ", modifiedDate=" + modifiedDate + ", modifiedBy=" + modifiedBy
				+ ", note=" + note + ", paymentMethod=" + paymentMethod + "]";
	}
	
}
package db;

import java.util.Date;

public class tbl_ProductReview {
	private int productReviewId;
    private int productId;
    private String name;
    private String phone;
    private String email;
    private Date createdDate;
    private String detail;
    private int star; 
    private boolean isActive;
    
	public tbl_ProductReview(int productReviewId, int productId, String name, String phone, String email,
			Date createdDate, String detail, int star, boolean isActive) {
		super();
		this.productReviewId = productReviewId;
		this.productId = productId;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.createdDate = createdDate;
		this.detail = detail;
		this.star = star;
		this.isActive = isActive;
	}

	public int getProductReviewId() {
		return productReviewId;
	}

	public void setProductReviewId(int productReviewId) {
		this.productReviewId = productReviewId;
	}

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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public int getStar() {
		return star;
	}

	public void setStar(int star) {
		this.star = star;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "tbl_ProductReview [productReviewId=" + productReviewId + ", productId=" + productId + ", name=" + name
				+ ", phone=" + phone + ", email=" + email + ", createdDate=" + createdDate + ", detail=" + detail
				+ ", star=" + star + ", isActive=" + isActive + "]";
	}
    
    
}

package db;

import java.util.Date;

public class tbl_BlogComment {
	private int commentId;
	private String name;
	private String phone;
	private String email;
	private Date createddate;
	private String detail;
	private int blogId;
	private boolean isactive;
	public tbl_BlogComment() {};
	public tbl_BlogComment(int commentId, String name, String phone, String email, Date createddate, String detail,
			int blogId, boolean isactive) {
		super();
		this.commentId = commentId;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.createddate = createddate;
		this.detail = detail;
		this.blogId = blogId;
		this.isactive = isactive;
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
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

	public Date getCreateddate() {
		return createddate;
	}

	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public int getBlogId() {
		return blogId;
	}

	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}

	public boolean isIsactive() {
		return isactive;
	}

	public void setIsactive(boolean isactive) {
		this.isactive = isactive;
	}

	@Override
	public String toString() {
		return "tbl_BlogComment [commentId=" + commentId + ", name=" + name + ", phone=" + phone + ", email=" + email
				+ ", createddate=" + createddate + ", detail=" + detail + ", blogId=" + blogId + ", isactive="
				+ isactive + "]";
	}

}
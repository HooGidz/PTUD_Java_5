package db;
import java.util.Date;


public class tbl_Contact {
	private int contatcId;
	private String name;
	private String phone;
	private String email;
	private String message;
	private boolean isRead;
	private Date createDate;
	private String createBy;
	public tbl_Contact(int contatcId, String name, String phone, String email, String message, boolean isRead,
			Date createDate, String createBy) {
		super();
		this.contatcId = contatcId;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.message = message;
		this.isRead = isRead;
		this.createDate = createDate;
		this.createBy = createBy;
	}
	public int getContatcId() {
		return contatcId;
	}
	public void setContatcId(int contatcId) {
		this.contatcId = contatcId;
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
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isRead() {
		return isRead;
	}
	public void setRead(boolean isRead) {
		this.isRead = isRead;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	@Override
	public String toString() {
		return "tbl_Contact [contatcId=" + contatcId + ", name=" + name + ", phone=" + phone + ", email=" + email
				+ ", message=" + message + ", isRead=" + isRead + ", createDate=" + createDate + ", createBy="
				+ createBy + "]";
	}


}

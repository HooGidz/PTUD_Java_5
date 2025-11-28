package db;
import java.util.Date;
public class tbl_Account{
	private int accountId;
	private String username;
	private String password;
	private String fullname;
	private String phone;
	private String email;
	private Date birthday;
	private String avatar;
	private int roleId;
	private String lastlogin;
	private boolean isactive;
	public tbl_Account(int accountId, String username, String password, String fullname, String phone, String email,
			Date birthday, String avatar, int roleId, String lastlogin, boolean isactive) {
		super();
		this.accountId = accountId;
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.phone = phone;
		this.email = email;
		this.birthday = birthday;
		this.avatar = avatar;
		this.roleId = roleId;
		this.lastlogin = lastlogin;
		this.isactive = isactive;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
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
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getLastlogin() {
		return lastlogin;
	}
	public void setLastlogin(String lastlogin) {
		this.lastlogin = lastlogin;
	}
	public boolean isIsactive() {
		return isactive;
	}
	public void setIsactive(boolean isactive) {
		this.isactive = isactive;
	}
	@Override
	public String toString() {
		return "tbl_Account [accountId=" + accountId + ", username=" + username + ", password=" + password
				+ ", fullname=" + fullname + ", phone=" + phone + ", email=" + email + ", birthday=" + birthday
				+ ", avatar=" + avatar + ", roleId=" + roleId + ", lastlogin=" + lastlogin + ", isactive=" + isactive
				+ "]";
	}
	
	
}
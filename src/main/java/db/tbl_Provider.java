package db;

public class tbl_Provider {
	private int providerId;
	private String providerName;
	private String address;
	private String phone;
	private String email;
	private String description;
	private boolean status;

	public tbl_Provider(int providerId, String providerName, String address, String phone, String email,
			String description, boolean status) {
		super();
		this.providerId = providerId;
		this.providerName = providerName;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.description = description;
		this.status = status;
	}

	public int getProviderId() {
		return providerId;
	}

	public void setProviderId(int providerId) {
		this.providerId = providerId;
	}

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "tbl_Provider [providerId=" + providerId + ", providerName=" + providerName + ", address=" + address
				+ ", phone=" + phone + ", email=" + email + ", description=" + description + ", status=" + status + "]";
	}

}
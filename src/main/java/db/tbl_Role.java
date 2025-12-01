package db;

public class tbl_Role {
	private int roleId;
	private String rolename;
	private String description;

	public tbl_Role(int roleId, String rolename, String description) {
		super();
		this.roleId = roleId;
		this.rolename = rolename;
		this.description = description;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "tbl_Role [roleId=" + roleId + ", rolename=" + rolename + ", description=" + description + "]";
	}

}
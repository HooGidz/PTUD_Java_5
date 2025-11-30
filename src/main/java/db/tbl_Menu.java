package db;
import java.util.Date;


public class tbl_Menu {
	private int menuId;
	private String name;
	private String alias;
	private String description;
	private int position;
	private Date createDate;
	private String createBy;
	private Date modifiedDate;
	private String modifiedBy;
	private boolean isActive;
	private boolean isdropdown;
	public tbl_Menu(int menuId, String name, String alias, String description, int position, Date createDate,
			String createBy, Date modifiedDate, String modifiedBy, boolean isActive, boolean isdropdown) {
		super();
		this.menuId = menuId;
		this.name = name;
		this.alias = alias;
		this.description = description;
		this.position = position;
		this.createDate = createDate;
		this.createBy = createBy;
		this.modifiedDate = modifiedDate;
		this.modifiedBy = modifiedBy;
		this.isActive = isActive;
		this.isdropdown = isdropdown;
	}
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
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
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public boolean isIsdropdown() {
		return isdropdown;
	}
	public void setIsdropdown(boolean isdropdown) {
		this.isdropdown = isdropdown;
	}
	@Override
	public String toString() {
		return "tbl_Menu [menuId=" + menuId + ", name=" + name + ", alias=" + alias + ", description=" + description
				+ ", position=" + position + ", createDate=" + createDate + ", createBy=" + createBy + ", modifiedDate="
				+ modifiedDate + ", modifiedBy=" + modifiedBy + ", isActive=" + isActive + ", isdropdown=" + isdropdown
				+ "]";
	}
	

}

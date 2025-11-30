package db;

public class tbl_ProductCategory {
	private int categoryId;
	private int roomCategoryId;
    private String name;
    private String alias;
    private String description;
    private boolean isActive;
	public tbl_ProductCategory(int categoryId, int roomCategoryId, String name, String alias, String description,
			boolean isActive) {
		super();
		this.categoryId = categoryId;
		this.roomCategoryId = roomCategoryId;
		this.name = name;
		this.alias = alias;
		this.description = description;
		this.isActive = isActive;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getRoomCategoryId() {
		return roomCategoryId;
	}
	public void setRoomCategoryId(int roomCategoryId) {
		this.roomCategoryId = roomCategoryId;
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
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	@Override
	public String toString() {
		return "tbl_ProductCategory [categoryId=" + categoryId + ", roomCategoryId=" + roomCategoryId + ", name=" + name
				+ ", alias=" + alias + ", description=" + description + ", isActive=" + isActive + "]";
	}


}

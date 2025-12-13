package db;

import java.util.Date;

public class tbl_Collection {

	private int collectionId;
	private String name;
	private String alias;
	private String designer;
	private String maker;
	private String description;
	private String detail;
	private String image;
	private boolean isNew;
	private boolean isBestSeller;
	private boolean isActive;
	private Date createdDate;

	public tbl_Collection(int collectionId, String name, String alias, String designer, String maker,
			String description, String detail, String image, boolean isNew, boolean isBestSeller, boolean isActive,
			Date createdDate) {
		super();
		this.collectionId = collectionId;
		this.name = name;
		this.alias = alias;
		this.designer = designer;
		this.maker = maker;
		this.description = description;
		this.detail = detail;
		this.image = image;
		this.isNew = isNew;
		this.isBestSeller = isBestSeller;
		this.isActive = isActive;
		this.createdDate = createdDate;
	}

	public int getCollectionId() {
		return collectionId;
	}

	public void setCollectionId(int collectionId) {
		this.collectionId = collectionId;
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

	public String getDesigner() {
		return designer;
	}

	public void setDesigner(String designer) {
		this.designer = designer;
	}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public boolean isNew() {
		return isNew;
	}

	public void setNew(boolean isNew) {
		this.isNew = isNew;
	}

	public boolean isBestSeller() {
		return isBestSeller;
	}

	public void setBestSeller(boolean isBestSeller) {
		this.isBestSeller = isBestSeller;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public String toString() {
		return "tbl_Collection [collectionId=" + collectionId + ", name=" + name + ", alias=" + alias + ", designer="
				+ designer + ", maker=" + maker + ", description=" + description + ", detail=" + detail + ", image="
				+ image + ", isNew=" + isNew + ", isBestSeller=" + isBestSeller + ", isActive=" + isActive
				+ ", createdDate=" + createdDate + "]";
	}

}
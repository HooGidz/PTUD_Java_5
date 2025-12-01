package db;

import java.util.Date;

public class tbl_Blog {
	private int blogId;
	private int accountId;
	private String title;
	private String alias;
	private int categoryId;
	private String description;
	private String detail;
	private String image;
	private String seotitle;
	private String seodescription;
	private String seokeywords;
	private Date createdate;
	private String createby;
	private Date modifieddate;
	private String modifiedby;
	private boolean isactive;

	public tbl_Blog(int blogId, int accountId, String title, String alias, int categoryId, String description,
			String detail, String image, String seotitle, String seodescription, String seokeywords, Date createdate,
			String createby, Date modifieddate, String modifiedby, boolean isactive) {
		super();
		this.blogId = blogId;
		this.accountId = accountId;
		this.title = title;
		this.alias = alias;
		this.categoryId = categoryId;
		this.description = description;
		this.detail = detail;
		this.image = image;
		this.seotitle = seotitle;
		this.seodescription = seodescription;
		this.seokeywords = seokeywords;
		this.createdate = createdate;
		this.createby = createby;
		this.modifieddate = modifieddate;
		this.modifiedby = modifiedby;
		this.isactive = isactive;
	}

	public int getBlogId() {
		return blogId;
	}

	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
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

	public String getSeotitle() {
		return seotitle;
	}

	public void setSeotitle(String seotitle) {
		this.seotitle = seotitle;
	}

	public String getSeodescription() {
		return seodescription;
	}

	public void setSeodescription(String seodescription) {
		this.seodescription = seodescription;
	}

	public String getSeokeywords() {
		return seokeywords;
	}

	public void setSeokeywords(String seokeywords) {
		this.seokeywords = seokeywords;
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public String getCreateby() {
		return createby;
	}

	public void setCreateby(String createby) {
		this.createby = createby;
	}

	public Date getModifieddate() {
		return modifieddate;
	}

	public void setModifieddate(Date modifieddate) {
		this.modifieddate = modifieddate;
	}

	public String getModifiedby() {
		return modifiedby;
	}

	public void setModifiedby(String modifiedby) {
		this.modifiedby = modifiedby;
	}

	public boolean isIsactive() {
		return isactive;
	}

	public void setIsactive(boolean isactive) {
		this.isactive = isactive;
	}

	@Override
	public String toString() {
		return "tbl_Blog [blogId=" + blogId + ", accountId=" + accountId + ", title=" + title + ", alias=" + alias
				+ ", categoryId=" + categoryId + ", description=" + description + ", detail=" + detail + ", image="
				+ image + ", seotitle=" + seotitle + ", seodescription=" + seodescription + ", seokeywords="
				+ seokeywords + ", createdate=" + createdate + ", createby=" + createby + ", modifieddate="
				+ modifieddate + ", modifiedby=" + modifiedby + ", isactive=" + isactive + "]";
	}

}
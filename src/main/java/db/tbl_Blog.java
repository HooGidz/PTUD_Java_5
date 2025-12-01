package db;

import java.util.Date;

public class tbl_Blog {

    private int blogId;              // Blog_ID
    private int accountId;           // Account_ID
    private String title;            // Title
    private String alias;            // Alias
    private int categoryId;          // Category_ID
    private String description;      // Description
    private String detail;           // Detail
    private String image;            // Image
    private String seoTitle;         // SeoTitle
    private String seoDescription;   // SeoDescription
    private String seoKeywords;      // SeoKeywords
    private Date createDate;         // CreatedDate
    private String createBy;         // CreateBy
    private Date modifiedDate;       // ModifiedDate
    private String modifiedBy;       // ModifiedBy
    private boolean isActive;     
    public tbl_Blog() {}// IsActive
	public tbl_Blog(int blogId, int accountId, String title, String alias, int categoryId, String description,
			String detail, String image, String seoTitle, String seoDescription, String seoKeywords, Date createDate,
			String createBy, Date modifiedDate, String modifiedBy, boolean isActive) {
		super();
		this.blogId = blogId;
		this.accountId = accountId;
		this.title = title;
		this.alias = alias;
		this.categoryId = categoryId;
		this.description = description;
		this.detail = detail;
		this.image = image;
		this.seoTitle = seoTitle;
		this.seoDescription = seoDescription;
		this.seoKeywords = seoKeywords;
		this.createDate = createDate;
		this.createBy = createBy;
		this.modifiedDate = modifiedDate;
		this.modifiedBy = modifiedBy;
		this.isActive = isActive;
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
	public String getSeoTitle() {
		return seoTitle;
	}
	public void setSeoTitle(String seoTitle) {
		this.seoTitle = seoTitle;
	}
	public String getSeoDescription() {
		return seoDescription;
	}
	public void setSeoDescription(String seoDescription) {
		this.seoDescription = seoDescription;
	}
	public String getSeoKeywords() {
		return seoKeywords;
	}
	public void setSeoKeywords(String seoKeywords) {
		this.seoKeywords = seoKeywords;
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
	@Override
	public String toString() {
		return "tbl_Blog [blogId=" + blogId + ", accountId=" + accountId + ", title=" + title + ", alias=" + alias
				+ ", categoryId=" + categoryId + ", description=" + description + ", detail=" + detail + ", image="
				+ image + ", seoTitle=" + seoTitle + ", seoDescription=" + seoDescription + ", seoKeywords="
				+ seoKeywords + ", createDate=" + createDate + ", createBy=" + createBy + ", modifiedDate="
				+ modifiedDate + ", modifiedBy=" + modifiedBy + ", isActive=" + isActive + "]";
	}

    
}
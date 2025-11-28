package db;

public class tbl_Product {
	private int productId;
    private int providerId;
    private int categoryId;
    private String name;
    private String alias;
    private String brands;
    private String material;
    private String dimensions;
    private String description;
    private String detail;
    private String image;
    private double price;
    private double priceSale;
    private int quantity;
    private boolean isNew;
    private boolean isBestSeller;
    private boolean isActive;
    private int star;
    
	public tbl_Product(int productId, int providerId, int categoryId, String name, String alias, String brands,
			String material, String dimensions, String description, String detail, String image, double price,
			double priceSale, int quantity, boolean isNew, boolean isBestSeller, boolean isActive, int star) {
		super();
		this.productId = productId;
		this.providerId = providerId;
		this.categoryId = categoryId;
		this.name = name;
		this.alias = alias;
		this.brands = brands;
		this.material = material;
		this.dimensions = dimensions;
		this.description = description;
		this.detail = detail;
		this.image = image;
		this.price = price;
		this.priceSale = priceSale;
		this.quantity = quantity;
		this.isNew = isNew;
		this.isBestSeller = isBestSeller;
		this.isActive = isActive;
		this.star = star;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getProviderId() {
		return providerId;
	}
	public void setProviderId(int providerId) {
		this.providerId = providerId;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
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
	public String getBrands() {
		return brands;
	}
	public void setBrands(String brands) {
		this.brands = brands;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public String getDimensions() {
		return dimensions;
	}
	public void setDimensions(String dimensions) {
		this.dimensions = dimensions;
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getPriceSale() {
		return priceSale;
	}
	public void setPriceSale(double priceSale) {
		this.priceSale = priceSale;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
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
	public int getStar() {
		return star;
	}
	public void setStar(int star) {
		this.star = star;
	}
	@Override
	public String toString() {
		return "tbl_Product [productId=" + productId + ", providerId=" + providerId + ", categoryId=" + categoryId
				+ ", name=" + name + ", alias=" + alias + ", brands=" + brands + ", material=" + material
				+ ", dimensions=" + dimensions + ", description=" + description + ", detail=" + detail + ", image="
				+ image + ", price=" + price + ", priceSale=" + priceSale + ", quantity=" + quantity + ", isNew="
				+ isNew + ", isBestSeller=" + isBestSeller + ", isActive=" + isActive + ", star=" + star + "]";
	}
    

}

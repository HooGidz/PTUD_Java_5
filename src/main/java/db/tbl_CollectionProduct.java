package db;

public class tbl_CollectionProduct {

	private int collectionId;
	private int productId;

	public tbl_CollectionProduct(int collectionId, int productId) {
		super();
		this.collectionId = collectionId;
		this.productId = productId;
	}

	public int getCollectionId() {
		return collectionId;
	}

	public void setCollectionId(int collectionId) {
		this.collectionId = collectionId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	@Override
	public String toString() {
		return "tbl_ConllectionProduct [collectionId=" + collectionId + ", productId=" + productId + "]";
	}

}

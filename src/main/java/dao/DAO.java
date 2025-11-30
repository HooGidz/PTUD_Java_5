package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import db.DBConnect;
import db.tbl_Menu;
import db.tbl_Order;
import db.tbl_OrderDetail;
import db.tbl_OrderStatus;
import db.tbl_Provider;
import db.tbl_RoomCategory;
import db.tbl_Product;
import db.tbl_ProductCategory;
import db.tbl_Collection;

public class DAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public List<tbl_Menu> getAllMenu() {
		List<tbl_Menu> list = new ArrayList<>();
		String query = "select * from tbl_Menu";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new tbl_Menu(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),
						rs.getDate(6), rs.getString(7), rs.getDate(8), rs.getString(9), rs.getBoolean(10),
						rs.getBoolean(11)));

			}

		} catch (Exception e) {

		}

		return list;
	}

	public List<tbl_RoomCategory> getAllRoomcategory() {
		List<tbl_RoomCategory> list = new ArrayList<>();
		String query = "select * from tbl_RoomCategory";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new tbl_RoomCategory(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getBoolean(5)));
			}

		} catch (Exception e) {

		}

		return list;
	}

	// user trang sản phẩm
	public List<tbl_Product> getAllProduct() {
		List<tbl_Product> list = new ArrayList<>();
		String query = "select * from tbl_Product";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new tbl_Product(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),
						rs.getString(11), rs.getDouble(12), rs.getDouble(13), rs.getInt(14), rs.getBoolean(15),
						rs.getBoolean(16), rs.getBoolean(17), rs.getInt(18)));

			}

		} catch (Exception e) {

		}

		return list;
	}

	public List<tbl_ProductCategory> getAllCategory() {
		List<tbl_ProductCategory> list = new ArrayList<>();
		String query = "SELECT * FROM tbl_ProductCategory";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new tbl_ProductCategory(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getBoolean(6)));
			}
		} catch (Exception e) {
		}
		return list;
	}

	public List<tbl_Product> getProductByCID(String cid) {
		List<tbl_Product> list = new ArrayList<>();
		String query = "SELECT * FROM tbl_Product WHERE Category_ID = ?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, cid);
			rs = ps.executeQuery();

			while (rs.next()) {
				list.add(new tbl_Product(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),
						rs.getString(11), rs.getDouble(12), rs.getDouble(13), rs.getInt(14), rs.getBoolean(15),
						rs.getBoolean(16), rs.getBoolean(17), rs.getInt(18)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<tbl_Product> getBestSellerProduct() {
		List<tbl_Product> list = new ArrayList<>();
		String query = "SELECT * FROM tbl_Product WHERE isBestSeller = 1";

		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next()) {
				list.add(new tbl_Product(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),
						rs.getString(11), rs.getDouble(12), rs.getDouble(13), rs.getInt(14), rs.getBoolean(15),
						rs.getBoolean(16), rs.getBoolean(17), rs.getInt(18)));
			}
		} catch (Exception e) {
		}
		return list;
	}

	public List<tbl_Product> pagingProduct(int index, int pageSize) {
		List<tbl_Product> list = new ArrayList<>();
		String query = "SELECT * FROM tbl_Product ORDER BY Product_ID OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";

		if (index < 1)
			index = 1;
		if (pageSize < 1)
			pageSize = 10;

		try (Connection conn = new DBConnect().getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {

			ps.setInt(1, (index - 1) * pageSize);
			ps.setInt(2, pageSize);

			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					list.add(new tbl_Product(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5),
							rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),
							rs.getString(11), rs.getDouble(12), rs.getDouble(13), rs.getInt(14), rs.getBoolean(15),
							rs.getBoolean(16), rs.getBoolean(17), rs.getInt(18)));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public int getTotalProductByCID(String cid) {
		String query = "SELECT COUNT(*) FROM tbl_Product WHERE Category_ID = ?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, cid);
			rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int getTotalAllProduct() {
		String query = "SELECT COUNT(*) FROM tbl_Product";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
		return 0;
	}

	// user trang bộ sưu tập
	public List<tbl_Collection> getAllCollection() {
		List<tbl_Collection> list = new ArrayList<>();
		String query = "SELECT * FROM tbl_Collection";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next()) {
				list.add(new tbl_Collection(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getBoolean(9),
						rs.getBoolean(10), rs.getBoolean(11), rs.getDate(12)));
			}
		} catch (Exception e) {
		}
		return list;
	}

	public tbl_Collection getCollectionById(int id) {
		String query = "SELECT * FROM tbl_Collection WHERE Collection_ID = ?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();

			if (rs.next()) {
				return new tbl_Collection(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getBoolean(9),
						rs.getBoolean(10), rs.getBoolean(11), rs.getDate(12));
			}
		} catch (Exception e) {
		}
		return null;
	}

	public List<tbl_Product> getProductsByCollectionId(int cid) {
		List<tbl_Product> list = new ArrayList<>();

		String query = "SELECT * FROM tbl_Product p JOIN tbl_CollectionProduct cp ON p.Product_ID = cp.Product_ID WHERE cp.Collection_ID = ?";

		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, cid);
			rs = ps.executeQuery();

			while (rs.next()) {
				list.add(new tbl_Product(rs.getInt(1), // productId
						rs.getInt(2), // categoryId
						rs.getInt(3), // supplierId
						rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),
						rs.getString(9), rs.getString(10), rs.getString(11), rs.getDouble(12), rs.getDouble(13),
						rs.getInt(14), rs.getBoolean(15), rs.getBoolean(16), rs.getBoolean(17), rs.getInt(18)));
			}

		} catch (Exception e) {
		}

		return list;
	}

	// admin thêm,sửa,xóa sản phẩm
	public void addProduct(tbl_Product p) {
		String query = "INSERT INTO tbl_Product "
				+ "(Provider_ID, Category_ID, name, alias, brands, material, dimensions, "
				+ "description, detail, image, price, priceSale, quantity, isNew, isBestSeller, isActive, star) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try (Connection conn = new DBConnect().getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {

			ps.setInt(1, p.getProviderId());
			ps.setInt(2, p.getCategoryId());
			ps.setString(3, p.getName());
			ps.setString(4, p.getAlias());
			ps.setString(5, p.getBrands());
			ps.setString(6, p.getMaterial());
			ps.setString(7, p.getDimensions());
			ps.setString(8, p.getDescription());
			ps.setString(9, p.getDetail());
			ps.setString(10, p.getImage());
			ps.setDouble(11, p.getPrice());
			ps.setDouble(12, p.getPriceSale());
			ps.setInt(13, p.getQuantity());
			ps.setBoolean(14, p.isNew());
			ps.setBoolean(15, p.isBestSeller());
			ps.setBoolean(16, p.isActive());
			ps.setInt(17, p.getStar());

			int rowsInserted = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Lỗi thêm sản phẩm vào DB: " + e.getMessage(), e);
		}
	}

	public tbl_Product getProductById(int id) {
		String query = "SELECT Product_ID AS productId, Provider_ID, Category_ID, Name, Alias, "
				+ "Brands, Material, Dimensions, Description, Detail, Image, "
				+ "Price, PriceSale, Quantity, IsNew, IsBestSeller, IsActive, Star "
				+ "FROM tbl_Product WHERE Product_ID = ?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				return new tbl_Product(rs.getInt("productId"), rs.getInt("Provider_ID"), rs.getInt("Category_ID"),
						rs.getString("name"), rs.getString("alias"), rs.getString("brands"), rs.getString("material"),
						rs.getString("dimensions"), rs.getString("description"), rs.getString("detail"),
						rs.getString("image"), rs.getDouble("price"), rs.getDouble("priceSale"), rs.getInt("quantity"),
						rs.getBoolean("isNew"), rs.getBoolean("isBestSeller"), rs.getBoolean("isActive"),
						rs.getInt("Star"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void editProduct(int productId, int providerId, int categoryId, String name, String alias, String brands,
			String material, String dimensions, String description, String detail, String image, double price,
			double priceSale, int quantity, boolean isBestSeller, boolean isActive, int star) {
		String query = "UPDATE tbl_Product SET " + "Provider_ID = ?, Category_ID = ?, Name = ?, Alias = ?, Brands = ?, "
				+ "Material = ?, Dimensions = ?, Description = ?, Detail = ?, Image = ?, "
				+ "Price = ?, PriceSale = ?, Quantity = ?, IsBestSeller = ?, " + "IsActive = ?, Star = ? "
				+ "WHERE Product_ID = ?";

		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);

			ps.setInt(1, providerId);
			ps.setInt(2, categoryId);
			ps.setString(3, name);
			ps.setString(4, alias);
			ps.setString(5, brands);
			ps.setString(6, material);
			ps.setString(7, dimensions);
			ps.setString(8, description);
			ps.setString(9, detail);
			ps.setString(10, image);
			ps.setDouble(11, price);
			ps.setDouble(12, priceSale);
			ps.setInt(13, quantity);
			ps.setBoolean(14, isBestSeller);
			ps.setBoolean(15, isActive);
			ps.setInt(16, star);
			ps.setInt(17, productId);

			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteProduct(int productId) {
		String query = "DELETE FROM tbl_Product WHERE Product_ID = ?";

		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, productId);
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//admin thêm,sửa,xóa danh mục sản phẩm
	public tbl_ProductCategory getProductCategoryById(int categoryId) {
		String query = "SELECT * FROM tbl_ProductCategory WHERE Category_ID = ?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, categoryId);
			rs = ps.executeQuery();
			if (rs.next()) {
				return new tbl_ProductCategory(rs.getInt("Category_ID"), rs.getInt("RoomCategory_ID"),
						rs.getString("name"), rs.getString("alias"), rs.getString("description"),
						rs.getBoolean("isActive"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void addProductCategory(String roomCategoryId, String name, String alias, String description,
			String isActive) {
		String query = "INSERT INTO tbl_ProductCategory(RoomCategory_ID, name, alias, description, isActive) VALUES (?, ?, ?, ?, ?)";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, roomCategoryId);
			ps.setString(2, name);
			ps.setString(3, alias);
			ps.setString(4, description);
			ps.setString(5, isActive);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void editProductCategory(int categoryId, int roomCategoryId, String name, String alias, String description,
			boolean isActive) {
		String query = "UPDATE tbl_ProductCategory SET RoomCategory_ID=?, name=?, alias=?, description=?, isActive=? WHERE Category_ID=?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, roomCategoryId);
			ps.setString(2, name);
			ps.setString(3, alias);
			ps.setString(4, description);
			ps.setBoolean(5, isActive);
			ps.setInt(6, categoryId);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteProductCategory(String categoryId) {
		String query = "DELETE FROM tbl_ProductCategory WHERE Category_ID = ?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, categoryId);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		DAO dao = new DAO();

		int testCollectionId = 1;
		// ---------------------------------------------

		System.out.println("--- KIỂM TRA getProductsByCollectionId ---");

		try {
			List<tbl_Product> list = dao.getProductsByCollectionId(testCollectionId);

			System.out.println("Collection ID đang kiểm tra: " + testCollectionId);
			System.out.println("Tổng số sản phẩm tìm thấy: " + list.size());

			if (list.isEmpty()) {
				System.out.println(
						"KHÔNG TÌM THẤY sản phẩm nào cho Collection ID này. Có thể Collection ID không tồn tại hoặc không có sản phẩm nào được liên kết.");
			} else {
				System.out.println("DANH SÁCH SẢN PHẨM:");
				for (tbl_Product o : list) {

					System.out.println(o);
				}
			}

		} catch (Exception e) {
			System.out.println("LỖI NGOẠI LỆ XẢY RA KHI TRUY VẤN DB:");
			e.printStackTrace();
		}
	}
}

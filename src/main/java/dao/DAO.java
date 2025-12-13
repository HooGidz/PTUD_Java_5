package dao;

import java.text.SimpleDateFormat;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.sql.PreparedStatement;

import db.CartItem;
import db.DBConnect;
import db.tbl_Menu;
import db.tbl_Order;
import db.tbl_OrderDetail;
import db.tbl_OrderStatus;
import db.tbl_Product;
import db.tbl_ProductReview;
import db.tbl_Provider;
import db.tbl_RoomCategory;
import db.tbl_Collection;
import db.tbl_ProductCategory;
import db.tbl_Product;
import db.tbl_Account;
import db.tbl_Contact;
import db.tbl_RoomCategory;
import db.tbl_ProductCategory;
import db.tbl_Blog;
import db.tbl_Collection;
import db.tbl_BlogComment;
import java.sql.Statement;
import db.tbl_Role;

public class DAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	/// --------USER--------///
	public List<tbl_Menu> getActiveMenu() {
		List<tbl_Menu> list = new ArrayList<>();
		String query = "select * from tbl_Menu where IsActive = 1";
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
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (Exception e) {
			}
			try {
				if (ps != null)
					ps.close();
			} catch (Exception e) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
		return list;
	}

	public List<tbl_Menu> getAllMenu() {
		List<tbl_Menu> list = new ArrayList<>();
		String query = "select * from tbl_Menu ";
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
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (Exception e) {
			}
			try {
				if (ps != null)
					ps.close();
			} catch (Exception e) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
		return list;
	}

	public tbl_Menu getMenuDetail(String menuId) {
		String query = "select * from tbl_Menu where Menu_ID = ?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, menuId);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new tbl_Menu(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),
						rs.getDate(6), rs.getString(7), rs.getDate(8), rs.getString(9), rs.getBoolean(10),
						rs.getBoolean(11));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (Exception e) {
			}
			try {
				if (ps != null)
					ps.close();
			} catch (Exception e) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
		return null;

	}

	public tbl_Menu getMenuById(String menuId) {
		String query = "select * from tbl_Menu where Menu_ID = ?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, menuId);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new tbl_Menu(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),
						rs.getDate(6), rs.getString(7), rs.getDate(8), rs.getString(9), rs.getBoolean(10),
						rs.getBoolean(11));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (Exception e) {
			}
			try {
				if (ps != null)
					ps.close();
			} catch (Exception e) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
		return null;

	}

	public void addMenu(String name, String alias, String description, String position, String createdDate,
			String createdBy, String modifiedDate, String modifiedBy, String isActive, String isDropdown) {

		String query = "INSERT INTO tbl_Menu "
				+ "(Name, Alias, Description, Position, CreatedDate, CreatedBy, ModifiedDate, ModifiedBy, IsActive, IsDropdown) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, alias);
			ps.setString(3, description);
			ps.setString(4, position);
			ps.setString(5, createdDate);
			ps.setString(6, createdBy);
			ps.setString(7, modifiedDate);
			ps.setString(8, modifiedBy);
			ps.setString(9, isActive);
			ps.setString(10, isDropdown);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
			} catch (Exception e) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
	}

	public void editMenu(String id, String name, String alias, String description, String position, String createdDate,
			String createdBy, String modifiedDate, String modifiedBy, String isActive, String isDropdown) {

		String query = "UPDATE tbl_Menu SET " + "Name = ?, Alias = ?, Description = ?, Position = ?, "
				+ "CreatedDate = ?, CreatedBy = ?, ModifiedDate = ?, ModifiedBy = ?, " + "IsActive = ?, IsDropdown = ? "
				+ "WHERE Menu_ID = ?";

		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);

			ps.setString(1, name);
			ps.setString(2, alias);
			ps.setString(3, description);
			ps.setString(4, position);
			ps.setString(5, createdDate);
			ps.setString(6, createdBy);
			ps.setString(7, modifiedDate);
			ps.setString(8, modifiedBy);
			ps.setString(9, isActive);
			ps.setString(10, isDropdown);
			ps.setString(11, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public void deleteMenu(String id) {
		String query = "delete from tbl_Menu where Menu_ID = ?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
			} catch (Exception e) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
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
			e.printStackTrace();

		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (Exception e) {
			}
			try {
				if (ps != null)
					ps.close();
			} catch (Exception e) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}

		return list;
	}

	public tbl_Product getProductDetail(String proId) {
		String query = "select * from tbl_Product where Product_ID = ?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, proId);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new tbl_Product(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),
						rs.getString(11), rs.getDouble(12), rs.getDouble(13), rs.getInt(14), rs.getBoolean(15),
						rs.getBoolean(16), rs.getBoolean(17), rs.getInt(18));
			}

		} catch (Exception e) {

		}
		return null;

	}

	public List<tbl_Product> getProBest() {
		List<tbl_Product> list = new ArrayList<>();
		String query = "select * from tbl_Product where IsBestSeller = 1";
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

	public List<tbl_ProductReview> getProReviewById(String id) {
		List<tbl_ProductReview> list = new ArrayList<>();
		String query = "select * from tbl_ProductReview where Product_ID = ?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new tbl_ProductReview(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getDate(6), rs.getString(7), rs.getInt(8), rs.getBoolean(9)));
			}

		} catch (Exception e) {

		}
		return list;
	}

	public void addProReview(String productId, String name, String phone, String email, String createdDate,
			String detail, String star, String isActive) {
		String query = "INSERT INTO tbl_ProductReview (Product_ID, Name, Phone, Email, CreatedDate, Detail, Star, IsActive)\r\n"
				+ "VALUES(?,?,?,?,?,?,?,?)";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, productId);
			ps.setString(2, name);
			ps.setString(3, phone);
			ps.setString(4, email);
			ps.setString(5, createdDate);
			ps.setString(6, detail);
			ps.setString(7, star);
			ps.setString(8, isActive);
			ps.executeUpdate();
		} catch (Exception e) {

		}
	}

	// --------ADMIN------//
	// Provider
	public List<tbl_Provider> getAllProvider() {
		List<tbl_Provider> list = new ArrayList<>();
		String query = "select * from tbl_Provider";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new tbl_Provider(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getBoolean(7)));
			}

		} catch (Exception e) {

		}

		return list;
	}

	public tbl_Provider getProviderById(String providerId) {
		String query = "select * from tbl_Provider where Provider_ID = ?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, providerId);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new tbl_Provider(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getBoolean(7));
			}

		} catch (Exception e) {

		}
		return null;

	}

	public void deleteProvider(String id) {
		String query = "delete from tbl_Provider where Provider_ID = ?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			rs = ps.executeQuery();
		} catch (Exception e) {

		}
	}

	public void addProvider(String name, String address, String phone, String email, String description,
			String status) {
		String query = "INSERT INTO tbl_Provider (ProviderName, Address, Phone, Email, Description, Status)\r\n"
				+ "VALUES(?,?,?,?,?,?)";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, address);
			ps.setString(3, phone);
			ps.setString(4, email);
			ps.setString(5, description);
			ps.setString(6, status);
			ps.executeUpdate();
		} catch (Exception e) {

		}
	}

	public void editProvider(String id, String name, String address, String phone, String email, String description,
			String status) {
		String query = "UPDATE tbl_Provider SET "
				+ "ProviderName = ?, Address = ?, Phone = ?, Email = ?, Description = ?, Status = ? "
				+ "WHERE Provider_ID = ?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, address);
			ps.setString(3, phone);
			ps.setString(4, email);
			ps.setString(5, description);
			ps.setString(6, status);
			ps.setString(7, id);
			ps.executeUpdate();
		} catch (Exception e) {

		}
	}

	//// Order
	public List<tbl_Order> getAllOrder() {
		List<tbl_Order> list = new ArrayList<>();
		String query = "select * from tbl_Order";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new tbl_Order(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),
						rs.getInt(6), rs.getDate(7), rs.getString(8), rs.getDate(9), rs.getString(10), rs.getString(11),
						rs.getString(12)));
			}

		} catch (Exception e) {

		}

		return list;
	}
	public int getTotalOrders() {
	    String query = "SELECT COUNT(*) FROM tbl_Order";
	    try {
	        conn = new DBConnect().getConnection();
	        ps = conn.prepareStatement(query);
	        rs = ps.executeQuery();
	        if (rs.next()) {
	            return rs.getInt(1);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return 0;
	}


	public List<tbl_Order> getOrdersByPage(int page, int pageSize) {
	    List<tbl_Order> list = new ArrayList<>();
	    String query = "SELECT * FROM tbl_Order ORDER BY Order_ID DESC OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";

	    try {
	        conn = new DBConnect().getConnection();
	        ps = conn.prepareStatement(query);

	        int offset = (page - 1) * pageSize;

	        ps.setInt(1, offset);
	        ps.setInt(2, pageSize);

	        rs = ps.executeQuery();
	        while (rs.next()) {
	            list.add(new tbl_Order(
	                rs.getInt(1), rs.getString(2), rs.getString(3),
	                rs.getString(4), rs.getInt(5), rs.getInt(6),
	                rs.getDate(7), rs.getString(8), rs.getDate(9),
	                rs.getString(10), rs.getString(11), rs.getString(12)
	            ));
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return list;
	}



	public tbl_Order getOrderById(String id) {
		String query = "select * from tbl_Order where Order_ID = ?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new tbl_Order(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),
						rs.getInt(6), rs.getDate(7), rs.getString(8), rs.getDate(9), rs.getString(10), rs.getString(11),
						rs.getString(12));
			}

		} catch (Exception e) {

		}
		return null;

	}

	public List<tbl_OrderDetail> getOrderDetailsByOrderId(String orderId) {
		List<tbl_OrderDetail> list = new ArrayList<>();
		String query = "SELECT * FROM tbl_OrderDetail WHERE Order_ID = ?";
		try (Connection c = new DBConnect().getConnection(); PreparedStatement p = c.prepareStatement(query)) {
			p.setString(1, orderId);
			try (ResultSet r = p.executeQuery()) {
				while (r.next()) {
					list.add(new tbl_OrderDetail(r.getInt(1), r.getInt(2), r.getInt(3), r.getDouble(4), r.getInt(5)));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public tbl_OrderStatus getOrderStatusByOrderId(String orderId) {
		String query = "SELECT * FROM tbl_OrderStatus WHERE Order_ID = ?";
		try (Connection c = new DBConnect().getConnection(); PreparedStatement p = c.prepareStatement(query)) {
			p.setString(1, orderId);
			try (ResultSet r = p.executeQuery()) {
				if (r.next()) {
					return new tbl_OrderStatus(r.getInt(1), r.getInt(2), r.getString(3), r.getString(4));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void deleteOrder(String id) {
		String query1 = "delete from tbl_OrderDetail where Order_ID = ?";
		String query2 = "DELETE FROM tbl_OrderStatus WHERE Order_ID = ?";
		String query3 = "DELETE FROM tbl_Order WHERE Order_ID = ?";

		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query1);
			ps.setString(1, id);
			ps.executeUpdate();
			ps = conn.prepareStatement(query2);
			ps.setString(1, id);
			ps.executeUpdate();
			ps = conn.prepareStatement(query3);
			ps.setString(1, id);
			ps.executeUpdate();
		} catch (Exception e) {

		}
	}

	public void addOrder(String customerName, String phone, String address, String totalAmount, String quantity,
			String note, String paymentMethod, String createdDate, String orderStatus, String descriptionStatus, String[] productIds, String[] productPrices,
			String[] productQuantities) {
		String query = "INSERT INTO tbl_Order (CustomerName, Phone, Address, TotalAmount, Quantity, CreatedDate, Note, PaymentMethod) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";

		Connection localConn = null;
		PreparedStatement psOrder = null;
		PreparedStatement psDetail = null;
		PreparedStatement psStatus = null;
		ResultSet generatedKeys = null;
		try {
			localConn = new DBConnect().getConnection();
			// Bắt đầu transaction
			localConn.setAutoCommit(false);

			psOrder = localConn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			psOrder.setString(1, customerName);
			psOrder.setString(2, phone);
			psOrder.setString(3, address);
			psOrder.setString(4, totalAmount);
			psOrder.setString(5, quantity);
			psOrder.setString(6, createdDate);
			psOrder.setString(7, note);
			psOrder.setString(8, paymentMethod);

			psOrder.executeUpdate();

			generatedKeys = psOrder.getGeneratedKeys();
			int orderId = -1;
			if (generatedKeys != null && generatedKeys.next()) {
				orderId = generatedKeys.getInt(1);
			}

			// Nếu có dữ liệu sản phẩm, chèn vào tbl_OrderDetail (hỗ trợ nhiều sản phẩm)
			if (orderId != -1 && productIds != null && productIds.length > 0) {
				String qd = "INSERT INTO tbl_OrderDetail (Order_ID, Product_ID, Price, Quantity) VALUES (?, ?, ?, ?)";
				psDetail = localConn.prepareStatement(qd);
				for (int i = 0; i < productIds.length; i++) {
					String pid = productIds[i];
					if (pid == null || pid.trim().isEmpty())
						continue;
					double price = 0.0;
					int qty = 0;
					if (productPrices != null && i < productPrices.length && productPrices[i] != null && !productPrices[i].trim().isEmpty()) {
						try { price = Double.parseDouble(productPrices[i].trim()); } catch (NumberFormatException nfe) { price = 0.0; }
					}
					if (productQuantities != null && i < productQuantities.length && productQuantities[i] != null && !productQuantities[i].trim().isEmpty()) {
						try { qty = Integer.parseInt(productQuantities[i].trim()); } catch (NumberFormatException nfe) { qty = 0; }
					}

					psDetail.setInt(1, orderId);
					psDetail.setString(2, pid);
					psDetail.setDouble(3, price);
					psDetail.setInt(4, qty);
					psDetail.executeUpdate();
				}
			}

			// Chèn trạng thái vào tbl_OrderStatus theo giá trị được chọn
			if (orderId != -1) {
				String qs = "INSERT INTO tbl_OrderStatus (Order_ID, Name, Description) VALUES (?, ?, ?)";
				psStatus = localConn.prepareStatement(qs);
				psStatus.setInt(1, orderId);
				psStatus.setString(2, orderStatus);
				psStatus.setString(3, descriptionStatus);
				psStatus.executeUpdate();
			}

			// Commit transaction
			localConn.commit();
		} catch (Exception e) {
			try { if (localConn != null) localConn.rollback(); } catch (Exception ex) { ex.printStackTrace(); }
			e.printStackTrace();
		} finally {
			try {
				if (generatedKeys != null)
					generatedKeys.close();
			} catch (Exception e) {
			}
			try {
				if (psOrder != null)
					psOrder.close();
			} catch (Exception e) {
			}
			try {
				if (psDetail != null)
					psDetail.close();
			} catch (Exception e) {
			}
			try {
				if (psStatus != null)
					psStatus.close();
			} catch (Exception e) {
			}
			try {
				if (localConn != null)
					localConn.setAutoCommit(true);
			} catch (Exception e) {}
			try {
				if (localConn != null)
					localConn.close();
			} catch (Exception e) {
			}
		}
	}

	public void editOrder(String id, String customerName, String phone, String address, String totalAmount,
			String quantity, String note, String paymentMethod, String orderStatus, String descriptionStatus, String modifiedDate,
			String[] productIds, String[] productPrices, String[] productQuantities) {
		String query = "UPDATE tbl_Order SET"
				+ " CustomerName = ?, Phone = ?, Address = ?, TotalAmount = ?, Quantity = ?, ModifiedDate = ?, Note = ?, PaymentMethod = ? "
				+ "WHERE Order_ID = ?";

		Connection localConn = null;
		PreparedStatement psOrder = null;
		PreparedStatement psDelDetail = null;
		PreparedStatement psInsDetail = null;
		PreparedStatement psStatus = null;
		ResultSet rs = null;
		try {
			localConn = new DBConnect().getConnection();
			localConn.setAutoCommit(false);

			psOrder = localConn.prepareStatement(query);
			psOrder.setString(1, customerName);
			psOrder.setString(2, phone);
			psOrder.setString(3, address);
			psOrder.setString(4, totalAmount);
			psOrder.setString(5, quantity);
			psOrder.setString(6, modifiedDate);
			psOrder.setString(7, note);
			psOrder.setString(8, paymentMethod);
			psOrder.setString(9, id);
			psOrder.executeUpdate();

			// Xóa các order detail cũ
			String qdel = "DELETE FROM tbl_OrderDetail WHERE Order_ID = ?";
			psDelDetail = localConn.prepareStatement(qdel);
			psDelDetail.setString(1, id);
			psDelDetail.executeUpdate();

			// Chèn lại các order detail mới (nếu có)
			if (productIds != null && productIds.length > 0) {
				String qinsDetail = "INSERT INTO tbl_OrderDetail (Order_ID, Product_ID, Price, Quantity) VALUES (?, ?, ?, ?)";
				psInsDetail = localConn.prepareStatement(qinsDetail);
				for (int i = 0; i < productIds.length; i++) {
					String pid = productIds[i];
					if (pid == null || pid.trim().isEmpty()) continue;
					double price = 0.0;
					int qty = 0;
					if (productPrices != null && i < productPrices.length && productPrices[i] != null && !productPrices[i].trim().isEmpty()) {
						try { price = Double.parseDouble(productPrices[i].trim()); } catch (NumberFormatException nfe) { price = 0.0; }
					}
					if (productQuantities != null && i < productQuantities.length && productQuantities[i] != null && !productQuantities[i].trim().isEmpty()) {
						try { qty = Integer.parseInt(productQuantities[i].trim()); } catch (NumberFormatException nfe) { qty = 0; }
					}
					psInsDetail.setString(1, id);
					psInsDetail.setString(2, pid);
					psInsDetail.setDouble(3, price);
					psInsDetail.setInt(4, qty);
					psInsDetail.executeUpdate();
				}
			}

			// Cập nhật tbl_OrderStatus: nếu tồn tại thì update, nếu không thì insert
			String qCheck = "SELECT OrderStatus_ID FROM tbl_OrderStatus WHERE Order_ID = ?";
			psStatus = localConn.prepareStatement(qCheck);
			psStatus.setString(1, id);
			rs = psStatus.executeQuery();
			if (rs != null && rs.next()) {
				rs.close();
				psStatus.close();
				String qup = "UPDATE tbl_OrderStatus SET Name = ?, Description = ? WHERE Order_ID = ?";
				psStatus = localConn.prepareStatement(qup);
				psStatus.setString(1, (orderStatus != null && !orderStatus.isEmpty()) ? orderStatus : "");
				psStatus.setString(2, (descriptionStatus != null) ? descriptionStatus : "");
				psStatus.setString(3, id);
				psStatus.executeUpdate();
			} else {
				if (psStatus != null) { try { rs = null; psStatus.close(); } catch (Exception ex) {} }
				String qins = "INSERT INTO tbl_OrderStatus (Order_ID, Name, Description) VALUES (?, ?, ?)";
				psStatus = localConn.prepareStatement(qins);
				psStatus.setString(1, id);
				psStatus.setString(2, (orderStatus != null && !orderStatus.isEmpty()) ? orderStatus : "");
				psStatus.setString(3, (descriptionStatus != null) ? descriptionStatus : "");
				psStatus.executeUpdate();
			}

			localConn.commit();
		} catch (Exception e) {
			try { if (localConn != null) localConn.rollback(); } catch (Exception ex) { ex.printStackTrace(); }
			e.printStackTrace();
		} finally {
			try { if (rs != null) rs.close(); } catch (Exception e) {}
			try { if (psOrder != null) psOrder.close(); } catch (Exception e) {}
			try { if (psDelDetail != null) psDelDetail.close(); } catch (Exception e) {}
			try { if (psInsDetail != null) psInsDetail.close(); } catch (Exception e) {}
			try { if (psStatus != null) psStatus.close(); } catch (Exception e) {}
			try { if (localConn != null) localConn.setAutoCommit(true); } catch (Exception e) {}
			try { if (localConn != null) localConn.close(); } catch (Exception e) {}
		}
	}

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

	// admin thêm,sửa,xóa danh mục sản phẩm
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
		List<tbl_RoomCategory> list = dao.getAllRoomcategory();
		for (tbl_RoomCategory o : list) {
			System.out.println(o);
		}

	}

	public List<tbl_ProductCategory> getAllProductCategory() {
		List<tbl_ProductCategory> list = new ArrayList<>();
		String query = "select * from tbl_ProductCategory";

		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next()) {
				list.add(new tbl_ProductCategory(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getBoolean(6)));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (rs != null)
					rs.close();
			} catch (Exception e) {
			}
			try {
				if (ps != null)
					ps.close();
			} catch (Exception e) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}

		return list;
	}

	public tbl_Account login(String Username, String Password) {

		tbl_Account account = null;

		String query = "select * from tbl_Account where Username = ? and Password = ?";

		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);

			ps.setString(1, Username);
			ps.setString(2, Password);

			rs = ps.executeQuery();

			if (rs.next()) {
				account = new tbl_Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getDate(7), rs.getString(8), rs.getInt(9),
						rs.getString(10), rs.getBoolean(11));
			}

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (Exception e) {
			}
			try {
				if (ps != null)
					ps.close();
			} catch (Exception e) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}

		return account;
	}

	public List<tbl_Account> getAllAccount() {
		List<tbl_Account> list = new ArrayList<>();
		String query = "SELECT * FROM tbl_Account";

		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new tbl_Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getDate(7), rs.getString(8), rs.getInt(9),
						rs.getString(10), rs.getBoolean(11)));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (Exception e) {
			}
			try {
				if (ps != null)
					ps.close();
			} catch (Exception e) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}

		return list;
	}

	public tbl_Account getAccountDetail(String accountId) {
		String query = "select * from tbl_Account where Account_ID = ?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, accountId);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new tbl_Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getDate(7), rs.getString(8), rs.getInt(9), rs.getString(10),
						rs.getBoolean(11));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (Exception e) {
			}
			try {
				if (ps != null)
					ps.close();
			} catch (Exception e) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
		return null;

	}

	public tbl_Account getAccountById(String accountId) {
		String query = "select * from tbl_Account where Account_ID = ?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, accountId);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new tbl_Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getDate(7), rs.getString(8), rs.getInt(9), rs.getString(10),
						rs.getBoolean(11));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (Exception e) {
			}
			try {
				if (ps != null)
					ps.close();
			} catch (Exception e) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
		return null;

	}

	public void addAccount(String username, String password, String fullName, String phone, String email,
			String birthdayStr, String avatar, String roleIDStr, String isActiveStr) {

		String query = "INSERT INTO tbl_Account (Username, Password, FullName, Phone, Email, Birthday, Avatar, Role_ID, IsActive) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {

			int roleID = (roleIDStr != null && !roleIDStr.isEmpty()) ? Integer.parseInt(roleIDStr) : 0;

			int activeValue = (isActiveStr != null) ? 1 : 0;

			java.sql.Date birthdaySql = null;
			if (birthdayStr != null && !birthdayStr.isEmpty()) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				java.util.Date utilDate = sdf.parse(birthdayStr);
				birthdaySql = new java.sql.Date(utilDate.getTime());
			}
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);

			ps.setString(1, username);
			ps.setString(2, password);
			ps.setString(3, fullName);
			ps.setString(4, phone);
			ps.setString(5, email);

			ps.setDate(6, birthdaySql);

			ps.setString(7, avatar);

			ps.setInt(8, roleID);

			ps.setBoolean(9, activeValue == 1);

			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
			} catch (Exception e) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
	}

	public void editAccount(String username, String password, String fullName, String phone, String email,
			String birthday, String avatar, String roleID, String isactive, String id) {

		String query = "UPDATE tbl_Account SET " + "Username = ?, Password = ?, FullName = ?, "
				+ "Phone = ?, Email = ?, Birthday = ?, " + "Avatar = ?, Role_ID = ?, IsActive = ? "
				+ "WHERE Account_ID = ?";

		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);

			ps.setString(1, username);
			ps.setString(2, password);
			ps.setString(3, fullName);
			ps.setString(4, phone);
			ps.setString(5, email);
			ps.setString(6, birthday);
			ps.setString(7, avatar);
			ps.setString(8, roleID);
			ps.setString(9, isactive);
			ps.setString(10, id);
			ps.executeUpdate();

			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public void deleteAccount(String id) {
		String query = "delete from tbl_Account where Account_ID = ?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
			} catch (Exception e) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
	}

	public List<tbl_Contact> getAllContact() {
		List<tbl_Contact> list = new ArrayList<>();
		String query = "select * from tbl_Contact";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new tbl_Contact(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getBoolean(6), rs.getDate(7), rs.getString(8)));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (Exception e) {
			}
			try {
				if (ps != null)
					ps.close();
			} catch (Exception e) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
		return list;
	}

	public tbl_Contact getContactById(String contactId) {
		String query = "select * from tbl_Contact where Contact_ID = ?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, contactId);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new tbl_Contact(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getBoolean(6), rs.getDate(7), rs.getString(8));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (Exception e) {
			}
			try {
				if (ps != null)
					ps.close();
			} catch (Exception e) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
		return null;

	}
	public void editContact(String name, String phone, String email, String message, String isread, String createdDate,
			 String createdBy, String id) {

		String query = "UPDATE tbl_Contact SET " + "Name = ?, Phone = ?, Email = ?, Message = ?, IsRead = ?, "
				+ "CreatedDate = ?, CreatedBy = ?"
				+ "WHERE Contact_ID = ?";

		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);

			ps.setString(1, name);
			ps.setString(2, phone);
			ps.setString(3, email);
			ps.setString(4, message);
			ps.setString(5,isread);
			ps.setString(6, createdDate);
			ps.setString(7, createdBy);
			ps.setString(8, id);
			ps.executeUpdate();

			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
	// ======================= BLOG CHO NGƯỜI DÙNG =======================
	public List<tbl_Blog> getAllBlog() {
		List<tbl_Blog> list = new ArrayList<>();
		String sql = "SELECT * FROM tbl_Blog ";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				list.add(new tbl_Blog(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),
						rs.getString(11), rs.getTimestamp(12), rs.getString(13), rs.getTimestamp(14), rs.getString(15),
						rs.getBoolean(16)));
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return list;
	}

	// ======================= DANH MỤC BLOG =======================
	public List<tbl_ProductCategory> getAllBlogCategories() {
		List<tbl_ProductCategory> list = new ArrayList<>();
		String sql = """
				    SELECT c.Category_ID, c.Name,
				           COUNT(b.Blog_ID) AS BlogCount
				    FROM tbl_ProductCategory c
				    LEFT JOIN tbl_Blog b ON c.Category_ID = b.Category_ID AND b.IsActive = 1
				    GROUP BY c.Category_ID, c.Name
				    ORDER BY c.Name ASC
				""";

		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				tbl_ProductCategory cat = new tbl_ProductCategory();
				cat.setCategoryId(rs.getInt("Category_ID"));
				cat.setName(rs.getString("Name"));
				cat.setBlogCount(rs.getInt("BlogCount"));
				list.add(cat);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// ======================= BLOG GẦN ĐÂY =======================
	public List<tbl_Blog> getRecentBlogs() {
		List<tbl_Blog> list = new ArrayList<>();
		String sql = "SELECT TOP 5 * FROM tbl_Blog WHERE IsActive = 1 ORDER BY CreatedDate DESC";

		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				list.add(new tbl_Blog(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),
						rs.getString(11), rs.getTimestamp(12), rs.getString(13), rs.getTimestamp(14), rs.getString(15),
						rs.getBoolean(16)));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// ======================= PHÂN TRANG =======================
	public List<tbl_Blog> getBlogsByPaging(int page, int recordsPerPage) {
		List<tbl_Blog> list = new ArrayList<>();
		int offset = (page - 1) * recordsPerPage;

		String sql = "SELECT * FROM tbl_Blog WHERE IsActive = 1 ORDER BY CreatedDate DESC OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";

		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, offset);
			ps.setInt(2, recordsPerPage);

			rs = ps.executeQuery();

			while (rs.next()) {
				list.add(new tbl_Blog(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),
						rs.getString(11), rs.getTimestamp(12), rs.getString(13), rs.getTimestamp(14), rs.getString(15),
						rs.getBoolean(16)));
			}

		} catch (Exception e) {
			System.out.println("Lỗi getBlogsByPaging: " + e.getMessage());
			e.printStackTrace();
		}
		return list;
	}

	public int getTotalBlogCount() {
		String sql = "SELECT COUNT(*) FROM tbl_Blog WHERE IsActive = 1";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next())
				return rs.getInt(1);
		} catch (Exception e) {
			System.out.println("Lỗi getTotalBlogCount: " + e.getMessage());
			e.printStackTrace();
		}
		return 0;
	}

	// ======================= BLOG DETAIL =======================

	public tbl_Blog getBlogById(int blogId) {
		tbl_Blog blog = null;
		String sql = "SELECT * FROM tbl_Blog WHERE Blog_ID = ? AND IsActive = 1";

		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, blogId);
			rs = ps.executeQuery();

			if (rs.next()) {
				// Map theo chỉ số cột (giống các method getRecentBlogs/getAllBlogs trong DAO)
				blog = new tbl_Blog(rs.getInt(1), // Blog_ID
						rs.getInt(2), // Account_ID hoặc Category_ID (tùy schema)
						rs.getString(3), // Title
						rs.getString(4), // Alias / Description (tùy schema)
						rs.getInt(5), // Category_ID / View_Count (tùy schema)
						rs.getString(6), // Description
						rs.getString(7), // Detail
						rs.getString(8), // Image
						rs.getString(9), // SeoTitle
						rs.getString(10), // SeoDescription
						rs.getString(11), // SeoKeywords
						rs.getTimestamp(12), // CreatedDate
						rs.getString(13), // CreatedBy
						rs.getTimestamp(14), // ModifiedDate
						rs.getString(15), // ModifiedBy
						rs.getBoolean(16) // IsActive
				);
				System.out.println("DAO - Found blog: " + blog.getTitle());
			} else {
				System.out.println("DAO - No blog found with ID: " + blogId);
			}

		} catch (Exception e) {
			System.out.println("Error in getBlogById: " + e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (Exception e) {
			}
			try {
				if (ps != null)
					ps.close();
			} catch (Exception e) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
		return blog;
	}
	
	//======================== BLOG TRƯỚC ======================
	public tbl_Blog getPrevBlog(int blogId) {
	    String sql = """
	        SELECT TOP 1 * FROM tbl_Blog
	        WHERE Blog_ID < ? AND IsActive = 1
	        ORDER BY Blog_ID DESC
	    """;

	    try {
	        conn = new DBConnect().getConnection();
	        ps = conn.prepareStatement(sql);
	        ps.setInt(1, blogId);
	        rs = ps.executeQuery();

	        if (rs.next()) {
	            return new tbl_Blog(
	                rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4),
	                rs.getInt(5), rs.getString(6), rs.getString(7), rs.getString(8),
	                rs.getString(9), rs.getString(10), rs.getString(11),
	                rs.getTimestamp(12), rs.getString(13),
	                rs.getTimestamp(14), rs.getString(15),
	                rs.getBoolean(16)
	            );
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return null;
	}

	//======================== BLOG TIẾP THEO ======================
	public tbl_Blog getNextBlog(int blogId) {
	    String sql = """
	        SELECT TOP 1 * FROM tbl_Blog
	        WHERE Blog_ID > ? AND IsActive = 1
	        ORDER BY Blog_ID ASC
	    """;

	    try {
	        conn = new DBConnect().getConnection();
	        ps = conn.prepareStatement(sql);
	        ps.setInt(1, blogId);
	        rs = ps.executeQuery();

	        if (rs.next()) {
	            return new tbl_Blog(
	                rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4),
	                rs.getInt(5), rs.getString(6), rs.getString(7), rs.getString(8),
	                rs.getString(9), rs.getString(10), rs.getString(11),
	                rs.getTimestamp(12), rs.getString(13),
	                rs.getTimestamp(14), rs.getString(15),
	                rs.getBoolean(16)
	            );
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return null;
	}


	// ======================== BÌNH LUẬN BLOG ======================
	public List<tbl_BlogComment> getCommentsByBlogId(int blogId) {
		List<tbl_BlogComment> list = new ArrayList<>();
		String sql = """
				    SELECT * FROM tbl_BlogComment
				    WHERE Blog_ID = ? AND IsActive = 1
				    ORDER BY CreatedDate DESC
				""";

		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, blogId);
			rs = ps.executeQuery();

			while (rs.next()) {
				tbl_BlogComment c = new tbl_BlogComment();
				c.setCommentId(rs.getInt("Comment_ID"));
				c.setName(rs.getString("Name"));
				c.setPhone(rs.getString("Phone"));
				c.setEmail(rs.getString("Email"));
				c.setCreateddate(rs.getTimestamp("CreatedDate"));
				c.setDetail(rs.getString("Detail"));
				c.setBlogId(rs.getInt("Blog_ID"));
				c.setIsactive(rs.getBoolean("IsActive"));

				list.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// ======================== THÊM BÌNH LUẬN BLOG =====================
	public void insertBlogComment(tbl_BlogComment c) {
		String sql = """
				    INSERT INTO tbl_BlogComment
				    (Name, Phone, Email, Detail, Blog_ID, IsActive)
				    VALUES (?, ?, ?, ?, ?, 1)
				""";

		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, c.getName());
			ps.setString(2, c.getPhone());
			ps.setString(3, c.getEmail());
			ps.setString(4, c.getDetail());
			ps.setInt(5, c.getBlogId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ===================ADMIN====================//
	public List<tbl_Blog> getAllBlogs() {
		List<tbl_Blog> list = new ArrayList<>();
		String sql = "SELECT * FROM tbl_Blog ";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				list.add(new tbl_Blog(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),
						rs.getString(11), rs.getDate(12), rs.getString(13), rs.getDate(14), rs.getString(15),
						rs.getBoolean(16)));
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return list;

	}

	public tbl_Blog getBlogById(String blogId) {
		String query = "SELECT * FROM tbl_Blog WHERE Blog_ID = ?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, blogId); // Gán tham số !!!

			rs = ps.executeQuery();
			if (rs.next()) {
				return new tbl_Blog(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),
						rs.getString(11), rs.getDate(12), rs.getString(13), rs.getDate(14), rs.getString(15),
						rs.getBoolean(16));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null; // Không tìm thấy blog
	}

	public void addBlog(String accountId, String title, String alias, String categoryId, String description,
			String detail, String image, String seoTitle, String seoDescription, String seoKeywords, String createdBy,
			String isActive) {

		String query = "INSERT INTO tbl_Blog (Account_ID, Title, Alias, Category_ID, Description, "
				+ "Detail, Image, SeoTitle, SeoDescription, SeoKeywords, " + "CreatedDate, CreatedBy, IsActive) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, GETDATE(), ?, ?)";

		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);

// Gán giá trị cho từng cột
			ps.setString(1, accountId);
			ps.setString(2, title);
			ps.setString(3, alias);
			ps.setString(4, categoryId);
			ps.setString(5, description);
			ps.setString(6, detail);
			ps.setString(7, image);
			ps.setString(8, seoTitle);
			ps.setString(9, seoDescription);
			ps.setString(10, seoKeywords);
			ps.setString(11, createdBy);

// Convert IsActive → boolean
			boolean active = "1".equals(isActive) || "true".equalsIgnoreCase(isActive);
			ps.setBoolean(12, active);

			ps.executeUpdate();
			System.out.println("Thêm blog thành công: " + title);

		} catch (Exception e) {
			System.out.println("Lỗi khi thêm blog: " + e.getMessage());
			e.printStackTrace();

		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
				if (conn != null)
					conn.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	public void editBlog(String blogId, String accountId, String title, String alias, String categoryId,
			String description, String detail, String image, String seoTitle, String seoDescription, String seoKeywords,
			String modifiedBy, String isActive) {
		String query = "UPDATE tbl_Blog SET "
				+ "Account_ID = ?, Title = ?, Alias = ?, Category_ID = ?, Description = ?, "
				+ "Detail = ?, Image = ?, SeoTitle = ?, SeoDescription = ?, "
				+ "SeoKeywords = ?, ModifiedDate = GETDATE(), ModifiedBy = ?, IsActive = ? " + "WHERE Blog_ID = ?";

		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);

			// Set parameters
			ps.setString(1, accountId);
			ps.setString(2, title);
			ps.setString(3, alias);
			ps.setString(4, categoryId);
			ps.setString(5, description);
			ps.setString(6, detail);
			ps.setString(7, image);
			ps.setString(8, seoTitle);
			ps.setString(9, seoDescription);
			ps.setString(10, seoKeywords);
			ps.setString(11, modifiedBy);
			ps.setBoolean(12, "1".equals(isActive) || "true".equalsIgnoreCase(isActive));
			ps.setString(13, blogId);

			ps.executeUpdate();
			System.out.println("Cập nhật bài viết thành công. ID: " + blogId);

		} catch (Exception e) {
			System.out.println("Lỗi khi cập nhật bài viết: " + e.getMessage());
			e.printStackTrace();
		} finally {
			// Đóng kết nối
			try {
				if (ps != null)
					ps.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void deleteBlog(String id) {
		String query = "DELETE FROM tbl_Blog WHERE Blog_ID = ?";

		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			ps.executeUpdate();

		} catch (Exception e) {
		}
	}

	public void toggleBlog(String id) {
		String sql = "UPDATE tbl_Blog SET IsActive = CASE WHEN IsActive = 1 THEN 0 ELSE 1 END WHERE Blog_ID = ?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("Lỗi toggle: " + e.getMessage());
			e.printStackTrace();
		}
	}

	// ===================COLLECTION=================//
	public List<tbl_Collection> getAllCollections() {
		List<tbl_Collection> list = new ArrayList<>();
		String sql = "select * from tbl_Collection";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new tbl_Collection(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getBoolean(9),
						rs.getBoolean(10), rs.getBoolean(11), rs.getDate(12)));
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			// Đóng kết nối và các tài nguyên để tránh rò rỉ hoặc ngắt giữa chừng khi có lỗi
			try {
				if (rs != null)
					rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if (ps != null)
					ps.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;

	}

	public tbl_Collection getCollectionId(String collectionId) {
		String query = "select * from tbl_Collection where Collection_ID = ?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, collectionId);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new tbl_Collection(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getBoolean(9),
						rs.getBoolean(10), rs.getBoolean(11), rs.getDate(12));
			}

		} catch (Exception e) {

		}
		return null;

	}

	public void addCollection(String name, String alias, String designer, String maker, String description,
			String detail, String image, boolean isNew, boolean isBestSeller, boolean isActive, String createdDate) {

		String query = "INSERT INTO tbl_Collection " + "(Name, Alias, Designer, Maker, Description, Detail, Image, "
				+ "IsNew, IsBestSeller, IsActive, CreatedDate) " + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);

			// Set parameters
			ps.setString(1, name);
			ps.setString(2, alias);
			ps.setString(3, designer);
			ps.setString(4, maker);
			ps.setString(5, description);
			ps.setString(6, detail);
			ps.setString(7, image);
			ps.setBoolean(8, isNew);
			ps.setBoolean(9, isBestSeller);
			ps.setBoolean(10, isActive);
			ps.setString(11, createdDate);

			ps.executeUpdate();

		} catch (Exception e) {

		} finally {
			try {
				if (ps != null)
					ps.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void editCollection(String collectionId, String name, String alias, String designer, String maker,
			String description, String detail, String image, boolean isNew, boolean isbestSeller, boolean isactive,
			String createdDate) {
		String query = "UPDATE tbl_Collection SET "
				+ "Name=?, Alias=?, Designer=?, Maker=?, Description=?, Detail=?, Image=?, "
				+ "IsNew=?, IsBestSeller=?, IsActive=?, CreatedDate=? " + "WHERE Collection_ID = ?";

		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);

			ps.setString(1, name);
			ps.setString(2, alias);
			ps.setString(3, designer);
			ps.setString(4, maker);
			ps.setString(5, description);
			ps.setString(6, detail);
			ps.setString(7, image);
			ps.setBoolean(8, isNew);
			ps.setBoolean(9, isbestSeller);
			ps.setBoolean(10, isactive);
			ps.setString(11, createdDate);
			ps.setString(12, collectionId);

			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteCollection(String id) {
		String query = "DELETE FROM tbl_Collection WHERE Collection_ID = ?";

		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			ps.executeUpdate();

		} catch (Exception e) {
		}
	}

	public void toggleCollection(String id) {
		String sql = "UPDATE tbl_Collection SET IsActive = CASE WHEN IsActive = 1 THEN 0 ELSE 1 END WHERE Collection_ID = ?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("Lỗi toggle: " + e.getMessage());
			e.printStackTrace();
		}
	}

	// ===================BLOGCOMMENT=================//
	public List<tbl_BlogComment> getAllBlogComment() {
		List<tbl_BlogComment> list = new ArrayList<>();
		String sql = "select * from tbl_BlogComment";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new tbl_BlogComment(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getDate(5), rs.getString(6), rs.getInt(7), rs.getBoolean(8)));
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		return list;

	}

	public tbl_BlogComment getBlogCommentById(String commentId) {
		String query = "select * from tbl_BlogComment where Comment_ID = ?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, commentId);
			rs = ps.executeQuery();
			if (rs.next()) {
				return new tbl_BlogComment(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getDate(5), rs.getString(6), rs.getInt(7), rs.getBoolean(8));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public tbl_RoomCategory getRoomCategoryById(int id) {
		String query = "SELECT * FROM tbl_RoomCategory WHERE RoomCategory_ID = ?";

		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();

			if (rs.next()) {
				return new tbl_RoomCategory(rs.getInt("RoomCategory_ID"), rs.getString("Name"), rs.getString("Alias"),
						rs.getString("Description"), rs.getBoolean("IsActive"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public void addRoomCategory(String name, String alias, String description, boolean isActive) {

		String query = "INSERT INTO tbl_RoomCategory (Name, Alias, Description, IsActive) VALUES (?, ?, ?, ?)";

		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);

			ps.setString(1, name);
			ps.setString(2, alias);
			ps.setString(3, description);
			ps.setBoolean(4, isActive);

			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void editRoomCategory(int roomCategoryId, String name, String alias, String description, boolean isActive) {

		String query = "UPDATE tbl_RoomCategory SET Name=?, Alias=?, Description=?, IsActive=? WHERE RoomCategory_ID=?";

		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);

			ps.setString(1, name);
			ps.setString(2, alias);
			ps.setString(3, description);
			ps.setBoolean(4, isActive);
			ps.setInt(5, roomCategoryId);

			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteRoomCategory(String id) {

		String query = "DELETE FROM tbl_RoomCategory WHERE RoomCategory_ID = ?";

		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, id);

			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<tbl_ProductReview> getAllReviews() {
	    List<tbl_ProductReview> list = new ArrayList<>();
	    String query = "SELECT r.*, p.name AS ProductName " +
	                   "FROM tbl_productreview r " +
	                   "JOIN tbl_product p ON r.Product_ID = p.Product_ID " +
	                   "ORDER BY r.CreatedDate DESC";

	    try {
	        conn = new DBConnect().getConnection();
	        ps = conn.prepareStatement(query);
	        rs = ps.executeQuery();

	        while (rs.next()) {
	            tbl_ProductReview review = new tbl_ProductReview(
	                rs.getInt("ProductReview_ID"),
	                rs.getInt("Product_ID"),
	                rs.getString("Name"),
	                rs.getString("Phone"),
	                rs.getString("Email"),
	                rs.getDate("CreatedDate"),
	                rs.getString("Detail"),
	                rs.getInt("Star"),
	                rs.getBoolean("IsActive")
	            );

	            // Thêm tên sản phẩm vào review
	            review.setProductName(rs.getString("ProductName"));

	            list.add(review);
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return list;
	}



	public tbl_ProductReview getReviewById(int reviewId) {
		String query = "SELECT * FROM tbl_productreview WHERE ProductReview_ID = ?";

		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, reviewId);
			rs = ps.executeQuery();

			if (rs.next()) {
				return new tbl_ProductReview(rs.getInt("ProductReview_ID"), rs.getInt("Product_ID"),
						rs.getString("Name"), rs.getString("Phone"), rs.getString("Email"), rs.getDate("CreatedDate"),
						rs.getString("Detail"), rs.getInt("Star"), rs.getBoolean("IsActive"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void editReviewStatus(int reviewId, boolean isActive) {
	    String query = "UPDATE tbl_productreview SET IsActive = ? WHERE ProductReview_ID = ?";

	    try {
	        conn = new DBConnect().getConnection();
	        ps = conn.prepareStatement(query);

	        ps.setBoolean(1, isActive);
	        ps.setInt(2, reviewId);

	        ps.executeUpdate();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	public void deleteReview(String reviewId) {
        String query = "DELETE FROM tbl_productreview WHERE ProductReview_ID=?";

        try {
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, reviewId);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	public void addBlogComment(String name, String phone, String email, String createddate, String detail,
			String blogId, String isActive) {

		String query = "INSERT INTO tbl_BlogComment (Name, Phone, Email, CreatedDate, Detail, Blog_ID, IsActive) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?)";

		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);

			ps.setString(1, name);
			ps.setString(2, phone);
			ps.setString(3, email);
			ps.setString(4, createddate);
			ps.setString(5, detail);
			ps.setString(6, blogId);
			ps.setString(7, isActive);

			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void editBlogComment(String commentId, String name, String phone, String email, String createddate,
			String detail, String blogId, String isActive) {
		String query = "UPDATE tbl_BlogComment SET "
				+ "Name = ?, Phone = ?, Email = ?, CreatedDate = ?, Detail = ?, Blog_ID = ?, IsActive = ? "
				+ "WHERE Comment_ID = ?";

		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);

			ps.setString(1, name);
			ps.setString(2, phone);
			ps.setString(3, email);
			ps.setString(4, createddate);
			ps.setString(5, detail);
			ps.setString(6, blogId);
			ps.setString(7, isActive);
			ps.setString(8, commentId);

			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteBlogComment(String id) {
		String query = "DELETE FROM tbl_BlogComment WHERE Comment_ID = ?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			ps.executeUpdate();

		} catch (Exception e) {
		}
	}
	
	//======================= Role =======================
	public List<tbl_Role> getAllRole() {
		List<tbl_Role> list = new ArrayList<>();
		String sql = "select * from tbl_Role";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new tbl_Role(rs.getInt(1), rs.getString(2),rs.getString(3)));
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		return list;

	}
	public void addRole(String rolename, String description) {

		String query = "INSERT INTO tbl_Role " + "(RoleName, Description)"
				+ "VALUES (?, ?)";

		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);

			// Set parameters
			ps.setString(1, rolename);
			ps.setString(2, description);

			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public tbl_Role getRoleDetail(String roleId) {
		String query = "select * from tbl_Role where Role_ID = ?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, roleId);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new tbl_Role(rs.getInt(1), rs.getString(2), rs.getString(3));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (Exception e) {
			}
			try {
				if (ps != null)
					ps.close();
			} catch (Exception e) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
		return null;

	}
	public tbl_Role getRoleById(String roleId) {
		String query = "select * from tbl_Role where Role_ID = ?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, roleId);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new tbl_Role(rs.getInt(1), rs.getString(2), rs.getString(3));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (Exception e) {
			}
			try {
				if (ps != null)
					ps.close();
			} catch (Exception e) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
		return null;

	}
	public void editRole(String rolename, String description, String id) {

		String query = "UPDATE tbl_Role SET " + "RoleName = ?, Description = ?"
				+ "WHERE Role_ID = ?";

		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);

			ps.setString(1, rolename);
			ps.setString(2, description);
			ps.setString(3, id);
			ps.executeUpdate();

			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public void deleteRole(String id) {
		String query = "delete from tbl_Role where Role_ID = ?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
			} catch (Exception e) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
	}



	public List<tbl_Product> getProductsByName(String q) {
		List<tbl_Product> list = new ArrayList<>();
		String query = "SELECT * FROM tbl_Product WHERE Name LIKE ? OR Alias LIKE ?" +
			" ORDER BY Product_ID OFFSET 0 ROWS FETCH NEXT 20 ROWS ONLY";
		try (Connection conn = new DBConnect().getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
			String like = "%" + q + "%";
			ps.setString(1, like);
			ps.setString(2, like);
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					list.add(new tbl_Product(rs.getInt("Product_ID"), rs.getInt("Provider_ID"), rs.getInt("Category_ID"),
							rs.getString("Name"), rs.getString("Alias"), rs.getString("Brands"), rs.getString("Material"),
							rs.getString("Dimensions"), rs.getString("Description"), rs.getString("Detail"),
							rs.getString("Image"), rs.getDouble("Price"), rs.getDouble("PriceSale"), rs.getInt("Quantity"),
							rs.getBoolean("IsNew"), rs.getBoolean("IsBestSeller"), rs.getBoolean("IsActive"), rs.getInt("Star")));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	// Thêm Order cho người dùng từ Cart, trả về true nếu thành công
	public boolean addOrderFromCart(String customerName, String phone, String address, double grandTotal, String note, String paymentMethod, Map<Integer, CartItem> cart) {
	    // Câu lệnh SQL cho tbl_Order (sử dụng GETDATE() để lấy ngày hiện tại)
	    String orderQuery = "INSERT INTO tbl_Order (CustomerName, Phone, Address, TotalAmount, Quantity, CreatedDate, Note, PaymentMethod) VALUES (?, ?, ?, ?, ?, GETDATE(), ?, ?)";
	    // Câu lệnh SQL cho tbl_OrderDetail
	    String detailQuery = "INSERT INTO tbl_OrderDetail (Order_ID, Product_ID, Price, Quantity) VALUES (?, ?, ?, ?)";
	    // Câu lệnh SQL cho tbl_OrderStatus (Mặc định là 'Chờ xác nhận')
	    String statusQuery = "INSERT INTO tbl_OrderStatus (Order_ID, Name, Description) VALUES (?, ?, ?)";
	    
	    Connection localConn = null;
	    PreparedStatement psOrder = null;
	    PreparedStatement psDetail = null;
	    PreparedStatement psStatus = null;
	    ResultSet generatedKeys = null;
	    
	    // Tính tổng số lượng sản phẩm
	    int totalQuantity = cart.values().stream().mapToInt(CartItem::getQuantity).sum();

	    try {
	        localConn = new DBConnect().getConnection();
	        localConn.setAutoCommit(false); // Bắt đầu giao dịch

	        // 1. Insert tbl_Order
	        psOrder = localConn.prepareStatement(orderQuery, Statement.RETURN_GENERATED_KEYS);
	        psOrder.setString(1, customerName);
	        psOrder.setString(2, phone);
	        psOrder.setString(3, address);
	        psOrder.setDouble(4, grandTotal);
	        psOrder.setInt(5, totalQuantity);
	        psOrder.setString(6, note);
	        psOrder.setString(7, paymentMethod);
	        
	        psOrder.executeUpdate();

	        // Lấy Order_ID vừa tạo (quan trọng)
	        int orderId = -1;
	        generatedKeys = psOrder.getGeneratedKeys();
	        if (generatedKeys.next()) {
	            orderId = generatedKeys.getInt(1);
	        } else {
	            throw new Exception("Không lấy được Order ID sau khi thêm Order.");
	        }

	        // 2. Insert tbl_OrderDetail từ CartItem
	        for (CartItem item : cart.values()) {
	            psDetail = localConn.prepareStatement(detailQuery);
	            psDetail.setInt(1, orderId);
	            psDetail.setInt(2, item.getProductId());
	            psDetail.setDouble(3, item.getPrice()); // Sử dụng giá gốc từ CartItem
	            psDetail.setInt(4, item.getQuantity());
	            psDetail.executeUpdate();
	            psDetail.close(); 
	        }
	        
	        // 3. Insert tbl_OrderStatus (Trạng thái mặc định)
	        psStatus = localConn.prepareStatement(statusQuery);
	        psStatus.setInt(1, orderId);
	        psStatus.setString(2, "Chờ xác nhận"); // Trạng thái ban đầu
	        psStatus.setString(3, "Đơn hàng mới được tạo từ người dùng.");
	        psStatus.executeUpdate();
	        
	        localConn.commit(); // Hoàn tất giao dịch
	        return true;
	        
	    } catch (Exception e) {
	        if (localConn != null) {
	            try {
	                localConn.rollback(); // Rollback nếu có lỗi
	            } catch (Exception ex) {
	                ex.printStackTrace();
	            }
	        }
	        e.printStackTrace();
	        return false;
	    } finally {
	        // Đóng tất cả tài nguyên
	        try { if (generatedKeys != null) generatedKeys.close(); } catch (Exception e) {}
	        try { if (psOrder != null) psOrder.close(); } catch (Exception e) {}
	        // psDetail đã đóng trong vòng lặp
	        try { if (psStatus != null) psStatus.close(); } catch (Exception e) {}
	        try { if (localConn != null) localConn.setAutoCommit(true); } catch (Exception e) {}
	        try { if (localConn != null) localConn.close(); } catch (Exception e) {}
	    }
	}
}



















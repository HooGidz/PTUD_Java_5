package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import db.DBConnect;
import db.tbl_Menu;
import db.tbl_Order;
import db.tbl_OrderDetail;
import db.tbl_OrderStatus;
import db.tbl_Product;
import db.tbl_ProductReview;
import db.tbl_Provider;
import db.tbl_RoomCategory;

public class DAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	///--------USER--------///
	public List<tbl_Menu> getAllMenu() {
		List<tbl_Menu> list = new ArrayList<>();
		String query = "select * from tbl_Menu";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new tbl_Menu(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getInt(5),						
						rs.getDate(6),
						rs.getString(7),
						rs.getDate(8),
						rs.getString(9),
						rs.getBoolean(10),
						rs.getBoolean(11)));
				
			}
			
		} catch  (Exception e){
			
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
			while(rs.next()) {
				list.add(new tbl_RoomCategory(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getBoolean(5)));
			}
			
		} catch  (Exception e){
			
		}
		
		return list;
	}
	/// Product
	public tbl_Product getProductDetail(String proId) {
		String query = "select * from tbl_Product where Product_ID = ?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, proId);
			rs = ps.executeQuery();
			while(rs.next()) {
				return new tbl_Product(
						rs.getInt(1),
						rs.getInt(2),
						rs.getInt(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6),
						rs.getString(7),
						rs.getString(8),
						rs.getString(9),
						rs.getString(10),
						rs.getString(11),
						rs.getDouble(12),
						rs.getDouble(13),
						rs.getInt(14),
						rs.getBoolean(15),
						rs.getBoolean(16),
						rs.getBoolean(17),
						rs.getInt(18));
			}
			
		} catch  (Exception e){
			
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
			while(rs.next()) {
				list.add(new tbl_Product(
						rs.getInt(1),
						rs.getInt(2),
						rs.getInt(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6),
						rs.getString(7),
						rs.getString(8),
						rs.getString(9),
						rs.getString(10),
						rs.getString(11),
						rs.getDouble(12),
						rs.getDouble(13),
						rs.getInt(14),
						rs.getBoolean(15),
						rs.getBoolean(16),
						rs.getBoolean(17),
						rs.getInt(18)));
			}
			
		} catch  (Exception e){
			
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
			while(rs.next()) {
				list.add( new tbl_ProductReview(
						rs.getInt(1),
						rs.getInt(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getDate(6),
						rs.getString(7),
						rs.getInt(8),
						rs.getBoolean(9)));
			}
			
		} catch  (Exception e){
			
		}
		return list;
	}
	public void addProReview(String productId,String name, String phone, String email, String createdDate, String detail, String star, String isActive) {
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
		} catch  (Exception e){
			
		}
	}
	
	
	//--------ADMIN------//
	//Provider
	public List<tbl_Provider> getAllProvider() {
		List<tbl_Provider> list = new ArrayList<>();
		String query = "select * from tbl_Provider";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new tbl_Provider(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6),
						rs.getBoolean(7)));
			}
			
		} catch  (Exception e){
			
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
			while(rs.next()) {
				return new tbl_Provider(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6),
						rs.getBoolean(7));
			}
			
		} catch  (Exception e){
			
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
		} catch  (Exception e){
			
		}
	}
	public void addProvider(String name, String address, String phone, String email, String description, String status) {
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
		} catch  (Exception e){
			
		}
	}
	public void editProvider(String id,String name, String address, String phone, String email, String description, String status) {
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
		} catch  (Exception e){
			
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
			while(rs.next()) {
				list.add(new tbl_Order(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getInt(5),
						rs.getInt(6),
						rs.getDate(7),
						rs.getString(8),
						rs.getDate(9),
						rs.getString(10),
						rs.getString(11),
						rs.getString(12)));
			}
			
		} catch  (Exception e){
			
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
			while(rs.next()) {
				return new tbl_Order(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getInt(5),
						rs.getInt(6),
						rs.getDate(7),
						rs.getString(8),
						rs.getDate(9),
						rs.getString(10),
						rs.getString(11),
						rs.getString(12));
			}
			
		} catch  (Exception e){
			
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
		} catch  (Exception e){
			
		}
	}
	public void addOrder(String customerName,  String phone, String address, String totalAmount, String quantity, String note, String paymentMethod, String createdDate ) {
		String query = "INSERT INTO tbl_Order (CustomerName, Phone, Address, TotalAmount, Quantity, CreatedDate, Note, PaymentMethod) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, customerName);
			ps.setString(2, phone);
			ps.setString(3, address);
			ps.setString(4, totalAmount);
			ps.setString(5, quantity);
			ps.setString(6, createdDate);
			ps.setString(7, note);
			ps.setString(8, paymentMethod);
			
			ps.executeUpdate();	
		} catch  (Exception e){
			
		}
	}
	public void editOrder(String id, String customerName,  String phone, String address, String totalAmount, String quantity, String note, String paymentMethod, String modifiedDate ) {
		String query = "UPDATE tbl_Order SET"
				+ " CustomerName = ?, Phone = ?, Address = ?, TotalAmount = ?, Quantity = ?, ModifiedDate = ?, Note = ?, PaymentMethod = ? "
				+ "WHERE Order_ID = ?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, customerName);
			ps.setString(2, phone);
			ps.setString(3, address);
			ps.setString(4, totalAmount);
			ps.setString(5, quantity);
			ps.setString(6, modifiedDate);
			ps.setString(7, note);
			ps.setString(8, paymentMethod);
			ps.setString(9, id);
			ps.executeUpdate();	
		} catch  (Exception e){
			
		}
	}
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		DAO dao = new DAO();
		List<tbl_Provider> list = dao.getAllProvider();
		for (tbl_Provider o : list ) {
			System.out.println(o);
		}
//		tbl_Product list = dao.getProductDetail("1");
//		System.out.println(list);
	}
	
	
	

}













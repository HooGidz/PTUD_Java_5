package dao;

import java.text.SimpleDateFormat;
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
import db.tbl_ProductCategory;
import db.tbl_Product;
import db.tbl_Account;
import db.tbl_Contact;

public class DAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

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
}

package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
	private final String serverName = "DESKTOP-L7HK7RE";
    private final String dbName = "Web_NoiThat";            
    private final String portNumber = "1433";            // Cổng SQL Server
    private final String userID = "sa"; 
    private final String password = "123"; 

	public Connection getConnection() throws ClassNotFoundException, SQLException {
		// Chuỗi URL kết nối SQL Server (sử dụng SQL Server Authentication)
		String dbURL = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";" + "databaseName=" + dbName + ";"
				+ "user=" + userID + ";" + "password=" + password + ";"
				// Cần thêm hai thuộc tính này nếu phiên bản SQL Server mới hoặc JDK mới
				+ "encrypt=true;" + "trustServerCertificate=true";

		Connection conn = null;
		try {
			// 1. Load Driver (Không bắt buộc với JDBC 4.0 trở lên, nhưng vẫn nên dùng để
			// đảm bảo)
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			// 2. Tạo kết nối
			conn = DriverManager.getConnection(dbURL);
			System.out.println("Kết nối SQL Server thành công!");
		} catch (ClassNotFoundException e) {
			System.err.println("Lỗi: Không tìm thấy JDBC Driver.");
			throw e;
		} catch (SQLException e) {
			System.err.println("Lỗi: Kết nối thất bại. Kiểm tra URL, user, pass, và trạng thái SQL Server.");
			throw e;
		}
		return conn;
	}

	// Phương thức thử nghiệm
	public static void main(String[] args) {
		try (Connection con = new DBConnect().getConnection()) {
			// Thực hiện truy vấn kiểm tra nếu kết nối thành công
			// Ví dụ: Statement st = con.createStatement();
			// ...
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

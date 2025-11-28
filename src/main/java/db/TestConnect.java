package db; // Thay đổi package nếu cần thiết

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestConnect {

    /* * * * * * * * * * * * * * * * * * * * * * * * * * * * *
     * THÔNG TIN KẾT NỐI (Sử dụng SQL Server Authentication)  *
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    private final String serverName = "ADMIN-PC\\MSSQLSERVER01";
    private final String dbName = "Web_NoiThat";            
    private final String portNumber = "1433";            // Cổng SQL Server
    private final String instance = "";                  
    private final String userID = "sa"; 
    private final String password = "123"; 

    public Connection getConnection() throws Exception {
        // Xây dựng URL kết nối
        String url;
        if (instance == null || instance.trim().isEmpty()) {
            // URL cho instance mặc định
            url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName;
        } else {
            // URL cho instance có tên
            url = "jdbc:sqlserver://" + serverName + ":" + portNumber + "\\" + instance + ";databaseName=" + dbName;
        }

        // KHÔNG CÓ integratedSecurity=true
        url += ";encrypt=true;trustServerCertificate=true;";

        // 1. Load Driver
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        
        // 2. Thiết lập kết nối BẰNG USERID VÀ PASSWORD
        return DriverManager.getConnection(url, userID, password); // <--- Đã sửa ở đây
    }

    public void testDatabaseConnection() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
            System.out.println("Đang cố gắng kết nối đến SQL Server...");
            
            // Lấy kết nối
            conn = getConnection();
            
            if (conn != null) {
                System.out.println("✅ KẾT NỐI THÀNH CÔNG!");
                
                // --- THỬ NGHIỆM ĐỌC DỮ LIỆU ĐƠN GIẢN ---
                System.out.println("Đang kiểm tra truy vấn đơn giản...");
                
                stmt = conn.createStatement();
                // Truy vấn lấy ngày giờ hiện tại của SQL Server
                rs = stmt.executeQuery("SELECT GETDATE() AS CurrentDateTime");
                
                if (rs.next()) {
                    System.out.println("    Đọc dữ liệu thành công! (Thời gian hiện tại trên DB: " + rs.getString("CurrentDateTime") + ")");
                }
                
                System.out.println("Kiểm tra kết thúc.");
                
            } else {
                System.out.println("❌ KẾT NỐI THẤT BẠI: Đối tượng Connection là NULL.");
            }
            
        } catch (ClassNotFoundException e) {
            System.err.println("❌ LỖI DRIVER: Không tìm thấy JDBC Driver.");
            System.err.println("Hãy đảm bảo bạn đã thêm file mssql-jdbc.jar vào Build Path.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("❌ LỖI SQL: Kết nối thất bại. Kiểm tra lại thông tin đăng nhập và trạng thái của SQL Server.");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("❌ LỖI KHÁC: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Đóng các tài nguyên
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) {
                    conn.close();
                    System.out.println("\nĐã đóng kết nối.");
                }
            } catch (SQLException e) {
                System.err.println("Lỗi khi đóng tài nguyên: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        TestConnect tester = new TestConnect();
        tester.testDatabaseConnection();
    }
}
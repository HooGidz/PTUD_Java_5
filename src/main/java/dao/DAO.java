package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import db.DBConnect;
import db.tbl_Menu;

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
			while(rs.next()) {
				list.add(new tbl_Menu(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3)));
			}
			
		} catch  (Exception e){
			
		}
		
		return list;
	}
	public static void main(String[] args) {
		DAO dao = new DAO();
		List<tbl_Menu> list = dao.getAllMenu();
		for (tbl_Menu o : list ) {
			System.out.println(o);
		}
	}
}

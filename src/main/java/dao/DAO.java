package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import db.DBConnect;
import db.tbl_Menu;
import db.tbl_RoomCategory;
import db.tbl_ProductCategory;
import db.tbl_Blog;
import db.tbl_Collection;
import db.tbl_BlogComment;

public class DAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    // ======================= MENU & ROOM CATEGORY =======================
    public List<tbl_Menu> getAllMenu() {
        List<tbl_Menu> list = new ArrayList<>();
        String sql = "SELECT * FROM tbl_Menu";
        try {
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new tbl_Menu(
                        rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getInt(5),
                        rs.getDate(6), rs.getString(7),
                        rs.getDate(8), rs.getString(9),
                        rs.getBoolean(10), rs.getBoolean(11)
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return list;
    }

    public List<tbl_RoomCategory> getAllRoomcategory() {
        List<tbl_RoomCategory> list = new ArrayList<>();
        String sql = "SELECT * FROM tbl_RoomCategory";
        try {
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new tbl_RoomCategory(
                        rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getBoolean(5)
                ));
            }
        } catch (Exception e) { e.printStackTrace(); }
        
        return list;
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
                list.add(new tbl_Blog(
                    rs.getInt(1),
                    rs.getInt(2), 
                    rs.getString(3),
                    rs.getString(4),
                    rs.getInt(5),
                    rs.getString(6),
                    rs.getString(7),
                    rs.getString(8),
                    rs.getString(9),
                    rs.getString(10),
                    rs.getString(11),
                    rs.getTimestamp(12),
                    rs.getString(13),
                    rs.getTimestamp(14),
                    rs.getString(15),
                    rs.getBoolean(16)
                ));
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
                list.add(new tbl_Blog(
                		 rs.getInt(1),
                         rs.getInt(2), 
                         rs.getString(3),
                         rs.getString(4),
                         rs.getInt(5),
                         rs.getString(6),
                         rs.getString(7),
                         rs.getString(8),
                         rs.getString(9),
                         rs.getString(10),
                         rs.getString(11),
                         rs.getTimestamp(12),
                         rs.getString(13),
                         rs.getTimestamp(14),
                         rs.getString(15),
                         rs.getBoolean(16)
                ));
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
                list.add(new tbl_Blog(
                		 rs.getInt(1),
                         rs.getInt(2), 
                         rs.getString(3),
                         rs.getString(4),
                         rs.getInt(5),
                         rs.getString(6),
                         rs.getString(7),
                         rs.getString(8),
                         rs.getString(9),
                         rs.getString(10),
                         rs.getString(11),
                         rs.getTimestamp(12),
                         rs.getString(13),
                         rs.getTimestamp(14),
                         rs.getString(15),
                         rs.getBoolean(16)
                ));
            }

        }catch (Exception e) {
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
            if (rs.next()) return rs.getInt(1);
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
            ps.setInt(1, blogId); // QUAN TRỌNG: Thêm dòng này
            rs = ps.executeQuery();

            if (rs.next()) {
                blog = new tbl_Blog(
                    rs.getInt("Blog_ID"),
                    rs.getInt("Category_ID"), 
                    rs.getString("Title"),
                    rs.getString("Content"),
                    rs.getInt("View_Count"),
                    rs.getString("Image"),
                    rs.getString("Author"),
                    rs.getString("Tags"),
                    rs.getString("Meta_Description"),
                    rs.getString("Meta_Keywords"),
                    rs.getString("Slug"),
                    rs.getTimestamp("Create_Date"),
                    rs.getString("Create_By"),
                    rs.getTimestamp("Update_Date"),
                    rs.getString("Update_By"),
                    rs.getBoolean("IsActive")
                );
                System.out.println("DAO - Found blog: " + blog.getTitle());
            } else {
                System.out.println("DAO - No blog found with ID: " + blogId);
            }

        } catch (Exception e) {
            System.out.println("Error in getBlogById: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Đóng kết nối
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return blog;
    }
    
    
    //===================ADMIN====================//
    public List<tbl_Blog> getAllBlogs(){
    	List<tbl_Blog> list = new ArrayList<>();
        String sql = "SELECT * FROM tbl_Blog ";
        try {
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new tbl_Blog(
                    rs.getInt(1),
                    rs.getInt(2), 
                    rs.getString(3),
                    rs.getString(4),
                    rs.getInt(5),
                    rs.getString(6),
                    rs.getString(7),
                    rs.getString(8),
                    rs.getString(9),
                    rs.getString(10),
                    rs.getString(11),
                    rs.getDate(12),
                    rs.getString(13),
                    rs.getDate(14),
                    rs.getString(15),
                    rs.getBoolean(16)
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        
        }
        return list;
    
    }
    
    public tbl_Blog getBlogById(String blogId) {
		String query = "select * from tbl_Blog where Blog_ID = ?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, blogId);
			rs = ps.executeQuery();
			while(rs.next()) {
				return new tbl_Blog(
						rs.getInt(1),
                        rs.getInt(2), 
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getDate(12),
                        rs.getString(13),
                        rs.getDate(14),
                        rs.getString(15),
                        rs.getBoolean(16));
			}
			
		} catch  (Exception e){
			
		}
		return null;
		
	}
    
		    public void addBlog(String accountId, String title, String alias, String categoryId, 
		            String description, String detail, String image, 
		            String seoTitle, String seoDescription, String seoKeywords,
		            String createdBy, String isActive) {
		String query = "INSERT INTO tbl_Blog (Account_ID, Title, Alias, Category_ID, Description, "
		          + "Detail, Image, SeoTitle, SeoDescription, SeoKeywords, CreatedDate, CreatedBy, IsActive) "
		          + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, GETDATE(), ?, ?)";
		
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
		 ps.setString(11, createdBy);
		 ps.setBoolean(12, "1".equals(isActive) || "true".equalsIgnoreCase(isActive));
		 
		 ps.executeUpdate();
		 System.out.println("Thêm bài viết thành công: " + title);
		 
		} catch (Exception e) {
		 System.out.println("Lỗi khi thêm bài viết: " + e.getMessage());
		 e.printStackTrace();
		} finally {
		 // Đóng kết nối
		 try {
		     if (ps != null) ps.close();
		     if (conn != null) conn.close();
		 } catch (Exception e) {
		     e.printStackTrace();
		 }
		}
		}
		    public void editBlog(String blogId, String accountId, String title, String alias, String categoryId, 
		            String description, String detail, String image, 
		            String seoTitle, String seoDescription, String seoKeywords,
		            String modifiedBy, String isActive) {
		String query = "UPDATE tbl_Blog SET "
		    + "Account_ID = ?, Title = ?, Alias = ?, Category_ID = ?, Description = ?, "
		    + "Detail = ?, Image = ?, SeoTitle = ?, SeoDescription = ?, "
		    + "SeoKeywords = ?, ModifiedDate = GETDATE(), ModifiedBy = ?, IsActive = ? "
		    + "WHERE Blog_ID = ?";
		
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
		    if (ps != null) ps.close();
		    if (conn != null) conn.close();
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
    public List<tbl_Collection> getAllCollection(){
    	List<tbl_Collection> list = new ArrayList<>();
    	String sql = "select * from tbl_Collection";
    	try {
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()) {
            	list.add(new tbl_Collection(
            			rs.getInt(1),
            			rs.getString(2),
            			rs.getString(3),
            			rs.getString(4),
            			rs.getString(5),
            			rs.getString(6),
            			rs.getString(7),
            			rs.getString(8),
            			rs.getBoolean(9),
            			rs.getBoolean(10),
            			rs.getBoolean(11),
            			rs.getDate(12)
            			));
            }
    	}catch (Exception e) {
            e.printStackTrace();
        
        }
        return list;
    
    }
    
    public tbl_Collection getCollectionById(String collectionId) {
		String query = "select * from tbl_Collection where Collection_ID = ?";
		try {
			conn = new DBConnect().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, collectionId);
			rs = ps.executeQuery();
			while(rs.next()) {
				return new tbl_Collection(
            			rs.getInt(1),
            			rs.getString(2),
            			rs.getString(3),
            			rs.getString(4),
            			rs.getString(5),
            			rs.getString(6),
            			rs.getString(7),
            			rs.getString(8),
            			rs.getBoolean(9),
            			rs.getBoolean(10),
            			rs.getBoolean(11),
            			rs.getDate(12)
            			);
            }
			
		} catch  (Exception e){
			
		}
		return null;
		
	}
    public void addCollection(String name, String alias, String designer, String maker,
            String description, String detail, String image,
            String isNew, String isBestSeller, String createdBy, String isActive) {
			
			String query = "INSERT INTO tbl_Collection "
			   + "(Name, Alias, Designer, Maker, Description, Detail, Image, "
			   + "IsNew, IsBestSeller, IsActive, CreateDate, CreatedBy) "
			   + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
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
			ps.setString(8, isNew);
			ps.setString(9, isBestSeller);
			ps.setString(10, isActive);
			ps.setString(11, createdBy);
			
			ps.executeUpdate();
			
			} catch (Exception e) {
			
			}
		}



    public void editCollection(tbl_Collection c) {
        String query = "UPDATE tbl_Collection SET "
            + "Name=?, Alias=?, Designer=?, Maker=?, Description=?, Detail=?, Image=?, "
            + "IsNew=?, IsBestSeller=?, IsActive=? "
            + "WHERE Collection_ID = ?";

        try {
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(query);

            ps.setString(1, c.getName());
            ps.setString(2, c.getAlias());
            ps.setString(3, c.getDesigner());
            ps.setString(4, c.getMaker());
            ps.setString(5, c.getDescription());
            ps.setString(6, c.getDetail());
            ps.setString(7, c.getImage());
            ps.setBoolean(8, c.isNew());
            ps.setBoolean(9, c.isBestSeller());
            ps.setBoolean(10, c.isActive());
            ps.setInt(11, c.getCollectionId());

            ps.executeUpdate();
            System.out.println("Sửa thành công Collection ID: " + c.getCollectionId());

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
	    public List<tbl_BlogComment> getAllBlogComment(){
	    	List<tbl_BlogComment> list = new ArrayList<>();
	    	String sql = "select * from tbl_BlogComment";
	    	try {
	            conn = new DBConnect().getConnection();
	            ps = conn.prepareStatement(sql);
	            rs = ps.executeQuery();
	            while(rs.next()) {
	                list.add(new tbl_BlogComment(
	                    rs.getInt(1),
	                    rs.getString(2),
	                    rs.getString(3),
	                    rs.getString(4),
	                    rs.getDate(5),
	                    rs.getString(6),
	                    rs.getInt(7),
	                    rs.getBoolean(8)
	                ));
	            }


	    	}catch (Exception e) {
	            e.printStackTrace();
	        
	        }
	        return list;
	    
	    }
	    
	    public tbl_BlogComment getBlogCommentById(String commentId) {
	        String query = "select * from tbl_BlogComment where BlogComment_ID = ?";
	        try {
	            conn = new DBConnect().getConnection();
	            ps = conn.prepareStatement(query);
	            ps.setString(1, commentId);
	            rs = ps.executeQuery();
	            if (rs.next()) {
	                return new tbl_BlogComment(
	                		rs.getInt(1),
		                    rs.getString(2),
		                    rs.getString(3),
		                    rs.getString(4),
		                    rs.getDate(5),
		                    rs.getString(6),
		                    rs.getInt(7),
		                    rs.getBoolean(8)
		                );
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return null;
	    }


}
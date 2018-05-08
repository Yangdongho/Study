package Study;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class stockDao {
	/*1.디비 드라이버 
	2.디비 커넥트
	3.statement 생성
	4.각 기능 메서드로*/
	PreparedStatement pstmt;
	int dbIndex = 0; 
	
	
	public HashMap<String,List<Stock>> select(){
		Connection con = null;
		String sql = "select * from stock";
		Statement stmt;
		ResultSet rs;// 디비에서 가져온 값을 저장하는 클래스
		HashMap<String,List<Stock>> map = new HashMap<String,List<Stock>>();
		try {
			con = DbConnect.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
		
			System.out.println("쿼리실행");
			
			while(rs.next()) {
				Stock temp = new Stock();
				if(map.containsKey(rs.getString("storeName"))!=true) {
					map.put(rs.getString("storeName"), new ArrayList()); //키 중복이면 무시
				}
				temp.setProductName(rs.getString("productName"));
				temp.setNumber(rs.getInt("amount"));
				temp.setPrice(rs.getInt("price"));
				temp.setIndex(rs.getInt("productNum"));
				map.get(rs.getString("storeName")).add(temp);
				dbIndex++;
				System.out.println("Dao 인덱스 번호 : "+dbIndex);
			}			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
		
		return map;
	}
	
	public void insert(String key,Stock s){
		Connection con = null;
		String sql = "insert into stock values(?,?,?,?,?)";
		PreparedStatement pstmt = null;
		
		try {
			con = DbConnect.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, key);
			pstmt.setString(2, s.getProductName());
			pstmt.setInt(3, s.getNumber());
			pstmt.setInt(4, s.getPrice());
			pstmt.setInt(5,s.getIndex());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	public void delete(int index) {
		
		Connection con = null;
		String sql = "delete from stock where productNum = ?";
		PreparedStatement pstmt = null;
		
		try {
			con = DbConnect.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, index);
			pstmt.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
	}
	
	public void update(Stock s) {
		Connection con = null;
		String sql = "update stock set productname = ? , amount = ?, price = ? where productnum = ?";
		PreparedStatement pstmt = null;
		
		try {
			con = DbConnect.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, s.getProductName());
			pstmt.setInt(2, s.getNumber());
			pstmt.setInt(3, s.getPrice());
			pstmt.setInt(4, s.getIndex());
			pstmt.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
	
}

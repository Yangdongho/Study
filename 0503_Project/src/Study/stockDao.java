package Study;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class stockDao {
	/*1.디비 드라이버 
	2.디비 커넥트
	3.statement 생성
	4.각 기능 메서드로*/
	private final static String url ="jdbc:oracle:thin:@localhost:1521:XE";
	private final static String id = "Yang";
	private final static String password = "123";
	Connection con;
	PreparedStatement pstmt;
	//pstmt = con.prepareStatement(sql);
	/*create table stock(
	 		storeName varchar2(30);
			prpoductName varchar2(30),
			num number,
			price number	
		);
	*/
	//HashMap<String,List<Stock>>
	
	public stockDao(){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con  = DriverManager.getConnection(url, id, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public HashMap<String,List<Stock>> select(){
		String sql = "select * from stock";
		ResultSet rs = null;// 디비에서 가져온 값을 저장하는 클래스
		HashMap<String,List<Stock>> map = new HashMap<String,List<Stock>>();
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				map.put(rs.getString(1), new ArrayList()); //키 중복이면 무시
				map.get(rs.getString(1)).add(new Stock(rs.getString(2),rs.getInt(3),rs.getInt(4)));
			}			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return map;
	}
	
	
	
	
	
}

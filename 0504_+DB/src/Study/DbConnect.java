package Study;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnect {
	final static String url = "jdbc:oracle:thin:@localhost:1521:XE";
	final static String id = "Yang";
	final static String password = "123";
    static Connection con = null;

	// 객체마다 생성될 필요가 없기 때문에 static메서드로 선언 객체선언없이 사용가능

	// DB연결이 필요할때마다 insert select 등에서 연결 후에
	// 연결을 끊어 자원을 반납해야한다.
	public static Connection getConnection() throws ClassNotFoundException, SQLException {

		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("드라이버 성공");
		con = DriverManager.getConnection(url, id, password);
		return con;

	}

}

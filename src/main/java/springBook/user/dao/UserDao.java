package springBook.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import springBook.user.domain.User;

public class UserDao {

	public void add(User user) throws ClassNotFoundException, SQLException {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, "scott3", "tiger");
	
		String sql = "insert into users(id, name, passwd) values(?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, user.getId());
		pstmt.setString(2, user.getName());
		pstmt.setString(3, user.getPasswd());
	
		pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
	}
	
	public User get(String id) throws ClassNotFoundException, SQLException {
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, "scott3", "tiger");
		
		String sql = "select * from users where id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		
		ResultSet rs = pstmt.executeQuery();
		rs.next();
		User user = new User();
		user.setId(rs.getString("id"));
		user.setName(rs.getString("name"));
		user.setPasswd(rs.getString("passwd"));
	
		rs.close();
		pstmt.close();
		conn.close();
		
		return user;
	}
}

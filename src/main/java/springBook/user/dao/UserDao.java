package springBook.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import springBook.user.domain.User;

public class UserDao {
	
	//인터페이스를 통해 오브젝트에 접근하므로 구체적인 클래스정보를 알 필요가 없다.
	//private ConnectionMaker connectionMaker;
	//private SimpleConnectionMaker simpleConnectionMaker;
	private ConnectionMaker connectionMaker;
	
	public UserDao(ConnectionMaker connectionMaker) {
		this.connectionMaker  = connectionMaker;
	}

	public void add(User user) throws ClassNotFoundException, SQLException {
		
		Connection conn = connectionMaker.makeConnection();
	
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
		 
		Connection conn = connectionMaker.makeConnection();
		
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

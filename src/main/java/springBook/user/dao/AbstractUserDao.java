package springBook.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import springBook.user.domain.User;

public abstract class AbstractUserDao {

	public void add(User user) throws ClassNotFoundException, SQLException {
		
		Connection conn = getConnection();
	
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
		 
		Connection conn = getConnection();
		
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
	
	public abstract Connection getConnection() throws ClassNotFoundException, SQLException;

	
	public class NUserDao extends AbstractUserDao {

		@Override
		public Connection getConnection() throws ClassNotFoundException, SQLException {
			
			return null;
		}
		 
	}
	

	public class DUserDao extends AbstractUserDao {

		@Override
		public Connection getConnection() throws ClassNotFoundException, SQLException {
			// TODO Auto-generated method stub
			return null;
		}
		 
	}
}



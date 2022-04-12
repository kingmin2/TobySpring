package springBook.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SimpleConnectionMaker {

	public Connection makeNewConnection() throws SQLException, ClassNotFoundException	{
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, "scott3", "tiger");
		
		return conn;
	}
}

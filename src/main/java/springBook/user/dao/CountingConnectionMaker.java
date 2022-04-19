package springBook.user.dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.taglibs.standard.lang.jstl.test.beans.PublicBean1;

public class CountingConnectionMaker implements ConnectionMaker {
	int counter = 0;
	private ConnectionMaker realconnectionMaker;
	
	public CountingConnectionMaker(ConnectionMaker realConnectionMaker) {
		this.realconnectionMaker = realConnectionMaker;
		
	}
	@Override
	public Connection makeConnection() throws ClassNotFoundException, SQLException {
		this.counter++;

		return realconnectionMaker.makeConnection();
	}
	
	public int getCounter() {
		return this.counter;
	}

}

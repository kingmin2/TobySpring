package springBook.user.dao;


public class DaoFactory {

	public UserDao userDao() {
		return new UserDao(new DConnectionMaker());
	}
	
	public ConnectionMaker connectionMaker() {
		return new DConnectionMaker();
	}
}

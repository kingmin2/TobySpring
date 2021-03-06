import java.sql.SQLException;

import springBook.user.dao.DaoFactory;
import springBook.user.dao.UserDao;
import springBook.user.domain.User;

public class UserDaoTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
//		ConnectionMaker connectionMaker = new DConnectionMaker();
//		ConnectionMaker connectionMaker = new NConnectionMaker();	
		UserDao dao = new DaoFactory().userDao();
		
		User user = new User();
		user.setId("whiteship");
		user.setName("백기선");
		user.setPasswd("married");
		
		dao.add(user);
		
		System.out.println(user.getId() + "등록 성공!");
		
		User user2 = dao.get(user.getId());
		System.out.println("user2.getName"+user2.getName());
		System.out.println("user2.getPasswd"+user2.getPasswd());
		
		System.out.println(user2.getId()+"조회 성공");
	}
}

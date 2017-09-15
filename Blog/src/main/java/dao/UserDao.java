package dao;



import model.User;

public interface UserDao extends BaseDao<User>{
	
	boolean existsUser(String username);
	User existsUser(String username, String password);
	

}

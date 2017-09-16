package service;

import java.util.List;


import model.User;

public interface UserService extends BaseService<User>{
	
	boolean checkUsername(String username);
	User checkUsernameAndPassword(String username, String password);
	Integer count();
	List<User> findAll();
	List<User> find(Integer pageNow, Integer rows);
	User find(Integer id);
	void delete(Integer id);
}

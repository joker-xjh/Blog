package service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.UserDao;
import model.User;
import service.UserService;

@Service("userService")
@Transactional
public class UserServiceImp extends BaseServiceImp<User> implements UserService{
	
	@Autowired
	@Qualifier("userDao")
	private UserDao dao;
	

	public boolean checkUsername(String username) {
		return dao.existsUser(username);
	}

	public User checkUsernameAndPassword(String username, String password) {
		return dao.existsUser(username, password);
	}

	public Integer count() {
		String hql = "from User";
		return dao.count(hql);
	}

	public List<User> findAll() {
		String hql = "from User";
		List<User> list = dao.findAll(hql);
		return list;
	}

	public List<User> find(Integer pageNow, Integer rows) {
		String hql = "from User";
		return dao.find(hql, pageNow, rows);
	}

}

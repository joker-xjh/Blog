package dao.imp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import dao.UserDao;
import model.User;

@SuppressWarnings("all")
@Repository("userDao")
public class UserDaoImp extends BaseDaoImp<User> implements UserDao{

	public boolean existsUser(String username) {
		Session session = getSession();
		String hql = "from User u where u.username = ?";
		Query query = session.createQuery(hql);
		query.setString(0, username);
		List list = query.list();
		if(list.size() > 0)
			return true;
		return false;
	}

	public User existsUser(String username, String password) {
		Session session = getSession();
		String hql = "from User u where u.username = ? and u.password = ?";
		Query query = session.createQuery(hql);
		query.setString(0, username);
		query.setString(1, password);
		User user = (User) query.uniqueResult();
		return user;
	}

}

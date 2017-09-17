package dao.imp;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.BaseDao;

@Repository("baseDao")
@SuppressWarnings("all")
public class BaseDaoImp<T> implements BaseDao<T>{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public static void main(String[] args) {
		
	}
	
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public void save(T obj) {
		getSession().save(obj);
	}

	public void delete(Class<T> clazz, Integer id) {
		T obj = find(clazz,id);
		getSession().delete(obj);
	}

	public void delete(T obj) {
		getSession().delete(obj);
	}

	public void update(T obj) {
		getSession().update(obj);
	}

	public T find(Class<T> clazz, Integer id) {
			return (T) getSession().get(clazz, id);
	}

	public Integer count(String hql) {
		Query query = getSession().createQuery(hql);
		List list = query.list();
		return list.size();
	}
	
	public Integer count(String hql, Object...params) {
		Query query = getSession().createQuery(hql);
		if(params != null && params.length >0) {
			for(int i=0; i<params.length; i++) {
				query.setParameter(i, params[i]);
			}
		}
		List list = query.list();
		return list.size();
	}

	public List<T> findAll(String hql) {
		Query query = getSession().createQuery(hql);
		List list = query.list();
		return list;
	}

	public List<T> find(String hql, Integer pageNow, Integer rows, Object...params) {
		Query query = getSession().createQuery(hql);
		if(params != null) {
			for(int i=0; i<params.length; i++) {
				query.setParameter(i, params[i]);
			}
		}
		query.setFirstResult((pageNow-1)*rows);
		query.setMaxResults(rows);
		List list = query.list();
		return list;
	}

	
	

}

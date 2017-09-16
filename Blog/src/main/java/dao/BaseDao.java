package dao;

import java.util.List;

public interface BaseDao<T> {
	
	void save(T obj);
	void delete(Class<T> clazz, Integer id);
	void delete(T obj);
	void update(T obj);
	T find(Class<T> clazz, Integer id);
	Integer count(String hql);
	List<T> findAll(String hql);
	List<T> find(String hql, Integer pageNow, Integer rows);

}

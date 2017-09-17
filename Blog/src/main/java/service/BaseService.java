package service;

import java.util.List;

public interface BaseService<T> {
	
	void save(T obj);
	void delete(T obj);
	void delete(Class<T> clazz, Integer id);
	void update(T obj);
	T find(Class<T> clazz, Integer id);
	Integer count(String hql);
	Integer count(String hql, Object...params);
	List<T> findAll(String hql);
	List<T> find(String hql, Integer pageNow, Integer rows, Object...params);

}

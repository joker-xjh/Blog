package service;

import java.util.List;

public interface BaseService<T> {
	
	void save(T obj);
	void delete(T obj);
	void delete(Integer id);
	void update(T obj);
	T find(Integer id);
	Integer count(String hql);
	List<T> findAll(String hql);
	List<T> find(String hql, Integer pageNow, Integer rows);

}
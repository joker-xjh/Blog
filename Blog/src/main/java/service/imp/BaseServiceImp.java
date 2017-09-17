package service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.BaseDao;
import service.BaseService;

@Service("baseService")
@Transactional
public class BaseServiceImp<T> implements BaseService<T>{
	
	@Autowired
	@Qualifier("baseDao")
	private BaseDao<T> dao;

	public void save(T obj) {
		dao.save(obj);
	}

	public void delete(T obj) {
		dao.delete(obj);
	}

	public void delete(Class<T> clazz, Integer id) {
		dao.delete(clazz, id);
	}

	public void update(T obj) {
		dao.update(obj);
	}

	public T find(Class<T> clazz, Integer id) {
		return dao.find(clazz, id);
	}

	public Integer count(String hql) {
		return dao.count(hql);
	}
	
	public Integer count(String hql, Object...params) {
		return dao.count(hql, params);
	}

	public List<T> findAll(String hql) {
		return dao.findAll(hql);
	}

	public List<T> find(String hql, Integer pageNow, Integer rows, Object...params) {
		return dao.find(hql, pageNow, rows,params);
	}

	

	
}

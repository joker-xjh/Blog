package service;

import java.util.List;

import model.Blog;

public interface BlogService extends BaseService<Blog>{
	
	Integer count();
	List<Blog> findAll();
	List<Blog> find(String hql, Integer pageNow, Integer rows,Object... params);
	Blog find(Integer id);
	void delete(Integer id);

}

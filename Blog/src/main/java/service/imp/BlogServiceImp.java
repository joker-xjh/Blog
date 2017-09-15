package service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.BlogDao;
import model.Blog;
import service.BlogService;

@Service("blogService")
@Transactional
public class BlogServiceImp extends BaseServiceImp<Blog> implements BlogService{
	
	@Autowired
	@Qualifier("blogDao")
	private BlogDao dao;

	public Integer count() {
		String hql = "from Blog";
		return dao.count(hql);
	}

	public List<Blog> findAll() {
		String hql = "from Blog";
		return dao.findAll(hql);
	}

	public List<Blog> find(Integer pageNow, Integer rows) {
		String hql = "from Blog";
		return dao.find(hql, pageNow, rows);
	}

}

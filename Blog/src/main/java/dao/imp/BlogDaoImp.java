package dao.imp;

import org.springframework.stereotype.Repository;

import dao.BlogDao;
import model.Blog;

@Repository("blogDao")
public class BlogDaoImp extends BaseDaoImp<Blog> implements BlogDao{

}

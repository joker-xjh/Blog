package controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.Blog;
import model.User;
import service.BlogService;
import service.UserService;

@Controller
public class BlogController {
	
	@Autowired
	private BlogService blogService;
	
	@Autowired
	private UserService UserService;
	
	private static final Integer rows = 4;
	
	@RequestMapping(value = "/writeBlogPage")
	public String writeBlogPage(HttpSession session) {
		if(session.getAttribute("user") == null)
			return "login";
		return "writeBlog";
	}
	
	@RequestMapping(value = {"/writeBlog"}, method = RequestMethod.POST)
	public String doWriteBlog(String title, String content, HttpSession session) {
		User user = (User)session.getAttribute("user");
		Blog blog = new Blog();
		blog.setTitle(title);
		blog.setContent(content);
		blog.setDate(new Date());
		user.getBlogs().add(blog);
		blog.setUser(user);
		UserService.update(user);
		blogService.save(blog);
		return "redirect:/myBlogsPage/1";
	}
	
	@RequestMapping(value = "/myBlogsPage/{pageNow}")
	public String myBlogsPage(HttpSession session, Map<String, Object> data, @PathVariable(value = "pageNow") Integer pageNow) {
		User user = (User)session.getAttribute("user");
		Integer userid = user.getUserid();
		String hql = "from Blog b where b.user.userid = ? order by b.blogid desc";
		
		if(pageNow == null || pageNow <1)
			pageNow =1;
		Integer prePage = pageNow==1 ? 1:pageNow-1;
		int count = blogService.count(hql, userid);
		Integer nextPage = 0;
		if(pageNow * rows == count)
			nextPage = pageNow;
		else if(pageNow * rows > count) {
			pageNow = count/rows+1;
			nextPage = pageNow;
		}
		else {
			nextPage = pageNow+1;
		}
		
		List<Blog> list = blogService.find(hql, pageNow, rows, userid);
		
		data.put("blogs", list);
		data.put("prePage", prePage);
		data.put("nextPage", nextPage);
		return "myBlogs";
	}
	
	
	@RequestMapping(value = "/blogsPage/{pageNow}")
	public String blogsPage(@PathVariable("pageNow") Integer pageNow, Map<String, Object> data) {
		String hql = "from Blog b order by b.blogid desc";
		if(pageNow == null || pageNow <1)
			pageNow =1;
		Integer prePage = pageNow==1 ? 1:pageNow-1;
		int count = blogService.count();
		Integer nextPage = 0;
		if(pageNow * rows == count)
			nextPage = pageNow;
		else if(pageNow * rows > count) {
			pageNow = count/rows+1;
			nextPage = pageNow;
		}
		else {
			nextPage = pageNow+1;
		}
		
		List<Blog> list = blogService.find(hql, pageNow, rows);
		
		data.put("blogs", list);
		data.put("prePage", prePage);
		data.put("nextPage", nextPage);
		return "blogs";
	}
	
	
	
	@RequestMapping(value = {"/blogDetail/{blogid}"})
	public String blogDetail(@PathVariable("blogid") Integer blogid, Map<String, Object> data) {
		Blog blog = blogService.find(blogid);
		data.put("blog", blog);
		return "blogDetail";
	}
	
	
	@RequestMapping(value = "/updateBlogPage/{blogid}")
	public String updateBlogPage(@PathVariable("blogid") Integer blogid, Map<String, Object> data) {
		Blog blog = blogService.find(blogid);
		data.put("blog", blog);
		return "updateBlog";
	}
	
	@RequestMapping(value = "/updateBlog")
	public String updateBlog(Blog blog, HttpSession session) {
		User user = (User)session.getAttribute("user");
		blog.setUser(user);
		blog.setDate(new Date());
		blogService.update(blog);
		return "redirect:/myBlogsPage/1";
	}
	
	@RequestMapping(value = "/deleteMyBlog/{blogid}")
	public String deleteBlog(@PathVariable("blogid") Integer blogid) {
		blogService.delete(blogid);
		return "redirect:/myBlogsPage/1";
	}
	
	
	

}

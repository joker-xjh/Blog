package test;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.Blog;
import model.User;
import service.BlogService;
import service.UserService;

public class BlogServiceImpTest {
	
	ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
	BlogService blogService = (BlogService) context.getBean("blogService");
	UserService userService = (UserService) context.getBean("userService");

	@Test
	public void testFindAll() {
		List<Blog> blogs = blogService.findAll();
		for(Blog blog:blogs)
			System.out.println(blog);
		System.out.println("ok");
	}

	@Test
	public void testSave() {
		User user = userService.find(1);
		System.out.println(user);
		Blog blog = new Blog();
		blog.setDate(new Date());
		blog.setContent("hahahaha");
		blog.setTitle("esgtrhtrhtrh");
		blog.setUser(user);
		user.getBlogs().add(blog);
		userService.save(user);
		blogService.save(blog);
		System.out.println("ok");
	}

	@Test
	public void testDeleteInteger() {
		blogService.delete(3);
		System.out.println("ok");
	}

	@Test
	public void testFindInteger() {
		Blog blog = blogService.find(1);
		System.out.println(blog);
	}

}

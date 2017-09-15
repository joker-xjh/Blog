package test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.User;
import service.UserService;

public class UserServiceImpTest {
	
	ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
	UserService service = (UserService) context.getBean("userService");

	@Test
	public void testCheckUsername() {
		String username = "kobe";
		boolean b = service.checkUsername(username);
		System.out.println(b);
	}

	@Test
	public void testCheckUsernameAndPassword() {
		User user = service.checkUsernameAndPassword("kobe", "kobe");
		System.out.println(user);
	}

	@Test
	public void testCount() {
		Integer count = service.count();
		System.out.println(count);
	}

	@Test
	public void testFindAll() {
		List<User> list = service.findAll();
		for(User user :list)
			System.out.println(user);
	}

	@Test
	public void testFindIntegerInteger() {
		fail("Not yet implemented");
	}

	@Test
	public void testSave() {
		User user = new User();
		user.setUsername("luffy");
		user.setPassword("luffy");
		user.setGrade(1);
		service.save(user);
		System.out.println("ok");
	}

	@Test
	public void testDeleteT() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteInteger() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindInteger() {
		fail("Not yet implemented");
	}

}

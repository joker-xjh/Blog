package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import model.User;
import service.UserService;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	//登陆页面
	@RequestMapping(value = {"/","/loginPage"})
	public String login() {
		return "login";
	}
	
	//注册页面
	@RequestMapping(value = "/registPage")
	public String regist() {
		return "regist";
	}
	
	//主页
	@RequestMapping(value = "/home")
	public String home(HttpSession session) {
		if(session.getAttribute("user") == null)
			return "login";
		return "home";
	}
	
	
	//注册处理
	@RequestMapping(value = "/regist",method = RequestMethod.POST)
	public ModelAndView doRegist(String username, String password) {
		ModelAndView modelAndView = new ModelAndView();
		if(username== null || username.length()==0 || password == null || password.length() ==0) {
			modelAndView.addObject("message", "用户名密码不能为空");
			modelAndView.setViewName("regist");
			return modelAndView;
		}
		boolean exists = userService.checkUsername(username);
		if(exists) {
			modelAndView.addObject("message", "用户名已经存在");
			modelAndView.setViewName("regist");
			return modelAndView;
		}
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		userService.save(user);
		modelAndView.addObject("message", "注册成功,请登录");
		modelAndView.setViewName("regist");
		return modelAndView;
	}
	
	//登陆处理
	@RequestMapping(value = "/login",method = RequestMethod.POST)
	public ModelAndView doLogin(String username, String password, HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		if(username== null || username.length()==0 || password == null || password.length() ==0) {
			modelAndView.addObject("message", "用户名密码不能为空");
			modelAndView.setViewName("login");
			return modelAndView;
		}
		User user = userService.checkUsernameAndPassword(username, password);
		if(user == null) {
			modelAndView.addObject("message", "用户名密码错误");
			modelAndView.setViewName("login");
			return modelAndView;
		}
		//判断是否为管理员
		if(user.getGrade()!=null  && user.getGrade() == 1) {
			session.setAttribute("admin", user);
		}
		else
			session.setAttribute("user", user);
		
		modelAndView.setViewName("home");
		return modelAndView;
	}
	
	
	
	

}

package com.ssm.qind.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssm.qind.base.ModuleConstance;
import com.ssm.qind.base.view.UserView;
import com.ssm.qind.bean.User;
import com.ssm.qind.dao.IUserDao;

@Controller
@RequestMapping("/user")
public class UserController {

	private Logger logger  =  Logger.getLogger(UserController. class );
	//定义当前模块
	private String curSpace = ModuleConstance.userView;
	
	@Autowired
	private IUserDao usermapper;

	@RequestMapping("/login")
	public String login(HttpServletRequest request, Model model) {
		
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		User user_login = usermapper.login(name, password);
		
		request.getSession().setAttribute("user", user_login);
		
		if (user_login == null) {
			logger.error("未登录或者登录失败，请重新登录!");
			return curSpace+UserView.loginView;
		} else {
			model.addAttribute("user", user_login);
			return curSpace+UserView.successView;
		}
	}

	@RequestMapping("/list")
	public String getAllUsers(Model model) {
		
		List<User> users = usermapper.getAllUsers();
		model.addAttribute("users", users);
		logger.info(users);
		return curSpace+UserView.listView;

	}
}

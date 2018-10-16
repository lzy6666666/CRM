package com.lzy.crm.web.action;

import com.lzy.crm.domain.User;
import com.lzy.crm.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<User>{
	//模型驱动
	
	private User user = new User();
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
	
	//注入userService
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * 用户注册
	 */
	public String regist(){
		System.out.println("userAction--------------"+user.toString());
		userService.regist(user);
		return LOGIN;
	} 
}

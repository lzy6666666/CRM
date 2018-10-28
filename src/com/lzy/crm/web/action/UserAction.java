package com.lzy.crm.web.action;

import org.apache.struts2.ServletActionContext;

import com.lzy.crm.domain.User;
import com.lzy.crm.service.UserService;
import com.opensymphony.xwork2.ActionContext;
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
	/**
	 * 用户登陆
	 */
	public String login(){
		
		User userlogin = userService.login(user);
		if(userlogin == null){
			this.addActionError("用户或者密码错误");
			return LOGIN;
		}else{
			
			/*ActionContext.getContext().getSession().put("userlogin", userlogin);*/
			ServletActionContext.getRequest().getSession().setAttribute("userlogin", userlogin);
			return SUCCESS;
		}
		
		
	}
}

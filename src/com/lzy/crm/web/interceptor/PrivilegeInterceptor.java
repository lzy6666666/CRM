package com.lzy.crm.web.interceptor;

import org.apache.struts2.ServletActionContext;

import com.lzy.crm.domain.User;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class PrivilegeInterceptor extends MethodFilterInterceptor {

	@Override
	protected String doIntercept(ActionInvocation arg0) throws Exception {
		User user = (User)ServletActionContext.getRequest().getSession().getAttribute("userlogin");
		if(user == null){
			System.out.println("user == null========================");
			ActionSupport actionSupport = (ActionSupport)arg0.getAction();
			actionSupport.addActionError("请先登陆");
			return "login";
		}else{
			System.out.println("user != null========================");
			 return arg0.invoke();
		}

	}

}

package com.lzy.crm.service.impl;

import org.springframework.transaction.annotation.Transactional;

import com.lzy.crm.dao.UserDao;
import com.lzy.crm.domain.User;
import com.lzy.crm.service.UserService;
import com.lzy.crm.utils.MD5Utils;
@Transactional
public class UserServiceImpl implements UserService {

	//注入DAO
	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void regist(User user) {
		System.out.println("userService=="+user.toString());
		user.setUser_password(MD5Utils.md5(user.getUser_password()));
		user.setUser_state("1");
		userDao.save(user);
		
	}

}

package com.lzy.crm.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.lzy.crm.dao.UserDao;
import com.lzy.crm.domain.User;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

	// 注册
	public void save(User user) {
		this.getHibernateTemplate().save(user);
	}

	// 登陆查询用户
	public User find(User user) {
		List<User> list = (List<User>) this.getHibernateTemplate()
				.find("from User where user_code=? and user_password=?", user.getUser_code(), user.getUser_password());
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}

}

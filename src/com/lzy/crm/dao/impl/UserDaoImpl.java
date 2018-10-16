package com.lzy.crm.dao.impl;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.lzy.crm.dao.UserDao;
import com.lzy.crm.domain.User;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao{

	public void save(User user) {
		this.getHibernateTemplate().save(user);
	}
	
}

package com.lzy.crm.dao;

import com.lzy.crm.domain.User;

public interface UserDao {

	void save(User user);

	User find(User user);

}

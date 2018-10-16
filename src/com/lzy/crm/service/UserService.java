package com.lzy.crm.service;

import com.lzy.crm.domain.User;

public interface UserService {

	void regist(User user);

	User login(User user);


}

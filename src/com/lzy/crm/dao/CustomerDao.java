package com.lzy.crm.dao;

import com.lzy.crm.domain.Customer;

/*
 * Customer的dao接口
 */
public interface CustomerDao {
	/**
	 * 客户保存
	 * @param customer
	 */
	void save(Customer customer);
	
}

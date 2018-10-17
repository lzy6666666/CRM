package com.lzy.crm.service;

import com.lzy.crm.domain.Customer;

/**
 * customer的service接口
 * @author Administrator
 *
 */
public interface CustomerService {
	/**
	 * 客户保存
	 * @param customer
	 */
	void save(Customer customer);

}

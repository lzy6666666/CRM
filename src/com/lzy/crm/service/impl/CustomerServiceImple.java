package com.lzy.crm.service.impl;

import org.springframework.transaction.annotation.Transactional;

import com.lzy.crm.dao.CustomerDao;
import com.lzy.crm.domain.Customer;
import com.lzy.crm.service.CustomerService;
/**
 * Customer的service实现类
 * @author Administrator
 *
 */

@Transactional
public class CustomerServiceImple implements CustomerService{
	//注入dao层
	private CustomerDao customerDao;
	
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}
	/**
	 * 客户保存
	 */
	public void save(Customer customer) {
		
		customerDao.save(customer);
	}

}

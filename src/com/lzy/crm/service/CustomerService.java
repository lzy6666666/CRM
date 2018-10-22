package com.lzy.crm.service;

import org.hibernate.criterion.DetachedCriteria;

import com.lzy.crm.domain.Customer;
import com.lzy.crm.domain.PageBean;

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
	PageBean<Customer> findBayPage(DetachedCriteria detachedCriteria, Integer currPage, Integer pageSize);

}

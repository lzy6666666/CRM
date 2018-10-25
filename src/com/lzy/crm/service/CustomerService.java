package com.lzy.crm.service;

import java.util.List;

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
	Customer findById(Integer cust_id);
	void deleteById(Customer customerSigle);
	void update(Customer customer);//客户数据更新
	List<Customer> findAll();//查询所有客户

}

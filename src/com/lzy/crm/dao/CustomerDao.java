package com.lzy.crm.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

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
	/**
	 *客户数据总量查询接口
	 * @param detachedCriteria
	 * @return
	 */
	Integer findCount(DetachedCriteria detachedCriteria);
	/**
	 * 客户数据分页查询接口
	 * @param currPage
	 * @param pageSize
	 * @return
	 */
	List<Customer> findByPage(DetachedCriteria detachedCriteria,Integer currPage, Integer pageSize);
	
}

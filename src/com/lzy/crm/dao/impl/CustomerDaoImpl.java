package com.lzy.crm.dao.impl;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.lzy.crm.dao.CustomerDao;
import com.lzy.crm.domain.Customer;
/**
 * Customer的dao的实现类
 * @author Administrator
 *
 */
public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao {
	
	/**
	 * 客户保存
	 */
	public void save(Customer customer) {
		this.getHibernateTemplate().save(customer);
		
	}

}

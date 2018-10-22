package com.lzy.crm.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
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
	/**
	 * 客户总数量查询
	 */
	public Integer findCount(DetachedCriteria detachedCriteria) {
		// TODO Auto-generated method stub
		detachedCriteria.setProjection(Projections.rowCount());
		List<Long> list = (List<Long>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
		if(list.size()>0){
			return list.get(0).intValue();
		}
		return null;
	}
	/**
	 * 客户分页查询
	 */
	public List<Customer> findByPage(DetachedCriteria detachedCriteria,Integer currPage, Integer pageSize) {
		detachedCriteria.setProjection(null);//条件清空
		List<Customer> list = (List<Customer>) this.getHibernateTemplate().findByCriteria(detachedCriteria,currPage,pageSize);
		return list;
	}
	/**
	 * 根据ID查询客户
	 */
	public Customer findById(Integer cust_id) {
		// TODO Auto-generated method stub
		Customer customer = this.getHibernateTemplate().get(Customer.class, cust_id);
		return customer;
	}
	/**
	 * 根据ID删除客户
	 */
	public void deleteById(Customer customerSigle) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(customerSigle);
		
	}
	/**
	 * 客户数据更新
	 */
	public void update(Customer customer) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(customer);
	}

}

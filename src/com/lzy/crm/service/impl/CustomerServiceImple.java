package com.lzy.crm.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import com.lzy.crm.dao.CustomerDao;
import com.lzy.crm.domain.Customer;
import com.lzy.crm.domain.PageBean;
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
	/**
	 * 分页查询客户
	 */
	public PageBean<Customer> findBayPage(DetachedCriteria detachedCriteria, Integer currPage, Integer pageSize) {
		// TODO Auto-generated method stub
		//将查询参数封装到PageBean
		PageBean<Customer> pageBean = new PageBean<Customer>();
		pageBean.setCurrPage(currPage);
		pageBean.setPageSize(pageSize);
		//获得数据总数量
		Integer totalCount = customerDao.findCount(detachedCriteria);
		pageBean.setTotalCount(totalCount);
		//计算数据总的页数
		//Math.ceil的向上取整
		Double tc = totalCount.doubleValue();
		Double ceil = Math.ceil(tc/pageSize);
		pageBean.setTotalPage(ceil.intValue());
		//根据分页的参数查询客户信息set到PageBean
		//查询数据从哪一行开始
		Integer row = (currPage-1)*pageSize;
		List<Customer> customers = customerDao.findByPage(detachedCriteria,row,pageSize);
		pageBean.setList(customers);
		return pageBean;
	}
	/**
	 * 删除前的查询
	 */
	public Customer findById(Integer cust_id) {
		// TODO Auto-generated method stub
		Customer customer = customerDao.findById(cust_id);
		return customer;
	}
	/**
	 * 客户删除
	 */
	public void deleteById(Customer customerSigle) {
		// TODO Auto-generated method stub
		customerDao.deleteById(customerSigle);
		
	}
	/**
	 * 客户数据更新
	 */
	public void update(Customer customer) {
		customerDao.update(customer);
		
	}
	/**
	 * 查询所有客户
	 */
	public List<Customer> findAll() {
		// TODO Auto-generated method stub
		List<Customer> customers = customerDao.findAll();
		return customers;
	}

}

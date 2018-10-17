package com.lzy.crm.web.action;

import com.lzy.crm.domain.Customer;
import com.lzy.crm.service.CustomerService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * Customer的action类
 * @author Administrator
 *
 */
public class CustomerAction extends ActionSupport implements ModelDriven<Customer>{

	//客户实体模型
	private Customer customer = new Customer();
	public Customer getModel() {
		// TODO Auto-generated method stub
		return customer;
	}
	//注入service
	private CustomerService customerService;
	

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}


	/**
	 * 客户保存
	 * @return
	 */
	public String save(){
		
		customerService.save(customer);
		return null;
	}

}

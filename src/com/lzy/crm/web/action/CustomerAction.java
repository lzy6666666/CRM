package com.lzy.crm.web.action;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.aspectj.apache.bcel.classfile.Field;
import org.hibernate.criterion.DetachedCriteria;

import com.lzy.crm.domain.Customer;
import com.lzy.crm.domain.PageBean;
import com.lzy.crm.service.CustomerService;
import com.lzy.crm.utils.UploadUtil;
import com.opensymphony.xwork2.ActionContext;
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
	//Struts文件上传拦截器中的三个属性值
	private String uploadFileName;
	private File   upload;
	private String uploadContentType;
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	//保存
	public String save() throws IOException{
		//文件上传
		if(upload != null){
			//路径
			String path = "E:/crm";
			//随机文件名
			String uuidName = UploadUtil.getFileName(uploadFileName);	
			System.out.println("uuid名字"+uuidName);
			//目录分离
			String drictry = UploadUtil.getPath(uuidName);
			System.out.println(drictry);
			String url = path+drictry;//创建最终路径
			System.out.println("最终路径"+url);
			File file = new File(url);
			//判断目录是否存在
			if(!file.exists()){
				file.mkdirs();
			}
			//文件上传
			File destDir = new File(url+"/"+uuidName);
			System.out.println(destDir);
			FileUtils.copyFile(upload, destDir);
			customer.setCust_img(url+"/"+uuidName);
		}
		
		
		//保存客户信息
		customerService.save(customer);
		return "customerSave";
	}
	/**
	 * 
	 * 客户查询
	 */
	//模型只能一个，所以分页的参数需要通过其他的方式传递
	private Integer currPage = 1 ;//当前页
	private Integer pageSize = 3 ;
	public void setCurrPage(Integer currPage) {
		if(currPage == null){
			currPage = 1;
		}
		this.currPage = currPage;
	}
	
	public void setPageSize(Integer pageSize) {
		if(pageSize == null){
			currPage = 3;
		}
		this.pageSize = pageSize;
	}
	public String find(){
		//接受分页的参数
		//离线条件检索
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Customer.class);//封装sql里面的customer参数到detachedCriteria
		PageBean<Customer> pageBean = customerService.findBayPage(detachedCriteria,currPage,pageSize); 
		ActionContext.getContext().getValueStack().push(pageBean);
		return "find";
	}
	
	/**
	 * 客户的删除
	 */
	public String delete(){
		Customer customerSigle =  customerService.findById(customer.getCust_id());
		//删除本地的图片
		if(customerSigle.getCust_img() != null){
			File file = new File(customerSigle.getCust_img());
			if(file.exists()){
				file.delete();	
			}			
		}
		customerService.deleteById(customerSigle);
		return"customer_delete";
	}
}

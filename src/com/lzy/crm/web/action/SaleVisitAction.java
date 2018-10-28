package com.lzy.crm.web.action;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;

import com.lzy.crm.domain.PageBean;
import com.lzy.crm.domain.SaleVisit;
import com.lzy.crm.service.SaleVisitService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * Salevisit的action
 * @author Administrator
 *
 */
public class SaleVisitAction extends ActionSupport implements ModelDriven<SaleVisit>{
	private SaleVisit saleVisit = new SaleVisit();
	public SaleVisit getModel() {
		// TODO Auto-generated method stub
		return saleVisit;
	}
	
	//注入servise层
	@Resource(name="saleVisitService")
	private SaleVisitService saleVisitService;
	//分页参数
	private Integer currPage = 1;
	private Integer pageSize = 3;

	public void setCurrPage(Integer currPage) {
		if(currPage == null){
			currPage = 1;
		}
		this.currPage = currPage;
	}

	public void setPageSize(Integer pageSize) {
		if(pageSize == null){
			pageSize =3;
			
		}
		this.pageSize = pageSize;
	}


	/**
	 * 查询所有拜访记录列表
	 */
	public String findAll(){
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(SaleVisit.class);
		//设置页面参数
		
		//调用业务层
	System.out.println(currPage+"===================="+pageSize+"===================="+saleVisitService);
	PageBean<SaleVisit> pageBean  =	saleVisitService.findAll(detachedCriteria,currPage,pageSize);
	ActionContext.getContext().getValueStack().push(pageBean);	
		return "findAll";
	}
	/**
	 * 客户拜访记录回显
	 */
	public String edit(){
		
		
		return "edit";
	}
	
}

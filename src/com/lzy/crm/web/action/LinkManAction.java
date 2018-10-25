package com.lzy.crm.web.action;

import org.hibernate.criterion.DetachedCriteria;

import com.lzy.crm.dao.LinkManDao;
import com.lzy.crm.domain.LinkMan;
import com.lzy.crm.domain.PageBean;
import com.lzy.crm.service.LinkManService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 联系人的action
 * @author Administrator
 *
 */
public class LinkManAction extends ActionSupport implements ModelDriven<LinkMan>{
	
	private LinkMan linkMan = new LinkMan();
	public LinkMan getModel() {
		// TODO Auto-generated method stub
		return linkMan;
	}
	//注入linkManService
	private LinkManService linkManService;
	public void setLinkManService(LinkManService linkManService) {
		this.linkManService = linkManService;
	}

	//条件带分页查询
	private Integer currPage = 1;//当前页
	private Integer pageSize =3;//显示行数
	public void setCurrPage(Integer currPage) {
		
		if(currPage == null){
			currPage =1;
			
		}
		this.currPage = currPage;
	}
	public void setPageSize(Integer pageSize) {
		if(pageSize == null){
			pageSize=3;
		}
		this.pageSize = pageSize;
	}
	// 条件带分页查询
	public String find(){
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(LinkMan.class);
		PageBean<LinkMan> pageBean = linkManService.find(detachedCriteria,currPage,pageSize);
		System.out.println(pageBean.getList().get(0).toString());
		ActionContext.getContext().getValueStack().push(pageBean);
		return "find";
	}
	
	/**
	 * 联系人删除
	 */
	public String delete(){
		//显查询再删除
		linkMan =  linkManService.findById(linkMan.getLkm_id());
		linkManService.delete(linkMan);
		return "delete";
	}
	
}

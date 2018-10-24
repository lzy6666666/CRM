package com.lzy.crm.web.action;

import com.lzy.crm.domain.LinkMan;
import com.lzy.crm.service.LinkManService;
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


	public String find(){
		
		
		return "find";
	}
	
	
}

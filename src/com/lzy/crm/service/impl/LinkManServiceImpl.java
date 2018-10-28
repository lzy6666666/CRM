package com.lzy.crm.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import com.lzy.crm.dao.LinkManDao;
import com.lzy.crm.domain.LinkMan;
import com.lzy.crm.domain.PageBean;
import com.lzy.crm.service.LinkManService;

@Transactional
public class LinkManServiceImpl implements LinkManService {
	
	//LinkManDao注入
	private LinkManDao linkManDao;
	public void setLinkManDao(LinkManDao linkManDao) {
		this.linkManDao = linkManDao;
	}
	/**
	 * 条件带分页查询
	 */
	public PageBean<LinkMan> find(DetachedCriteria detachedCriteria, Integer currPage, Integer pageSize) {
		// TODO Auto-generated method stub
		PageBean<LinkMan> pageBean = new PageBean<LinkMan>();
		pageBean.setCurrPage(currPage);
		pageBean.setPageSize(pageSize);
		//总数量
		Integer totalCount = linkManDao.findCount(detachedCriteria);
		
		//总页数
		Double countD = totalCount.doubleValue();
		Double totalPageD = Math.ceil(countD/pageSize);
		Integer totalPage = totalPageD.intValue();
		
		pageBean.setTotalCount(totalCount);
		pageBean.setTotalPage(totalPage);
		
		//查询的初始位置
		Integer row = (currPage-1)*pageSize;
		
		//查询联系人，并封装入pageBean
		List<LinkMan>  linkMans =  linkManDao.findAll(detachedCriteria,row,pageSize);
		pageBean.setList(linkMans);
			
		return pageBean;
	}
	/**
	 * 根据id查询
	 */
	public LinkMan findById(Integer lkm_id) {
		// TODO Auto-generated method stub
		LinkMan linkMan = linkManDao.findById(lkm_id);
		return linkMan;
	}
	/**
	 * 根据查询结果，删除联系人
	 */
	public void delete(LinkMan linkMan) {
		// TODO Auto-generated method stub
		linkManDao.delete(linkMan);
	}
	/**
	 * 跟新联系人数据
	 */
	public void update(LinkMan linkMan) {
		// TODO Auto-generated method stub
		linkManDao.update(linkMan);
	}
	/**
	 * 保存联系人
	 */
	public void save(LinkMan linkMan) {
		linkManDao.save(linkMan);
		
	}
	
	
}

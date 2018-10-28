package com.lzy.crm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import com.lzy.crm.dao.SaleVisitDao;
import com.lzy.crm.domain.BaseDict;
import com.lzy.crm.domain.PageBean;
import com.lzy.crm.domain.SaleVisit;
import com.lzy.crm.service.BaseDictService;
import com.lzy.crm.service.SaleVisitService;
/**
 * SaleVisitservice实现类
 * @author Administrator
 *
 */
@Transactional
public class SaleVisitServiceImpl implements SaleVisitService {
	//注入salevisitDao层
	
	@Resource(name="saleVisitDao")
	private SaleVisitDao saleVisitDao;
	
	
	//条件带分页查询
	public PageBean<SaleVisit> findAll(DetachedCriteria detachedCriteria, Integer currPage, Integer pageSize) {
		// TODO Auto-generated method stub
		System.out.println(saleVisitDao+"====================");
		PageBean<SaleVisit> pageBean = new PageBean<SaleVisit>();
		pageBean.setCurrPage(currPage);
		pageBean.setPageSize(pageSize);
		//获取总数量
		Integer  totalCount =saleVisitDao.findCount(detachedCriteria);
		System.out.println(totalCount+"=====================");
		//获取总页数
		Double totalCountD = totalCount.doubleValue();
		Double totalPage = Math.ceil(totalCountD/pageSize);
		//从哪个位置开始查询
		Integer begin = (currPage-1)*pageSize;
		//分页查询
		List<SaleVisit> list = saleVisitDao.findByPage(detachedCriteria, begin, pageSize);
		System.out.println(list.size()+"=====================");
		pageBean.setTotalCount(totalCount);
		pageBean.setTotalPage(totalPage.intValue());
		pageBean.setList(list);
		
		return pageBean;
	}

}

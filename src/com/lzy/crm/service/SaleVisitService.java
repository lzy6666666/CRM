package com.lzy.crm.service;

import org.hibernate.criterion.DetachedCriteria;

import com.lzy.crm.domain.PageBean;
import com.lzy.crm.domain.SaleVisit;

/**
 * salevisit的业务层接口
 * @author Administrator
 *
 */
public interface SaleVisitService {
	//条件带分页查询
	PageBean<SaleVisit> findAll(DetachedCriteria detachedCriteria, Integer currPage, Integer pageSize);

}

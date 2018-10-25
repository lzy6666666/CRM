package com.lzy.crm.service;

import org.hibernate.criterion.DetachedCriteria;

import com.lzy.crm.domain.LinkMan;
import com.lzy.crm.domain.PageBean;

public interface LinkManService {
	//条件带分页查询
	PageBean<LinkMan> find(DetachedCriteria detachedCriteria, Integer currPage, Integer pageSize);
	//根据id查询
	LinkMan findById(Integer lkm_id);
	//根据对象删除联系人
	void delete(LinkMan linkMan);
}

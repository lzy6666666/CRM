package com.lzy.crm.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.lzy.crm.domain.LinkMan;

public interface LinkManDao {
	
	Integer findCount(DetachedCriteria detachedCriteria);//查询总的条数

	List<LinkMan> findAll(DetachedCriteria detachedCriteria, Integer currPage, Integer pageSize);//查询所有联系人

	LinkMan findById(Integer lkm_id);//根据id查询
	
	void delete(LinkMan linkMan);//根据对象删除联系人

	void update(LinkMan linkMan);//跟新联系人数据
}

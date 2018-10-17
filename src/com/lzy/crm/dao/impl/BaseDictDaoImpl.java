package com.lzy.crm.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.lzy.crm.dao.BaseDictDao;
import com.lzy.crm.domain.BaseDict;
/**
 * 
 * basedict的dao现实类
 * @author Administrator
 *
 */
public class BaseDictDaoImpl extends HibernateDaoSupport implements BaseDictDao  {

	public List<BaseDict> findByTypecode(String dict_type_code) {
		List<BaseDict> list = (List<BaseDict>) this.getHibernateTemplate().find("form BaseDict where dict_type_code=?", dict_type_code);
		return list;
	}

}

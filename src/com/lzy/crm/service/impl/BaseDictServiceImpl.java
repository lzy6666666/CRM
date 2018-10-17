package com.lzy.crm.service.impl;

import java.util.List;

import com.lzy.crm.dao.BaseDictDao;
import com.lzy.crm.domain.BaseDict;
import com.lzy.crm.service.BaseDictService;
/**
 * BaseDict的service实现类
 * @author Administrator
 *
 */
public class BaseDictServiceImpl implements BaseDictService {
	//注入baseDict的Dao
	private BaseDictDao baseDictDao;
	public void setBaseDictDao(BaseDictDao baseDictDao) {
		this.baseDictDao = baseDictDao;
	}


	public List<BaseDict> findByTypecode(String dict_type_code) {
		
		return baseDictDao.findByTypecode(dict_type_code);
		
	}

}

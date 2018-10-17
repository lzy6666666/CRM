package com.lzy.crm.dao;

import java.util.List;

import com.lzy.crm.domain.BaseDict;

/**
 * basedict的dao接口
 * @author Administrator
 *
 */
public interface BaseDictDao {
	List<BaseDict> findByTypecode(String dict_type_code);
}

package com.lzy.crm.service;

import java.util.List;

import com.lzy.crm.domain.BaseDict;

/**
 * 字典的service接口
 * @author Administrator
 *
 */
public interface BaseDictService {

	List<BaseDict> findByTypecode(String dict_type_code);

}

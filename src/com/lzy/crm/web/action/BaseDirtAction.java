package com.lzy.crm.web.action;

import java.util.List;

import com.lzy.crm.domain.BaseDict;
import com.lzy.crm.service.BaseDictService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 字典的action类
 * @author Administrator
 *
 */
public class BaseDirtAction extends ActionSupport implements ModelDriven<BaseDict>{
	//baseDict的模型
	private BaseDict baseDict = new BaseDict();
	public BaseDict getModel() {
		// TODO Auto-generated method stub
		return baseDict;
	}
	
	//注入baseDrict的service
	private BaseDictService baseDictService;
	public void setBaseDictService(BaseDictService baseDictService) {
		this.baseDictService = baseDictService;
	}


	/**
	 * 查询并返回字典到页面
	 * @return
	 */
	public String getBaseDict(){
		
		List<BaseDict> list = baseDictService.findByTypecode(baseDict.getDict_type_code());
		return NONE;
	}

}

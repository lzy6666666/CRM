package com.lzy.crm.web.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.lzy.crm.domain.BaseDict;
import com.lzy.crm.service.BaseDictService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

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
		for (BaseDict baseDict : list) {
			System.out.println(baseDict.toString());
		}
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes(new String[]{"dict_sort","dict_enable","dict_memo"});//这些属性不转json
		JSONArray jsonArray = JSONArray.fromObject(list, jsonConfig);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		try {
			response.getWriter().println(jsonArray);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return NONE;
	}

}

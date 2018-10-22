package com.lzy.crm.utils;

import java.io.File;
import java.util.UUID;

import org.aspectj.apache.bcel.classfile.Field;

/**
 * 文件上传工具类
 * @author Administrator
 *
 */
public class UploadUtil {
	/**
	 * 获取文件名
	 * @param FileName
	 * @return
	 */
	public static String getFileName(String FileName){
		int index = FileName.lastIndexOf(".");
		String extion = FileName.substring(index);
		String uuidName = UUID.randomUUID().toString().replace("-", "");
		String newFileName = uuidName+extion;
		return newFileName;	
	}
	/**
	 * 目录分离
	 */
	public static String getPath(String newFileName){
		
		int codl = newFileName.hashCode();
		int cd1 = codl & 0xf;//一级目录
		int cd = codl>>>4;
		int cd2  = cd & 0xf;//二级目录
		return "/"+cd1+"/"+cd2;
		
		
	}

}

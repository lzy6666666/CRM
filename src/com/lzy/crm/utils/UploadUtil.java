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
		String NewFileName = uuidName+extion;
		return NewFileName;	
	}
	/**
	 * 目录分离
	 */
	public static String getPath(String uuidName){
		
		int codl = uuidName.hashCode();
		int cdl = codl & 0xf;//一级目录
		int cd = cdl >>>4;
		int d  = cd & 0xf;//二级目录
		return "/"+cd+"/"+d;
		
		
	}

}

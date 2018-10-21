package com.lzy.crm.domain;

import java.util.List;

/**
 * 分页查询的参数
 * @author Administrator
 *
 */
public class PageBean<T> {
	private Integer currPage;//当前页
	private Integer pageSize;//显示行数
	private Integer totalCount;//总的数据量
	private Integer totalPage;//总的页数
	private List<T> list;//查询的客户数据
	public Integer getCurrPage() {
		return currPage;
	}
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}
	public Integer getPagrSize() {
		return pageSize;
	}
	public void setPagrSize(Integer pagrSize) {
		this.pageSize = pagrSize;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "PageBean [currPage=" + currPage + ", pagrSize=" + pageSize + ", totalCount=" + totalCount
				+ ", totalPage=" + totalPage + ", list=" + list + "]";
	}
	
	
}

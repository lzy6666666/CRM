package com.lzy.crm.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Customer的实体类
 * @author Administrator
 *
 */
public class Customer {

		private Integer cust_id;
		private String cust_name;
/*		private String cust_source;
		private String cust_industry;
		private String cust_level;*/
		private String cust_phone;
		private String cust_mobile;
		private String cust_img;//图片地址 
		/**
		 * 在一的一方配置多的一方的对象
		 * @return
		 */
		private BaseDict baseDictSource;
		private BaseDict baseDictIndustry;
		private BaseDict baseDictLevel;
		//在一的一方放置多的集合
		private Set<LinkMan> linkMans = new HashSet<LinkMan>();
				
		public Set<LinkMan> getLinkMans() {
			return linkMans;
		}
		public void setLinkMans(Set<LinkMan> linkMans) {
			this.linkMans = linkMans;
		}
		public Integer getCust_id() {
			return cust_id;
		}
		public void setCust_id(Integer cust_id) {
			this.cust_id = cust_id;
		}
		public String getCust_name() {
			return cust_name;
		}
		public void setCust_name(String cust_name) {
			this.cust_name = cust_name;
		}
		public String getCust_phone() {
			return cust_phone;
		}
		public void setCust_phone(String cust_phone) {
			this.cust_phone = cust_phone;
		}
		public String getCust_mobile() {
			return cust_mobile;
		}
		public void setCust_mobile(String cust_mobile) {
			this.cust_mobile = cust_mobile;
		}
		public String getCust_img() {
			return cust_img;
		}
		public void setCust_img(String cust_img) {
			this.cust_img = cust_img;
		}
		public BaseDict getBaseDictSource() {
			return baseDictSource;
		}
		public void setBaseDictSource(BaseDict baseDictSource) {
			this.baseDictSource = baseDictSource;
		}
		public BaseDict getBaseDictIndustry() {
			return baseDictIndustry;
		}
		public void setBaseDictIndustry(BaseDict baseDictIndustry) {
			this.baseDictIndustry = baseDictIndustry;
		}
		public BaseDict getBaseDictLevel() {
			return baseDictLevel;
		}
		public void setBaseDictLevel(BaseDict baseDictLevel) {
			this.baseDictLevel = baseDictLevel;
		}
		@Override
		public String toString() {
			return "Customer [cust_id=" + cust_id + ", cust_name=" + cust_name + ", cust_phone=" + cust_phone
					+ ", cust_mobile=" + cust_mobile + ", cust_img=" + cust_img + "]";
		}

		
}

package com.lzy.crm.dao.impl;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.lzy.crm.dao.LinkManDao;
import com.lzy.crm.domain.LinkMan;
/**
 * 联系人Dao的实现类
 * @author Administrator
 *
 */
public class LinkManDaoImpl extends HibernateDaoSupport implements LinkManDao  {

	//联系人数量查询
	public Integer findCount(DetachedCriteria detachedCriteria) {
		
		detachedCriteria.setProjection(Projections.rowCount());
		List<Long> list = (List<Long>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
		if(list.size()>0){
			
			return list.get(0).intValue();
		}
		return null;
	}
	/**
	 * 查询所有联系人
	 */
	public List<LinkMan> findAll(DetachedCriteria detachedCriteria, Integer currPage, Integer pageSize) {
		// TODO Auto-generated method stub
		detachedCriteria.setProjection(null);
		List<LinkMan> list = (List<LinkMan>) this.getHibernateTemplate().findByCriteria(detachedCriteria,currPage,pageSize);
		
		return list;
	}
	/**
	 * 根据id查询
	 */
	public LinkMan findById(Integer lkm_id) {
		// TODO Auto-generated method stub
		LinkMan linkMan = this.getHibernateTemplate().get(LinkMan.class,lkm_id);
		return linkMan;
	}
	/**
	 * 根据对象删除联系人
	 */
	public void delete(LinkMan linkMan) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(linkMan);
	}

}

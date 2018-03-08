package com.gtlk.dao.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


import com.gtlk.dao.prototype.IGenericDao;
import com.sram.util.pager.PagerModel;
import com.sram.util.system.SystemContext;

public abstract class GenericDaoImpl<T, T_OID extends Serializable> extends
		HibernateDaoSupport implements IGenericDao<T, T_OID> {

	private Class<T> type;
	//private TrainMonitorInfo trainMonitorInfo;

	// -- 构�?函数
	@SuppressWarnings("unchecked")
	public GenericDaoImpl(String type) {
		try {
			this.type = (Class<T>) Class.forName(type);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("hello2");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		return getHibernateTemplate().find(
				"from " + this.type.getName());
	}

	@Override
	//@SuppressWarnings("unchecked")
	public T findById(T_OID id) {
		return (T) getHibernateTemplate().get(type, id);
	}

	@Override
	@SuppressWarnings("unchecked")
	public T_OID save(T entity) {
		return (T_OID) getHibernateTemplate().save(entity);
	}

	@Override
	public void modify(T entity) {
		getHibernateTemplate().update(entity);
	}

	@Override
	public void remove(T entity) {
		System.out.println(entity);
		getHibernateTemplate().delete(entity);
		System.out.println("chenggong");
	}

	@Override
	//@SuppressWarnings("unchecked")
	public void removeAll() {
		List<T> list = getHibernateTemplate().loadAll(type);
		getHibernateTemplate().deleteAll(list);
	}

	@Override
	public void removeAll(Collection<T> entities) {
		getHibernateTemplate().deleteAll(entities);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public PagerModel findPaginated(String hql, Object[] params, int offset,
			int pageSize) {
		// -- 查询总记录数
		String countHQL = getCountHQL(hql);
		Query query = getSession().createQuery(countHQL);
		if (query != null && params != null && params.length > 0) {
			for (int i = 0; i < params.length; i++) {
				query.setParameter(i, params[i]);
			}
		}
		int total = ((Long) query.uniqueResult()).intValue();
		// -- 查询数据列表
		query = getSession().createQuery(hql);
		if (query != null && params != null && params.length > 0) {
			for (int i = 0; i < params.length; i++) {
				query.setParameter(i, params[i]);
			}
		}
		query.setFirstResult(offset);
		query.setMaxResults(pageSize);
		List datas = query.list();

		PagerModel pm = new PagerModel();
		pm.setTotal(total);
		pm.setDatas(datas);
		return pm;
	}

	private String getCountHQL(String hql) {
		int index = hql.indexOf("from");
		if (index != -1)
			return "select count(*) " + hql.substring(index);
		throw new RuntimeException("不合法的HQL语句");
	}

	@Override
	public PagerModel findPaginated(String hql) {
		return findPaginated(hql, null, SystemContext.getOffset(),
				SystemContext.getPagesize());
	}

	@Override
	public PagerModel findPaginated(String hql, Object param) {
		return findPaginated(hql, new Object[] { param },
				SystemContext.getOffset(), SystemContext.getPagesize());
	}

	@Override
	public PagerModel findPaginated(String hql, Object[] params) {
		return findPaginated(hql, params, SystemContext.getOffset(),
				SystemContext.getPagesize());
	}

	@Override
	public abstract PagerModel pageFind();

	@Override
	public abstract PagerModel pageFind(Object param);

	@Override
	public abstract PagerModel pageFind(Object[] params);
}

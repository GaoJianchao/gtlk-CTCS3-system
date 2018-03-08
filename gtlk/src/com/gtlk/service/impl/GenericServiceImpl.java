package com.gtlk.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import com.gtlk.dao.prototype.IGenericDao;
import com.gtlk.service.prototype.IGenericService;
import com.sram.util.pager.PagerModel;

public class GenericServiceImpl<T, T_OID extends Serializable> implements
		IGenericService<T, T_OID> {

	private IGenericDao<T, T_OID> dao;

	public void setDao(IGenericDao<T, T_OID> dao) {
		this.dao = dao;
	}

	public IGenericDao<T, T_OID> getDao() {
		return dao;
	}

	@Override
	public List<T> findAll() {
		return dao.findAll();
	}

	@Override
	public T findById(T_OID id) {
		return dao.findById(id);
	}

	@Override
	public PagerModel findPaginated(String hql) {
		return dao.findPaginated(hql);
	}

	@Override
	public PagerModel findPaginated(String hql, Object param) {
		return dao.findPaginated(hql, param);
	}

	@Override
	public PagerModel findPaginated(String hql, Object[] params) {
		return dao.findPaginated(hql, params);
	}

	@Override
	public PagerModel findPaginated(String hql, Object[] params, int offset,
			int pageSize) {
		return dao.findPaginated(hql, params, offset, pageSize);
	}

	@Override
	public PagerModel pageFind() {
		return dao.pageFind();
	}

	@Override
	public PagerModel pageFind(Object param) {
		return dao.pageFind(param);
	}

	@Override
	public PagerModel pageFind(Object[] params) {
		return dao.pageFind(params);
	}

	@Override
	public void modify(T entity) {
		dao.modify(entity);
	}

	@Override
	public void remove(T entity) {
		dao.remove(entity);
	}

	@Override
	public void removeAll() {
		dao.removeAll();
	}

	@Override
	public void removeAll(Collection<T> entities) {
		dao.removeAll(entities);
	}

	@Override
	public T_OID save(T entity) {
		return dao.save(entity);
	}

}

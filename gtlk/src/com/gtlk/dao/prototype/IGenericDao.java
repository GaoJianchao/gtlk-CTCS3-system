package com.gtlk.dao.prototype;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import com.sram.util.pager.PagerModel;

/**
 * 通用Dao接口设计
 * 
 * @author RanJi
 * @since 2011-6-7 pm
 * @version jdk1.6.21
 */
public interface IGenericDao<T, T_OID extends Serializable> {
	/**
	 * 保存实体
	 * 
	 * @param entity
	 * @return 保存后得到的实体的oid
	 */
	public T_OID save(T entity);

	/**
	 * 删除实体
	 * 
	 * @param entity
	 *            实体
	 */
	public void remove(T entity);

	/**
	 * 删除全部实体
	 */
	public void removeAll();

	/**
	 * 删除实体集合
	 * 
	 * @param entities
	 *            实体集合
	 */
	public void removeAll(Collection<T> entities);

	/**
	 * 修改实体
	 * 
	 * @param entity
	 *            实体
	 */
	public void modify(T entity);

	/**
	 * 根据OID查询实体
	 * 
	 * @param id
	 * @return 查找到的实体
	 */
	public T findById(T_OID id);

	/**
	 * 查询全部
	 * 
	 * @return
	 */
	public List<T> findAll();

	/**
	 * 分页查找
	 * 
	 * @param hql
	 *            HQL语句
	 * @return 页面模型
	 */
	public PagerModel findPaginated(String hql);

	/**
	 * 分页查找
	 * 
	 * @param hql
	 *            HQL语句
	 * @param param
	 *            HQL语句的参�?
	 * @return
	 */
	public PagerModel findPaginated(String hql, Object param);

	/**
	 * 根据HQL语言进行分页查询
	 * 
	 * @param hql
	 *            HQL语句
	 * @param params
	 *            HQL语句的参�?
	 * @return
	 */
	public PagerModel findPaginated(String hql, Object[] params);

	/**
	 * 根据HQL语言进行分页查询
	 * 
	 * @param hql
	 *            HQL语句
	 * @param params
	 *            HQL语句的参�?
	 * @return
	 */
	public PagerModel findPaginated(String hql, Object[] params, int offset,
			int pageSize);

	/**
	 * 以下三个方法要实际的业务重写来实现分页查找的方法
	 * 
	 * @return
	 */
	public PagerModel pageFind();

	public PagerModel pageFind(Object param);

	public PagerModel pageFind(Object[] params);

}
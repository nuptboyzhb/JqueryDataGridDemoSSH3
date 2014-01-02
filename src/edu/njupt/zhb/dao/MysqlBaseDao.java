/*
 * $filename: MysqlBaseDao.java,v $
 * $Date: 2013-11-27  $
 * Copyright (C) ZhengHaibo, Inc. All rights reserved.
 * This software is Made by Zhenghaibo.
 */
package edu.njupt.zhb.dao;
/*
 *@author: ZhengHaibo  
 *web:     http://blog.csdn.net/nuptboyzhb
 *mail:    zhb931706659@126.com
 *2013-11-27  Nanjing,njupt,China
 */
import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class MysqlBaseDao extends HibernateDaoSupport implements BaseDao{
	/**
	 * 保存
	 * 
	 * @example save(user)
	 * @param o
	 * @return
	 */
	@Override
	public Serializable save(Object o) throws Exception {
		return this.getSessionFactory().getCurrentSession().save(o);
	}
	
	/**
	 * 根据id获取对象
	 * 
	 * @example get(User.class,id)
	 * @param c
	 * @param id
	 * @return
	 */
	@Override
	public Object get(Class<?> c, Serializable id) throws Exception {
		Object obj = null;
		obj = this.getSessionFactory().getCurrentSession().get(c, id);
		return (Object) obj;
	}

	/**
	 * 根据hql获取对象
	 * 
	 * @example get("from User")
	 * @param hql
	 * @return
	 */
	@Override
	public Object get(String hql) throws Exception {
		Query q = this.getSessionFactory().getCurrentSession().createQuery(hql);
		return (Object)q.uniqueResult();
	}

	/**
	 * 根据map条件获取获取对象
	 * 
	 * @example Map map=new HashMap(); map.put("id",1) get("from User",map)
	 * @param hql
	 * @param params
	 * @return
	 */
	@Override
	public Object get(String hql, Map<String, Object> params) throws Exception {
		Query q = this.getSessionFactory().getCurrentSession().createQuery(hql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		List<Object> l = q.list();
		if (l != null && l.size() > 0) {
			return l.get(0);
		}
		return null;
	}

	/**
	 * 删除
	 * 
	 * @example delete(user)
	 * @param o
	 */
	@Override
	public void delete(Object o) throws Exception {
		this.getSessionFactory().getCurrentSession().delete(o);
	}

	/**
	 * 更新
	 * 
	 * @example update(user)
	 * @param o
	 */
	@Override
	public void update(Object o) throws Exception {
		this.getSessionFactory().getCurrentSession().update(o);
	}
	
	/**
	 * 保存或更新
	 * 
	 * @example saveOrUpdate(user)
	 * @param o
	 */
	@Override
	public void saveOrUpdate(Object o) throws Exception {
		this.getHibernateTemplate().saveOrUpdate(o);
	}

	/**
	 * 根据hql语句查询集合
	 * 
	 * @example find("from User")
	 * @param hql
	 * @return
	 */
	@Override
	public List find(String hql) throws Exception {
		Query q = this.getSessionFactory().getCurrentSession().createQuery(hql);
		return q.list();
	}

	/**
	 * 根据map条件查询集合
	 * 
	 * @example Map map=new HashMap(); map.put("id",1) find("from User",map)
	 * @param hql
	 * @param params
	 * @return
	 */
	@Override
	public List find(String hql, Map<String, Object> params)
			throws Exception {
		Query q = this.getSessionFactory().getCurrentSession().createQuery(hql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		return q.list();
	}

	/**
	 * 根据map条件分页查询集合
	 * 
	 * @example Map map=new HashMap(); map.put("id",1)
	 *          find("from User",map,1,10)
	 * @param hql
	 * @param params
	 * @param page
	 * @param rows
	 * @return
	 */
	@Override
	public List find(String hql, Map<String, Object> params, int page,
			int rows) throws Exception {
		Query q = null;
		try {
			q = this.getSessionFactory().getCurrentSession().createQuery(hql);
			if (params != null && !params.isEmpty()) {
				for (String key : params.keySet()) {
					q.setParameter(key, params.get(key));
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
	}

	/**
	 * 分页查询
	 * 
	 * @example find("from User",1,10)
	 * @param hql
	 * @param page
	 * @param rows
	 * @return
	 */
	@Override
	public List find(String hql, int page, int rows) throws Exception {
		Query q = this.getSessionFactory().getCurrentSession().createQuery(hql);
		List list = q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
		return list;
	}

	/**
	 * 查询数量
	 * 
	 * @example find("from User")
	 * @param hql
	 * @return
	 */
	@Override
	public Long count(String hql) throws Exception {
		Query q = this.getSessionFactory().getCurrentSession().createQuery(hql);
		return (Long) q.uniqueResult();
	}
	
	/**
	 * 查询数量
	 * 
	 * @example find("from User")
	 * @param hql
	 * @return
	 */
	@Override
	public int total(String hql) throws Exception {
		Query q = this.getSessionFactory().getCurrentSession().createQuery(hql);
		return q.list().size();
	}

	/**
	 * 根据map条件查询
	 * 
	 * @example Map map=new HashMap() map.put("id",1) find("from User",map)
	 * @param hql
	 * @param params
	 * @return
	 */
	@Override
	public Long count(String hql, Map<String, Object> params) throws Exception {
		Query q = this.getSessionFactory().getCurrentSession().createQuery(hql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		return (Long) q.uniqueResult();
	}

	/**
	 * 执行一个hql语句
	 * 
	 * @example executeHql("delete from User where id=1")
	 * @param hql
	 * @return 执行这条语句响应的行数
	 */
	@Override
	public int executeHql(String hql) throws Exception {
		Query q = this.getSessionFactory().getCurrentSession().createQuery(hql);
		return q.executeUpdate();
	}

	/**
	 * 根据map条件执行一个hql语句
	 * 
	 * @example Map map=new HashMap(); map.put("id",id);
	 *          executeHql("delete from User",map)
	 * @param hql
	 * @param params
	 * @return
	 */
	@Override
	public int executeHql(String hql, Map<String, Object> params)
			throws Exception {
		Query q = this.getSessionFactory().getCurrentSession().createQuery(hql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				q.setParameter(key, params.get(key));
			}
		}
		return q.executeUpdate();
	}
	
	@Override
	public Object findOne(String hql)throws Exception{
		Query q = this.getSessionFactory().getCurrentSession().createQuery(hql);
		return q.uniqueResult();
	}
	@Override
	public List findList(String hql)throws Exception{
		Query q = this.getSessionFactory().getCurrentSession().createQuery(hql);
		return q.list();
	}
}



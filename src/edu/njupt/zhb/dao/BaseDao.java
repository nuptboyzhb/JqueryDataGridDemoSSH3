/*
 * $filename: BaseDao.java,v $
 * $Date: 2013-11-27  $
 * Copyright (C) ZhengHaibo, Inc. All rights reserved.
 * This software is Made by Zhenghaibo.
 */
package edu.njupt.zhb.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;

/*
 *@author: ZhengHaibo  
 *web:     http://blog.csdn.net/nuptboyzhb
 *mail:    zhb931706659@126.com
 *2013-11-27  Nanjing,njupt,China
 */
public interface BaseDao {
	public Serializable save(Object o) throws Exception ;
	public Object get(Class<?> c, Serializable id)throws Exception ;
	public Object get(String hql)throws Exception;
	public Object get(String hql, Map<String, Object> params)throws Exception;
	public void delete(Object o)throws Exception;
	public void update(Object o)throws Exception;
	public void saveOrUpdate(Object o)throws Exception;
	public List find(String hql)throws Exception;
	public List find(String hql, Map<String, Object> params)throws Exception;
	public List find(String hql, Map<String, Object> params, int page,int rows)throws Exception;
	public List find(String hql, int page, int rows)throws Exception;
	public Long count(String hql)throws Exception;
	public int total(String hql)throws Exception;
	public Long count(String hql, Map<String, Object> params)throws Exception;
	public int executeHql(String hql)throws Exception;
	public int executeHql(String hql, Map<String, Object> params)throws Exception;
	public Object findOne(String hql)throws Exception;
	public List findList(String hql)throws Exception;
}

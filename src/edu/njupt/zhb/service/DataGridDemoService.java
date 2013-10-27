/*
 * $filename: DataGridDemoService.java,v $
 * $Date: 2013-10-26  $
 * Copyright (C) ZhengHaibo, Inc. All rights reserved.
 * This software is Made by Zhenghaibo.
 */
package edu.njupt.zhb.service;

import java.util.List;

import net.sf.json.JSONObject;
import edu.njupt.zhb.dao.BaseDao;
import edu.njupt.zhb.model.Student;
import edu.njupt.zhb.tools.DataGrid;
import edu.njupt.zhb.tools.Tips;

/*
 *@author: ZhengHaibo  
 *web:     http://blog.csdn.net/nuptboyzhb
 *mail:    zhb931706659@126.com
 *2013-10-26  Nanjing,njupt,China
 */
public class DataGridDemoService {
	private BaseDao<Student> baseDao;

	public BaseDao<Student> getBaseDao() {
		return baseDao;
	}
	public void setBaseDao(BaseDao<Student> baseDao) {
		this.baseDao = baseDao;
	}
	public String getStudentList(int page, int rows) {
		// TODO Auto-generated method stub
		System.out.println("page="+page+",rows="+rows);
		String hql = "from Student";
		try {
			List<Student> list = baseDao.find(hql,page,rows);
			DataGrid<Student> dataGrid = new DataGrid<Student>();
			dataGrid.setRows(list);
			dataGrid.setTotal(baseDao.total(hql));
			String result = JSONObject.fromObject(dataGrid).toString();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public String addStudent(Student student) {
		// TODO Auto-generated method stub
		Tips tips = new Tips();
		try {
			baseDao.save(student);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			tips.setMsg("添加失败");
			return JSONObject.fromObject(tips).toString();
		}
		tips.setMsg("添加成功");
		return JSONObject.fromObject(tips).toString();
	}
	public String deleteStudent(int studentid) {
		// TODO Auto-generated method stub
		Tips tips = new Tips();
		try {
			baseDao.executeHql("delete from Student where id = "+studentid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			tips.setMsg("删除失败");
			return JSONObject.fromObject(tips).toString();
		}
		tips.setMsg("删除成功");
		return JSONObject.fromObject(tips).toString();
	}
	public String editStudent(Student student) {
		// TODO Auto-generated method stub
		Tips tips = new Tips();
		try {
			baseDao.update(student);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			tips.setMsg("编辑失败");
			return JSONObject.fromObject(tips).toString();
		}
		tips.setMsg("编辑成功");
		return JSONObject.fromObject(tips).toString();
	}


}

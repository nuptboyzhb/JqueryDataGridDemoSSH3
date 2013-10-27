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
public interface DataGridDemoService {
	public String getStudentList(int page, int rows);
	public String addStudent(Student student);
	public String deleteStudent(int studentid);
	public String editStudent(Student student);
}

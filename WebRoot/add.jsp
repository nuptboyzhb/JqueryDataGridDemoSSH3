<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
	<title>Custom DataGrid Pager - jQuery EasyUI Demo</title>
	<link rel="stylesheet" type="text/css" href="js/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="js/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="js/demo/demo.css">
	<link rel="stylesheet" type="text/css" href="css/ymPrompt.css">
	<link rel="stylesheet" type="text/css" href="css/popupwindows.css">
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="js/ymPrompt_source.js"></script>
	<script type="text/javascript" src="js/Form.js"></script>
	<script type="text/javascript">
	function save(){
		var id = $('#id').val();
		var name = $('#name').val();
		var course = $('#course').val();
		var score = $('#score').val();
		if(id==""){
			alert("学号不能为空");
			document.myform.ssjczbh.focus();
			return false;
		}
		else if(name==""){
			alert("姓名不能为空");
			document.myform.gxddh.focus();
			return false;
		}
		else if(name.length>=32){
			alert("姓名长度不能超过32位");
			document.myform.gxddh.focus();
			return false;
		}
		else if(course==""){
			alert("课程不能为空");
			document.myform.gxddh.focus();
			return false;
		}
		else if(course.length>=32){
			alert("课程长度不能超过32位");
			document.myform.gxddh.focus();
			return false;
		}
		else if(score==""){
			alert("分数不能为空");
			document.myform.gxddh.focus();
			return false;
		}
		var form=new Form("form_add","addStudent");
		form.submit();
	}

	function cancel(){
		window.parent.ymPrompt.close();
	}
	</script>
</head>
<body>
	<form name="myform" id="form_add" method="post">
  	<div class="div_popup_content">
    <table cellspacing="0" cellpadding="0" >
    	<tr>
    		<th>学号</th>
    		<td>
    			<input id="id" name="student.id" style="width: 150px" panelHeight="auto" editable="false"/>
    		</td>
    		<th>姓名</th>
    		<td>
    			<input id="name" class="noneinput" name="student.name" />
    		</td>
    	</tr>
    	<tr>
    		<th>课程</th>
    		<td>
    			<input id="course" name="student.course" style="width: 150px" panelHeight="auto" editable="false"/>
    		</td>
    		<th>分数</th>
    		<td>
    			<input id="score" class="noneinput" name="student.score" />
    		</td>
    	</tr>
    	<tr>
    	<tr>
    		<th>备注</th>
    		<td colspan="3">
    			<textarea style="border:1px solid #A4BED4" name="student.remarks" cols="58" rows="4"></textarea>
    		</td>
    	</tr>
    	<tr>
			<td colspan="4">
				<div style="margin-bottom:5px;text-align: right">
		          <a href="#" class="easyui-linkbutton" onclick="save()" iconCls="icon-save">保存</a>
		          <a href="#" class="easyui-linkbutton" onclick="cancel()" iconCls="icon-cancel">取消</a>  
		        </div> 
			</td>
		</tr>
    </table>
    </div>
    </form>
</body>
</html>


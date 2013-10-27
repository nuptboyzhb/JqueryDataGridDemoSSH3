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
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="js/ymPrompt_source.js"></script>
	<script type="text/javascript" src="js/Ajax.js"></script>
	<script type="text/javascript">
	function getUrlWithParams(url,rowData) {
		var params = url + "?index=1";
		for ( var cell in rowData) {
			params += "&" + cell + "=" + encodeURI(encodeURI(rowData[cell]));
		}
		return params;
	}
	function callBack(tips) {
		if (tips == 'close'){
			return;
		}else{
			$.messager.alert('提示', tips.msg, 'info');
			$('#dg').datagrid('load');
		}
	}
	function add() {
		window.top.ymPrompt.win( {
			message : 'add.jsp',
			useSlide : true,
			slideCfg : {
				increment : 0.2,
				interval : 100
			},
			width : 520,
			height : 360,
			title : '增加',
			maxBtn : false,
			minBtn : true,
			iframe : true,
			handler : callBack
		});
	}
	function edit(){
		var rowData = $('#dg').datagrid('getSelected');
		if (rowData!=null) {
			var url=getUrlWithParams("edit.jsp",rowData);//将选中的表格数据传递给edit.jsp
			window.top.ymPrompt.win( {
				message : url,
				useSlide : true,
				slideCfg : {
					increment : 0.2,
					interval : 100
				},
				width : 520,
				height : 360,
				title : '编辑',
				maxBtn : false,
				minBtn : true,
				iframe : true,
				handler : callBack
			});
		} else {
			$.messager.alert('提示', '请选择要编辑的记录!', 'info');
		}
	}
	function del()
	{
		var rowData = $('#dg').datagrid('getSelected');
		if(rowData != null)
		{
			$.messager.confirm('提示', '确定删除这条数据吗?', function(r){
				if (r){
					var studentId = rowData.id;
					var ajax = new Ajax("deleteStudent","studentId="+studentId);
					$('#dg').datagrid('load');
				}
			});
		}else{
			$.messager.alert('提示','请选择要删除的行!','info');
		}
	}
	</script>
</head>
<body>
	<h2>Custom DataGrid Pager</h2>
	<div class="demo-info">
		<div class="demo-tip icon-tip"></div>
		<div>You can append some buttons to the standard datagrid pager bar.</div>
	</div>
	<div style="margin:10px 0;"></div>
	<div id="tb">
	  <a href="#" class="easyui-linkbutton" id="addform" onclick="add()" iconCls="icon-add" plain="true">增加</a>
	  <a href="#" class="easyui-linkbutton" onclick="edit()" iconCls="icon-edit" plain="true">编辑</a>
	  <a href="#" class="easyui-linkbutton" onclick="del()" iconCls="icon-remove" plain="true">删除</a>
	</div>
	<table id="dg" title="Custom DataGrid Pager" style="width:700px;height:550px"
			data-options="rownumbers:true,singleSelect:true,pagination:true,url:'getStudentList',method:'get',toolbar:'#tb'">
		<thead>
			<tr>
				<th data-options="field:'id',width:80">学号</th>
				<th data-options="field:'name',width:100">姓名</th>
				<th data-options="field:'course',width:180">课程</th>
				<th data-options="field:'score',width:80">分数</th>
				<th data-options="field:'remarks',width:80">备注</th>
			</tr>
		</thead>
	</table>
	<script type="text/javascript">
		$(function(){
			var pager = $('#dg').datagrid().datagrid('getPager');	// get the pager of datagrid
			pager.pagination({
				buttons:[{
					iconCls:'icon-search',
					handler:function(){
						
					}
				},{
					iconCls:'icon-add',
					handler:function(){
					
				}
				},{
					iconCls:'icon-edit',
					handler:function(){
					
				}
				}]
			});			
		})
	</script>
</body>
</html>


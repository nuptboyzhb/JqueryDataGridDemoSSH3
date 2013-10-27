var url;
var data;

function Ajax(url,data){
	this.url=url;
	this.data=data;
	bindAjax(url,data);
}
function bindAjax(url,data){
	$.ajax({
		type:"post",
		url:url,
		data:data,
		dateType:"json",
		success:function(data){
			var json=eval("("+data+")");
			$.messager.alert('提示', json.msg, 'info');
			$('#list').datagrid('load');
		}
	})
}
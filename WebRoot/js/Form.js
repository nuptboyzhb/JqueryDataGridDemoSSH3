var id;
var url

function Form(id, url) {
	this.id = id;
	this.url = url;
	bindForm(id, url);
}
function bindForm(id, url) {
	$('#' + id).form( {
		url : url,
		onSubmit:function(){
			return $(this).form('validate');
		},
		success : function(data) {
			console.log("--add json--");
			console.log(data);
			var json=eval("("+data+")");
			window.parent.ymPrompt.doHandler(json, true);
			window.parent.ymPrompt.close();
		}
	});
}
Form.prototype = {
	submit : function() {
		$('#' + this.id).submit();
	}
}

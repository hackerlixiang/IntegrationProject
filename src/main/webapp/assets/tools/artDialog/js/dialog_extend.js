function messageDialog(type,message){
	var msgType = "text-success";
	switch (type) {
		case "warning":{msgType = "text-warning";break;}
		case "success":{msgType = "text-success";break;}
		case "failure":{msgType = "text-danger";break;}
		default:{msgType = "text-success";break;}
	}
	var content = "<p class='"+msgType+"' style='width:100%;text-align:center'>"+message+"</p>"
	dialog({
	    title: '提示',
	    align: 'left',
	    width:"200px",
	    content: content,
	    quickClose: true,
	    okValue: '确定',
	    skin: "",
	    ok: function () {
	    	if(type=="success"){
	    		//执行重置按钮事件
	    		//$("button[type='reset']").trigger("click"); 
	    		//重新加载当前页面
	    		document.location.reload();
	    	}
	        return true;
	    }
	}).show();
}
function messageDialog(type,cont){
	var msgType = "text-success";
	switch (type) {
		case "warning":{msgType = "text-warning";break;}
		case "success":{msgType = "text-success";break;}
		case "failure":{msgType = "text-danger";break;}
		default:{msgType = "text-success";break;}
	}
	var content = "<p class='"+msgType+"' style='width:100%;text-align:center'>"+cont+"</p>"
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
	    		$("button[type='reset']").trigger("click"); 
	    	}
	        return true;
	    }
	}).show();
}
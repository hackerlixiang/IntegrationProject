/**
 * 初始化表单
 * @author lixiang
 */
function initInputForm(){
	//为表单中的input加上icon位
	$("form").find(".form-group").append("<span class='tag' aria-hidden='true' style='margin-top:8px;'>");
	//为支持icon位添加属性
	$("form").find(".form-group").addClass("has-feedback");
	//将表单中的下拉菜单改成select2的组件
	$("form").find("select").addClass("js-states");
	$("#parentId").select2({allowClear: true});
	//将表单中的select2的组件调整样式
	$(".select2-selection").css({"height":"33px"});
	$(".select2-selection").find(".select2-selection__rendered").css({"height":"33px","line-height":"32px"});
	$(".select2-selection").find(".select2-selection__arrow").css({"height":"33px"});
	//添加加密功能
	if(window.Base64){
		Base64.extendString();
	}
}
//执行表单初始化方法
initInputForm();

/**
 * 刷新列表
 * @author lixiang
 */
function refreshForm(){
	//移除成功样式
	$(".form-group").removeClass("has-success");
	//移除失败样式
	$(".form-group").removeClass("has-error");
	//移除成功图标√
	$(".form-group").find(".tag").removeClass("glyphicon glyphicon-ok");
	//移除失败图标×
	$(".form-group").find(".tag").removeClass("glyphicon glyphicon-remove");
	//清空错误提示
	$(".form-group").find(".text-danger").text("");
	//重置select2组件选中效果
	if($("#select2-parentId-container")!=null&&$("#select2-parentId-container")&&$("#select2-parentId-container").closest("form")[0]){
		$("#select2-parentId-container").closest("form")[0].reset();
	}
	
	var defaultText = $("#select2-parentId-container").closest("div").find("select").find("option:selected").text();
	if(defaultText!=null && defaultText!="" && typeof(defaultText) != "undefined"){
		$("#select2-parentId-container").attr("title",defaultText);
		$("#select2-parentId-container").html('<span class="select2-selection__clear">×</span>'+defaultText);
	}else{
		$("#select2-parentId-container").attr("title","");
		$("#select2-parentId-container").html('<span class="select2-selection__placeholder">请选择</span>');
	}
}

/**
 * 表单验证成功方法
 * @author lixiang
 * @param element 被验证元素
 */
function formSuccess(element){
	if(!element.val()){
		return;
	}
	//移除失败样式
	element.closest(".form-group").removeClass("has-error");
	//清空失败提示
	element.closest(".form-group").find("div").find(".text-danger").text("");
	//如果不是自定义icon，将失败的icon'×'移除掉
	element.closest(".form-group").find(".tag").removeClass("glyphicon glyphicon-remove color_red3");
	//添加成功样式
	element.closest(".form-group").addClass("has-success");
	//如果不是自定义icon，添加成功'√'icon
	if(!element.hasClass("custom-icon")){
		element.closest(".form-group").find(".tag").addClass("glyphicon glyphicon-ok color_green4");
	}
}

/**
 * 表单验证失败方法
 * @author lixiang
 * @param element 被验证元素
 * @param error 错误对象
 */
function formFailure(element,error){
	//移除成功样式
	element.closest(".form-group").removeClass("has-success");
	//移除成功的iocn'√'
	element.closest(".form-group").find(".tag").removeClass("glyphicon glyphicon-ok color_green4");
	//添加失败样式
	element.closest(".form-group").addClass("has-error");
	//如果不是自定义icon添加失败icon'×'
	element.closest(".form-group").find(".tag").css({ "right":"","top":""});
	element.closest(".form-group").find(".tag").addClass("glyphicon glyphicon-remove color_red3");
	//添加错误提示
	element.closest(".form-group").find("div").find(".text-danger").text(error.text());
}

// 对表单中 encryption 属性的字段进行加密
function encryption(form){
	var encryptions = $(form).find(".encryption");
	for(var i=0;i<encryptions.length;i++){
		var encryption = encryptions[i];
		var value = $(encryption).val();
		if(value!=null&&value!=""&&value){
			$(encryption).val(value.toBase64());
		}
	}
}
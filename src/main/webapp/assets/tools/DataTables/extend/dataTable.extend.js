/**
 * 获取排序对象
 * @author lixiang
 * @param nameArray 参数名数组
 * @param valArray 值数组
 * @returns {Object} 排序对象
 */
function sortParams(nameArray,valArray){
	//创建排序对象
	var sortParam = new Object();
	for(var i = 0;i<valArray.length;i++){
		//获取列表
		var column = valArray[i].column;
		//获取排序值
		var dir = valArray[i].dir;
		//获取排序参数名
		var name = nameArray[column].data;
		//添加到对象中
		eval("sortParam."+name+"='"+dir+"'");
	}
	//返回排序对象
	return sortParam;
}

/**
 * 获取查询对象
 * @author lixiang
 * @returns {Object} 查询对象
 */
function queryParams(){
	//获取表单中的所有input元素
	var queryEles = $("#queryForm input");
	//创建查询对象
	var queryParam = new Object();
	//遍历input元素
	for(var i = 0;i<queryEles.length;i++){
		//获取参数名及参数值
		var name = $(queryEles[i]).attr("name");
		var value = $(queryEles[i]).val();
		//添加到对象中
		eval("queryParam."+name+"='"+value+"'");
	}
	//返回查询对象
	return queryParam;
}

/**
 * 封装dt查询、排序参数
 * @author lixiang
 * @param d dt对象
 */
function formateParmas(d){
	var orders = d.order;
	var columns = d.columns;
	
	var queryParam = queryParams();
	var sortParam = sortParams(columns,orders);
	
	d.order = JSON.stringify(sortParam);
	d.filter = JSON.stringify(queryParam);
	if($("a[seleted]").length>0){
		d.length = $("a[seleted]").attr("val");
	}
}

//创建默认的dt
$.extend( $.fn.dataTable.defaults, {
	"processing": true,
    "serverSide": true,
    "lengthMenu": [10,30,50,80,100],
    "displayLength":10,
    "scrollX":"100%",
    "scrollY":600,
    "scrollCollapse": true,
    "deferRender":true,
    "pagingType": "simple_numbers",
    "searching": false,
    "language": { 
        "sProcessing": "处理中...",
        "sLengthMenu": "显示 _MENU_ 项结果",
        "sZeroRecords": "没有匹配结果",
        "sInfo": "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
        "sInfoEmpty": "显示第 0 至 0 项结果，共 0 项",
        "sInfoFiltered": "(由 _MAX_ 项结果过滤)",
        "sInfoPostFix": "",
        "sSearch": "搜索:",
        "sUrl": "",
        "sEmptyTable": "暂无数据",
        "sLoadingRecords": "载入中...",
        "sInfoThousands": ",",
        "oPaginate": {
            "sFirst": "首页",
            "sPrevious": "上页",
            "sNext": "下页",
            "sLast": "末页"
        },
        "oAria": {
            "sSortAscending": ": 以升序排列此列",
            "sSortDescending": ": 以降序排列此列"
        }
    },
    "initComplete":function(settings, json) {
//    	console.debug(settings);
//    	console.debug(json);
    	
    	/**
    	 * 定义每页显示条数的的change方法
    	 * @author lixiang
    	 * @param item 值
    	 * @param self 当前被点击的元素
    	 */
		function changeItem(val,self){
			//显示选中的值
			self.closest("div").find("span").find("strong").text(self.attr("val"));
			//清空所有选中属性
			if($("a[seleted]").length>0){
				$("a[seleted]").removeAttr("seleted");
			}
			//为被点击元素添加选中属性
			self.attr("seleted","selected");
			//获取隐藏中的select标签
			var selets = $("select[name=datas_length]");
			var seletItem = selets[0];
			//遍历options，移除所有的selected属性
			for (var i = 0; i < seletItem.options.length; i++) {
				  var sItem = seletItem.options[i];
				  if($(sItem).attr("selected")){
					  $(sItem).removeAttr("selected","selected");
					  break;
				  }       
			}
			//遍历options，为选中的option添加selected属性
			for (var i = 0; i < seletItem.options.length; i++) {
			  var sItem = seletItem.options[i];
			  if(sItem.value==val){
				  $(sItem).attr("selected","selected");
				  $(sItem).change();
				  break;
			  }       
			}
		}
		
		/**
		 *  修改精确模糊查询的显示及赋值
		 *  @author lixiang
    	 *  @param eqOrLike 选中的筛选项
		 */
		function addQueryInput(eqOrLike){
			//获取模糊精确查询span
			var span = eqOrLike.closest(".btn-group").find(".describe");
			//获取查询选中的span值
			var value1 = span.attr("value");
			//获取查询未选中的span值
			var value2 = eqOrLike.attr("value");
			
			//交换双方文本显示及值
			text1 = span.text();
			text2 = eqOrLike.text();
			span.text(text2);
			eqOrLike.text(text1);
			eqOrLike.attr("value",value1);
			span.attr("value",value2);
			
			//获取到该查询对应到的input元素
			var el = eqOrLike.closest(".form-group").children("input");
			//为该元素添加上选中的值
			el.val(value2);
		}
		
		//隐藏原有的每页显示标签
		$("#datas_length").addClass("hide");
		//加载工具模板
		$("#datas_length").after(template("buttonTemplate",{"":""}));
		//为每页显示的项添加点击事件
		$("a[name='changeItem']").on("click",function(){
			changeItem($(this).attr("val"),$(this));
		});
		
		//将精确模糊input项的类型设置为hidden
		$(".select-control").attr("type","hidden");
		//如果精确模糊input项没有值，默认添加为eq
		if("eq"!=($(".select-control").val())&&"like"!=($(".select-control").val())){
			console.debug($(".select-control"));
			$(".select-control").val("eq");
		}
		//加载精确模糊下拉
		$(".select-control").closest(".form-group").find(".form-control").before(template("eqOrLikeTemplate",{"":""}));
		//为精确模糊下拉项添加点击事件
		$(".input-group-btn").find("a").on("click",function(){
			addQueryInput($(this));
		});
		
		//组合查询弹窗
		var d = null;
		$("#query").on("click",function(){
			$("#querys").removeClass("hide");
			d = dialog({
				title: '查询',
				align: 'center',
				width:"600px",
				content: $("#querys"),
				quickClose: true,
				onclose: function () {
					$("#querys").addClass("hide");
	 			}
			}).show();
		});

		//为组合查询按钮添加点击事件
		$("#queryButton").on("click",function(){
			settings.oApi._fnDraw(settings);//调用dt的列表刷新方法
			if(d){
				d.close(); // 关闭（隐藏）对话框
				d.remove();// 主动销毁对话框
			}
		});
		
    }
});


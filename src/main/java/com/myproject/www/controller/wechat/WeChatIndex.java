package com.myproject.www.controller.wechat;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myproject.www.controller.web.system.BaseSystemController;


@Controller
@RequestMapping("/wechat")
@Scope("prototype")
public class WeChatIndex extends BaseSystemController{
	
	@RequestMapping(value="/index")
	@ResponseBody
	public Boolean index(HttpServletRequest request) throws Exception{
		printParams(request);
		return true;
	}
}

package com.myproject.www.freemarker;

import java.util.List;

import org.springframework.stereotype.Component;

import com.myproject.www.utils.AbbreviateUtils;
import com.myproject.www.utils.StringUtils;

import freemarker.template.SimpleScalar;
import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModelException;

@Component("abbreviateMethod")
public class AbbreviateMethod implements TemplateMethodModelEx {
	
	@SuppressWarnings("rawtypes")
    public Object exec(List arguments) throws TemplateModelException {

        // 验证参数
        if (arguments != null && !arguments.isEmpty() && arguments.get(0) != null
                && StringUtils.isNotBlank(arguments.get(0).toString())) {

            // 获取格式化类型
            String type = arguments.get(0).toString();

            // 格式化用户名
            if (StringUtils.equals(type, "username") && arguments.size() > 1) {
                String username = arguments.get(1).toString();
                return new SimpleScalar(AbbreviateUtils.abbrUsername(username));
            }

            // 格式化姓名
            if (StringUtils.equals(type, "name") && arguments.size() > 1) {
                String fullName = arguments.get(1).toString();
                return new SimpleScalar(AbbreviateUtils.abbrName(fullName));
            }

            // 格式化手机号码
            if (StringUtils.equals(type, "mobile") && arguments.size() > 1) {
                String mobile = arguments.get(1).toString();
                return new SimpleScalar(AbbreviateUtils.abbrMobile(mobile));
            }

            // 格式化身份证号码
            if (StringUtils.equals(type, "idCard") && arguments.size() > 1) {
                String identity = arguments.get(1).toString();
                return new SimpleScalar(AbbreviateUtils.abbrIdCard(identity));
            }
            
        }

        return null;
    }
}

jQuery.validator.addMethod("matching", function(value, element, param) {
	return this.optional(element) || param.test(value);
}, "格式不匹配");
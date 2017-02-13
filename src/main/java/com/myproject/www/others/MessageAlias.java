package com.myproject.www.others;

/**
 * 消息别名
 * 
 * @author lixiang
 * @Version 1.0
 * @Time 2017年2月10日 下午2:26:22
 */
public interface MessageAlias {
	public static final String MESSAGE_UNDEFINED = "MessageUndefined";//未定义消息
	
	/* -----------------------------------------------------------菜单提示消息--------------------------------------------------------------------- */
	public static final String MENU_PARAM_ERROR = "MenuParamError";//参数错误
	public static final String MENU_NAME_REPEAT = "MenuNameRepeat";//菜单名称重复
	public static final String MENU_PATH_REPEAT = "MenuPathRepeat";//菜单路劲重复
	
	public static final String MENU_ADD_SUCCESS = "MenuAddSuccess";//添加菜单成功
	public static final String MENU_DELETE_SUCCESS = "MenuDeleteSuccess";//删除菜单成功
	public static final String MENU_UPDATE_SUCCESS = "MenuUpdateSuccess";//修改菜单成功
	
	public static final String MENU_ADD_FAILURE = "MenuAddFailure";//菜单添加失败
	public static final String MENU_DELETE_FAILURE = "MenuDeleteFailure";//菜单删除失败
	public static final String MENU_UPDATE_FAILURE = "MenuUpdateFailure";//菜单修改失败
	
	/* -----------------------------------------------------------管理员提示消息--------------------------------------------------------------------- */
	public static final String ADMIN_PARAM_ERROR = "AdminParamError";//参数错误
	public static final String ADMIN_NOT_FOUND = "AdminNotFound";//管理员不存在
	
	public static final String ADMIN_ADD_SUCCESS = "AdminAddSuccess";//管理员添加成功
	public static final String ADMIN_DELETE_SUCCESS = "AdminDeleteSuccess";//管理员删除成功
	public static final String ADMIN_UPDATE_SUCCESS = "AdminUpdateSuccess";//管理员修改成功
	                           
	public static final String ADMIN_ADD_FAILURE = "AdminAddFailure";//管理员添加失败
	public static final String ADMIN_DELETE_FAILURE = "AdminDeleteFailure";//管理员删除失败
	public static final String ADMIN_UPDATE_FAILURE = "AdminUpdateFailure";//管理员修改失败

	/* ----------------------------------------------------------数据字典提示消息-------------------------------------------------------------------- */
	public static final String DATA_DICTIONARY_ADD_SUCCESS = "DataDictionaryAddSuccess";//数据字典添加成功
	public static final String DATA_DICTIONARY_ADD_FAILURE = "DataDictionaryAddFailure";//数据字典添加失败

	
}

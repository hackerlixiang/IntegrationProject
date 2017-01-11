package com.myproject.www.others;

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
	
	/* -----------------------------------------------------------用户提示消息--------------------------------------------------------------------- */
	public static final String USER_PARAM_ERROR = "UserParamError";//参数错误
	
	public static final String USER_ADD_SUCCESS = "UserAddSuccess";//用户添加成功
	public static final String USER_DELETE_SUCCESS = "UserDeleteSuccess";//用户删除成功
	public static final String USER_UPDATE_SUCCESS = "UserUpdateSuccess";//用户修改成功
	                           
	public static final String USER_ADD_FAILURE = "UserAddFailure";//用户添加失败
	public static final String USER_DELETE_FAILURE = "UserDeleteFailure";//用户删除失败
	public static final String USER_UPDATE_FAILURE = "UserUpdateFailure";//用户修改失败

	/* ----------------------------------------------------------数据字典提示消息-------------------------------------------------------------------- */
	public static final String DATA_DICTIONARY_ADD_SUCCESS = "DataDictionaryAddSuccess";//数据字典添加成功
	public static final String DATA_DICTIONARY_ADD_FAILURE = "DataDictionaryAddFailure";//数据字典添加失败

	
}

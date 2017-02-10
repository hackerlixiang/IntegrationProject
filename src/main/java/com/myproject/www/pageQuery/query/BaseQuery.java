package com.myproject.www.pageQuery.query;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.myproject.www.annon.FieldColumn;
import com.myproject.www.entity.BaseEntity;
import com.myproject.www.utils.CommonUtils;
import com.myproject.www.utils.JsonUtils;
import com.myproject.www.utils.StringUtils;

/**
 * 基础查询VO
 * 
 * @author lixiang
 * @Version 1.0
 * @Time 2017年2月9日 下午5:41:03
 */
public class BaseQuery<E extends BaseEntity> {
	
	/** 每页显示条数 */
	private Long length = 10L;

	/** 请求次数 */
	private Long draw;

	/** 开始条数 */
	private Long start = 1L;
	
	/** 排序参数 */
	private String order;
	
	/** 查询参数 */
	private String filter;
	
	/** 排序map集合 */
	private Map<String,Object> orders = new HashMap<String,Object>();
	
	/** 查询map集合 */
	private Map<String,Object> querys = new HashMap<String,Object>();
	
	private Class<E> entityClass; 
	
	@SuppressWarnings("unchecked")
	public BaseQuery() {
		//getClass() 返回表示此 Class 所表示的实体（类、接口、基本类型或 void）的超类的 Class。  
	    this.entityClass=(Class<E>)getSuperClassGenricType(getClass(), 0);  
	}
	
	public Long getLength() {
		return length;
	}

	public void setLength(Long length) {
		this.length = length;
	}

	public Long getDraw() {
		return draw;
	}

	public void setDraw(Long draw) {
		this.draw = draw;
	}

	public Long getStart() {
		if (start != null) {
			return start;
		} else {
			start = start - 1L;
			return start;
		}
	}

	public void setStart(Long start) {
		this.start = start;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	@SuppressWarnings("unchecked")
	public String getFilter() {
		Field[] fields = this.getClass().getDeclaredFields();
		Map<String, Object> allFilters = new HashMap<String, Object>();
		if(StringUtils.isNotBlank(filter)){
			allFilters = JsonUtils.toObject(filter, Map.class);
		}
		Map<String, Object> filters = new HashMap<String, Object>();
		for (Field field : fields) {
			filters.put(field.getName(),allFilters.get(field.getName()));
		}
		return JsonUtils.toJson(filters);
	}

	public void setFilter(String filter) {
		this.filter = filter;
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> getOrders() {
		Class<?> thisClass = this.getClass();
		Field[] thisFields = thisClass.getDeclaredFields();
		orders = JsonUtils.toObject(getOrder(), Map.class);
		for (Field thisField : thisFields) {
			if(orders.containsKey(thisField.getName())){
				orders.remove(thisField.getName());
			}
		}
		
		Field[] superFields = BaseEntity.class.getDeclaredFields();
		for (Field superField : superFields) {
			if(orders.containsKey(superField.getName())){
				String columnName = getColumnName(superField);
				Object columnValue = orders.get(superField.getName());
				orders.remove(superField.getName());
				orders.put(columnName, columnValue);
			}
		}
		
		if(CommonUtils.isNullOrEmpty(orders)){
			orders.put("create_date", "desc");
		}
		
		return orders;
	}

	public void setOrders(Map<String, Object> orders) {
		this.orders = orders;
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> getQuerys() {
		Field[] fields = this.getClass().getDeclaredFields();
		Map<String, Object> filters = JsonUtils.toObject(filter, Map.class);
		for (Field field : fields) {
			if(filters.containsKey(field.getName())){
				filters.remove(field.getName());
			}
		}
		
		Iterator<Entry<String, Object>> it = filters.entrySet().iterator();
		while (it.hasNext()) {
			Entry<String, Object> en = it.next();
			String key = en.getKey();
			Object val = en.getValue();
			if(StringUtils.contains(key,"Filter")||StringUtils.isBlank(val.toString())){
				continue;
			}else{
				Map<Object,Object> vlaue = new HashMap<Object,Object>();
				vlaue.put(filters.get(key+"Filter"),val);
				try {
					Field field = entityClass.getDeclaredField(key);
					key = getColumnName(field);
				} catch (NoSuchFieldException | SecurityException e) {
					e.printStackTrace();
				}
				querys.put(key, vlaue);
			}
		}
		return querys;
	}

	public void setQuerys(Map<String, Object> querys) {
		this.querys = querys;
	}

	/**
	 * 
	 * @return 查询bean转换忽略掉的参数
	 */
	public String[] getIgnoreProperties(){
		Field[] fields = BaseQuery.class.getDeclaredFields();
		String[] ignoreProperties = new String[fields.length];
		for (int i = 0; i < fields.length; i++) {
			ignoreProperties[i] = fields[i].getName();
		}
		return ignoreProperties;
	}
	
	/**
	 * 获取字段名
	 * @param field 反射字段
	 * @return 字段名
	 */
	private String getColumnName(Field field){
		//如果字段上有@FieldColumn 取其值返回
		if(field.getAnnotation(FieldColumn.class)!=null){
			return field.getAnnotation(FieldColumn.class).column();
		}else{
			return field.getName();
		}
	}
	
	/** 
     * 通过反射, 获得定义Class时声明的父类的泛型参数的类型. 如无法找到, 返回Object.class. 
     *  
     *@param clazz 
     *            clazz The class to introspect 
     * @param index 
     *            the Index of the generic ddeclaration,start from 0. 
     * @return the index generic declaration, or Object.class if cannot be 
     *         determined 
     */  
    @SuppressWarnings("unchecked")  
    public static Class<?> getSuperClassGenricType(final Class<?> clazz, final int index) {  
          
        //返回表示此 Class 所表示的实体（类、接口、基本类型或 void）的直接超类的 Type。  
        Type genType = clazz.getGenericSuperclass();  
  
        if (!(genType instanceof ParameterizedType)) {  
           return Object.class;  
        }  
        //返回表示此类型实际类型参数的 Type 对象的数组。  
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();  
  
        if (index >= params.length || index < 0) {  
                     return Object.class;  
        }  
        if (!(params[index] instanceof Class)) {  
              return Object.class;  
        }  
  
        return (Class<Object>) params[index];  
    }
}

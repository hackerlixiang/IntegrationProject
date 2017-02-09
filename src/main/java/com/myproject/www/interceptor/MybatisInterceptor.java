//package com.myproject.www.interceptor;
//
//import java.lang.reflect.Method;
//import java.util.Properties;
//
//import org.apache.ibatis.executor.Executor;
//import org.apache.ibatis.mapping.MappedStatement;
//import org.apache.ibatis.plugin.Interceptor;
//import org.apache.ibatis.plugin.Intercepts;
//import org.apache.ibatis.plugin.Invocation;
//import org.apache.ibatis.plugin.Plugin;
//import org.apache.ibatis.plugin.Signature;
//  
///**  
// *  
// * 分页拦截器，用于拦截需要进行分页查询的操作，然后对其进行分页处理。  
// * 利用拦截器实现Mybatis分页的原理：  
// * 要利用JDBC对数据库进行操作就必须要有一个对应的Statement对象，Mybatis在执行Sql语句前就会产生一个包含Sql语句的Statement对象，而且对应的Sql语句  
// * 是在Statement之前产生的，所以我们就可以在它生成Statement之前对用来生成Statement的Sql语句下手。在Mybatis中Statement语句是通过RoutingStatementHandler对象的  
// * prepare方法生成的。所以利用拦截器实现Mybatis分页的一个思路就是拦截StatementHandler接口的prepare方法，然后在拦截器方法中把Sql语句改成对应的分页查询Sql语句，之后再调用  
// * StatementHandler对象的prepare方法，即调用invocation.proceed()。  
// * 对于分页而言，在拦截器里面我们还需要做的一个操作就是统计满足当前条件的记录一共有多少，这是通过获取到了原始的Sql语句后，把它改为对应的统计语句再利用Mybatis封装好的参数和设  
// * 置参数的功能把Sql语句中的参数进行替换，之后再执行查询记录数的Sql语句进行总记录数的统计。  
// *  
// */    
////@Intercepts({@Signature(type=StatementHandler.class,method="update",args={Connection.class})})
//@Intercepts({@Signature(type= Executor.class,method = "update",args = {MappedStatement.class,Object.class})})
//public class MybatisInterceptor implements Interceptor {  
//    private String dialect = ""; //数据库方言    
//    private String pageSqlId = ""; //mapper.xml中需要拦截的ID(正则匹配)    
//	
//    @Override
//	public Object intercept(Invocation invocation) throws Throwable {
//		System.out.println("--");
//		 Object target = invocation.getTarget();
//	        Object result = null;
//	        if (target instanceof Executor) {
//	            long start = System.currentTimeMillis();
//	            Method method = invocation.getMethod();
//	            /**执行方法*/
//	            result = invocation.proceed();
//	            long end = System.currentTimeMillis();
//	            System.out.println("[TimerInterceptor] execute [" + method.getName() + "] cost [" + (end - start) + "] ms");
//	        }
//	        return result;
//	}
//	@Override
//	public Object plugin(Object target) {
//		// TODO Auto-generated method stub
//		 return Plugin.wrap(target, this);																																		
//	}
//	@Override
//	public void setProperties(Properties properties) {
//		// TODO Auto-generated method stub
//	}
//	
//	public String getDialect() {
//		return dialect;
//	}
//	public void setDialect(String dialect) {
//		this.dialect = dialect;
//	}
//	public String getPageSqlId() {
//		return pageSqlId;
//	}
//	public void setPageSqlId(String pageSqlId) {
//		this.pageSqlId = pageSqlId;
//	}
//        
//   
//      
//}  

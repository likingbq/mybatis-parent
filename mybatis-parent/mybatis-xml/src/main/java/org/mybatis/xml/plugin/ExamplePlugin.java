package org.mybatis.xml.plugin;

import java.sql.Connection;
import java.util.Properties;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;



/**
 * 
 * @author Administrator
 * 分页插件
 * 
 * @Intercepts 注明此类是属于mybatis的插件
 * @Signature  标注需要在哪些方法进行拦截
 *
 */
@Intercepts({
	@Signature(type = Executor.class,method = "query",args = {MappedStatement.class, Object.class, RowBounds.class,ResultHandler.class }),
	@Signature(type = StatementHandler.class,method = "prepare",args = {Connection.class})
})
public class ExamplePlugin implements Interceptor {

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		 Object result = invocation.proceed();	//放行方法
		 System.out.println("invocation.proceed()");
		return result;
	}

	@Override
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	
	
	
	@Override
	public void setProperties(Properties properties) {
		String pro1 = properties.getProperty("pro1");
		String pro2 = properties.getProperty("pro2");
		System.out.println("pro1 = " + pro1);
		System.out.println("pro2 = " + pro2);
				
	}

}

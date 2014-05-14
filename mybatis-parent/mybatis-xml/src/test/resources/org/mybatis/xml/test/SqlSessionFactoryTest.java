package org.mybatis.xml.test;

import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.datasource.pooled.PooledDataSourceFactory;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.junit.Test;
import org.mybatis.xml.dao.UserDao;
import org.mybatis.xml.model.Group;
import org.mybatis.xml.model.User;

public class SqlSessionFactoryTest {

	
	/**
	 * 不使用 XML 构建 SqlSessionFactory
	 */
	@Test
	public void buildSessionFactoryTest(){
		//创建数据源
		Properties properties = new Properties();
		properties.setProperty("driver", "com.mysql.jdbc.Driver");
		properties.setProperty("url", "jdbc:mysql://127.0.0.1:3306/mybatis_xml");
		properties.setProperty("username", "root");
		properties.setProperty("password", "root");
		PooledDataSourceFactory pooledDataSourceFactory = new PooledDataSourceFactory();
		pooledDataSourceFactory.setProperties(properties);
		DataSource dataSource = pooledDataSourceFactory.getDataSource();
		
		//创建JDBC事务工厂
		TransactionFactory transactionFactory = new JdbcTransactionFactory();
		//创建环境对象,环境对象包含使用的事务、数据源等信息
		Environment environment = new Environment("development", transactionFactory, dataSource);
		//创建一个配置文件对象
		Configuration configuration = new Configuration(environment);
		
		//当然如果只是创建SqlSessionFactory,下面三行代码不是必须的
		//注册类型别名
		configuration.getTypeAliasRegistry().registerAlias("User", User.class);
		configuration.getTypeAliasRegistry().registerAlias("Group",Group.class);
		configuration.addMapper(UserDao.class);		//加入UserDao的Mapper配置信息,
		
		
 		//创建SqlSessionFactory对象
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
		System.out.println(sqlSessionFactory);
	}
	
	
	@Test
	public void buildSqlSessionFactoryByXMLTest(){
		//读取mybatis-config.xml到字符流
		try {
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
			//通过配置文件的字符流创建SqlsessionFactory
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			System.out.println(sqlSessionFactory);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}

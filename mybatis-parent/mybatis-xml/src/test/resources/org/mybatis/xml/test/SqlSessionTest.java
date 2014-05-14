package org.mybatis.xml.test;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SqlSessionTest {

	private SqlSessionFactory sqlSessionFactory;

	@Before
	public void before() {
		// 读取mybatis-config.xml到字符流
		try {
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
			// 通过配置文件的字符流创建SqlsessionFactory
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	@Test
	public void openSqlSession(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
 		System.out.println(sqlSession);
	}
	
	
	
	@After
	public void after(){
		
	}
	
}

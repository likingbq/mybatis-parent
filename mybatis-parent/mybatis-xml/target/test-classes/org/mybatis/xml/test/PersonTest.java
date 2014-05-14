package org.mybatis.xml.test;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.mybatis.xml.dao.PersonDao;
import org.mybatis.xml.model.Person;
import org.mybatis.xml.paging.Page;

public class PersonTest {
	
	private SqlSessionFactory sqlSessionFactory;

	@Before
	public void before() {
		try {
			// 读取mybatis-config.xml到字符流
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
			// 通过配置文件的字符流创建SqlsessionFactory
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void findByIdTest(){
		String statement = "org.mybatis.xml.dao.PersonDao.findById";
		SqlSession sqlSession = sqlSessionFactory.openSession();
		Page<Person> page = new Page<Person>();
		page.setPageNo(1);
		page.setPageSize(10);
		Person p = sqlSession.selectOne(statement,page);
		System.out.println(p);
	}
	
	
	
	@Test
	public void saveTest(){
		String statement = "org.mybatis.xml.dao.PersonDao.save";
		SqlSession sqlSession = sqlSessionFactory.openSession();
		Person p = new Person("张三",11);
		sqlSession.insert(statement, p);
	}
	
	@Test
	public void getMapper(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		PersonDao dao =  sqlSession.getMapper(PersonDao.class);
		System.out.println(dao.findByName("xx"));
	}
	
	
}

package org.mybatis.xml.test;

import java.io.IOException;
import java.io.Reader;
import java.util.Date;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.mybatis.xml.dao.UserDao;
import org.mybatis.xml.model.User;

public class UserDaoTest {
	
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
	public void saveTest(){
		User user = new User(1,"张三",new Date(),1);
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		UserDao dao = sqlSession.getMapper(UserDao.class);
		dao.save(user);
	}
	
	@Test
	public void findByIdTest(){
		String statement = "org.mybatis.xml.dao.UserDao.findById";
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		User user = sqlSession.selectOne(statement, 1);
		System.out.println(user);
	}
}	
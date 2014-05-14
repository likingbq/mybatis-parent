package org.mybatis.xml.test;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.mybatis.xml.dao.GroupMapper;
import org.mybatis.xml.model.Group;

public class GroupMapperTest {
	
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
		Group group = new Group("第二组");
		SqlSession sqlSession = sqlSessionFactory.openSession();
 		GroupMapper gm = sqlSession.getMapper(GroupMapper.class);
		gm.save(group);
	}
	
	@Test
	public void findByIdTest(){
		String statement = "org.mybatis.xml.dao.GroupMapper.findById";
		SqlSession sqlSession = sqlSessionFactory.openSession();
		Group group = sqlSession.<Group>selectOne(statement, 1);
		System.out.println(group);
	}
	
	
	
}

package org.mybatis.xml.dao;

import java.util.List;

import org.mybatis.xml.model.Person;

public interface PersonDao {
	
	List<Person> findByName(String name);
	
}

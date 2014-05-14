package org.mybatis.xml.dao;

import org.mybatis.xml.model.User;

public interface UserDao {

	User findById(Long id);

	void save(User user);
}

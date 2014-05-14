package org.mybatis.xml.dao;

import org.mybatis.xml.model.Group;

public interface GroupMapper {
	
	void save(Group group);
	Group findById(Long id);
 	
}

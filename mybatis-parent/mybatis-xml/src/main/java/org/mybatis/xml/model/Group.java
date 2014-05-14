package org.mybatis.xml.model;

import java.util.HashSet;
import java.util.Set;

public class Group {
	
	private Long gid;
	private String groupName;
	private Set<User> users = new HashSet<User>();
	public Long getGid() {
		return gid;
	}
	public void setGid(Long gid) {
		this.gid = gid;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
 	
	 
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	public Group(Long gid, String groupName, Set<User> users) {
		super();
		this.gid = gid;
		this.groupName = groupName;
		this.users = users;
	}
	public Group() {
		super();
 	}
	public Group(String groupName) {
		this.groupName = groupName;
	}
	
	public Group addUser(User user){
		user.setGroup(this);
		users.add(user);
		return this;
	}
	@Override
	public String toString() {
		return "Group [gid=" + gid + ", groupName=" + groupName + ", users="
				+ users + "]";
	}
	
	
	
}

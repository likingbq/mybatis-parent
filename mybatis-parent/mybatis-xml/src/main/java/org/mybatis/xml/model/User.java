package org.mybatis.xml.model;

import java.util.Date;

public class User {
	private Long uid;
	private String username;
	private Date birthday;
	private Long groupId;
	
	private Group group;

	 
	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(Long uid, String username, Date birthday, Long groupId,
			Group group) {
		super();
		this.uid = uid;
		this.username = username;
		this.birthday = birthday;
		this.groupId = groupId;
		this.group = group;
	}

	public User(String username, Date birthday, long groupId) {
		this.username = username;
		this.birthday = birthday;
		this.groupId = groupId;
		
	}

	public User(long uid,String username, Date birthday, long groupId) {
		this(username,birthday,groupId);
		this.uid = uid;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", username=" + username + ", birthday="
				+ birthday + ", groupId=" + groupId + ", group=" + group + "]";
	}
	
  }

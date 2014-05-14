-- 如果存在mybatis_xml数据库名称,则删除
drop database if  exists mybatis_xml;

-- 如果数据库不存在,则创建一个
CREATE DATABASE if not exists mybatis_xml;

USE mybatis_xml;

-- 创建t_group 组表
create table if not exists `t_group`(
	gid bigint primary key auto_increment,
	groupname varchar(255)
)ENGINE=InnoDB DEFAULT CHARSET=UTF8;
--


CREATE TABLE IF NOT EXISTS `t_user`(
	uid	bigint primary key auto_increment,
	username varchar(255),
	birthday datetime,
	groupid bigint,
	CONSTRAINT `t_group_foreignkey` FOREIGN KEY(groupid) 
	REFERENCES `t_group`(gid)
)ENGINE=InnoDB DEFAULT CHARSET=UTF8;

create table if not exists `t_person`(
	id	bigint	primary key auto_increment,
	name varchar(255),
	age int
);


You should do these steps:
	1. create database in MySql;
		DROP TABLE IF EXISTS `hd-jpa`.mybatis_user;
		CREATE TABLE `hd-jpa`.mybatis_user (
		  `id` int(11) NOT NULL AUTO_INCREMENT,
		  `name` varchar(255) DEFAULT NULL,
		  `age` int(11) DEFAULT NULL,
		  `hobby` varchar(500) DEFAULT NULL,
		  PRIMARY KEY (`id`)
		) ENGINE=InnoDB DEFAULT CHARSET=utf8;
		
	2. Assign table name to mybatis_user;
		@Select("SELECT * FROM mybatis_user WHERE id = #{id}")
		User queryById(@Param("id") int id);
	
	Spring Boot入门教程、使用Spring Boot+MyBatis访问数据库（CURD）注解版
		boot: 2.0.2.RELEASE, MyBatis: 1.3.2, MySQL: 6.0.6
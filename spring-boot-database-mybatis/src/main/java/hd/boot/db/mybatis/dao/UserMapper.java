package hd.boot.db.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import hd.boot.db.mybatis.entity.User;

@Mapper
public interface UserMapper {
	@Select("SELECT * FROM mybatis_user WHERE id = #{id}")
	User queryById(@Param("id") int id);

	@Select("SELECT * FROM mybatis_user")
	List<User> queryAll();

	@Insert({ "INSERT INTO mybatis_user(name,age,hobby) VALUES(#{name},#{age},#{hobby})" })
	int add(User user);

	@Delete("DELETE FROM mybatis_user WHERE id = #{id}")
	int delById(int id);

	@Update("UPDATE mybatis_user SET name=#{name},age=#{age},hobby=#{hobby} WHERE id = #{id}")
	int updateById(User user);
}

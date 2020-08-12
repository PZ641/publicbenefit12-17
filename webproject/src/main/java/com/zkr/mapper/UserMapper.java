package com.zkr.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.zkr.pojo.User;
@Repository
@Mapper
public interface UserMapper {

	//查询所有用户
	@Select("SELECT * FROM TEST.USER")
	public List<User> findUser();

	//根据ID查询用户
	@Select("SELECT * FROM TEST.USER WHERE id = #{id}")
	public User findUserById(int id);

	//插入用户信息
	@Insert("insert into TEST.USER"
			+ "(id, " +
			"username, " +
			"password, " +
			"status " +
			") values (#{user.id}, " +
			"#{user.username}, " +
			"#{user.password}, " +
			"#{user.status} " +
			") "
			)
	public int addUser(@Param("user")User user);

	//修改根据ID更新用户信息
	@Update("UPDATE TEST.USER SET username = #{user.username},password = #{user.password},status = #{user.status} WHERE id = #{user.id}")
	public int updateUser(@Param("user")User user);

	//删除用户信息
	@Delete("DELETE from TEST.USER where id = #{id}")
	public int deleteUser(int id);

	//根据用户名查找用户
	@Select("SELECT * FROM TEST.USER WHERE username = #{username}")
	public User login(String username);

}
package com.zkr.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.zkr.mapper.UserMapper;
import com.zkr.pojo.User;
import com.zkr.service.UserService;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

	//注入
	@Autowired
	private UserMapper userMapper;

	/**
	 * 用户登录的方法
	 */
	public User login(String username) {
		return userMapper.login(username);
	}

	public List<User> findAll() {
		return null;
	}

	public User findById(Long id) {
		return null;
	}

	public void create(User user) {

	}

	public void delete(Long id) {

	}

	public void update(User user) {

	}

	@Override
	public List<User> findUser() {
		System.out.println("UserServiceImpl findUser");
		return userMapper.findUser();
	}

	@Override
	public List<User> findByPage(int page, int size) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, size);
		return userMapper.findUser();
	}



	@Override
	public int addUser(User user) {
		int boolInt = user.getId();
		//判断数据库主键是否重复
		//    	System.out.println(boolInt);
		if(this.findUserById(boolInt) != null|| boolInt == 0)
		{
			return 0;
		}else {
			return userMapper.addUser(user);
		}
	}

	@Override
	public int updateUser(User user) {
		// TODO Auto-generated method stub
		return userMapper.updateUser(user);
	}

	@Override
	public int deleteUser(int id) {
		// TODO Auto-generated method stub
		return userMapper.deleteUser(id);
	}

	@Override
	public User findUserById(int id) {
		// TODO Auto-generated method stub
		return userMapper.findUserById(id);
	}



}

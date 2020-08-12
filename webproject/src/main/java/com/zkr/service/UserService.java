package com.zkr.service;

import java.util.List;

import com.zkr.pojo.User;

public interface UserService extends BaseService<User> {

	public User login(String username);

	public List<User> findUser();

	public List<User> findByPage(int page, int size);

	public int addUser(User user);

	public int updateUser(User user);

	public int deleteUser(int id);

	public User findUserById(int id);
}

package com.kaicom.jdbcsupport;

import java.util.List;

import com.kaicom.bean.User;

public interface UserDao {
	void addUser(User u);
	void deleteUser(Integer uid);
	void updateUser(User u);
	User getUser(Integer uid);
	List<User> getAllUser1();
	List<User> getAllUser2();
	int getTotal();
}

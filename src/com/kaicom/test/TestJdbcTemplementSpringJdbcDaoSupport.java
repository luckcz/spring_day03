package com.kaicom.test;

import java.lang.reflect.Field;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kaicom.bean.User;
import com.kaicom.jdbcsupport.UserDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/kaicom/jdbcsupport/applicationContext.xml")
public class TestJdbcTemplementSpringJdbcDaoSupport {
	@Resource(name = "userDao")
	private UserDao userDao ;
	@Test
	public void fun1(){
		User u = new User();
		u.setUname("王五");
		u.setUage(90);
		userDao.addUser(u);
	}
	
	@Test
	public void fun2(){
		userDao.deleteUser(3);
	}
	
	@Test
	public void fun3(){
		User u = new User();
		u.setUname("王五");
		u.setUage(90);
		u.setUid(2);
		userDao.updateUser(u);
	}
	
	@Test
	public void fun4(){
		System.out.println(userDao.getUser(2));
	}
	
	@Test
	public void fun5(){
		System.out.println(userDao.getTotal());
	}
	@Test
	public void fun6(){
		System.out.println(userDao.getAllUser1());
	}
	
	@Test
	public void fun7(){
		System.out.println(userDao.getAllUser2());
	}
	
	@Test
	public void fun8() throws InstantiationException, IllegalAccessException{
		User u = User.class.newInstance();
		//Field[] fields = u.getClass().getDeclaredFields();
		Field[] fields = User.class.getDeclaredFields();
		System.out.println(fields.length);
	}
}

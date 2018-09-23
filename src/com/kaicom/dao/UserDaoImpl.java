package com.kaicom.dao;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.kaicom.bean.User;
import com.mchange.v2.beans.BeansUtils;

public class UserDaoImpl implements UserDao{
	private JdbcTemplate jt ;
	public void addUser(User u) {
		String sql = "insert into user values (null,?,?)";
		int count = jt.update(sql, u.getUname(),u.getUage());
		if(count > 0){
			System.out.println("新增成功");
		}else{
			System.out.println("新增失败");
		}
	}

	public void deleteUser(Integer uid) {
		String sql = "delete from user where uid = ?";
		int count = jt.update(sql,uid);
		if(count > 0){
			System.out.println("删除成功");
		}else{
			System.out.println("删除失败");
		}
	}

	public void updateUser(User u) {
		String sql = "update user set uname = ? ,uage = ? where uid = ?";
		int count = jt.update(sql, u.getUname(),u.getUage(),u.getUid());
		if(count > 0){
			System.out.println("修改成功");
		}else{
			System.out.println("修改失败");
		}
	}

	public User getUser(Integer uid) {
		String sql = "select * from user where uid = ?";
		User u = jt.queryForObject(sql, new RowMapper<User>(){

			public User mapRow(ResultSet rs, int arg1) throws SQLException {
				User u = new User();
				u.setUid(rs.getInt("uid"));
				u.setUname(rs.getString("uname"));
				u.setUage(rs.getInt("uage"));
				return u ;
			}
			
		}, uid);
		if(null != u){
			System.out.println("查询用户成功");
		}else{
			System.out.println("查询用户失败");
		}
		return u ;
	}

	public List<User> getAllUser1() {
		String sql = "select * from user";
		List<User> list = jt.query(sql, new RowMapper<User>(){
			public User mapRow(ResultSet rs, int arg1) throws SQLException {
				User u = new User();
				u.setUid(rs.getInt("uid"));
				u.setUname(rs.getString("uname"));
				u.setUage(rs.getInt("uage"));
				return u ;
			}
			
		});
		return list ;
	}
	
	public List<User> getAllUser2() {
		String sql = "select * from user";
		List<Map<String, Object>> queryForList = jt.queryForList(sql);
		List<User> list = new ArrayList<User>();
		Field[] fields = User.class.getDeclaredFields();
		for(Map<String, Object> map : queryForList){
			User u = new User() ;
			for(Field field : fields){
				int mod = field.getModifiers();
				if(Modifier.isStatic(mod) || Modifier.isFinal(mod)){
					continue ;
				}
				field.setAccessible(true);
				try {
					field.set(u, map.get(field.getName()));
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
			list.add(u);
		}
		return list ;
	}

	public int getTotal() {
		String sql = "select count(*) from user";
		Integer count = jt.queryForObject(sql, Integer.class);
		return count ;
	}
	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}
}

package com.kaicom.test;

import java.beans.PropertyVetoException;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class TestJdbcTemplement {
	@Test
	public void fun1() throws PropertyVetoException{
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setDriverClass("com.mysql.jdbc.Driver");
		dataSource.setJdbcUrl("jdbc:mysql:///test_spring");
		dataSource.setUser("root");
		dataSource.setPassword("123456");
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource);
		String sql = "insert into user values (null,'ÀîËÄ',18)";
		jdbcTemplate.update(sql);
	}
}

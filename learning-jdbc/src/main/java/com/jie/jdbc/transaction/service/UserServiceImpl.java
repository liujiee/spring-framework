package com.jie.jdbc.transaction.service;

import com.jie.jdbc.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;


@Service
public class UserServiceImpl implements UserService {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	private DataSource dataSource;

	@Autowired
	public void setJdbcTemplate(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}


	@Override
	public void save(User user) throws Exception {
		jdbcTemplate.update("insert into \"user\"(name, age, sex) values (?, ?, ?)",
				new Object[]{user.getName(), user.getAge(), user.getSex()});

		throw new RuntimeException("aa");
	}

	@Override
	public User get(String name) throws Exception {
		//return jdbcTemplate.query("select * from user where name = ?", name, UserRowMapper.class);
		return null;
	}
}

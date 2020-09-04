package com.jie.jdbc.spring.service;

import com.jie.jdbc.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private JdbcTemplate jdbcTemplate;


	@Override
	public void save(User user) {
		jdbcTemplate.update("insert into \"user\"(name, age, sex) values (?, ?, ?)",
				new Object[]{user.getName(), user.getAge(), user.getSex()});
	}

	@Override
	public List<User> getUsers() {
		List<User> list = jdbcTemplate.query("SELECT * FROM \"user\"", new RowMapper<User>() {
			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new User(
						rs.getInt("id"),
						rs.getString("name"),
						rs.getInt("age"),
						rs.getString("sex")) ;
			}
		});
		return list;
	}
}

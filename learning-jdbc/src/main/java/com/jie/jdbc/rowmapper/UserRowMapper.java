package com.jie.jdbc.rowmapper;

import com.jie.jdbc.entity.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {
	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {

		return new User(rs.getInt("id"), rs.getString("name"), rs.getInt("age"), rs.getString("sex")) ;
	}
}

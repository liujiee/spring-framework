package com.jie.jdbc.spring2mybatis;

import com.jie.jdbc.entity.User;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

	//@Select("SELECT * FROM \"user\"")
	//	public List<User> listUser();
	@Select("SELECT * FROM \"user\" WHERE id = #{id}")
	public User select(Integer id);
}

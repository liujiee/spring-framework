package com.jie.jdbc.mybatis;

import com.jie.jdbc.entity.User;
import org.apache.ibatis.session.SqlSession;

/**
 * 参考链接： https://mybatis.org/mybatis-3/getting-started.html
 */
public class TestMybatis {


	public static void main(String[] args) {
		 testSelectUser();

//		testInsertUser();
	}


	public static void testInsertUser() {
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			User user = new User("mybatis-insert", 133, "sex");
			userMapper.insert(user);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}


	public static void testSelectUser() {
		SqlSession sqlSession = getSqlSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			User user = userMapper.select(1);
			System.out.println(user);
		} finally {
			sqlSession.close();
		}
	}

	public static SqlSession getSqlSession() {
		return MybatisUtils.getSqlSessionFactory().openSession();
	}




}

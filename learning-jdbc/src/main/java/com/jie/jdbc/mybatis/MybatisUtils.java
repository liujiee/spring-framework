package com.jie.jdbc.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.postgresql.Driver;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.Reader;

public class MybatisUtils {
	private final static SqlSessionFactory sqlSessionFactory;

	static {
		String resource = "mybatis/mybatis-config.xml";
		Reader reader = null;

		try {
			reader = Resources.getResourceAsReader(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}

		sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
	}

	public static SqlSessionFactory getSqlSessionFactory() {
//		return new SqlSessionFactoryBuilder().build(getConfiguration());
		return sqlSessionFactory;
	}



	private static Configuration getConfiguration() {



		Configuration configuration = new Configuration();
		configuration.setEnvironment(getEnvironment());
		configuration.addMapper(UserMapper.class);
		configuration.addLoadedResource("mybatis/UserMapper.xml");
		return configuration;
	}

	private static Environment getEnvironment() {
		Environment environment = new Environment("development", new JdbcTransactionFactory(), getDatasource());
		return environment;
	}


	private static DataSource getDatasource() {
		SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/test");
		dataSource.setDriverClass(Driver.class);
		dataSource.setUsername("postgres");
		dataSource.setPassword("123456");
		return dataSource;
	}
}

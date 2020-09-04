package com.jie.jdbc.spring2mybatis;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.postgresql.Driver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;

@Configuration
public class AppConfig {

	@Bean
	public DataSource dataSource() {
		SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/test");
		dataSource.setDriverClass(Driver.class);
		dataSource.setUsername("postgres");
		dataSource.setPassword("123456");
		return dataSource;
	}

	@Bean
	public SqlSessionFactoryBean sqlSessionFactory() {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource());
//		sqlSessionFactoryBean.setMapperLocations(new ClassPathResource("mybatis/UserMapper.xml"));
//		Configuration configuration = new Configuration();
//		configuration.getMapperRegistry().addMappers()
//		sqlSessionFactoryBean.setEnvironment();
		return sqlSessionFactoryBean;
	}
/*

	@Bean
	public MapperFactoryBean userMapper(SqlSessionFactory sqlSessionFactory) throws Exception {
		MapperFactoryBean mapperFactoryBean = new MapperFactoryBean();
		mapperFactoryBean.setMapperInterface(UserMapper.class);
		mapperFactoryBean.setSqlSessionFactory(sqlSessionFactory);
		return mapperFactoryBean;
	}
*/


	@Bean
	public MapperFactoryBean<UserMapper> userMapper(SqlSessionFactory sqlSessionFactory) throws Exception {
		MapperFactoryBean<UserMapper> mapperFactoryBean = new MapperFactoryBean<>(UserMapper.class);
		mapperFactoryBean.setSqlSessionFactory(sqlSessionFactory);
		return mapperFactoryBean;
	}



}

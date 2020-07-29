package com.jie.config;

import com.jie.dao.UserDao;
import com.jie.dao.UserDaoImpl;
import com.jie.imports.registrar.EnableRegistrarService;
import com.jie.imports.selector.EnableTestImportDao;
import com.jie.service.UserService;
import com.jie.service.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 *
 *  如果标加了 Import, Component, ImportResource, ComponentScan 或者有 @Bean 注解的方法 spring 會认定为 lite class，不会进行 cglib
 *  增强
 *  如果加了 @Configuration spring 会被认定为 full config class. 会对 AppConfig 进行 cglib 增强。注入 defaultListableBeanFactory
 *  调用 @Bean 注解的方法时，会先在 defaultListableBeanFactory 获取，获取不到才会 执行真实的方法
 *
 *  1. 通过 jps 平命令查询出 process id
 *  2. 执行以下命令从内存中得到 class 文件
 *  java -classpath "%JAVA_HOME%/lib/sa-jdi.jar" -Dsun.jvm.hotspot.tools.jcore.filter=sun.jvm.hotspot.tools.jcore.PackageNameFilter -Dsun.jvm.hotspot.tools.jcore.PackageNameFilter.pkgList=com.jie.config sun.jvm.hotspot.tools.jcore.ClassDump <processId>
 *
 *  Linux or MacOS 使用 $JAVA_HOME 替换 %JAVA_HOME%
 */
@Configuration
@ComponentScan("com.jie")
@EnableTestImportDao
@EnableRegistrarService
public class AppConfig {


	@Bean
	public UserService userService() {
		return new UserServiceImpl(userDao());
	}

	@Bean
	public UserDao userDao() {
		return new UserDaoImpl();
	}
}

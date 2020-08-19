package com.jie.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

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
 *	jdk 动态代理时  pkgList=com.sun.proxy
 *  Linux or MacOS 使用 $JAVA_HOME 替换 %JAVA_HOME%
 */

@Configuration
@ComponentScan("com.jie")
@EnableAspectJAutoProxy
public class AppConfig {
}

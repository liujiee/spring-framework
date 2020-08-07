package com.jie;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

public class Application {
	public static void main(String[] args) {

		Tomcat tomcat = new Tomcat();
		tomcat.setPort(8080);
		tomcat.addWebapp("/app", "E:\\opensource\\spring-framework\\learning-spring-webmvc\\src\\main");
/*		AnnotationConfigWebApplicationContext ac = new AnnotationConfigWebApplicationContext();
		ac.register(AppConfig.class);
		//ac.refresh();

		// Create and register the DispatcherServlet
		DispatcherServlet servlet = new DispatcherServlet(ac);
		ServletRegistration.Dynamic registration = tomcat.addServlet("app", servlet);
		registration.setLoadOnStartup(1);
		registration.addMapping("/");*/

		try {
			tomcat.start();
			tomcat.getServer().await();
		} catch (LifecycleException e) {
			e.printStackTrace();
		}
	}
}

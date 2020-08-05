package com.jie;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

public class Application {
	public static void main(String[] args) {

		Tomcat tomcat = new Tomcat();
		tomcat.setPort(8080);
		tomcat.addContext("/", "d:\\test_tomcat\\");
	/*	AnnotationConfigWebApplicationContext ac = new AnnotationConfigWebApplicationContext();
		ac.register(AppConfig.class);



		// Create and register the DispatcherServlet
		DispatcherServlet servlet = new DispatcherServlet(ac);
		Wrapper mvc = tomcat.addServlet("/", "dispatcherServlet", servlet);

		mvc.setLoadOnStartup(1);
		mvc.addMapping("/");*/

		try {
			tomcat.start();
			tomcat.getServer().await();
		} catch (LifecycleException e) {
			e.printStackTrace();
		}
	}
}

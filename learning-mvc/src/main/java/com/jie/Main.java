package com.jie;

import com.jie.config.AppConfig;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.Wrapper;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletException;
import java.io.File;

public class Main {

	public static void main(String[] args) throws LifecycleException, ServletException {

		String webAppDirLocation = "src/main/";
		Tomcat tomcat = new Tomcat();

		//Set Port #
		tomcat.setPort(8080);

		StandardContext ctx = (StandardContext) tomcat.addWebapp("/", new File(webAppDirLocation).getAbsolutePath());

		tomcat.start();
		tomcat.getServer().await();

	}
}

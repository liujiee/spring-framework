package com.jie.jdbc.spring;


import com.jie.jdbc.entity.User;
import com.jie.jdbc.spring.config.AppConfig;
import com.jie.jdbc.spring.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringJDBCTest {

	/**
     * =============================测试说明================================
	 *
	 * jdbc 使用基本流程如下
	 * 1. 加载驱动依赖， 以 postgresql 为例： compile group: 'org.postgresql', name: 'postgresql', version: '42.2.12'
	 * 2. 加载驱动程序 Class.forName("org.postgresql.Driver");
	 * 3. 创建数据连接对象，通过 DriverManager 类创建 Connection
	 * 		Connection conn = DriverManager.getConnection(url，username, password)
	 * 4. 创建 Statement 对象	. Statement smt = conn.createStatement();
	 * 5. 调用 Statement 对象的相关方法执行对应的 SQL 语句,
	 * 		* smt.executeUpdate(update...)
	 * 		* Result resultSet = smt.executeQuery(select...)
	 *
	 *
	 * @param args
     * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		UserService userService = (UserService) context.getBean("userService");

		for (User user : userService.getUsers()) {
			System.out.println(user);
		}
	}
}

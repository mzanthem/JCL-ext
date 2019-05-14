package io.github.mzanthem.runner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


/**
 * ApplicationRunner
 * 
 * @author MSH8244
 *
 */
@Component
@Order(2) // 数值越小，优先级越高
public class MyApplicationRunner implements ApplicationRunner {
	// public class MyApplicationRunner implements ApplicationRunner, Order {
	@Override
	public void run(ApplicationArguments args) {
		System.out.println("-------- MyApplicationRunner by Spring Boot");
		if (args != null) {
			String[] argArr = args.getSourceArgs();
			for (String s : argArr) {
				System.out.println("MyApplicationRunner:" + s);
			}
		}
		
		//加载所有启用的jar包
		System.out.println("-------- load jars from db which is enabled......");
		
	}
}
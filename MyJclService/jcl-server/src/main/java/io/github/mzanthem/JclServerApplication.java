package io.github.mzanthem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 参考
 * https://blog.csdn.net/winter_chen001/article/details/77249029
 * https://github.com/WinterChenS/springboot-mybatis-demo
 * 
 * 
 * @author MSH8244
 *
 */
@SpringBootApplication
@MapperScan("io.github.mzanthem.mapper")
public class JclServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(JclServerApplication.class, args);
	}
}

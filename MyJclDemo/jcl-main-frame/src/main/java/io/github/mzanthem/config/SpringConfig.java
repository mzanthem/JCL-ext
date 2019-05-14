package io.github.mzanthem.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource({ "classpath:spring/*.xml" })
public class SpringConfig {

}

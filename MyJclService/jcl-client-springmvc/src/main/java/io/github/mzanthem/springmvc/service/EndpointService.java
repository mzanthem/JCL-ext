package io.github.mzanthem.springmvc.service;

import java.lang.reflect.Method;

import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * https://stackoverflow.com/questions/5758504/is-it-possible-to-dynamically-set-requestmappings-in-spring-mvc
 * @author zan.ma
 *
 */
public interface EndpointService {

	void addMapping(String urlPath, RequestMethod requestMethod, Object handler, Method method);
	
	void removeMapping(String urlPath, RequestMethod requestMethod);
}

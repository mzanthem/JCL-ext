package io.github.mzanthem.springmvc.service.impl;

import java.lang.reflect.Method;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import io.github.mzanthem.springmvc.service.EndpointService;

@Service("endpointService")
public class EndpointServiceImpl implements EndpointService {

	@Autowired
	private RequestMappingHandlerMapping requestMappingHandlerMapping;
	
	
	/**
	 * isHandler
	 * @param beanType
	 * @return
	 */
	public boolean isHandler(Class<?> beanType) {
		return (AnnotatedElementUtils.hasAnnotation(beanType, Controller.class) ||
				AnnotatedElementUtils.hasAnnotation(beanType, RequestMapping.class));
	}
	/**
	 * add mapping
	 */
	@Override
	public void addMapping(String urlPath, RequestMethod requestMethod, Object handler, Method method) {
		// build requestMappingInfo
		RequestMappingInfo requestMappingInfo = RequestMappingInfo
	            .paths(urlPath)
	            .methods(requestMethod)
	            .produces(MediaType.APPLICATION_JSON_VALUE)
	            .build();
		// registerMapping
	    requestMappingHandlerMapping.
	            registerMapping(requestMappingInfo, handler, method
	            );
	}

	@Override
	public void removeMapping(String urlPath, RequestMethod requestMethod) {
		// build requestMappingInfo
		RequestMappingInfo requestMappingInfo = RequestMappingInfo
	            .paths(urlPath)
	            .methods(requestMethod)
	            .produces(MediaType.APPLICATION_JSON_VALUE)
	            .build();
		// unregisterMapping
		requestMappingHandlerMapping.unregisterMapping(requestMappingInfo);
	}
}

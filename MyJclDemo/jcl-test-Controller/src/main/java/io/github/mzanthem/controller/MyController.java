package io.github.mzanthem.controller;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@RestController
public class MyController {

    @Autowired
    private RequestMappingHandlerMapping handlerMapping;

    /***
     * Register controller methods to various URLs.
     */
    @PostConstruct
    public void init() throws NoSuchMethodException {

        /**
         * GET /simpleHandler is called invoke parametrizedHandler(String,
         * HttpServletRequest) method.
         */
        handlerMapping.registerMapping(
                RequestMappingInfo.paths("/simpleHandler").methods(RequestMethod.GET)
                .produces(MediaType.APPLICATION_JSON_VALUE).build(),
                this,
                // Method to be executed when above conditions apply (HTTP
                // method and URL are called)
                MyController.class.getDeclaredMethod("simpleHandler"));

        /**
         * GET /x/y/z/parametrizedHandler is called invoke
         * parametrizedHandler(String, HttpServletRequest) method.
         */
        handlerMapping.registerMapping(
                RequestMappingInfo.paths("/x/y/z/parametrizedHandler").methods(RequestMethod.GET)
                .produces(MediaType.APPLICATION_JSON_VALUE).build(),
                this,
                // Method to be executed when above conditions apply (HTTP
                // method and URL are called)
                MyController.class.getDeclaredMethod("parametrizedHandler", String.class));
    }

    // GET /simpleHandler
    public List<String> simpleHandler() {
        return Arrays.asList("simpleHandler called");
    }

    // GET /x/y/z/parametrizedHandler
    public ResponseEntity<List<String>> parametrizedHandler(
            @RequestParam(value = "param1", required = false) String param1) {
        return ResponseEntity.ok(Arrays.asList("parametrizedHandler called", param1));
    }
}
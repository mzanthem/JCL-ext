package io.github.mzanthem.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author zan.ma
 *
 */
@RequestMapping
@RestController
public class WelcomeController {

	@RequestMapping("/index")
	public String index() {
		System.out.println("index");
		return "welcome!";
	}
}

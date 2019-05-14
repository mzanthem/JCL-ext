package io.github.mzanthem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * test controller
 * @author zan.ma
 *
 */
@Controller
@RequestMapping("/testController")
public class TestController {
	
	/**
	 * test
	 * @return
	 */
	@RequestMapping("/test")
	@ResponseBody
	public Object test() {
		return "this is a test-controller";
	}
	
}

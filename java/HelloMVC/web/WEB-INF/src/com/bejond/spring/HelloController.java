package com.bejond.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.ModelMap;

@Controller
@RequestMapping("/hello")
public class HelloController {

	@RequestMapping(method = RequestMethod.GET)
	public String printHello (ModelMap model) {
		System.out.println("This is controller.");
		model.addAttribute("message", "Hello, this is Spring MVC Framework!");

		return "hello";
	}
}
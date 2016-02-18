package com.accenture.relationship;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Map<String, Object> model) {

		System.out.println("index() is executed!");

		model.put("title", "This is title");
		model.put("msg", "This is descr");
		
		return "index.html";
	}
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public  @ResponseBody String hello(Map<String, Object> model) {

		System.out.println("index() is executed!");

		model.put("title", "This is title");
		model.put("msg", "This is descr");
		
		return "index.html";
	}
}
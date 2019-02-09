package com.microservices.app.views;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/view")
public class ViewController {

	@RequestMapping(value="/Microservices" , method=RequestMethod.GET)
	public String Microservices (Model model) {
		return "Microservices";
	}
}

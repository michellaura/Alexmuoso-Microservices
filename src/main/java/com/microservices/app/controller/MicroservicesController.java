package com.microservices.app.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/microservices")
public class MicroservicesController {
	
	
	@RequestMapping(value="/menu", method=RequestMethod.GET)
	public String displayMicroservicesView (Model model) {

 		return "microservices_view";		
	}
}

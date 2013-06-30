package com.unnatii.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.unnatii.in.HomeController;

@Controller
public class TemplateController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class); 
		
	@RequestMapping(value="/admin/templates")
	public String templateMain()
	{
		logger.info("In template controller ");
		
		return "/admin/templates";
	}

}

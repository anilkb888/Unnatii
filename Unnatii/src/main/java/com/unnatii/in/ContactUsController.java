package com.unnatii.in;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.unnatii.in.model.Contact;


@Controller
public class ContactUsController {

	
	
	

	   @RequestMapping(value = "/contact", method = RequestMethod.GET)
	   public ModelAndView contact() {
	      return new ModelAndView("contact", "command", new Contact());
	   }
	   
	   @RequestMapping(value = "/addContact", method = RequestMethod.POST)
	   public String addStudent(@ModelAttribute("SpringWeb")Contact contact, 
	   ModelMap model) {
	      model.addAttribute("name", contact.getName());
	      model.addAttribute("email", contact.getEmail());
	      model.addAttribute("phone", contact.getTelephone());
	      model.addAttribute("description", contact.getDescription());
	      model.addAttribute("id", contact.getId());
	      
	      return "result";
	   }
	
}

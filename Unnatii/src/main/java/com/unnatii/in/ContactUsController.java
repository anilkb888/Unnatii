package com.unnatii.in;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.unnatii.in.model.Contact;
import com.unnatii.in.services.ContactService;


@Controller
public class ContactUsController {

		@Autowired
		private ContactService contactService;
	
	   @RequestMapping(value = "/contact", method = RequestMethod.GET)
	   public ModelAndView contact() {
	      return new ModelAndView("contact", "command", new Contact());
	   }
	   
	   @RequestMapping(value = "/addContact", method = RequestMethod.POST)
	   public ModelAndView addStudent(@ModelAttribute("SpringWeb")Contact contact, 
	   ModelMap model) {
		  
		   if(contact.getName() !="" && contact.getEmail() !="" && contact.getTelephone() !="" && contact.getDescription() !="")
		   {
					  contactService.addContact(contact);
					  model.addAttribute("name", contact.getName());
					 /* model.addAttribute("email", contact.getEmail());
					  model.addAttribute("phone", contact.getTelephone());
					  model.addAttribute("description", contact.getDescription());
					  model.addAttribute("id", contact.getId()); */
					  return new ModelAndView("thankyou");
					  //return "thankyou";
		   }		   
		   else
		   {
			   return new ModelAndView("contact", "command", new Contact());  
		   }
	   }
	
}

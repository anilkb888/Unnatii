package com.unnatii.in;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.unnatii.in.common.MailServer;
import com.unnatii.in.model.Contact;
import com.unnatii.in.services.ContactService;


@Controller
public class ContactUsController {

		@Autowired
		private ContactService contactService;
		
		@Autowired
		MailServer mailService ;
	
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
					  
					  mailService.sendMail("unnatiigss@gmail.com", "unnatiigss@gmail.com", "Enquiry From Web - "+ contact.getId(), 
					  "Name : "+ contact.getName() +"\n\nPhone Number : " + contact.getTelephone() +"\n\nDescription : " + contact.getDescription());
				        
				      //mailService.sendAlertMail("Exception occurred");
				        System.out.println("Name : "+ contact.getName() +"\n\nPhone Number : " + contact.getTelephone() +"\n\nDescription : " + contact.getDescription());
						
					 /* model.addAttribute("email", contact.getEmail());
					  model.addAttribute("phone", contact.getTelephone());
					  model.addAttribute("description", contact.getDescription());
					  model.addAttribute("id", contact.getId()); */
					  return new ModelAndView("thankyou");
					  
		   }		   
		   else
		   {
			   return new ModelAndView("contact", "command", new Contact());  
		   }
		 //  return "redirect:/index";
	   }
	   
	   
	   @RequestMapping(value = "/GetCncts", method = RequestMethod.GET)
	   public ModelAndView GetDtls() {
	      return new ModelAndView("GetContacts", "command", new Contact());
	   }
	   
	  // @RequestMapping(value = "/GetDetails", method = RequestMethod.POST)
	   @RequestMapping(value = "/GetDetails", method = RequestMethod.POST)
	   public String  GetDetails(Map<String, Object> map) {
		 System.out.println("hdss");
		    map.put("contact", new Contact());
	        map.put("contactList", contactService.listContact());

		  // List<Contact>   lst;
		   //lst= contactService.listContact();
		 /*  for(int i=0;i < lst.size() ; i++)
		   {
			 System.out.println(" "+ lst.get(i).getName());  
			 model.addAttribute("name",lst.get(0).getName());
		   }
		   return new ModelAndView("thankyou");
		   */
	   
	        return "GetContacts";
	   } 
	   
	   
	  /* @RequestMapping(value = "/GetDetails", method = RequestMethod.POST)
	   public ModelAndView  GetDetails(ModelMap model) {
			 System.out.println("hdss");
			// model.addAttribute("contact", new Contact());
			// model.addAttribute("contactList", contactService.listContact());

			  // List<Contact>   lst;
			   //lst= contactService.listContact();
			 /*  for(int i=0;i < lst.size() ; i++)
			   {
				 System.out.println(" "+ lst.get(i).getName());  
				 model.addAttribute("name",lst.get(0).getName());
			   }
			   return new ModelAndView("thankyou");
		   
			 //List employeeDetails = employeeService.getEmployeeDetails();
			 return new ModelAndView("/GetCncts", "contactList", contactService.listContact());
		       // return "GetContacts";
		   }*/
	   @RequestMapping("/delete/{contactId}")
	    public String deleteContact(@PathVariable("contactId")
	    Integer contactId) {
	 
	        contactService.removeContact(contactId);
	 
	        return "redirect:/GetCncts";
	    }

	
}

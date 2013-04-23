package com.unnatii.in;

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
	public ModelAndView addStudent(@ModelAttribute("SpringWeb")Contact contact,  ModelMap model) {

		if(contact.getName() !="" && contact.getEmail() !="" && contact.getTelephone() !="" && contact.getDescription() !="")
		{
			contactService.addContact(contact);
			model.addAttribute("name", contact.getName());

			mailService.sendMail("unnatiigss@gmail.com", "unnatiigss@gmail.com", "Enquiry From Web - "+ contact.getId(), 
					"Name : "+ contact.getName() +"\n\nPhone Number : " + contact.getTelephone() +"\n\nDescription : " + contact.getDescription());


			System.out.println("Name : "+ contact.getName() +"\n\nPhone Number : " + contact.getTelephone() +"\n\nDescription : " + contact.getDescription());

			/*model.addAttribute("email", contact.getEmail());*/

			return new ModelAndView("thankyou");				  
		}		   
		else
		{
			
			return new ModelAndView("contact", "command", new Contact());
			
		}

	}

	/*@RequestMapping(value = "/admin/listContact", method = RequestMethod.GET)
	public ModelAndView GetDtls() {

		return new ModelAndView("/admin/GetContacts", "command", new Contact());

	}*/



	@RequestMapping(value = "/admin/listContact", method = RequestMethod.GET)
	public String  GetDetails(Map<String, Object> map) {

		map.put("contact", new Contact());
		map.put("contactList", contactService.listContact());

		return "/admin/GetContacts";

	} 

	@RequestMapping("/admin/deleteContact/{contactId}")
	public String deleteContact(@PathVariable("contactId") Integer contactId) {

		contactService.removeContact(contactId);
		return "/admin/GetContacts";

	}

}

package com.unnatii.in;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

//import com.unnatii.in.model.Contact;
import com.unnatii.in.model.SpecSheet;
import com.unnatii.in.services.SpecService;


@Controller
public class SpecSheetController {

		@Autowired
		private SpecService specService;
	
	   @RequestMapping(value = "/enquiry", method = RequestMethod.GET)
	   public ModelAndView specsheet() {
	      return new ModelAndView("SpecSheet", "command", new SpecSheet());
	   }
	   
	   @RequestMapping(value = "/addSpecSheet", method = RequestMethod.POST)
	   public ModelAndView addspecsheet(@ModelAttribute("SpringWeb")SpecSheet spec, 
	   ModelMap model) {
		  System.out.println("Spec Name "+ spec.getFirstname());
		   if(spec.getFirstname() !="" && spec.getEmail() !="" && spec.getPhone() !="")
		   {
				specService.addSpec(spec);
				model.addAttribute("name", spec.getFirstname());
				return new ModelAndView("thankyou");
		   }		   
		   else
		   {
			   return new ModelAndView("SpecSheet", "command", new SpecSheet());  
		   }
	   }
	
}

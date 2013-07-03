package com.unnatii.admin;

import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.unnatii.in.HomeController;
import com.unnatii.in.model.Template;

@Controller
public class TemplateController  implements HandlerExceptionResolver{

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class); 
		
	@RequestMapping(value="/admin/templates")
	public ModelAndView templateMain()
	{
		logger.info("In template controller ");
		
		return new ModelAndView("/admin/templates", "template", new Template());
	}

	@RequestMapping(value = "/admin/addTemplates", method = RequestMethod.POST)
	public ModelAndView addProducts(@ModelAttribute(value="Template") Template template,BindingResult result,HttpSession session ) {
		 System.out.println("inside add Templates    " + template.getName()); 
		 
		 	ServletContext context = session.getServletContext();
	    	String realContextPath = context.getRealPath("/");
	        if(!result.hasErrors()){
	            FileOutputStream outputStream = null;
	            String filePath = System.getProperty("java.io.tmpdir") + "/" + template.getTemplateImage().getOriginalFilename();
	            String newFilePath = "D:\\uploadTest\\" + template.getTemplateImage().getOriginalFilename();
	            try {
	                outputStream = new FileOutputStream(new File(filePath));
	                outputStream.write(template.getTemplateImage().getFileItem().get());
	                outputStream.close();
	                
	                outputStream = new FileOutputStream(new File(newFilePath));
	                outputStream.write(template.getTemplateImage().getFileItem().get());
	                outputStream.close();
	                
	                System.out.println(realContextPath);
	                System.out.println("File name :" + template.getTemplateImage().getOriginalFilename());
	                System.out.println(filePath);
	                
	            } catch (Exception e) {
	                System.out.println("Error while saving file");
	                return new ModelAndView("/admin/templates");	
	            }
	            return new ModelAndView("/admin/success");	
	        }else{
	            return new ModelAndView("/admin/templates");	
	        }
	}

	
	@Override
	public ModelAndView resolveException(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3) {
		// TODO Auto-generated method stub
		return null;
	}
}

package com.unnatii.admin;

import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.unnatii.in.HomeController;
import com.unnatii.in.model.Contact;
import com.unnatii.in.model.Product;
import com.unnatii.in.model.ReplyContact;
import com.unnatii.in.model.ReplyQuote;
import com.unnatii.in.model.SpecSheet;
import com.unnatii.in.services.ProductsService;

@Controller
public class ProductController  implements HandlerExceptionResolver{

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class); 
	
	@Autowired
	private ProductsService productService;
 
	@RequestMapping(value = "/admin/product")
	public ModelAndView products() {
		logger.info("In product form page -- to add product");
		return new ModelAndView("/admin/products", "product", new Product());
	}
	
	@RequestMapping(value = "/admin/addProducts", method = RequestMethod.POST)
	public ModelAndView addProducts(@ModelAttribute(value="Product") Product product,BindingResult result,HttpSession session ) {
		 System.out.println("inside add products    " + product.getDescription()); 
		 
		 	ServletContext context = session.getServletContext();
	    	String realContextPath = context.getRealPath("/");
	        if(!result.hasErrors()){
	            FileOutputStream outputStream = null;
	            String filePath = System.getProperty("java.io.tmpdir")  + product.getFileData().getOriginalFilename();
	            String newFilePath = "F:\\Unnatti_Pro_01Jul\\Unnatii\\src\\main\\webapp\\resources\\images\\" + product.getFileData().getOriginalFilename();
	            String imagePath = "/unnatii/resources/images/" + product.getFileData().getOriginalFilename();
try {
	                outputStream = new FileOutputStream(new File(filePath));
	                outputStream.write(product.getFileData().getFileItem().get());
	                outputStream.close();
	                
	                outputStream = new FileOutputStream(new File(newFilePath));
	                outputStream.write(product.getFileData().getFileItem().get());
	                outputStream.close();
	                
	                System.out.println(realContextPath);
	                System.out.println("File name :" + product.getFileData().getOriginalFilename());
	                System.out.println(filePath);
	                
	                product.setImage(imagePath);
	                product.setFileData(null);
	                
	                productService.addProduct(product);               
	                
	                
	                
	                
	            } catch (Exception e) {
	                System.out.println("Error while saving file");
	                return new ModelAndView("/admin/product");	
	            }
	            return new ModelAndView("/admin/success");	
	        }else{
	            return new ModelAndView("/admin/product");	
	        }
	}

	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		logger.info("In handeler part ");
		
		 Map<Object, Object> model = new HashMap<Object, Object>();
	        if (ex instanceof MaxUploadSizeExceededException){
	            model.put("errors", "File size should be less then "+
	            ((MaxUploadSizeExceededException)ex).getMaxUploadSize()+" byte.");
	        } else{
	            model.put("errors", "Unexpected error: " + ex.getMessage());
	        }
	        model.put("product", new Product());
	        return new ModelAndView("/error/500", (Map) model);
	}

	@RequestMapping(value = "/admin/listProducts", method = RequestMethod.GET)
	public String  GetProduct(Map<String, Object> map) {
		 System.out.println("inside listproduct  ");
		 System.out.println("HeU  " + map);
		map.put("product", new Product());
		map.put("productList", productService.listProduct());
		 //System.out.println("contactname  " + productService.listProduct().get(0).getName());
		 //System.out.println("ID    " + productService.listProduct().get(0).getImage());
		 //System.out.println("getProductCode    " + productService.listProduct().get(0).getProductCode());
		return "/admin/listProducts";

	} 
	
	@RequestMapping("/admin/editProduct/{productId}")
	public ModelAndView editProductDtls(@PathVariable("productId") Integer productId,Map<String, Object> map) {
		System.out.println("ID  " + productId);
		
		 List<Product> listproduct = productService.listSpecificProduct(productId);
		 System.out.println("contactname  " + listproduct.get(0).getName());
		 System.out.println("ID    " + listproduct.get(0).getId());
		//map.put("contactSpecificList",listproduct );		
		
		 Product objProduct=listproduct.get(0);
		
		return new ModelAndView("/admin/products", "product", objProduct);

	}
	
	@RequestMapping("/admin/deleteProduct/{contactId}")
	public String deleteContact(@PathVariable("contactId") Integer productId) {

		productService.removeProduct(productId);
		return "/admin/listProducts";

	}
}

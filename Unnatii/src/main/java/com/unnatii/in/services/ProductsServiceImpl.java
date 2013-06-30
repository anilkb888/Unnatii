package com.unnatii.in.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unnatii.in.dao.ProductsDAO;
import com.unnatii.in.model.Product;

@Service
@Transactional
public class ProductsServiceImpl implements ProductsService {

	@Autowired
	private ProductsDAO productsDAO;
	
	@Required
	public void addProduct(Product product) {
		productsDAO.addProducts(product);
	}

	/*@Required
	public List<Contact> listContact() {

		return contactDAO.listContact();
	}
	
	@Required
	public List<Contact> listSpecificContact(Integer contactId)
	{
		return contactDAO.listSpecificContact(contactId);
	}
	
	
	@Required
	public void removeContact(Integer id) {
		contactDAO.removeContact(id);
	}*/
}

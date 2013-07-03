package com.unnatii.in.services;

import java.util.List;

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
	
	@Required
	public List<Product> listProduct() {

		return productsDAO.listProduct();
	}

	
	
	@Required
	public List<Product> listSpecificProduct(Integer productId)
	{
		return productsDAO.listSpecificProduct(productId);
	}
	
	
	@Required
	public void removeProduct(Integer id) {
		productsDAO.removeProduct(id);
	}
}

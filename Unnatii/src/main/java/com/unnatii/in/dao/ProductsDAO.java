package com.unnatii.in.dao;

import java.util.List;


import com.unnatii.in.model.Product;

public interface ProductsDAO {
	
	public void addProducts(Product product);
	public List<Product> listProduct();
	
	public void removeProduct(Integer id);
	public List<Product> listSpecificProduct(Integer contactId);
	
	
}
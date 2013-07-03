package com.unnatii.in.services;

import java.util.List;

import com.unnatii.in.model.Product;

public interface ProductsService {
	
	public void addProduct(Product product);
	public List<Product> listProduct();
	
	public void removeProduct(Integer id);
	public List<Product> listSpecificProduct(Integer productId);
}

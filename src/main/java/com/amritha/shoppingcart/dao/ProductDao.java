package com.amritha.shoppingcart.dao;

import java.util.List;

import com.amritha.shoppingcart.model.Product;

public interface ProductDao {
	List<Product> list();
	void saveProduct(Product product);
	void deleteProduct(Product product,int id);
	Product updateProduct(Product product,int id);
	Product getproductbyid(int id);
}


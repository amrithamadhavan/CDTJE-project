package com.amritha.shoppingcart.dao;
import java.util.List;
import com.amritha.shoppingcart.model.Category;
import com.amritha.shoppingcart.model.Product;
public interface CategoryDao {
	public List<Category> listcategories();
	public void saveCategory(Category category);
	public List<Product> getProducts(int id);
	public void deletecategory(Category category, int id);
	public Category updatecategory(Category category, int id);
}

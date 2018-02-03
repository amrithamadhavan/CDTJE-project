package com.amritha.shoppingcart.dao;

import java.util.List;
import com.amritha.shoppingcart.model.Category;
import com.amritha.shoppingcart.model.Product;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository("CategoryDAO")
public class CategoryDaoImpl implements CategoryDao{
	@Autowired
	private SessionFactory sessionFactory;

	public CategoryDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;}
	@Transactional
	public List<Category> listcategories() {
		@SuppressWarnings("unchecked")
		List<Category> listcategory = (List<Category>) sessionFactory.getCurrentSession().createCriteria(Category.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		//System.out.println(listProduct);
		return listcategory;
	}
	@Override
	@Transactional
	public void saveCategory(Category category) {
		sessionFactory.getCurrentSession().saveOrUpdate(category);
		
	}
	@Transactional
	
	public void deletecategory(Category category, int id) {
		category.setId(id);
		sessionFactory.getCurrentSession().delete(category);
	}
	@Transactional
	public Category updatecategory(Category category, int id)
	{
		
			category.setId(id);
			category=(Category)sessionFactory.getCurrentSession().get(category.getClass(),id);
			//System.out.println(product.getCost());
			return category;
		
	}
	
	
	@Transactional
	public List<Product> getProducts(int id){
	
		return sessionFactory.getCurrentSession().createQuery("from Product where CATEGORY_ID='"+id+"'",Product.class).getResultList();
	}
	}

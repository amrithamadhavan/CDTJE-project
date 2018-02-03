package com.amritha.shoppingcart.dao;



import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.amritha.shoppingcart.model.Category;
import com.amritha.shoppingcart.model.Product;
@Repository("productDAO")
public class ProductDaoImpl implements ProductDao {
	@Autowired
	private SessionFactory sessionFactory;

	public ProductDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Transactional
	public List<Product> list() {
		@SuppressWarnings("unchecked")
		List<Product> listProduct = (List<Product>) sessionFactory.getCurrentSession().createCriteria(Product.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		//System.out.println(listProduct);
		return listProduct;
	}
	@Override
	@Transactional
	public void saveProduct(Product product) {
		sessionFactory.getCurrentSession().saveOrUpdate(product);
		
	}
	@Transactional
	public void deleteProduct(Product product,int id)
	{
		product.setId(id);
		sessionFactory.getCurrentSession().delete(product);
	}
	@Transactional
	public Product updateProduct(Product product,int id)
	{
		product.setId(id);
		product=(Product)sessionFactory.getCurrentSession().get(product.getClass(),id);
		//System.out.println(product.getCost());
		return product;
	}
	@Transactional
	public Product getproductbyid(int id)
	{
		
			Product product=new Product();
			product=(Product)sessionFactory.getCurrentSession().get(product.getClass(),id);
			//System.out.println(product.getCost());
			return product;
		
	}
}


package com.amritha.shoppingcart.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.amritha.shoppingcart.model.Cart;
import com.amritha.shoppingcart.model.CartItems;


@Repository("cartitemsDAO")
@Transactional
public class CartItemsDaoImpl implements CartItemsDao{
	@Autowired
	private SessionFactory sessionFactory;
	public CartItemsDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
@Override
@Transactional
	public void savecartitems(CartItems cartitems) {
		Session session = sessionFactory.getCurrentSession();
		
		session.saveOrUpdate(cartitems);
		
		
	}
public CartItems getcartitembyproductid(int id) {
	 try {
			return sessionFactory.getCurrentSession().createQuery("from CartItems where PRODUCT_ID='"+id+"'",CartItems.class).getSingleResult();}
		 catch(Exception ex)
			{
			 System.out.println(ex);
			 System.out.println("error");return null;}
}
}

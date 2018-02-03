package com.amritha.shoppingcart.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.amritha.shoppingcart.model.Cart;
import com.amritha.shoppingcart.model.CartItems;
import com.amritha.shoppingcart.model.Category;
import com.amritha.shoppingcart.model.Product;
import com.amritha.shoppingcart.model.User;

@Repository("cartdao")
@Transactional
public class CartDaoImpl implements CartDao{
	@Autowired
	private SessionFactory sessionFactory;
	public CartDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
@Override
 public List<CartItems> listcartitems(int id)
 {   Cart cart=new Cart();
 
 sessionFactory.getCurrentSession().createQuery("from Cart where USER_ID='"+id+"'",Cart.class).getResultList();
	
	cart.getCartitems();
	return cart.getCartitems();
 }
@Transactional
public Cart saveintocart(Cart cart)
{ 
	Session session = sessionFactory.getCurrentSession();
	//Transaction transaction=session.beginTransaction();
	session.persist(cart);
	return cart;
}
@Transactional
public void saveorupdatecart(Cart cart)
{ 
	Session session = sessionFactory.getCurrentSession();
	//Transaction transaction=session.beginTransaction();
	session.saveOrUpdate(cart);
	
}@Transactional
public void deletecart_cartitem(int cartitemid) {
	Session session = sessionFactory.getCurrentSession();
	session.delete("cart_cartitems", cartitemid);
}
@Transactional
public Cart getcartbyuserid(int uid){
    try {
	return sessionFactory.getCurrentSession().createQuery("from Cart where USER_ID='"+uid+"'",Cart.class).getSingleResult();}
 catch(Exception ex)
	{return null;}
}
/*@Transactional
public Cart getcartbyuserid(int uid) {
	// TODO Auto-generated method stub
	User user=new User();
	
	Cart cart=new Cart();
	Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Cart.class);
	cart= (Cart) criteria.add(Restrictions.eq("user_id", uid)) .uniqueResult();
	   
			
	return cart;
}*/

}
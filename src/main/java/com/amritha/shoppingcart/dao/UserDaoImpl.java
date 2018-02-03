package com.amritha.shoppingcart.dao;
import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.amritha.shoppingcart.model.Product;
import com.amritha.shoppingcart.model.User;

@Repository("userDao")
@Transactional
public class UserDaoImpl implements UserDao {
	@Autowired
	private SessionFactory sessionFactory;

	public UserDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	
	public void saveUserwithaddress(User user) {
		Session session = sessionFactory.getCurrentSession();
		//Transaction transaction=session.beginTransaction();
		session.saveOrUpdate(user);
		//user=getuserbyid(user.getId());
		//transaction.commit();
		
	}
	@Override
	@Transactional
	
	public User saveUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		//Transaction transaction=session.beginTransaction();
		user.setRole("ROLE_USER");
		user.setEnabled("TRUE");
		session.persist(user);
		//transaction.commit();
		return user;
	}
	@Transactional
	public User getuserbyid(int id)
	{   User user=new User();
		user.setId(id);
		user=(User)sessionFactory.getCurrentSession().get(user.getClass(),id);
		//System.out.println(product.getCost());
		return user;
	}

	@Override
	@Transactional
	public User getuserbyname(String uname) {
		// TODO Auto-generated method stub
		User user=new User();
		/*//user=(User)sessionFactory.getCurrentSession().get(user.getClass(),);
		//System.out.println(user.getId());
		//int id=user.getId();
		return sessionFactory.getCurrentSession().createQuery("select id from User where uname='"+uname+"'");
		//query.setParameter("uname", uname);
		/*int id=user.getId();
		System.out.println(user.getId());
		return id;*/
	// return id;*/
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
		user= (User) criteria.add(Restrictions.eq("uname", uname)) .uniqueResult();
		   
				int id=user.getId();                        
		System.out.println(id);
		return user;
	}
}

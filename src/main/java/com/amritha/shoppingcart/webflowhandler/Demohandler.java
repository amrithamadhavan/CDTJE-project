package com.amritha.shoppingcart.webflowhandler;

import java.security.Principal;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;

import com.amritha.shoppingcart.dao.UserDao;
import com.amritha.shoppingcart.model.Address;
import com.amritha.shoppingcart.model.User;

@Component("demohandler")
public class Demohandler {
	@Autowired
	private UserDao userDAO;
	@Autowired
	private SessionFactory sessionFactory;
@Autowired
HttpServletRequest request;
//Principal user;
	public User initFlow(){
		System.out.println("hiiii00");
		String uname = request.getUserPrincipal().getName();
		User user1 = userDAO.getuserbyname(uname);
		System.out.println("hiiii11");
		System.out.println(user1.getEmail());
		return  user1;
		
		//return new User();
	}
	public String validateDetails(User user,MessageContext messageContext){
		
		String status = "success";
		System.out.println("hiiii");
		return status;
}
public String getDetails(int id,MessageContext messageContext){
		
Address address=new Address();
//address=(Address)sessionFactory.getCurrentSession().get(address.getClass(),id);
return "success";
}
	
}
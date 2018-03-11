package com.amritha.shoppingcart.webflowhandler;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;

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
public String getDetails(MessageContext messageContext){
		
//Address address=new Address();
//address=(Address)sessionFactory.getCurrentSession().get(address.getClass(),id);
return "success";
}
public String newaddressinstance(){
	
	Address address=new Address();
	//address=(Address)sessionFactory.getCurrentSession().get(address.getClass(),id);
	return "address";
	}
	public String saveaddress(User user,Address address,MessageContext messageContext) {
	  
		user=userDAO.getuserbyid(user.getId());
		System.out.println("user fetched");
		//List<Address> addresses=new ArrayList<Address>();
		List<Address> addresses= user.getAddresses();
		System.out.println("got addresses");
		addresses.add(address);
		System.out.println("new address added");
		user.setAddresses(addresses);
		System.out.println("address set");
		userDAO.saveUserwithaddress(user);
		System.out.println("address saved");
		return "success";
	}
}
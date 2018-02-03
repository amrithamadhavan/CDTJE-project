package com.amritha.shoppingcart.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.amritha.shoppingcart.dao.CartDao;
import com.amritha.shoppingcart.dao.CartItemsDao;
import com.amritha.shoppingcart.dao.CategoryDao;
import com.amritha.shoppingcart.dao.ProductDao;
import com.amritha.shoppingcart.dao.UserDao;
import com.amritha.shoppingcart.model.Cart;
import com.amritha.shoppingcart.model.CartItems;
import com.amritha.shoppingcart.model.Product;
import com.amritha.shoppingcart.model.User;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired(required = true)
	private ProductDao productDAO;
	@Autowired
	HttpServletRequest request;
	@Autowired
	private CategoryDao categoryDAO;
	@Autowired
	private CartItemsDao cartitemsDAO;
	@Autowired
	private CartDao cartDAO;

	@Autowired
	private UserDao userDAO;
	
	@RequestMapping("/viewproduct/{id}")
	public String displayproductdetails(@PathVariable("id") int id, Model model) {
		Product product = productDAO.getproductbyid(id);
		model.addAttribute("product", product);

		model.addAttribute("cartitems", new CartItems());
		return "productdescription";
	}

	@RequestMapping("/product")
	public String productdetails() {
		return "userdatatable";
	}
	@RequestMapping("/deletecart")
	public String deletecart(Principal user)
	{String uname = user.getName();
	User user1 = userDAO.getuserbyname(uname);
	Cart cart=cartDAO.getcartbyuserid(user1.getId());
	cart.setCartitems(new ArrayList<CartItems>());
	cart.setGrandtotal(0);
	cartDAO.saveorupdatecart(cart);
	new ArrayList<CartItems>();
	//return "index";
	//return "payment";
	return "checkout";
	}
	@RequestMapping("/existing")
	public String showaddress(Principal user,Model model)
	{
		String uname = user.getName();
		System.out.println(uname);
		User user1 = userDAO.getuserbyname(uname);
		model.addAttribute("addresses",user1.getAddresses());
		return "listaddress";
	}
@RequestMapping("/cart")
public String cart(Principal user, Model model)
{
	String uname = user.getName();
	System.out.println(uname);
	User user1 = userDAO.getuserbyname(uname);
	//System.out.println(userid);
	Cart cart;
	cart = cartDAO.getcartbyuserid(user1.getId());
	model.addAttribute("cart",cart);
	model.addAttribute("cartitemslist", cart.getCartitems());
	return "listcartitems";

}
	@RequestMapping("/addtocart/{id}")
	public String savetocartitems(@ModelAttribute("cartitems") CartItems cartitems, @PathVariable("id") int id,
			Principal user, Model model) {
		
		
		
		
		String uname = user.getName();
		System.out.println(uname);
		User user1 = userDAO.getuserbyname(uname);
		//System.out.println(userid);
		Cart cart;
		if ((cart = cartDAO.getcartbyuserid(user1.getId())) == null) {
			cart = new Cart();
			cart.setUser(user1);
            
			cart = cartDAO.saveintocart(cart);
		}

		// int cartid=cart.getId();
		List<CartItems> itemsincart;
		if ((cart.getCartitems()) == null) {
			itemsincart = new ArrayList<CartItems>();
			cart.setGrandtotal(0);
		} else {
			itemsincart = cart.getCartitems();
			
			
		}
		int count=0;
		//Iterator<CartItems> iterator = itemsincart.iterator();
		
		for(CartItems items:itemsincart) {
			System.out.println(items.getProduct().getPname());
			if(items.getProduct().getId()==id)
			{  
				items.setQuantity(items.getQuantity()+cartitems.getQuantity());
			    int cost=Integer.parseInt(items.getProduct().getCost());
			    items.setSubtotal(items.getQuantity()*cost);
				
			    cart.setCartitems(itemsincart);
			    cart.setGrandtotal((cartitems.getQuantity()*cost)+cart.getGrandtotal());
				cartDAO.saveorupdatecart(cart);
				count=1;
				break;
			}
		}
		
		if(count==0) {
		// cart.setUser(user1);
			
			Product product = productDAO.getproductbyid(id);
			cartitems.setProduct(product);
			int cost=Integer.parseInt(cartitems.getProduct().getCost());
			
			cartitems.setSubtotal(cartitems.getQuantity()*cost);
			
			
			itemsincart.add(cartitems);
			cart.setGrandtotal(cart.getGrandtotal()+cartitems.getSubtotal());
		cart.setCartitems(itemsincart);
		
		cartDAO.saveorupdatecart(cart);
		}
		
		model.addAttribute("cart",cart);
		model.addAttribute("cartitemslist", itemsincart);
		return "listcartitems";
	}
}
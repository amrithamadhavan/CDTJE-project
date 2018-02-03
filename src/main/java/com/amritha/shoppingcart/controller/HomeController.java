package com.amritha.shoppingcart.controller;
import java.util.ArrayList;
import java.util.List;
//import java.io.*;
import java.util.Map;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.amritha.shoppingcart.dao.CategoryDao;
import com.amritha.shoppingcart.dao.ProductDao;
import com.amritha.shoppingcart.dao.UserDao;
import com.amritha.shoppingcart.model.Address;
import com.amritha.shoppingcart.model.Category;
import com.amritha.shoppingcart.model.Product;
import com.amritha.shoppingcart.model.User;


@Controller

public class HomeController {
	@Autowired(required = true)
	private ProductDao productDAO;
	@Autowired(required = true)
	private UserDao userDao;
    @Autowired 
    private CategoryDao categoryDAO;
	@RequestMapping("/")
	public String setUpForm(Map<String, Object> map) {

		return "index";
	}
    
	 
	  @RequestMapping("/index")
	  public String loginForm(Map<String, Object> map) {
	  
	  return "register"; }
	 
	
	  @RequestMapping("/register")  
	    public ModelAndView showform(){  
	         //command is a reserved request attribute name, now use <form> tag to show object data  
	        return new ModelAndView("register","uDemo",new User());  
	    } 
	  @RequestMapping(value={"/login"},method = { RequestMethod.GET, RequestMethod.POST })
	  public String login(Model model)
	  {
		  model.addAttribute("user",new User());
		  return "login";
	  }
	  @RequestMapping("/logout")
	  public String logout()
	  {
		  return "/";
	  }
	  @RequestMapping("/test123")
		public @ResponseBody List<Product> listAllUsers() {
			System.out.println("hello");
			return productDAO.list();

		}
		
		@RequestMapping("/testforcategory")
		public @ResponseBody List<Category> listAllcategories() {
			System.out.println("hello");
			return categoryDAO.listcategories();

		}
		@RequestMapping("/ajaxsearch/{id}")
		public @ResponseBody List<Product> searchajax(@ModelAttribute("product") Product product, @PathVariable("id") int id) {
		    //id=product.getCategory().getId();
		    System.out.println(id);
			List<Product> productlist=categoryDAO.getProducts(id);
			return productlist;
		}
   /*  @RequestMapping("/Login")
     public String loginform(@ModelAttribute("user") User user,Model model)
     {
    	 model.addAttribute("categorylist", categoryDAO.listcategories());
    	 model.addAttribute("product", new Product()); 
    	return "datatable"; 
     }*/
	
	@RequestMapping("/registration")
	public String save(@ModelAttribute("uDemo") @Validated User uDemo,BindingResult bindingResult,Model model)
	{
		 if (bindingResult.hasErrors()) {
	         return "register";
	      }
		uDemo=userDao.saveUser(uDemo);
		model.addAttribute("address", new Address());
		model.addAttribute("user",uDemo);
		return "address";
		
	}
	@RequestMapping("/address/{id}")
	public String gotoaddress(@ModelAttribute("address") Address address,@PathVariable("id") int id,Model model)
	{
		User user=userDao.getuserbyid(id);
		model.addAttribute("user", user);
		return "address";
		
	}
	@RequestMapping("/setaddress/{id}")
	public String saveaddress(@ModelAttribute("address") @Validated Address address,BindingResult bindingResult,@PathVariable("id") int id,Model model)
	{
		 if (bindingResult.hasErrors()) {
	         return "address";
	      }
		
		User user=userDao.getuserbyid(id);
		//List<Address> addresses=new ArrayList<Address>();
		List<Address> addresses= user.getAddresses();
		addresses.add(address);
		user.setAddresses(addresses);
		userDao.saveUserwithaddress(user);
		model.addAttribute("user", user);
		return "extraaddress";
	}
	
	/* @RequestMapping("/Product")
	  public String productForm(Model model) {
		// List<Category> categorylist=categoryDAO.listcategories()
		model.addAttribute("product", new Product());
		  model.addAttribute("categorylist", categoryDAO.listcategories());
		  return "datatable";
	 }*/
	  
	
	
	/* @RequestMapping("/Product")
	  public ModelAndView productForm() {
	  
	  return new ModelAndView("Product","product",new Productpojo()); }*/
	/*@RequestMapping("/registration")
	public String regFormSubmit(HttpServletRequest req, HttpServletResponse res) {
		String fname = req.getParameter("fname");
		String lname = req.getParameter("lname");
		String email = req.getParameter("email");
		String uname = req.getParameter("uname");
		String pwd = req.getParameter("pwd");
		String mobno = req.getParameter("mobno");
        
		User uDemo = new User();

		uDemo.setFname(fname);
		uDemo.setLname(lname);
		uDemo.setEmail(email);
		uDemo.setUname(uname);
		uDemo.setPwd(pwd);
		uDemo.setMobno(mobno);
		//System.out.println(mobno);
		userDao.saveUser(uDemo);
		return "register";
	}*/
	
}

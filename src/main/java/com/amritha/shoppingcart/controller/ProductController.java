package com.amritha.shoppingcart.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.amritha.shoppingcart.dao.CartDao;
import com.amritha.shoppingcart.dao.CategoryDao;
import com.amritha.shoppingcart.dao.ProductDao;
import com.amritha.shoppingcart.dao.UserDao;
import com.amritha.shoppingcart.model.Cart;
import com.amritha.shoppingcart.model.CartItems;
import com.amritha.shoppingcart.model.Category;
import com.amritha.shoppingcart.model.Product;
import com.amritha.shoppingcart.model.User;

@Controller
@RequestMapping("/admin")
public class ProductController {
	@Autowired(required = true)
	private ProductDao productDAO;
	@Autowired
	HttpServletRequest request;
	@Autowired
	private CategoryDao categoryDAO;
	@Autowired
	private UserDao userDAO;
	@Autowired
	private CartDao cartDAO;
	@RequestMapping("/addcategory")
	public String categoryform(Model model) {
		model.addAttribute("category", new Category());
		return "Categoryform";
	}

	@RequestMapping("/savecategory")
	public String savecategory(@ModelAttribute("category") @Validated Category category,BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			
	         return "Categoryform";
	      }
		categoryDAO.saveCategory(category);

		// request.getServletContext().setAttribute("product", product);
		/*
		 * ModelAndView model = new ModelAndView(); model.addObject("productList",
		 * this.productDAO.list()); model.setViewName("datatable");
		 */
		model.addAttribute("categorylist", this.categoryDAO.listcategories());

		model.addAttribute("productList", this.productDAO.list());
		model.addAttribute("product", new Product());
		return "Categoryform";

	}
	
	@RequestMapping("/deletecategory/{id}")
	public ModelAndView deleteproduct(@ModelAttribute("category") Category category, @PathVariable("id") int id) {

		categoryDAO.deletecategory(category, id);
		ModelAndView model = new ModelAndView();
		model.addObject("categorylist", categoryDAO.listcategories());
		
		model.setViewName("Categoryform");
		return model;

	}
	
	@RequestMapping("/updatecategory/{id}")
	public String updatecategory(@ModelAttribute("category") Category category, @PathVariable("id") int id,
			Model model) {

		category = categoryDAO.updatecategory(category, id);
		// System.out.println(product.getPname());
		// System.out.println(product.getCost());
		// ModelAndView model = new ModelAndView();
		model.addAttribute("categorylist", categoryDAO.listcategories());
		model.addAttribute("categoryList", category);
		
		return "updatecategory";

	}

	@RequestMapping("/editcategory")
	public String editsavecategory(@ModelAttribute("category") @Validated Category category,BindingResult bindingResult, Model model) {
		// System.out.println(product.getPname());
		// System.out.println(product.getCost());
		 if (bindingResult.hasErrors()) {
			// model.addAttribute("categorylist", categoryDAO.listcategories());
			// model.addAttribute("productList", product);
	         return "updatecategory";
	      }
		categoryDAO.saveCategory(category);

		// ModelAndView model = new ModelAndView();
		//model.addAttribute("categorylist", this.categoryDAO.listcategories());
		//model.addAttribute("productList", this.productDAO.list());
		// model.setViewName("datatable");
		return "Categoryform";

	}
	@RequestMapping("/categorysearch")
	public String categorysearchform(@ModelAttribute("category") Product category,Model model)
	{  
		model.addAttribute("categorylist", this.categoryDAO.listcategories());
		model.addAttribute("productList", this.productDAO.list());
		return "searchbycatg";
	}
	
	
	

	
	@RequestMapping("/searchproduct")
	public String searchproducts(@ModelAttribute("category") Product category,Model model)
	{
		//System.out.println(category.getCategory().getId());
		//int id=category.getCategory().getId();
		//List<Product> productlist=categoryDAO.getProducts(id);
		 model.addAttribute("catid", category.getCategory().getId());
		model.addAttribute("categorylist", this.categoryDAO.listcategories());
		model.addAttribute("productList", this.productDAO.list());
		
		return "searchbycatg";
	}

	
	
	
	@RequestMapping("/addprodct")
	public String saveProduct(@ModelAttribute("product") @Validated Product product,BindingResult bindingResult,Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("categorylist", categoryDAO.listcategories());
	         return "datatable";
	      }
		productDAO.saveProduct(product);
		request.getServletContext().setAttribute("product", product);
		// ModelAndView model = new ModelAndView();
		model.addAttribute("categorylist", categoryDAO.listcategories());
		model.addAttribute("productList", this.productDAO.list());

		// model.setViewName("datatable");
		return "datatable";

	}

	

	@RequestMapping("/dispajax")
	public String ajaxdisplay(Model model) { // System.out.println("hello");
		model.addAttribute("categorylist", categoryDAO.listcategories());
		model.addAttribute("productList", this.productDAO.list());
		model.addAttribute("product", new Product());
		return "datatable";
	}

	@RequestMapping("/display")
	public ModelAndView displayProduct(@ModelAttribute("product") Product product) {
		ModelAndView model = new ModelAndView();
		model.addObject("productList", this.productDAO.list());
		model.setViewName("Product");
		return model;
	}

	@RequestMapping("/deleteproduct/{id}")
	public ModelAndView deleteproduct(@ModelAttribute("product") Product product, @PathVariable("id") int id) {

		productDAO.deleteProduct(product, id);
		ModelAndView model = new ModelAndView();
		model.addObject("categorylist", categoryDAO.listcategories());
		model.addObject("productList", this.productDAO.list());
		model.setViewName("datatable");
		return model;

	}

	@RequestMapping("/updateproduct/{id}")
	public String updateproduct(@ModelAttribute("product") Product product, @PathVariable("id") int id,
			Model model) {

		product = productDAO.updateProduct(product, id);
		// System.out.println(product.getPname());
		// System.out.println(product.getCost());
		// ModelAndView model = new ModelAndView();
		model.addAttribute("categorylist", categoryDAO.listcategories());
		model.addAttribute("productList", product);
		/*
		 * model.setViewName("update" + "product");
		 */
		return "updateproduct";

	}

	@RequestMapping("/editprodct")
	public String editsaveProduct(@ModelAttribute("product") @Validated Product product,BindingResult bindingResult, Model model) {
		// System.out.println(product.getPname());
		// System.out.println(product.getCost());
		 if (bindingResult.hasErrors()) {
			 model.addAttribute("categorylist", categoryDAO.listcategories());
			 model.addAttribute("productList", product);
	         return "updateproduct";
	      }
		productDAO.saveProduct(product);

		// ModelAndView model = new ModelAndView();
		model.addAttribute("categorylist", this.categoryDAO.listcategories());
		model.addAttribute("productList", this.productDAO.list());
		// model.setViewName("datatable");
		return "datatable";

	}

	@RequestMapping("/uploadform")
	public ModelAndView uploadForm() {
		return new ModelAndView("uploadform");
	}
	
	@RequestMapping(value = "savefile", method = RequestMethod.POST)
	public String saveimage(@ModelAttribute("product") Product product, @RequestParam CommonsMultipartFile file,
			Model model, HttpSession session) throws Exception {
		product = (Product) request.getServletContext().getAttribute("product");
		ServletContext context = session.getServletContext();
		String path = context.getRealPath("/resources/images");
		String filename = Integer.toString(product.getId());

		System.out.println(path + " " + filename);

		byte[] bytes = file.getBytes();
		BufferedOutputStream stream = new BufferedOutputStream(
				new FileOutputStream(new File(path + File.separator + filename + ".jpg")));
		stream.write(bytes);
		stream.flush();
		stream.close();
		model.addAttribute("categorylist", this.categoryDAO.listcategories());
		model.addAttribute("productList", this.productDAO.list());

		return "datatable";
	}

}

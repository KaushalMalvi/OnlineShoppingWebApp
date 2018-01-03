package com.ksm.OnlineShoppingTest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ksm.ShoppingBackend.dao.CategoryDAO;
import com.ksm.ShoppingBackend.dao.ProductDAO;
import com.ksm.ShoppingBackend.dto.Category;
import com.ksm.ShoppingBackend.dto.Product;

@Controller
public class PageController {

	private static final Logger logger = LoggerFactory.getLogger(PageController.class);
	
	@Autowired 
	CategoryDAO categoryDAO;
	
	@Autowired
	ProductDAO productDAO;
	
	@RequestMapping(value= {"/","/home"})
	public ModelAndView data() {
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");
		
		logger.info("Inside logger - INFO");
		logger.debug("Inside logger - DEBUG");
		
		//Passing the list of categories
		mv.addObject("categories",categoryDAO.list());
		mv.addObject("clickHome", true);
		return mv;
	}
	
	@RequestMapping(value= {"/aboutus"})
	public ModelAndView about() {
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About Us");
		mv.addObject("clickAbout", true);
		return mv;
	}
	
	@RequestMapping(value= {"/contactus"})
	public ModelAndView contact() {
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Contact Us");
		mv.addObject("clickContact", true);
		return mv;
	}
	
	
	/*
	 * For view all products base on category
	 * 
	 * */
	@RequestMapping(value= {"/show/all/products"})
	public ModelAndView showAllProducts() {
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "All Products");
		
		/*Passing list of categories*/
		mv.addObject("categories",categoryDAO.list());
		
		mv.addObject("clickAllProducts", true);
		return mv;
	}
	
	@RequestMapping(value= {"/show/category/{id}/products"})
	public ModelAndView showCategoryProducts(@PathVariable(value="id")int id) {
		
		ModelAndView mv = new ModelAndView("page");
		
		/*
		 * CategoryDAO to fetch category base on id
		 * */
		Category category = categoryDAO.get(id);
		mv.addObject("title", category.getName());		
		
		/*Passing list of categories*/
		mv.addObject("categories",categoryDAO.list());
		
		/*View category by id*/
		mv.addObject("category", category);
		
		mv.addObject("clickCategoryProduct", true);
		return mv;
	}
	
	/*
	 * Code for Viewing single product
	 * */
	@RequestMapping(value ="/show/{id}/product")
	public ModelAndView viewSingleProduct(@PathVariable int id) {
		
		ModelAndView mv = new ModelAndView("page");
		
		Product product = productDAO.get(id);
		
		//Update the view count
		product.setViews(product.getViews() + 1);
		productDAO.update(product);
		
		mv.addObject("title", product.getName());
		mv.addObject("prod", product);
		mv.addObject("clickOnSingleProduct", true);
		
		return mv;
	}
	
}

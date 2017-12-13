package com.ksm.OnlineShoppingTest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.ksm.ShoppingBackend.dao.CategoryDAO;
import com.ksm.ShoppingBackend.dto.Category;

@Controller
public class PageController {

	@Autowired 
	CategoryDAO categoryDAO;
	
	@RequestMapping(value= {"/home"})
	public ModelAndView data() {
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");
		
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
	
}

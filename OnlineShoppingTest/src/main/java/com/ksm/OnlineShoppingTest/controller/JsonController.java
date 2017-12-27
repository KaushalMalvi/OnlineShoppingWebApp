package com.ksm.OnlineShoppingTest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ksm.ShoppingBackend.dao.ProductDAO;
import com.ksm.ShoppingBackend.dto.Product;

@Controller
@RequestMapping("/json/data")
public class JsonController {

	@Autowired
	public ProductDAO productDAO;
	
	@RequestMapping("/all/products")
	@ResponseBody
	public List<Product> getAllProducts(){
		
		return productDAO.listActiveProducts();
	}
	
	@RequestMapping("/category/{id}/products")
	@ResponseBody
	public List<Product> getProductsByCategory(@PathVariable("id")int pid){
		
		return productDAO.listActiveProductsByCategory(pid);
	}
}

package com.ksm.ShoppingBackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ksm.ShoppingBackend.dao.ProductDAO;
import com.ksm.ShoppingBackend.dto.Product;

public class ProductTest {

	private static  AnnotationConfigApplicationContext context ;
	
	private static ProductDAO productDAO;
	
	private Product product;
	
	@BeforeClass
	public static void init() {
		
		context = new AnnotationConfigApplicationContext();
		context.scan("com.ksm.ShoppingBackend");
		context.refresh();
		productDAO = (ProductDAO)context.getBean("productDAO");
	}
	
	/*@Test
	public void testCRUDProduct() {
		
		product = new Product();
		
		//Add Product
		product.setName("Moto-Turbo3");
		product.setBrand("Motorola");
		product.setDescription("Nice Mobile");
		product.setUnitPrice(15000);
		product.setActive(true);
		product.setCategoryId(3);
		product.setSupplierId(3);
		
		assertEquals("Something went wrong while adding record",true,productDAO.add(product));
		
		//update category
		product = productDAO.get(2);
		product.setName("Samsung s8");
		assertEquals("Something went wrong while update record",true,productDAO.update(product));
		
		//delete category
		assertEquals("Something went wrong while delete record",true,productDAO.delete(product));
		
		//list product
		assertEquals("Something went wrong while update record",6,productDAO.list().size());
	}*/
	
	/*@Test
	public void listofActiveProducts() {
		
		assertEquals("All active products",5,productDAO.listActiveProducts().size());
	}*/
	
	/*@Test
	public void listofActiveProductsByCategoryId() {
		
		assertEquals("All active products",3,productDAO.listActiveProductsByCategory(3).size());
		assertEquals("All active products",2,productDAO.listActiveProductsByCategory(1).size());
	}*/
	
	@Test
	public void listofLatestActiveProducts() {
		
		assertEquals("All active products",4,productDAO.getLatestActiveProducts(4).size());
		
	}
}

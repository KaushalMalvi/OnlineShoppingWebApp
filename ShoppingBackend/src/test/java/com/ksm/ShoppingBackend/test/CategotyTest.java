package com.ksm.ShoppingBackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ksm.ShoppingBackend.dao.CategoryDAO;
import com.ksm.ShoppingBackend.dto.Category;

public class CategotyTest {

	private static AnnotationConfigApplicationContext context;

	private static CategoryDAO categoryDAO;

	private static Category category;

	@BeforeClass
	public static void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("com.ksm.ShoppingBackend");
		context.refresh();
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");

	}
	
	/*@Test
	public void addCategory() {
		
		category = new Category();
		category.setName("Laptop");
		category.setDescription("Nice Laptop");
		category.setImgUrl("lap.png");
		
		category = new Category();
		category.setName("Mobile");
		category.setDescription("Nice Mobile");
		category.setImgUrl("mob.png");
		
		category = new Category();
		category.setName("T.V");
		category.setDescription("Nice TV");
		category.setImgUrl("tv.png");
		
		assertEquals("Categor added to table", true,categoryDAO.add(category));
	}*/
	
	
	/*@Test
	public void fetchCategory() {
		
		category = categoryDAO.get(2);
		assertEquals("Fetched Data Successfully","Laptop",category.getName());
	}*/
	
	/*@Test
	public void updateCategory() {
		
		category = categoryDAO.get(2);
		category.setImgUrl("mobile.png");
		assertEquals("Data Updated",true,categoryDAO.update(category));
	}*/
	
	/*@Test
	public void deleteCategory() {
		
		category = categoryDAO.get(2);
		
		assertEquals("Data is not alive",true,categoryDAO.delete(category));
	}*/
	
	
	/*@Test
	public void fetchAllCategory() {
		
		
		assertEquals("Data is fetched",1,categoryDAO.list().size());
	}*/
	
	@Test
	public void crudOperation() {
		
		//Add category
		category = new Category();
		category.setName("Mobi");
		category.setDescription("Nice Mobile");
		category.setImgUrl("mob.png");
		
		assertEquals("Categor added to table", true,categoryDAO.add(category));
		
		//Update Category
		category = categoryDAO.get(4);
		category.setName("Mobile");
		assertEquals("Data Updated",true,categoryDAO.update(category));
		
		//fetch Category
		assertEquals("Data is fetched",3,categoryDAO.list().size());
	}
}

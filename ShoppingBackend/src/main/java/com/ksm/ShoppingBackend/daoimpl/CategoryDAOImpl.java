package com.ksm.ShoppingBackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ksm.ShoppingBackend.dao.CategoryDAO;
import com.ksm.ShoppingBackend.dto.Category;


@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	public SessionFactory sessionFactory;
	
	public static List<Category> categories = new ArrayList<>();
	
	/*static {
		
		Category category = new Category();
		category.setId(1);
		category.setName("Television");
		category.setDescription("This is my TV");
		category.setImgUrl("sam.png");
		categories.add(category);
		
		category = new Category();
		category.setId(2);
		category.setName("Mobile");
		category.setDescription("This is my TV");
		category.setImgUrl("sam.png");
		categories.add(category);
		
		category = new Category();
		category.setId(3);
		category.setName("Laptop");
		category.setDescription("This is my TV");
		category.setImgUrl("sam.png");
		
		categories.add(category);
	}*/
	
	
	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		//return categories;
		
		String query = "from Category where active = :active";
		
		Query que =sessionFactory.getCurrentSession().createQuery(query);
		
		que.setParameter("active", true);
		
		return que.getResultList();
	}


	/*
	 * Getting single category base on id
	 * */
	@Override
	public Category get(int id) {
		
		/*for(Category category : categories) {
			
			if (category.getId() == id) 
				
				return category;
			}
		
		return null;*/
		return sessionFactory.getCurrentSession().get(Category.class,Integer.valueOf(id));
		
	}


	@Override
	public boolean add(Category category) {

		try {
		
			sessionFactory.getCurrentSession().persist(category);
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}


	@Override
	public boolean update(Category category) {
		
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}


	@Override
	public boolean delete(Category category) {

		category.setActive(false);
		
		try {
		sessionFactory.getCurrentSession().delete(category);
		return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}

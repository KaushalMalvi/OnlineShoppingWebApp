package com.ksm.ShoppingBackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ksm.ShoppingBackend.dao.ProductDAO;
import com.ksm.ShoppingBackend.dto.Product;

@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	public SessionFactory sessionFactory;

	// For single product
	@Override
	public Product get(int productId) {

		try {
			return sessionFactory.getCurrentSession().get(Product.class, Integer.valueOf(productId));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// List of products
	@Override
	public List<Product> list() {

		return sessionFactory.getCurrentSession().createQuery("from Product", Product.class).getResultList();
	}

	// Inserting product
	@Override
	public boolean add(Product product) {

		try {
			sessionFactory.getCurrentSession().persist(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	// Updating Product
	@Override
	public boolean update(Product product) {

		try {
			sessionFactory.getCurrentSession().update(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	//Delete Product
	@Override
	public boolean delete(Product product) {
		try {
			product.setActive(false);
			//Call update method
			return this.update(product);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	
	@Override
	public List<Product> listActiveProducts() {
		
		String sql = "from Product where active = :activated";
		return sessionFactory.getCurrentSession().createQuery(sql,Product.class).setParameter("activated", true).getResultList();
	
	}

	@Override
	public List<Product> listActiveProductsByCategory(int categoryId) {
		
		String sql = "from Product where active = :activated and categoryId = :categoryID";
		return sessionFactory.getCurrentSession()
				.createQuery(sql,Product.class)
				.setParameter("activated", true)
				.setParameter("categoryID", categoryId)
				.getResultList();
	
	}

	@Override
	public List<Product> getLatestActiveProducts(int count) {
		
		String sql = "from Product where active = :activated order by id";
		return sessionFactory.getCurrentSession()
				.createQuery(sql,Product.class)
				.setParameter("activated", true)
				.setFirstResult(0)
				.setMaxResults(count)
				.getResultList();
	}

}

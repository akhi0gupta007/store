package com.akhi.store.service;

import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.akhi.store.dao.ProductDao;
import com.akhi.store.dao.UserDao;
import com.akhi.store.general.User;
import com.akhi.store.product.Category;
import com.akhi.store.product.Product;
import com.akhi.store.product.ProductVO;

@Service
public class ProductServiceImpl implements ProductService {

	private static org.apache.log4j.Logger log = Logger
			.getLogger(ProductServiceImpl.class);

	@Autowired
	private ProductDao dao;

	@Autowired
	private UserDao userDao;

	@Override
	@Transactional
	public Product persistProduct(ProductVO obj) {

		log.info("persistProduct():::::::::::::::" + obj);
		if (obj.getId() == null) {
			log.error("Who is user ? ????????????????");
			return null;
		}
		User user = null;

		if (obj.getId() > 0) {
			user = userDao.findById(obj.getId());
		}

		if (user == null) {
			log.error("User can't be found in DB");
			return null;
		}

		log.info("Going to persist product for user." + user);

		Product product = createProduct(obj);
		Set<Product> products = user.getProducts();
		product.setUser(user);
		products.add(product);

		if (obj.getColl() != null && obj.getColl().length() > 0) {
			Set<Category> cats = user.getCatogories();
			Category cat = new Category();
			cat.setUser(user);
			cat.setName(obj.getColl());
			Set<Product> newPros = new HashSet<Product>();
			newPros.add(product);
			cat.setProducts(newPros);
			cats.add(cat);
			Set<Category> newCats = new HashSet<Category>();
			newCats.add(cat);
			product.setCategories(newCats);
			userDao.makePersistent(user);
		}

		return null;
	}

	private Product createProduct(ProductVO obj) {
		Product product = new Product();
		product.setDescription(obj.getDescription());
		product.setTitle(obj.getName());
		product.setImage(product.getImage());
		product.setSel_price(obj.getSel_price());
		product.setPro_id(obj.getPro_id());
		product.setWeight(obj.getWeight());
		return product;
	}

}

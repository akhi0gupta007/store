package com.akhi.store.service;

import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.akhi.store.dao.ProductDao;
import com.akhi.store.dao.UserDao;
import com.akhi.store.general.ProductServiceLog;
import com.akhi.store.general.User;
import com.akhi.store.product.Category;
import com.akhi.store.product.Product;
import com.akhi.store.product.ProductVO;

@Service
public class ProductServiceImpl implements ProductService
    {

    private static org.apache.log4j.Logger	log	   = Logger.getLogger(ProductServiceImpl.class);

    private static ThreadLocal<ProductServiceLog> transactionId = new ThreadLocal<ProductServiceLog>()
								    {

									@Override
									protected ProductServiceLog initialValue()
									    {

									    return new ProductServiceLog();
									    }

								    };

    @Autowired
    private ProductDao			    dao;

    @Override
    @Transactional
    public Product persistProduct( ProductVO obj )
	{

	Long userId = null;
	log.info("persistProduct():::::::::::::::" + obj);
	if (obj.getId() == null)
	    {
	    log.error("Who is user ? ????????????????");
	    return null;
	    }
	userId = obj.getId();

	log.info("Going to persist product for user." + userId);

	Product product = createProduct(obj);
	product = dao.persistProduct(product, userId);
	Category cat = null;
	if (obj.getColl() != null && obj.getColl().length() > 0 && !isLong(obj.getColl()))
	    {
	    cat = new Category();
	    cat.setName(obj.getColl());
	    cat = dao.persistCat(cat, userId);
	    }
	if (cat != null)
	    {
	    Set<Category> newCats = new HashSet<Category>();
	    newCats.add(cat);
	    product.setCategories(newCats);
	    Set<Product> newPros = new HashSet<Product>();
	    newPros.add(product);
	    cat.setProducts(newPros);
	    dao.mergeChanges(cat);
	    dao.mergeChanges(product);
	    }

	if (obj.getCategory() != null && obj.getCategory().length() > 0 && isLong(obj.getCategory()))
	    {
	    log.info("persistProduct:Going to persist Cateogory : " + obj.getCategory());
	    Long id = Long.parseLong(obj.getCategory());
	    cat = dao.findCatById(id);
	    log.info("Found Cat as " + cat);
	    Set<Product> products = cat.getProducts();
	    products.add(product);
	    Set<Category> newCats = new HashSet<Category>();
	    newCats.add(cat);
	    product.setCategories(newCats);
	    dao.mergeChanges(cat);
	    dao.mergeChanges(product);
	    }
	else
	    {
	    log.info("Not persisting Cateogory : " + obj.getCategory());
	    }

	//Set<Category> cats = user.getCatogories();

	//	    Set<Product> newPros = new HashSet<Product>();
	//	    newPros.add(product);
	//	    cat.setProducts(newPros);
	//	    cats.add(cat);

	//	    userDao.makePersistent(user);

	return product;
	}

    private Product createProduct( ProductVO obj )
	{
	Product product = new Product();
	product.setDescription(obj.getDescription());
	product.setTitle(obj.getName());
	product.setImage(product.getImage());
	product.setSel_price(obj.getSel_price());
	product.setPro_id(obj.getPro_id());
	product.setWeight(obj.getWeight());
	return product;
	}

    public boolean isLong( String input )
	{
	try
	    {
	    Long.parseLong(input);
	    return true;
	    }
	catch (Exception ex)
	    {
	    return false;
	    }
	}

    }

package com.akhi.store.test;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.akhi.store.dao.ProductDao;
import com.akhi.store.dao.UserDao;
import com.akhi.store.general.Profile;
import com.akhi.store.general.User;
import com.akhi.store.product.Category;
import com.akhi.store.product.Product;
import com.akhi.store.product.Tag;
import com.akhi.store.product.Vendor;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations =
    { "classpath:storeBean.xml" })
@TransactionConfiguration(transactionManager = "txMgr", defaultRollback = false)
@TestExecutionListeners(
    { DependencyInjectionTestExecutionListener.class, TransactionalTestExecutionListener.class })
public class UserDaoTest
    {

    @Autowired
    private UserDao      dao;

    @Autowired
    private ProductDao   productDao;

    public static Logger log = Logger.getLogger(UserDaoTest.class);

    @After
    public void cleanup()
	{
	// deleteFromTables(jdbcTemplate, "spitter");
	}

    @Transactional
    @Test
    public void shouldCreateRowsAndSetIds()
	{
	User user = new User();
	user.setEmailId("akhi0gupta007@gmail.com");
	user.setUserId("akhi");
	user.setPassword("password");
	Profile profile = new Profile();
	profile.setPhone("9718304337");
	profile.setUser(user);
	user.setProfile(profile);
	log.info("DAO: " + dao + " we have product DAO " + productDao);
	Product product = makeProduct();
	Category cat = new Category();
	cat.setUser(user);
	cat.setName("Dish Washer");
	Set<Category> catogories = new HashSet<Category>();
	catogories.add(cat);
	catogories.add(new Category("Clothes", user));
	user.setCatogories(catogories);
	product.setUser(user);
	Vendor vendor = new Vendor();
	vendor.setVen_name("Surf");
	product.setVendor(vendor);
	HashSet<Product> products = new HashSet<Product>();
	HashSet<Vendor> vendors = new HashSet<Vendor>();
	vendors.add(vendor);
	vendor.setUser(user);
	products.add(product);
	user.setProducts(products);
	user.setVendors(vendors);
	Tag tag = new Tag("soap", user);
	Set<Tag> tags = new HashSet<Tag>();
	tags.add(tag);
	user.setTags(tags);
	tag.setProducts(new HashSet<Product>(products));
	//productDao.makePersistent(product);
	dao.makePersistent(user);
	//dao.findById(1L);

	}

    @Transactional(propagation = Propagation.REQUIRED)
    //  @Test
    public void shouldBeAbleToFindByCriteria()
	{
	log.warn("::::::::::::::::::::" + dao.findByIdAndPassword("akhi",
								  "password"));

	}

    private Product makeProduct()
	{
	Product product = new Product();
	product.setTitle("RIN");
	product.setSel_price(123.0);
	product.setPro_id("223");

	return product;

	}
    }

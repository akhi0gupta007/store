package com.akhi.store.test;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
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
import com.akhi.store.product.Product;
import com.akhi.store.product.Vendor;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations =
    { "classpath:storeBean.xml" })
@TransactionConfiguration(transactionManager = "txMgr", defaultRollback = true)
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
	product.setUser(user);
	Vendor vendor = new Vendor();
	vendor.setVen_name("Surf");
	product.setVendor(vendor);
	ArrayList<Product> products = new ArrayList<Product>();
	ArrayList<Vendor> vendors = new ArrayList<Vendor>();
	vendors.add(vendor);
	vendor.setUser(user);
	products.add(product);
	user.setProducts(products);
	user.setVendors(vendors);
	dao.makePersistent(user);
	log.info(user.getProfile() + "  " + profile.getUser());

	log.info("Searching by User and password");
	assertEquals("Found the same object",
		     user,
		     dao.findByIdAndPassword("akhi", "password"));
	profile.setCountry("Pakistan");

	user.setProfile(profile);
	dao.makePersistent(user);
	// dao.makeTransient(user);

	User user2 = dao.findByIdAndPassword("akhi", "password");
	System.out.println(user2);

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

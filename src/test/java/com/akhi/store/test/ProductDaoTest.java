/**---------------------------------------------------------------------*
 * filename     : ProductDaoTest.java
 * date         : May 27, 2013
 * Author       : akhilesh
 *
 * Changes      : See javadoc object description
 *----------------------------------------------------------------------*
 */
package com.akhi.store.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import com.akhi.store.dao.ProductDao;
import com.akhi.store.dao.UserDao;
import com.akhi.store.general.User;
import com.akhi.store.product.Category;
import com.akhi.store.product.Product;
import com.akhi.store.product.Tag;

/*-----------------------------------------------------------------------*//**
*
* @author      akhilesh
* @version     %R%
*
* <BR><B>Revision History:</B><BR>
* <PRE>
*     Date        | User  | Description
*     ------------------------------------------------------------
*     May 27, 2013 | akhilesh   | Original
* </PRE>
*
* @since       JDK1.4.2_07
*
*/
/*-----------------------------------------------------------------------*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations =
    { "classpath:storeBean.xml" })
@TransactionConfiguration(transactionManager = "txMgr", defaultRollback = false)
@TestExecutionListeners(
    { DependencyInjectionTestExecutionListener.class, TransactionalTestExecutionListener.class })
public class ProductDaoTest
    {
    @Autowired
    private ProductDao productDao;

    @Autowired
    private UserDao    dao;

    @Test
    @Transactional
    public final void testMakePersistent()
	{
	User user = dao.findById(1l, true);
	Product product = makeProduct();
	product.setUser(user);
	Category cat = new Category("pc", user);
	Set<Product> products = new HashSet<Product>();
	products.add(product);
	cat.setProducts(products);
	Set<Category> cats = new HashSet<Category>();
	cats.add(cat);
	
	user.setCatogories(cats);
	product.setCategories(cats);
	Collection<Tag> tags  = getTags(user);
	user.setTags(tags);
	product.setTags((Set<Tag>) tags);
	assertNotNull(dao.makePersistent(user));
	assertNotNull(productDao.makePersistent(product));

	}

    private Product makeProduct()
	{

	Product product = new Product();
	product.setTitle("RIN");
	product.setSel_price(123.0);
	Random random = new Random();
	product.setPro_id(String.valueOf(Math.abs(random.nextInt())));
	return product;

	}

    public Collection<Tag> getTags( User user )
	{
	Collection<Tag> tags = new HashSet<Tag>();
	tags.add(new Tag("electronics", user));
	tags.add(new Tag("laptop", user));
	return tags;
	}

    }

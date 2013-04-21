/**
 * 
 */
package com.akhi.store.test;

import static org.junit.Assert.assertNotNull;

import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.akhi.store.util.HibernateUtil;

/**
 * @author akhilesh
 * 
 */
public class UserTest {

	@Autowired
	HibernateUtil util = null;

	@Before
	public void setUp() throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "storeBean.xml" });
		


	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		System.out.println("Factory "+util);
	
	/*	Session session = util.getSession();
		System.out.println(session);*/
		
	/*	assertNotNull("Session is Created",session);
		session.beginTransaction();
		session.getTransaction().commit();*/
	}

}

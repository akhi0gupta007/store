/**---------------------------------------------------------------------*
 * filename     : DaoTest.java
 * date         : Apr 22, 2013
 * Author       : akhilesh
 *
 * Changes      : See javadoc object description
 *----------------------------------------------------------------------*
 */
package com.akhi.store.general;

import static org.junit.Assert.assertEquals;

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

import com.akhi.store.util.DaoUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations =
    { "classpath:storeBean.xml" })
@TransactionConfiguration(transactionManager = "txMgr", defaultRollback = true)
@TestExecutionListeners(
    { DependencyInjectionTestExecutionListener.class, TransactionalTestExecutionListener.class })
@Transactional
public class DaoTest
    {

    @Autowired
    private DaoUtils utils;

    @Test
    public void testDao()
	{
	User user = new User();
	user.setUserId("akhi2");
	user.setPassword("password");
	user.setEmailId("ae@b.com");
	utils.insertUser(user);
	
	User user2 = utils.getUser(2);
	assertEquals("Both users are equal", user.getUserId(),user2.getUserId());
	}

    }

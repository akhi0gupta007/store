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

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

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


    @Before
    public void setUp() throws Exception
	{
	}

    @After
    public void tearDown() throws Exception
	{
	}

    @Test
    @Transactional
    public final void testMakePersistent()
	{
	
	
	}

    @Test
    public final void testMakeTransient()
	{
	fail("Not yet implemented");
	}

    }

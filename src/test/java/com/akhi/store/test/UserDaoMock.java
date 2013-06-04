/**---------------------------------------------------------------------*
 * filename     : UserDaoMock.java
 * date         : May 21, 2013
 * Author       : akhilesh
 *
 * Changes      : See javadoc object description
 *----------------------------------------------------------------------*
 */
package com.akhi.store.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;

import com.akhi.store.dao.UserDao;
import com.akhi.store.general.User;
import com.akhi.store.product.Product;
import com.akhi.store.service.UserServiceImplDao;

/*-----------------------------------------------------------------------*//**
*
* @author      akhilesh
* @version     %R%
*
* <BR><B>Revision History:</B><BR>
* <PRE>
*     Date        | User  | Description
*     ------------------------------------------------------------
*     May 21, 2013 | akhilesh   | Original
* </PRE>
*
* @since       JDK1.4.2_07
*
*/
/*-----------------------------------------------------------------------*/

public class UserDaoMock
    {
    private UserServiceImplDao service = new UserServiceImplDao();

    private UserDao	    dao;

    @Before
    public void setUp() throws Exception
	{
	dao = Mockito.mock(UserDao.class);
	service.setUserDao(dao);
	}

    @After
    public void tearDown() throws Exception
	{
	service = new UserServiceImplDao();
	}

    @Test
    public void test()
	{
	User user = new User();
	when(service.addUser(user)).thenReturn(user);
	assertEquals(user, service.addUser(user));
	verify(dao, times(1)).makePersistent(user);
	}

    }

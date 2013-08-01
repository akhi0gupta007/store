/**---------------------------------------------------------------------*
 * filename     : UserServiceImplDao.java
 * date         : May 22, 2013
 * Author       : akhilesh
 *
 * Changes      : See javadoc object description
 *----------------------------------------------------------------------*
 */
package com.akhi.store.service;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.akhi.store.dao.UserDao;
import com.akhi.store.dao.UserDaoImpl;
import com.akhi.store.general.User;

/*-----------------------------------------------------------------------*//**
* 
* @author
*         akhilesh
* @version %R%
* 
* <BR>
*          <B>Revision History:</B><BR>
* 
*          <PRE>
*     Date        | User  | Description
*     ------------------------------------------------------------
*     May 22, 2013 | akhilesh   | Original
* </PRE>
* 
* @since JDK1.4.2_07
* 
*/
/*-----------------------------------------------------------------------*/

@Service(value = "daopowered")
public class UserServiceImplDao implements UserService
    {
    private static org.apache.log4j.Logger log = Logger.getLogger(UserServiceImplDao.class);

    @Inject
    private UserDao			userDao;

    @Override
    @Transactional
    public User addUser( User user )
	{
	return userDao.makePersistent(user);
	}

    @Override
    @Transactional
    public void removeUser( User user )
	{
	userDao.makeTransient(user);
	}

    @Override
    @Transactional
    public User autheticate( String userId, String password )
	{
	User user = userDao.findByIdAndPassword(userId, password);
	log.info(">>>>>>>>>>>>>>>>>>>>>>>>UserServiceImplDao() "+user);
	return user;
	}

    public UserDao getUserDao()
	{
	return userDao;
	}

    public void setUserDao( UserDao userDao )
	{
	this.userDao = userDao;
	}

    }

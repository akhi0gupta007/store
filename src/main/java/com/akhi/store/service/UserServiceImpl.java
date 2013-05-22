/**---------------------------------------------------------------------*
 * filename     : UserServiceImpl.java
 * date         : Apr 23, 2013
 * Author       : akhilesh
 *
 * Changes      : See javadoc object description
 *----------------------------------------------------------------------*
 */
package com.akhi.store.service;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.akhi.store.general.User;

/*-----------------------------------------------------------------------*//**
*
* @author      akhilesh
* @version     %R%
*
* <BR><B>Revision History:</B><BR>
* <PRE>
*     Date        | User  | Description
*     ------------------------------------------------------------
*     Apr 23, 2013 | akhilesh   | Original
* </PRE>
*
* @since       JDK1.4.2_07
*
*/
/*-----------------------------------------------------------------------*/

@Service(value="userService")
@Transactional
@TransactionConfiguration(transactionManager = "txMgr", defaultRollback = true)
public class UserServiceImpl implements UserService
    {

    private SessionFactory sessionFactory;

    private static Logger  log = Logger.getLogger(UserServiceImpl.class);

    @Override
    public User addUser( User user )
	{
	log.info("AddUser:::::::::::::::::::::");
	return null;
	}

    @Override
    public void removeUser( User user )
	{

	}

    @Override
    public User autheticate( String userId, String password )
	{

	User user = null;

	Session session = sessionFactory.getCurrentSession();

	if (session != null)
	    {
	    user = (User) session.createCriteria(User.class).add(Restrictions.eq("userId",
										 userId)).add(Restrictions.eq("password",
													      password)).setMaxResults(1).uniqueResult();
	    if (user != null)
		{
		log.info("User found" + user);
		}
	    else
		{
		log.warn("No Idea abt user" + userId);
		}
	    }
	else
	    {
	    log.fatal("No Sesssion Found");
	    }
	return user;

	}

    public SessionFactory getSessionFactory()
	{
	return sessionFactory;
	}

    @Autowired
    @Required
    public void setSessionFactory( SessionFactory sessionFactory )
	{
	this.sessionFactory = sessionFactory;
	}

    }

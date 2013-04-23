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
import org.hibernate.SessionFactory;
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

@Service
@Transactional
@TransactionConfiguration(transactionManager = "txMgr", defaultRollback = true)
public class UserServiceImpl implements UserService
    {

    private SessionFactory sessionFactory;
    
    private static Logger log = Logger.getLogger(UserServiceImpl.class);

    @Override
    public void addUser( User user )
	{
	log.info("AddUser:::::::::::::::::::::"+sessionFactory.getCurrentSession());
	}

    @Override
    public void removeUser( User user )
	{

	}

    @Override
    public User autheticate( String userId, String password )
	{
	return null;

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

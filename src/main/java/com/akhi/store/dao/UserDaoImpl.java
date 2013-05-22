/**---------------------------------------------------------------------*
 * filename     : UserDaoImpl.java
 * date         : May 20, 2013
 * Author       : adc
 *
 * Changes      : See javadoc object description
 *----------------------------------------------------------------------*
 */
package com.akhi.store.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
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
*     May 20, 2013 | adc   | Original
* </PRE>
*
* @since       JDK1.4.2_07
*
*/
/*-----------------------------------------------------------------------*/

@Repository
public class UserDaoImpl extends GenericHibernateDAO<User, Long>
								implements
								UserDao
    {

    @Override
    public User findByIdAndPassword( String id, String password )
	{

	Criteria crit = getSession().createCriteria(User.class).add(Restrictions.eq("userId",
										    id)).add(Restrictions.eq("password",
													     password)).setMaxResults(1);
	List<?> list = crit.list();

	if (list.size() > 0)
	    return (User) list.get(0);
	else
	    return null;
	}

    @Override
    public List<User> findByExample( User exampleInstance )
	{
	// TODO Auto-generated method stub
	return null;
	}

    }

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

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.akhi.store.general.Profile;
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
 *     May 20, 2013 | adc   | Original
 * </PRE>
 * 
 * @since JDK1.4.2_07
 * 
 */
/*-----------------------------------------------------------------------*/

@Repository
public class UserDaoImpl extends GenericHibernateDAO<User, Long> implements
		UserDao {

	private static org.apache.log4j.Logger log = Logger
			.getLogger(UserDaoImpl.class);

	@Override
	public User findByIdAndPassword(String id, String password) {
		log.info(">>>>>>>UserDaoImpl: Testing against user/password : "
				+ getSession());
		Criteria crit = getSession().createCriteria(User.class)
				.add(Restrictions.eq("userId", id))
				.add(Restrictions.eq("password", password)).setMaxResults(1);
		List<?> list = crit.list();

		if (list.size() > 0)
			return (User) list.get(0);
		else
			return null;
	}

	@Override
	public List<User> findByExample(User exampleInstance) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserDaoImpl [session=" + session + "]";
	}

	@Override
	public void deleteProfile(Profile entity) {
		getSession().delete(entity);
	}

	@Override
	public User findById(Long id) {
		User user = null;
		Query query = getSession()
				.createQuery("from user as user where id=:id");

		query.setParameter("id", id);
		query.setMaxResults(1);
		
		log.info(" userdao: findById:::::::::::::::::::::::::" + query.list());

		List<?> results = query.list();

		user = (User) results.get(0);
		log.info("User : " + user);
		log.info("User vendors: " + user.getVendors().size());
		return user;
	}
}

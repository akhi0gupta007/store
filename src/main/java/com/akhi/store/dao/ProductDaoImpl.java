/**---------------------------------------------------------------------*
 * filename     : ProductDaoImpl.java
 * date         : May 27, 2013
 * Author       : akhilesh
 *
 * Changes      : See javadoc object description
 *----------------------------------------------------------------------*
 */
package com.akhi.store.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.akhi.store.product.Category;
import com.akhi.store.product.Product;
import com.akhi.store.product.Tag;
import com.akhi.store.product.Vendor;

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
 *     May 27, 2013 | akhilesh   | Original
 * </PRE>
 * 
 * @since JDK1.4.2_07
 * 
 */
/*-----------------------------------------------------------------------*/
@Repository
@SuppressWarnings("unchecked")
public class ProductDaoImpl extends GenericHibernateDAO<Product, Long>
		implements ProductDao, ApplicationContextAware {

	private ApplicationContext context;

	@Override
	public List<Product> findByExample(Product exampleInstance) {
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
		return "ProductDaoImpl [session=" + session + "]";
	}

	@Override
	@Transactional
	public List<Vendor> getVendors(Long id) {

		Query query = getSession().createQuery("from vendor where USER_ID=:id");
		query.setParameter("id", id);
		List<?> result = query.list();
		return (List<Vendor>) result;
	}

	@Override
	@Transactional
	public List<Tag> getTags(Long id) {
		Query query = getSession().createQuery("from tag where USER_ID=:id");
		query.setParameter("id", id);
		List<?> result = query.list();
		return (List<Tag>) result;
	}

	@Override
	@Transactional
	public List<Category> getCatgories(Long id) {
		Query query = getSession().createQuery(
				"from catogory where USER_ID=:id");
		query.setParameter("id", id);
		List<?> result = query.list();
		return (List<Category>) result;
	}

	@Override
	@Transactional
	public List<Product> getProducts(Long id) {
		Query query = getSession().createQuery(
				"from product where user_products=:id");
		query.setParameter("id", id);
		List<?> result = query.list();
		return (List<Product>) result;
	}

	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		setContext(arg0);

	}

	public ApplicationContext getContext() {
		return context;
	}

	public void setContext(ApplicationContext context) {
		this.context = context;
	}

	@Override
	public void persistCat(String cat, Long id) {
		// TODO Auto-generated method stub
		
	}

}

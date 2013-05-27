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

import org.springframework.stereotype.Repository;

import com.akhi.store.product.Product;


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
@Repository
public class ProductDaoImpl extends GenericHibernateDAO<Product, Long> implements ProductDao
    {

    @Override
    public List<Product> findByExample( Product exampleInstance )
	{
	// TODO Auto-generated method stub
	return null;
	}

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
	{
	return "ProductDaoImpl [session=" + session + "]";
	}

    }

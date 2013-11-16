/**---------------------------------------------------------------------*
 * filename     : ProductDao.java
 * date         : May 27, 2013
 * Author       : akhilesh
 *
 * Changes      : See javadoc object description
 *----------------------------------------------------------------------*
 */
package com.akhi.store.dao;

import java.util.List;

import com.akhi.store.product.Category;
import com.akhi.store.product.Product;
import com.akhi.store.product.Tag;
import com.akhi.store.product.Vendor;

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

public interface ProductDao extends GenericDAO<Product, Long>
    {
    List<Vendor> getVendors( Long id );

    List<Tag> getTags( Long id );

    List<Category> getCatgories( Long id );

    List<Product> getProducts( Long id );

    Category persistCat( Category cat, Long id );

    Product persistProduct( Product product, Long userId );

    Object mergeChanges( Object entity );
    
    Category findCatById(Long id);
    
    Tag findTagById(Long id);
    
    Vendor findVendorById(Long id);

    Vendor persistVen( Vendor ven , Long id);

    boolean deleteProduct( Product product );

    }

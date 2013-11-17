/**---------------------------------------------------------------------*
 * filename     : UserDao.java
 * date         : May 20, 2013
 * Author       : adc
 *
 * Changes      : See javadoc object description
 *----------------------------------------------------------------------*
 */
package com.akhi.store.dao;

import java.util.List;

import com.akhi.store.general.Profile;
import com.akhi.store.general.User;
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
*     May 20, 2013 | adc   | Original
* </PRE>
*
* @since       JDK1.4.2_07
*
*/
/*-----------------------------------------------------------------------*/

public interface UserDao extends GenericDAO<User, Long> 
    {
    User findByIdAndPassword(String id,String password);

    void deleteProfile( Profile entity );
    
    User findById(Long id);

    List<Product> getProducts( Long id,
                               int max,
                               int offset,
                               String orderBy,
                               String order );
    }

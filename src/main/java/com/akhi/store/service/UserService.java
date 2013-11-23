/**---------------------------------------------------------------------*
 * filename     : UserService.java
 * date         : Apr 23, 2013
 * Author       : akhilesh
 *
 * Changes      : See javadoc object description
 *----------------------------------------------------------------------*
 */
package com.akhi.store.service;

import java.util.List;

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
*     Apr 23, 2013 | akhilesh   | Original
* </PRE>
*
* @since       JDK1.4.2_07
*
*/
/*-----------------------------------------------------------------------*/

public interface UserService
    {
    enum Order
	{
	ASC, DSC
	}

    User addUser( User user );

    void removeUser( User user );

    User autheticate( String userId, String password );

    User findById( Long id, boolean lock );

    List<Product> getProducts( Long id,
	                       int max,
	                       int offset,
	                       String orderBy,
	                       Order order );



    List<Product> searchProducts( Long id, String keywords );
    }

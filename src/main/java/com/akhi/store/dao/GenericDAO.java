/**---------------------------------------------------------------------*
 * filename     : GenericDAO.java
 * date         : May 20, 2013
 * Author       : adc
 *
 * Changes      : See javadoc object description
 *----------------------------------------------------------------------*
 */
package com.akhi.store.dao;

import java.io.Serializable;
import java.util.List;

/*-----------------------------------------------------------------------*//**
*
* @author      adc
* @version     %R%
*
* <BR><B>Revision History:</B><BR>
* <PRE>
*     Date        | User  | Description
*     ------------------------------------------------------------
*     May 20, 2013 | akhilesh   | Original
* </PRE>
*
* @since       JDK1.4.2_07
*
*/
/*-----------------------------------------------------------------------*/

public interface GenericDAO<T, ID extends Serializable>
    {

    T findById( ID id, boolean lock );

    List<T> findAll();

    List<T> findByExample( T exampleInstance );

    T makePersistent( T entity );

    void makeTransient( T entity );
    }

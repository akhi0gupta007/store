/**---------------------------------------------------------------------*
 * filename     : DaoUtils.java
 * date         : Apr 22, 2013
 * Author       : adc
 *
 * Changes      : See javadoc object description
 *----------------------------------------------------------------------*
 */
package com.akhi.store.util;

import org.hibernate.Session;

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
*     Apr 22, 2013 | akhilesh   | Original
* </PRE>
*
* @since       JDK1.4.2_07
*
*/
/*-----------------------------------------------------------------------*/

public interface DaoUtils
    {
     Session getSession();
     void insertUser(User user);
     User getUser(long id);
    }

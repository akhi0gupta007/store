/**---------------------------------------------------------------------*
 * filename     : UserService.java
 * date         : Apr 23, 2013
 * Author       : akhilesh
 *
 * Changes      : See javadoc object description
 *----------------------------------------------------------------------*
 */
package com.akhi.store.service;

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

public interface UserService
    {
    
    User addUser(User user);
    void removeUser(User user);
    User autheticate(String userId,String password);
    
    }

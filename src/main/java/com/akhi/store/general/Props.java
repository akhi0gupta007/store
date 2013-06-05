/**---------------------------------------------------------------------*
 * filename     : Props.java
 * date         : Jun 5, 2013
 * Author       : akhilesh
 *
 * Changes      : See javadoc object description
 *----------------------------------------------------------------------*
 */
package com.akhi.store.general;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import com.akhi.store.listener.LastModifiable;


/*-----------------------------------------------------------------------*//**
*
* @author      akhilesh
* @version     %R%
*
* <BR><B>Revision History:</B><BR>
* <PRE>
*     Date        | User  | Description
*     ------------------------------------------------------------
*     Jun 5, 2013 | akhilesh   | Original
* </PRE>
*
* @since       JDK1.4.2_07
*
*/
/*-----------------------------------------------------------------------*/

@MappedSuperclass
public abstract class Props implements LastModifiable
    {
    @Column(nullable = true)
    protected Date		lastUpdated;
    
    @Override
    public void setLastModified( Date date )
	{
	this.lastUpdated = date;
	}

    /**
     * @return Returns the lastUpdated.
     */
    public Date getLastUpdated()
        {
        return lastUpdated;
        }
    

    }

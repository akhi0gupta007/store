/**---------------------------------------------------------------------*
 * filename     : SaveUpdateListener.java
 * date         : Jun 4, 2013
 * Author       : akhilesh
 *
 * Changes      : See javadoc object description
 *----------------------------------------------------------------------*
 */
package com.akhi.store.listener;

import java.util.Date;

import org.hibernate.event.SaveOrUpdateEvent;
import org.hibernate.event.def.DefaultSaveOrUpdateEventListener;

/*-----------------------------------------------------------------------*//**
*
* @author      akhilesh
* @version     %R%
*
* <BR><B>Revision History:</B><BR>
* <PRE>
*     Date        | User  | Description
*     ------------------------------------------------------------
*     Jun 4, 2013 | akhilesh   | Original
* </PRE>
*
* @since       JDK1.4.2_07
*
*/
/*-----------------------------------------------------------------------*/

public class SaveUpdateListener extends DefaultSaveOrUpdateEventListener
    {

    private static final long serialVersionUID = 1L;

    /* (non-Javadoc)
     * @see org.hibernate.event.def.DefaultSaveOrUpdateEventListener#onSaveOrUpdate(org.hibernate.event.SaveOrUpdateEvent)
     */
    @Override
    public void onSaveOrUpdate( SaveOrUpdateEvent event )
	{
	if (event.getObject() instanceof LastModifiable)
	    {
	    LastModifiable record = (LastModifiable) event.getObject();
	    record.setLastModified(new Date());
	    }
	super.onSaveOrUpdate(event);
	}
    }

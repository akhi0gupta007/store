/********************************************************************
 * Copyright Group 2000 Nederland B.V. - 2010, all rights reserved
 * Author: MHA
 * 
 * Description for this project
 * 
 ********************************************************************/
/**---------------------------------------------------------------------*
 * filename     : UTCTimestampType.java
 * date         : Sept, 21 2010
 * Author       : MHA
 *
 * Changes      : See javadoc object description
 *----------------------------------------------------------------------*
 */
package com.akhi.store.general;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.hibernate.HibernateException;
import org.hibernate.usertype.UserType;

/**
 * Like a Hibernate timestamp, but using the UTC TimeZone (not the default
 * TimeZone).
 */
public class UTCTimestampType implements UserType
    {

    /** the SQL type this type manages. */
    protected static int[] SQL_TYPES_UTC =
					     { Types.TIMESTAMP };

    /**
     * Sql types.
     *
     * @return the int[]
     * see net.sf.hibernate.UserType#sqlTypes()
     */
    @Override
    public int[] sqlTypes()
	{
	return SQL_TYPES_UTC;
	}

    /** the Calendar to hold the UTC timezone. */
    protected Calendar sUTCCalendar = Calendar.getInstance();

    {
	// set the timezone for the calendar to UTC (= GMT)
	sUTCCalendar.setTimeZone(TimeZone.getTimeZone("GMT"));
    }


    /* (non-Javadoc)
     * @see org.hibernate.usertype.UserType#equals(java.lang.Object, java.lang.Object)
     */
    @Override
    public boolean equals( Object x, Object y )
	{
	return (x == null) ? (y == null) : x.equals(y);
	}

    /* (non-Javadoc)
     * @see org.hibernate.usertype.UserType#isMutable()
     */
    @Override
    public boolean isMutable()
	{
	return true;
	}

    /* (non-Javadoc)
     * @see org.hibernate.usertype.UserType#returnedClass()
     */
    @Override
    public Class<?> returnedClass()
	{
	return Date.class;
	}

    /* (non-Javadoc)
     * @see org.hibernate.usertype.UserType#deepCopy(java.lang.Object)
     */
    @Override
    public Object deepCopy( Object value )
	{
	return (value == null) ? null : new Date(((Date) value).getTime());

	}

    /* (non-Javadoc)
     * @see org.hibernate.usertype.UserType#nullSafeGet(java.sql.ResultSet, java.lang.String[], java.lang.Object)
     */
    /**
     * retrieves the stored SQL Timestamp and converts it from UTC time to a Date object
     */
    @Override
    public Object nullSafeGet( ResultSet rs, String[] names, Object owner ) throws SQLException
	{
	if (rs.getTimestamp(names[0]) == null)
	    return null;

	return new Date(rs.getTimestamp(names[0], sUTCCalendar).getTime());
	}

    /* (non-Javadoc)
     * @see org.hibernate.usertype.UserType#nullSafeSet(java.sql.PreparedStatement, java.lang.Object, int)
     */
    /**
     * stores the Date object in a SQL Timestamp in UTC time timestamp
     */
    @Override
    public void nullSafeSet( PreparedStatement st, Object value, int index ) throws SQLException
	{
	if (value == null)
	    {
	    st.setTimestamp(index, null);
	    return;
	    }

	if (!(value instanceof Date))
	    value = deepCopy(value);
	st.setTimestamp(index,
			new Timestamp(((Date) value).getTime()),
			sUTCCalendar);
	}

    /* (non-Javadoc)
     * @see org.hibernate.usertype.UserType#assemble(java.io.Serializable, java.lang.Object)
     */
    @Override
    public Object assemble( Serializable cached, Object owner ) throws HibernateException
	{
	return deepCopy(cached);
	}

    /* (non-Javadoc)
     * @see org.hibernate.usertype.UserType#disassemble(java.lang.Object)
     */
    @Override
    public Serializable disassemble( Object value ) throws HibernateException
	{
	return (Serializable) deepCopy(value);
	}

    /* (non-Javadoc)
     * @see org.hibernate.usertype.UserType#hashCode(java.lang.Object)
     */
    @Override
    public int hashCode( Object x ) throws HibernateException
	{
	return x.hashCode();
	}

    /* (non-Javadoc)
     * @see org.hibernate.usertype.UserType#replace(java.lang.Object, java.lang.Object, java.lang.Object)
     */
    @Override
    public Object replace( Object original, Object target, Object owner ) throws HibernateException
	{
	return deepCopy(original);
	}
        }

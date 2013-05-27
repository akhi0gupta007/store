package com.akhi.store.product;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenerationTime;

import com.akhi.store.general.User;

@Entity(name = "vendor")
public class Vendor
    {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long    id;

    @Column(nullable = false)
    private String  ven_name;

    @Column(nullable = true)
    private String  description;

    @Column(name = "DATE_CREATED", insertable = false, updatable = false, columnDefinition = "timestamp default current_timestamp")
    @org.hibernate.annotations.Generated(value = GenerationTime.INSERT)
    @Temporal(TemporalType.TIMESTAMP)
    private Date    dateCreated;

    @ManyToOne()
    @JoinColumn(name = "USER_ID", nullable = false)
    private User    user;

    @Column(nullable = true)
    private String  website;

    @Column(nullable = true)
    private boolean showColl = true;

    /**
     * @return Returns the dateCreated.
     */
    public Date getDateCreated()
	{
	return dateCreated;
	}

    /**
     * @return Returns the description.
     */
    public String getDescription()
	{
	return description;
	}

    public String getVen_name()
	{
	return ven_name;
	}

    /**
     * @return Returns the website.
     */
    public String getWebsite()
	{
	return website;
	}

    /**
     * @return Returns the showColl.
     */
    public boolean isShowColl()
	{
	return showColl;
	}

    /**
     * @param dateCreated The dateCreated to set.
     */
    public void setDateCreated( Date dateCreated )
	{
	this.dateCreated = dateCreated;
	}

    /**
     * @param description The description to set.
     */
    public void setDescription( String description )
	{
	this.description = description;
	}

    /**
     * @param showColl The showColl to set.
     */
    public void setShowColl( boolean showColl )
	{
	this.showColl = showColl;
	}

    public void setVen_name( String ven_name )
	{
	this.ven_name = ven_name;
	}

    /**
     * @param website The website to set.
     */
    public void setWebsite( String website )
	{
	this.website = website;
	}
    }

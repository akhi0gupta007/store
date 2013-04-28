/**
 * 
 */
package com.akhi.store.general;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.validator.Email;

/**
 * @author akhilesh
 * 
 */
@Entity(name = "user")
public class User
    {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long    id;

    @Column(nullable = false, unique = true)
    private String  userId;

    @Column(nullable = false)
    private String  password;

    @Column(nullable = false, unique = true)
    @Email
    private String  emailId;

    @Column(name = "DATE_CREATED", insertable = false, updatable = false, columnDefinition = "timestamp default current_timestamp")
    @org.hibernate.annotations.Generated(value = GenerationTime.INSERT)
    @Temporal(TemporalType.TIMESTAMP)
    private Date    dateCreated;

    @Column(nullable = true)
    private String  aboutUs;

    @Column(nullable = true)
    private String  domain;

    @OneToOne(cascade =
	{ CascadeType.ALL }, mappedBy = "user")
    private Profile profile;

    public String getUserId()
	{
	return userId;
	}

    public void setUserId( String userId )
	{
	this.userId = userId;
	}

    public String getPassword()
	{
	return password;
	}

    public void setPassword( String password )
	{
	this.password = password;
	}

    public String getEmailId()
	{
	return emailId;
	}

    public void setEmailId( String emailId )
	{
	this.emailId = emailId;
	}

    public Date getDateCreated()
	{
	return dateCreated;
	}

    public void setDateCreated( Date dateCreated )
	{
	this.dateCreated = dateCreated;
	}

    public String getAboutUs()
	{
	return aboutUs;
	}

    public void setAboutUs( String aboutUs )
	{
	this.aboutUs = aboutUs;
	}

    public String getDomain()
	{
	return domain;
	}

    public void setDomain( String domain )
	{
	this.domain = domain;
	}

    public Profile getProfile()
	{
	return profile;
	}

    public void setProfile( Profile profile )
	{
	this.profile = profile;
	}

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
	{
	return "User [id=" + id + ", userId=" + userId + ", password=" + password + ", emailId=" + emailId + ", dateCreated=" + dateCreated + ", aboutUs=" + aboutUs + ", domain=" + domain + ", profile=" + profile + "]";
	}

    }

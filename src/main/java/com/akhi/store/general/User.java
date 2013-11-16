/**
 * 
 */
package com.akhi.store.general;

import java.util.Set;
import java.util.Date;
import java.util.HashSet;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.validator.Email;

import com.akhi.store.product.Category;
import com.akhi.store.product.Product;
import com.akhi.store.product.Tag;
import com.akhi.store.product.Vendor;

/**
 * @author akhilesh
 * 
 */
@Entity(name = "user")
@XmlRootElement
public class User extends Props
    {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long		 id;

    @Column(nullable = false, unique = true)
    private String	       userId;

    @Column(nullable = false)
    private String	       password;

    @Column(nullable = false, unique = true)
    @Email
    private String	       emailId;

    @Column(name = "DATE_CREATED", insertable = false, updatable = false, columnDefinition = "timestamp default current_timestamp")
    @org.hibernate.annotations.Generated(value = GenerationTime.INSERT)
    @Temporal(TemporalType.TIMESTAMP)
    private Date		 dateCreated;

    @Column(nullable = true)
    private String	       aboutUs;

    @Column(nullable = true)
    private String	       domain;

    @OneToOne(cascade = CascadeType.ALL, optional = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "PROFILE_ID")
    @Cascade({org.hibernate.annotations.CascadeType.DELETE_ORPHAN})
    private Profile	      profile;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
    @Cascade({org.hibernate.annotations.CascadeType.DELETE_ORPHAN})
    private Set<Product>  products   = new HashSet<Product>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
    private Set<Vendor>   vendors    = new HashSet<Vendor>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
    private Set<Category> catogories = new HashSet<Category>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
    private Set<Tag>      tags       = new HashSet<Tag>();

    /**
     * @return Returns the tags.
     */
    public Set<Tag> getTags()
	{
	return tags;
	}

    /**
     * @param tags The tags to set.
     */
    public void setTags( Set<Tag> tags )
	{
	this.tags = tags;
	}

    /**
     * @return Returns the catogories.
     */
    public Set<Category> getCatogories()
	{
	return catogories;
	}

    /**
     * @param catogories The catogories to set.
     */
    public void setCatogories( Set<Category> catogories )
	{
	this.catogories = catogories;
	}

    /**
     * @return Returns the vendors.
     */
    public Set<Vendor> getVendors()
	{
	return vendors;
	}

    /**
     * @param vendors The vendors to set.
     */
    public void setVendors( Set<Vendor> vendors )
	{
	this.vendors = vendors;
	}

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

    /**
     * @return Returns the id.
     */
    public long getId()
	{
	return id;
	}

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
	{
	return "User [id=" + id + ", userId=" + userId + ", password=" + password + ", emailId=" + emailId + ", dateCreated=" + dateCreated + ", aboutUs=" + aboutUs + ", domain=" + domain + ", profile=" + profile + "]";
	}

    public Set<Product> getProducts()
	{
	return products;
	}

    public void setProducts( Set<Product> products )
	{
	this.products = products;
	}

    }

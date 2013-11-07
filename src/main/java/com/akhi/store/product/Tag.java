/**---------------------------------------------------------------------*
 * filename     : Tag.java
 * date         : Jun 6, 2013
 * Author       : akhilesh
 *
 * Changes      : See javadoc object description
 *----------------------------------------------------------------------*
 */
package com.akhi.store.product;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.akhi.store.general.Props;
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
*     Jun 6, 2013 | akhilesh   | Original
* </PRE>
*
* @since       JDK1.4.2_07
*
*/
/*-----------------------------------------------------------------------*/

@Entity(name = "tag")
public class Tag extends Props
    {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long   id;

    @Column(nullable = false)
    private String name;

    @ManyToOne(optional = false)
    @JoinColumn(name = "USER_ID", nullable = false)
    private User   user;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "TAG_PRODUCT", joinColumns =
	{ @JoinColumn(nullable = false, name = "TAG_ID") }, inverseJoinColumns =
	{ @JoinColumn(nullable = false, name = "PRODUCT_ID") })
    Set<Product>   products = new HashSet<Product>();

    public Tag(String name, User user)
	{
	super();
	this.name = name;
	this.user = user;
	}

    public Tag()
	{
	}

    /**
     * @return Returns the user.
     */
    public User getUser()
	{
	return user;
	}

    /**
     * @param user The user to set.
     */
    public void setUser( User user )
	{
	this.user = user;
	}

    /**
     * @return Returns the name.
     */
    public String getName()
	{
	return name;
	}

    /**
     * @param name The name to set.
     */
    public void setName( String name )
	{
	this.name = name;
	}

    /**
     * @return Returns the products.
     */
    public Set<Product> getProducts()
	{
	return products;
	}

    /**
     * @param products The products to set.
     */
    public void setProducts( Set<Product> products )
	{
	this.products = products;
	}

    public Long getId()
	{
	// TODO Auto-generated method stub
	return id;
	}

    }

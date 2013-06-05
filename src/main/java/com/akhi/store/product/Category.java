/**---------------------------------------------------------------------*
 * filename     : Category.java
 * date         : Jun 5, 2013
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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
*     Jun 5, 2013 | akhilesh   | Original
* </PRE>
*
* @since       JDK1.4.2_07
*
*/
/*-----------------------------------------------------------------------*/
@Entity(name = "catogory")
public class Category extends Props
    {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column(nullable=false)
    private String name;
    
    @Column(nullable=true)
    private String description;
    
    @ManyToOne(optional = false)
    @JoinColumn(nullable=false)
    private User user;
    
    @ManyToMany(mappedBy="categories")
    private Set<Product> products = new HashSet<Product>();

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
     * @return Returns the description.
     */
    public String getDescription()
        {
        return description;
        }

    /**
     * @param description The description to set.
     */
    public void setDescription( String description )
        {
        this.description = description;
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

    /**
     * @return Returns the id.
     */
    public long getId()
        {
        return id;
        }
    


    }

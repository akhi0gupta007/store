package com.akhi.store.product;

import org.springframework.web.multipart.MultipartFile;

public class ProductVO
    {

	private Long id;
	
    private String name;

    private String description;

    private String pro_id;

    private String tag;

    private String vendor;

    private String category;

    private Double weight;

    private Double sel_price;

    private String image;

    private String coll;

    private String vendors;
    
    private MultipartFile file;
    

    public MultipartFile getFile()
        {
        return file;
        }

    public void setFile( MultipartFile file )
        {
        this.file = file;
        }

   
    @Override
    public String toString()
	{
	return "ProductVO [name=" + name + ", description=" + description + ", pro_id=" + pro_id + ", tag=" + tag + ", vendor=" + vendor + ", category=" + category + ", weight=" + weight + ", sel_price=" + sel_price + ", image=" + image + ", coll=" + coll + ", vendors=" + vendors + ", file=" + file + "]";
	}

    public String getColl()
        {
        return coll;
        }

    public void setColl( String coll )
        {
        this.coll = coll;
        }

    public String getVendors()
        {
        return vendors;
        }

    public void setVendors( String vendors )
        {
        this.vendors = vendors;
        }

    public String getPro_id()
	{
	return pro_id;
	}

    public void setPro_id( String pro_id )
	{
	this.pro_id = pro_id;
	}

    public String getTag()
	{
	return tag;
	}

    public void setTag( String tag )
	{
	this.tag = tag;
	}

    public String getVendor()
	{
	return vendor;
	}

    public void setVendor( String vendor )
	{
	this.vendor = vendor;
	}

    public String getCategory()
	{
	return category;
	}

    public void setCategory( String category )
	{
	this.category = category;
	}

    public Double getWeight()
	{
	return weight;
	}

    public void setWeight( Double weight )
	{
	this.weight = weight;
	}

    public Double getSel_price()
	{
	return sel_price;
	}

    public void setSel_price( Double sel_price )
	{
	this.sel_price = sel_price;
	}

    public String getImage()
	{
	return image;
	}

    public void setImage( String image )
	{
	this.image = image;
	}

    public String getName()
	{
	return name;
	}

    public void setName( String name )
	{
	this.name = name;
	}

    public String getDescription()
	{
	return description;
	}

    public void setDescription( String description )
	{
	this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

    }

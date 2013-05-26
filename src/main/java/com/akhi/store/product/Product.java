/**
 * 
 */
package com.akhi.store.product;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenerationTime;

/**
 * @author akhilesh
 * 
 */
@Entity(name = "product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(nullable = false)
	private String title;
	@Column(nullable = true)
	private String description;
	@Column(nullable = true)
	private Vendor vendor;
	@Column(nullable = true)
	private ProType type;
	@Column(nullable = true)
	private String image;
	@Column(nullable = false)
	private Double sel_price;
	@Column(nullable = true)
	private Double list_price;
	@Column(nullable = true)
	private Double weight;
	@Column(nullable = true)
	private String dimen;
	@Column(nullable = true)
	private String pkg_dimen;
	@Column(nullable = false, unique = true)
	private String pro_id;
	@Column(nullable = true)
	private int quan = 0;
	@Column(nullable = true)
	private boolean tax;
	@Column(nullable = true)
	private boolean ship_addr;
	@Column(nullable = true)
	private boolean ofo;
	@Column(nullable = true)
	private Date avail;
	@Column(name = "DATE_CREATED", insertable = false, updatable = false, columnDefinition = "timestamp default current_timestamp")
	@org.hibernate.annotations.Generated(value = GenerationTime.INSERT)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;
	@Column(nullable = true)
	private Variants variants;
	@Column(nullable = true)
	private ProTemplates proTemplates;

	/*
	 * static hasMany = [collection:CustomCollection,tags:Tag] static
	 * constraints = { sel_price(blank:false) proTemplates(nullable: true)
	 * title(blank:false) list_price(nullable:true)
	 * description(size:3..2000,nullable: true) image(nullable:true)
	 * title(blank:false) vendor(nullable:true) type(nullable:true)
	 * image(nullable:true) weight(nullable:true) dimen(nullable:true)
	 * pkg_dimen(nullable:true) pro_id(nullable: true) quan(nullable:true)
	 * avail(nullable:true) variants(nullable:true) } static mapping = { vendor
	 * fetch: 'join' type fetch: 'join' tablePerHierarchy false sort
	 * dateCreated:"desc"
	 * 
	 * }
	 */
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	public ProType getType() {
		return type;
	}

	public void setType(ProType type) {
		this.type = type;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Double getSel_price() {
		return sel_price;
	}

	public void setSel_price(Double sel_price) {
		this.sel_price = sel_price;
	}

	public Double getList_price() {
		return list_price;
	}

	public void setList_price(Double list_price) {
		this.list_price = list_price;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public String getDimen() {
		return dimen;
	}

	public void setDimen(String dimen) {
		this.dimen = dimen;
	}

	public String getPkg_dimen() {
		return pkg_dimen;
	}

	public void setPkg_dimen(String pkg_dimen) {
		this.pkg_dimen = pkg_dimen;
	}

	public String getPro_id() {
		return pro_id;
	}

	public void setPro_id(String pro_id) {
		this.pro_id = pro_id;
	}

	public int getQuan() {
		return quan;
	}

	public void setQuan(int quan) {
		this.quan = quan;
	}

	public boolean isTax() {
		return tax;
	}

	public void setTax(boolean tax) {
		this.tax = tax;
	}

	public boolean isShip_addr() {
		return ship_addr;
	}

	public void setShip_addr(boolean ship_addr) {
		this.ship_addr = ship_addr;
	}

	public boolean isOfo() {
		return ofo;
	}

	public void setOfo(boolean ofo) {
		this.ofo = ofo;
	}

	public Date getAvail() {
		return avail;
	}

	public void setAvail(Date avail) {
		this.avail = avail;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Variants getVariants() {
		return variants;
	}

	public void setVariants(Variants variants) {
		this.variants = variants;
	}

	public ProTemplates getProTemplates() {
		return proTemplates;
	}

	public void setProTemplates(ProTemplates proTemplates) {
		this.proTemplates = proTemplates;
	}

}

/**---------------------------------------------------------------------*
 * filename     : Products.java
 * date         : Aug 2, 2013
 * Author       : adc
 *
 * Changes      : See javadoc object description
 *----------------------------------------------------------------------*
 */
package com.akhi.store.product;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

/*-----------------------------------------------------------------------*//**
*
* @author      adc
* @version     %R%
*
* <BR><B>Revision History:</B><BR>
* <PRE>
*     Date        | User  | Description
*     ------------------------------------------------------------
*     Aug 2, 2013 | adc   | Original
* </PRE>
*
* @since       JDK1.4.2_07
*
*/
/*-----------------------------------------------------------------------*/

@Entity
@Table(name = "PRODUCTS")
public class Products
    {

    private String company;

    private String product_code;

    private String type_product;

    private String product_cat;

    private String brand_code;

    private String um_code;

    private String price_cat;

    private String packing;

    private String product_name;

    private String product_other_name;

    private String default_name;

    private String description;

    private String old_product_code;

    private Double gross_weight;

    private Double net_weight;

    private Double max_level;

    private Double reorder_level;

    private Double reorder_quan;

    private String abc_code;

    private String ved_code;

    private String high_value_flag;

    private Double total_stock_qty;

    private Double total_stock_value;

    private String month_opening_qty;

    private Double month_opening_value;

    private Double year_opening_qty;

    private Double year_opening_val;

    private String type_sale;

    private String status;

    private String created_by;

    private Date   created_on;

    private String last_updated_by;

    private Date   last_upd_on;

    private String local_sale_gl_code;

    private String local_sale_gl_sub_code;

    private String export_sale_gl_code;

    private String export_sale_gl_sub_code;

    private String packing_size_code;

    private String ref_product_code;

    private int    print_seq_no;

    private String schedule_no;

    private String hsn_code;

    private String k_entry_no;

    private String business_line;

    private String product_classification;

    private int    cases_size;

    private String buss_code;

    /**
     * @return Returns the company.
     */
    public String getCompany()
        {
        return company;
        }

    /**
     * @param company The company to set.
     */
    public void setCompany( String company )
        {
        this.company = company;
        }

    /**
     * @return Returns the product_code.
     */
    public String getProduct_code()
        {
        return product_code;
        }

    /**
     * @param product_code The product_code to set.
     */
    public void setProduct_code( String product_code )
        {
        this.product_code = product_code;
        }

    /**
     * @return Returns the type_product.
     */
    public String getType_product()
        {
        return type_product;
        }

    /**
     * @param type_product The type_product to set.
     */
    public void setType_product( String type_product )
        {
        this.type_product = type_product;
        }

    /**
     * @return Returns the product_cat.
     */
    public String getProduct_cat()
        {
        return product_cat;
        }

    /**
     * @param product_cat The product_cat to set.
     */
    public void setProduct_cat( String product_cat )
        {
        this.product_cat = product_cat;
        }

    /**
     * @return Returns the brand_code.
     */
    public String getBrand_code()
        {
        return brand_code;
        }

    /**
     * @param brand_code The brand_code to set.
     */
    public void setBrand_code( String brand_code )
        {
        this.brand_code = brand_code;
        }

    /**
     * @return Returns the um_code.
     */
    public String getUm_code()
        {
        return um_code;
        }

    /**
     * @param um_code The um_code to set.
     */
    public void setUm_code( String um_code )
        {
        this.um_code = um_code;
        }

    /**
     * @return Returns the price_cat.
     */
    public String getPrice_cat()
        {
        return price_cat;
        }

    /**
     * @param price_cat The price_cat to set.
     */
    public void setPrice_cat( String price_cat )
        {
        this.price_cat = price_cat;
        }

    /**
     * @return Returns the packing.
     */
    public String getPacking()
        {
        return packing;
        }

    /**
     * @param packing The packing to set.
     */
    public void setPacking( String packing )
        {
        this.packing = packing;
        }

    /**
     * @return Returns the product_name.
     */
    public String getProduct_name()
        {
        return product_name;
        }

    /**
     * @param product_name The product_name to set.
     */
    public void setProduct_name( String product_name )
        {
        this.product_name = product_name;
        }

    /**
     * @return Returns the product_other_name.
     */
    public String getProduct_other_name()
        {
        return product_other_name;
        }

    /**
     * @param product_other_name The product_other_name to set.
     */
    public void setProduct_other_name( String product_other_name )
        {
        this.product_other_name = product_other_name;
        }

    /**
     * @return Returns the default_name.
     */
    public String getDefault_name()
        {
        return default_name;
        }

    /**
     * @param default_name The default_name to set.
     */
    public void setDefault_name( String default_name )
        {
        this.default_name = default_name;
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
     * @return Returns the old_product_code.
     */
    public String getOld_product_code()
        {
        return old_product_code;
        }

    /**
     * @param old_product_code The old_product_code to set.
     */
    public void setOld_product_code( String old_product_code )
        {
        this.old_product_code = old_product_code;
        }

    /**
     * @return Returns the gross_weight.
     */
    public Double getGross_weight()
        {
        return gross_weight;
        }

    /**
     * @param gross_weight The gross_weight to set.
     */
    public void setGross_weight( Double gross_weight )
        {
        this.gross_weight = gross_weight;
        }

    /**
     * @return Returns the net_weight.
     */
    public Double getNet_weight()
        {
        return net_weight;
        }

    /**
     * @param net_weight The net_weight to set.
     */
    public void setNet_weight( Double net_weight )
        {
        this.net_weight = net_weight;
        }

    /**
     * @return Returns the max_level.
     */
    public Double getMax_level()
        {
        return max_level;
        }

    /**
     * @param max_level The max_level to set.
     */
    public void setMax_level( Double max_level )
        {
        this.max_level = max_level;
        }

    /**
     * @return Returns the reorder_level.
     */
    public Double getReorder_level()
        {
        return reorder_level;
        }

    /**
     * @param reorder_level The reorder_level to set.
     */
    public void setReorder_level( Double reorder_level )
        {
        this.reorder_level = reorder_level;
        }

    /**
     * @return Returns the reorder_quan.
     */
    public Double getReorder_quan()
        {
        return reorder_quan;
        }

    /**
     * @param reorder_quan The reorder_quan to set.
     */
    public void setReorder_quan( Double reorder_quan )
        {
        this.reorder_quan = reorder_quan;
        }

    /**
     * @return Returns the abc_code.
     */
    public String getAbc_code()
        {
        return abc_code;
        }

    /**
     * @param abc_code The abc_code to set.
     */
    public void setAbc_code( String abc_code )
        {
        this.abc_code = abc_code;
        }

    /**
     * @return Returns the ved_code.
     */
    public String getVed_code()
        {
        return ved_code;
        }

    /**
     * @param ved_code The ved_code to set.
     */
    public void setVed_code( String ved_code )
        {
        this.ved_code = ved_code;
        }

    /**
     * @return Returns the high_value_flag.
     */
    public String getHigh_value_flag()
        {
        return high_value_flag;
        }

    /**
     * @param high_value_flag The high_value_flag to set.
     */
    public void setHigh_value_flag( String high_value_flag )
        {
        this.high_value_flag = high_value_flag;
        }

    /**
     * @return Returns the total_stock_qty.
     */
    public Double getTotal_stock_qty()
        {
        return total_stock_qty;
        }

    /**
     * @param total_stock_qty The total_stock_qty to set.
     */
    public void setTotal_stock_qty( Double total_stock_qty )
        {
        this.total_stock_qty = total_stock_qty;
        }

    /**
     * @return Returns the total_stock_value.
     */
    public Double getTotal_stock_value()
        {
        return total_stock_value;
        }

    /**
     * @param total_stock_value The total_stock_value to set.
     */
    public void setTotal_stock_value( Double total_stock_value )
        {
        this.total_stock_value = total_stock_value;
        }

    /**
     * @return Returns the month_opening_qty.
     */
    public String getMonth_opening_qty()
        {
        return month_opening_qty;
        }

    /**
     * @param month_opening_qty The month_opening_qty to set.
     */
    public void setMonth_opening_qty( String month_opening_qty )
        {
        this.month_opening_qty = month_opening_qty;
        }

    /**
     * @return Returns the month_opening_value.
     */
    public Double getMonth_opening_value()
        {
        return month_opening_value;
        }

    /**
     * @param month_opening_value The month_opening_value to set.
     */
    public void setMonth_opening_value( Double month_opening_value )
        {
        this.month_opening_value = month_opening_value;
        }

    /**
     * @return Returns the year_opening_qty.
     */
    public Double getYear_opening_qty()
        {
        return year_opening_qty;
        }

    /**
     * @param year_opening_qty The year_opening_qty to set.
     */
    public void setYear_opening_qty( Double year_opening_qty )
        {
        this.year_opening_qty = year_opening_qty;
        }

    /**
     * @return Returns the year_opening_val.
     */
    public Double getYear_opening_val()
        {
        return year_opening_val;
        }

    /**
     * @param year_opening_val The year_opening_val to set.
     */
    public void setYear_opening_val( Double year_opening_val )
        {
        this.year_opening_val = year_opening_val;
        }

    /**
     * @return Returns the type_sale.
     */
    public String getType_sale()
        {
        return type_sale;
        }

    /**
     * @param type_sale The type_sale to set.
     */
    public void setType_sale( String type_sale )
        {
        this.type_sale = type_sale;
        }

    /**
     * @return Returns the status.
     */
    public String getStatus()
        {
        return status;
        }

    /**
     * @param status The status to set.
     */
    public void setStatus( String status )
        {
        this.status = status;
        }

    /**
     * @return Returns the created_by.
     */
    public String getCreated_by()
        {
        return created_by;
        }

    /**
     * @param created_by The created_by to set.
     */
    public void setCreated_by( String created_by )
        {
        this.created_by = created_by;
        }

    /**
     * @return Returns the created_on.
     */
    public Date getCreated_on()
        {
        return created_on;
        }

    /**
     * @param created_on The created_on to set.
     */
    public void setCreated_on( Date created_on )
        {
        this.created_on = created_on;
        }

    /**
     * @return Returns the last_updated_by.
     */
    public String getLast_updated_by()
        {
        return last_updated_by;
        }

    /**
     * @param last_updated_by The last_updated_by to set.
     */
    public void setLast_updated_by( String last_updated_by )
        {
        this.last_updated_by = last_updated_by;
        }

    /**
     * @return Returns the last_upd_on.
     */
    public Date getLast_upd_on()
        {
        return last_upd_on;
        }

    /**
     * @param last_upd_on The last_upd_on to set.
     */
    public void setLast_upd_on( Date last_upd_on )
        {
        this.last_upd_on = last_upd_on;
        }

    /**
     * @return Returns the local_sale_gl_code.
     */
    public String getLocal_sale_gl_code()
        {
        return local_sale_gl_code;
        }

    /**
     * @param local_sale_gl_code The local_sale_gl_code to set.
     */
    public void setLocal_sale_gl_code( String local_sale_gl_code )
        {
        this.local_sale_gl_code = local_sale_gl_code;
        }

    /**
     * @return Returns the local_sale_gl_sub_code.
     */
    public String getLocal_sale_gl_sub_code()
        {
        return local_sale_gl_sub_code;
        }

    /**
     * @param local_sale_gl_sub_code The local_sale_gl_sub_code to set.
     */
    public void setLocal_sale_gl_sub_code( String local_sale_gl_sub_code )
        {
        this.local_sale_gl_sub_code = local_sale_gl_sub_code;
        }

    /**
     * @return Returns the export_sale_gl_code.
     */
    public String getExport_sale_gl_code()
        {
        return export_sale_gl_code;
        }

    /**
     * @param export_sale_gl_code The export_sale_gl_code to set.
     */
    public void setExport_sale_gl_code( String export_sale_gl_code )
        {
        this.export_sale_gl_code = export_sale_gl_code;
        }

    /**
     * @return Returns the export_sale_gl_sub_code.
     */
    public String getExport_sale_gl_sub_code()
        {
        return export_sale_gl_sub_code;
        }

    /**
     * @param export_sale_gl_sub_code The export_sale_gl_sub_code to set.
     */
    public void setExport_sale_gl_sub_code( String export_sale_gl_sub_code )
        {
        this.export_sale_gl_sub_code = export_sale_gl_sub_code;
        }

    /**
     * @return Returns the packing_size_code.
     */
    public String getPacking_size_code()
        {
        return packing_size_code;
        }

    /**
     * @param packing_size_code The packing_size_code to set.
     */
    public void setPacking_size_code( String packing_size_code )
        {
        this.packing_size_code = packing_size_code;
        }

    /**
     * @return Returns the ref_product_code.
     */
    public String getRef_product_code()
        {
        return ref_product_code;
        }

    /**
     * @param ref_product_code The ref_product_code to set.
     */
    public void setRef_product_code( String ref_product_code )
        {
        this.ref_product_code = ref_product_code;
        }

    /**
     * @return Returns the print_seq_no.
     */
    public int getPrint_seq_no()
        {
        return print_seq_no;
        }

    /**
     * @param print_seq_no The print_seq_no to set.
     */
    public void setPrint_seq_no( int print_seq_no )
        {
        this.print_seq_no = print_seq_no;
        }

    /**
     * @return Returns the schedule_no.
     */
    public String getSchedule_no()
        {
        return schedule_no;
        }

    /**
     * @param schedule_no The schedule_no to set.
     */
    public void setSchedule_no( String schedule_no )
        {
        this.schedule_no = schedule_no;
        }

    /**
     * @return Returns the hsn_code.
     */
    public String getHsn_code()
        {
        return hsn_code;
        }

    /**
     * @param hsn_code The hsn_code to set.
     */
    public void setHsn_code( String hsn_code )
        {
        this.hsn_code = hsn_code;
        }

    /**
     * @return Returns the k_entry_no.
     */
    public String getK_entry_no()
        {
        return k_entry_no;
        }

    /**
     * @param k_entry_no The k_entry_no to set.
     */
    public void setK_entry_no( String k_entry_no )
        {
        this.k_entry_no = k_entry_no;
        }

    /**
     * @return Returns the business_line.
     */
    public String getBusiness_line()
        {
        return business_line;
        }

    /**
     * @param business_line The business_line to set.
     */
    public void setBusiness_line( String business_line )
        {
        this.business_line = business_line;
        }

    /**
     * @return Returns the product_classification.
     */
    public String getProduct_classification()
        {
        return product_classification;
        }

    /**
     * @param product_classification The product_classification to set.
     */
    public void setProduct_classification( String product_classification )
        {
        this.product_classification = product_classification;
        }

    /**
     * @return Returns the cases_size.
     */
    public int getCases_size()
        {
        return cases_size;
        }

    /**
     * @param cases_size The cases_size to set.
     */
    public void setCases_size( int cases_size )
        {
        this.cases_size = cases_size;
        }

    /**
     * @return Returns the buss_code.
     */
    public String getBuss_code()
        {
        return buss_code;
        }

    /**
     * @param buss_code The buss_code to set.
     */
    public void setBuss_code( String buss_code )
        {
        this.buss_code = buss_code;
        }

    }

/**
 * 
 */
package com.akhi.store.service;

import com.akhi.store.product.Product;
import com.akhi.store.product.ProductVO;

/**
 * @author akhilesh
 * 
 */
public interface ProductService {

	Product persistProduct(ProductVO obj);

	
}

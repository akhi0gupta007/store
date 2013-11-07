package com.akhi.store.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.akhi.store.dao.ProductDao;
import com.akhi.store.general.ApiData;
import com.akhi.store.product.Category;
import com.akhi.store.product.Product;
import com.akhi.store.product.Tag;
import com.akhi.store.product.Vendor;

@Controller
@RequestMapping(value =
    { "/api" })
@SessionAttributes(value =
    { "customer" })
public class ApiController
    {
    private static org.apache.log4j.Logger log = Logger.getLogger(ApiController.class);

    @Autowired
    private ProductDao		     productDao;

    @RequestMapping(value =
	{ "/getVendors/{id}" }, method = RequestMethod.GET)
    public @ResponseBody
    ApiData getVendors( @PathVariable
    String id, ModelMap model, HttpSession session )
	{
	Map<Long, String> vo = new HashMap<Long, String>();
	ApiData data = new ApiData();
	List<Vendor> result = productDao.getVendors(Long.parseLong(id));
	log.info("apicontroller() " + result);

	for (Vendor ven : result)
	    {
	    vo.put(ven.getId(), ven.getVen_name());
	    }

	data.setData(vo);
	data.setSuccess(true);

	log.info("getVendors() , data " + data);
	return data;
	}

    @RequestMapping(value =
	{ "/getTags/{id}" }, method = RequestMethod.GET)
    public @ResponseBody
    ApiData getTags( @PathVariable
    String id, ModelMap model, HttpSession session )
	{
	Map<Long, String> vo = new HashMap<Long, String>();
	ApiData data = new ApiData();
	List<Tag> result = productDao.getTags(Long.parseLong(id));
	log.info("apicontroller() " + result);

	for (Tag ven : result)
	    {
	    vo.put(ven.getId(), ven.getName());
	    }

	data.setData(vo);
	data.setSuccess(true);

	log.info("getTags() , data " + data);
	return data;
	}

    @RequestMapping(value =
	{ "/getCategories/{id}" }, method = RequestMethod.GET)
    public @ResponseBody
    ApiData getCategories( @PathVariable
    String id, ModelMap model, HttpSession session )
	{
	Map<Long, String> vo = new HashMap<Long, String>();
	ApiData data = new ApiData();
	List<Category> result = productDao.getCatgories(Long.parseLong(id));
	log.info("apicontroller() " + result);

	for (Category ven : result)
	    {
	    vo.put(ven.getId(), ven.getName());
	    }

	data.setData(vo);
	data.setSuccess(true);

	log.info("getCategories() , data " + data);
	return data;
	}

    @RequestMapping(value =
	{ "/getProducts/{id}" }, method = RequestMethod.GET)
    public @ResponseBody
    ApiData getProducts( @PathVariable
    String id, ModelMap model, HttpSession session )
	{
	Map<Long, String> vo = new HashMap<Long, String>();
	ApiData data = new ApiData();
	List<Product> result = productDao.getProducts(Long.parseLong(id));
	log.info("apicontroller() " + result);

	for (Product ven : result)
	    {
	    vo.put(ven.getId(), ven.getTitle());
	    }

	data.setData(vo);
	data.setSuccess(true);

	log.info("getProducts() , data " + data);
	return data;
	}

    }

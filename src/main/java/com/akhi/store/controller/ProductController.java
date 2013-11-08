package com.akhi.store.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.akhi.store.general.User;
import com.akhi.store.product.Category;
import com.akhi.store.product.Product;
import com.akhi.store.product.Tag;
import com.akhi.store.product.Vendor;

@Controller
@RequestMapping(value =
    { "/product" })
@SessionAttributes(value =
    { "customer" })
public class ProductController
    {
    private static org.apache.log4j.Logger log = Logger.getLogger(ProductController.class);

    @RequestMapping(value =
	{ "/addProduct" }, method = RequestMethod.GET)
    public String addProduct( ModelMap model,
			      @RequestParam(value = "cat", defaultValue = "NAP")
			      String cat,
			      HttpSession session )
	{
	String result = "customer";

	if (session.getAttribute("customer") != null)
	    {
	    User user = (User) session.getAttribute("customer");

	    if (user != null)
		{
		Product product = new Product();
		Category category = new Category();
		Vendor vendor = new Vendor();
		Tag tag = new Tag();

		model.addAttribute("vendor", vendor);
		model.addAttribute("category", category);
		model.addAttribute("product", product);
		model.addAttribute("tag", tag);
		log.warn("Dash board , session is present for " + user);
		result = "addProduct";
		}
	    }

	return result;
	}

    @RequestMapping(value =
	{ "/newProduct" }, method = RequestMethod.POST)
    public String putProduct( ModelMap model,
			      HttpSession session,
			      @ModelAttribute("product")
			      Product product,
			      @ModelAttribute("vendor")
			      Vendor vendor,
			      @ModelAttribute("category")
			      Category category,
			      @ModelAttribute("tag")
			      Tag tag,
			      BindingResult bresult )
	{
	String result = null;
	log.warn("Adding product:    :::::::::::::" + product);
	log.warn("Adding Cat:    :::::::::::::" + category);
	log.warn("Adding tag:    :::::::::::::" + tag);
	log.warn("Adding vendor:    :::::::::::::" + vendor);
	result = "addProduct";
	return result;
	}

    public boolean isLong( String input )
	{
	try
	    {
	    Long.parseLong(input);
	    return true;
	    }
	catch (Exception ex)
	    {
	    return false;
	    }
	}

    }

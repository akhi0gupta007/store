package com.akhi.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.apache.log4j.Logger;

import com.akhi.store.general.User;
import com.akhi.store.service.UserService;
import com.akhi.store.validator.UserValidator;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value =
    { "/", "/home" })
@SessionAttributes(value =
    { "customer" })
public class HomeController
    {

    private static org.apache.log4j.Logger log = Logger.getLogger(HomeController.class);

    @Autowired
    private UserService		    service;

    @Autowired
    private UserValidator		  validator;

    @RequestMapping(method = RequestMethod.GET)
    public String home( ModelMap model )
	{
	log.info("HomeController home");
	User user = new User();
	model.addAttribute("customer", user);
	
	return "customer";
	}

    @RequestMapping(method = RequestMethod.POST)
    public String processLogin( @ModelAttribute("customer")
    User user, BindingResult result, SessionStatus status )
	{
	log.info("Process Login " + user);
	validator.validate(user, result);

	if (result.hasErrors())
	    {
	    return "customer";
	    }
	else
	    {
	    user = service.autheticate(user.getUserId(), user.getPassword());

	    return "customer";
	    }

	}

    public UserValidator getValidator()
	{
	return validator;
	}

    public void setValidator( UserValidator validator )
	{
	this.validator = validator;
	}

    }
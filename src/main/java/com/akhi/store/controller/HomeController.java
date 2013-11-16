package com.akhi.store.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.akhi.store.general.User;
import com.akhi.store.service.UserService;
import com.akhi.store.validator.UserValidator;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = { "/", "/home"
})
@SessionAttributes(value = { "customer"
})
public class HomeController
    {

    private static org.apache.log4j.Logger log = Logger.getLogger(HomeController.class);

    @Autowired(required = true)
    @Qualifier("daopowered")
    private UserService                    service;

    @Autowired
    private UserValidator                  validator;

    @RequestMapping(method = RequestMethod.GET)
    public String home( ModelMap model, HttpSession session )
	{
	log.info("HomeController home");
	User user = new User();
	model.addAttribute("customer", user);
	return "customer";
	}

    @RequestMapping(value = { "/logout"
    }, method = RequestMethod.GET)
    public String logout( ModelMap model, HttpSession session )
	{
	log.info("logout");

	model.clear();
	session.invalidate();
	log.warn("removed key");

	return "redirect:/";
	}

    @RequestMapping(value = { "/authenticate"
    }, method = RequestMethod.POST)
    public String processLogin( @ModelAttribute("customer") User user,
	                        BindingResult result,
	                        SessionStatus status,
	                        ModelMap model )
	{
	log.info("Process Login " + user);
	validator.validate(user, result);

	if (result.hasErrors())
	    {
	    return "customer";
	    }
	else
	    {
	    log.info("Before Service" + user);
	    user = service.autheticate(user.getUserId(), user.getPassword());

	    if (user != null)
		{
		model.addAttribute("customer", user);

		log.warn("<<<<<<<<<<<Redirecting to home page, Login process complete>>>>>>>>>>>>>>");
		return "redirect:/home/dashboard";
		}
	    else
		{
		model.addAttribute("error", "Wrong username or password");
		return "customer";
		}
	    }

	}

    @RequestMapping(value = { "/home/dashboard"
    }, method = RequestMethod.GET)
    public String dashboard( SessionStatus status, ModelMap model )
	{
	log.info("Dashboard....................");
	if (model.containsKey("customer"))
	    {
	    User user = (User) model.get("customer");
	    model.addAttribute("customer", user);
	    log.info("Dashboard...................." + user);
	    return "success";
	    }
	log.error("No user........................." + model.get("customer"));
	return "customer";

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
package com.akhi.store.controller;

/**
 * Hello world!
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.apache.log4j.Logger;

import com.akhi.store.service.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController
    {

    private static org.apache.log4j.Logger log = Logger.getLogger(HomeController.class);

    @Autowired
    private UserService service ;

    @RequestMapping(value = {"/","/home"})
    public String home()
	{

	log.info("HomeController home");
	service.addUser(null );
	System.out.println("HomeController: Passing through...");
	return "customer";
	}
    }
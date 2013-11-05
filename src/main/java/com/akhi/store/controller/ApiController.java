package com.akhi.store.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.akhi.store.general.User;

@Controller
@RequestMapping(value =
    { "/api" })
@SessionAttributes(value =
    { "customer" })
public class ApiController
    {
    private static org.apache.log4j.Logger log = Logger.getLogger(ApiController.class);

    @RequestMapping(value =
	{ "/getVendors/{id}" }, method = RequestMethod.GET)
    public @ResponseBody
    List<List<String>> getVendors( @PathVariable
    String id, ModelMap model )
	{

	List<List<String>> parent = new ArrayList<List<String>>();

	if (model.containsKey("customer"))
	    {
	    User user = (User) model.get("customer");

	    if (user.getUserId() != null)
		{
		List<String> demo = new ArrayList<String>();
		demo.add("adesh:" + id);
		parent.add(demo);

		}
	    }
	else
	    {
	    log.error("No Session Found for this API");
	    }
	log.info("CartHelper , parent " + parent);
	return parent;
	}

    }

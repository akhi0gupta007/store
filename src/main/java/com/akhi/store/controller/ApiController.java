package com.akhi.store.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.akhi.store.general.ApiData;
import com.akhi.store.general.User;

@Controller
@RequestMapping(value = { "/api" })
@SessionAttributes(value = { "customer" })
public class ApiController {
	private static org.apache.log4j.Logger log = Logger
			.getLogger(ApiController.class);

	@RequestMapping(value = { "/getVendors/{id}" }, method = RequestMethod.GET)
	public @ResponseBody
	ApiData getVendors(@PathVariable String id, ModelMap model,
			HttpSession session) {

		ApiData data = new ApiData();

		User user = (User) session.getAttribute("customer");

		if (user != null) {
			//data.setData(user);
			data.setSuccess(true);

		} else {
			log.error("No session found");
		}

		log.info("CartHelper , data " + data);
		return data;
	}

}

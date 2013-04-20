package com.akhi;

/**
 * Hello world!
 */
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.apache.log4j.Logger;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static org.apache.log4j.Logger log = Logger
			.getLogger(HomeController.class);

	@RequestMapping(value = "/")
	public String home() {

		log.debug("Debug Message!.......................");
		log.info("Info Message!........................");

		log.error("Error Message!..........................");

		System.out.println("HomeController: Passing through...");
		return "WEB-INF/views/home.jsp";
	}
}
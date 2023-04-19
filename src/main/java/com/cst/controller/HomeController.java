package com.cst.controller;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/*
	 * { BasicConfigurator.configure(); }
	 */

	/**
	 * Shows Home Page
	 * @return "index" (home-page)
	 */
    @GetMapping("/")
    public String home() {
    	
    	//Log the API call
    	logger.info("Entering HomeController.home()");
    	
    	logger.info("Exiting HomeController.home()");

        return "index";
    }
    
    /**
     * Shows Logged In Message
     * @return index - home page
     */
    @GetMapping("/loggedIn")
    public String loggedIn() {
    	
    	//Log the API call
    	logger.info("Entering HomeController.loggedin()");
    	
    	return "index";
    }
    
    /**
     * Shows test page
     * @return trial - test only
     */
    @RequestMapping("/trial")
    public String tryMe() {
    	
    	//Log the API call
    	logger.info("Entering HomeController.tryme()");
    	
    	return "trial";
    }
	
}

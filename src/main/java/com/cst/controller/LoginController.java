package com.cst.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cst.business.RunningBackInterface;
import com.cst.business.RunningBackService;
import com.cst.data.RunningBackDataService;
import com.cst.entity.RBEntity;
import com.cst.model.Login;
import com.cst.model.User;
import com.cst.repository.PlayerRepository;

//Login Controller controls Login Page Actions
@SuppressWarnings("unused")
@Controller
public class LoginController {
	
	Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private RunningBackInterface service;
	
	@Autowired
	private RunningBackService orderService;
	
	@Autowired
	private PlayerRepository orderRepo;

	/**
	 * Shows Login Page
	 * @param model - Auto Injection of Model
	 * @param user - Auto Injected User Class
	 * @param login - Auto Injected Login Class
	 * @return login - Login Page
	 */
	@GetMapping("/login")
	public String display(Model model, User user, Login login) {
		
    	logger.info("Entering LoginController.display()");

		model.addAttribute("title", "Login Form");
		model.addAttribute("login", new Login());
		
    	logger.info("Exiting LoginController.display()");

		return "login";
	}

	public static Login login = new Login();//temp solution to passing the current login to other controllers
	
	/**
	 * Handles Login Response
	 * @param login - Auto Injected Login Class
	 * @param bindingResult - Auto Injected Binding Result Class
	 * @param model - Auto Injected Model
	 * @return viewOrders - Order Management Dashboard
	 */
	@SuppressWarnings("static-access")
	@PostMapping("/login")
	public String loginUser(/*@Valid*/@ModelAttribute Login login, BindingResult bindingResult, Model model) {		
		
    	logger.info("Entering LoginController.loginUser()");


		this.login = login;
		
		// Display something
		model.addAttribute("title", "Login Form");
		model.addAttribute("runningbacks", service.getRunningBacks());
		model.addAttribute("rbEntity", new RBEntity());
			
    	logger.info("Exiting LoginController.loginUser()");

		return "viewOrders";
	}
}
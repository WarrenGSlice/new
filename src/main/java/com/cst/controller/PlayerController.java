package com.cst.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cst.business.RunningBackInterface;
import com.cst.entity.Backs;
import com.cst.entity.RBEntity;
import com.cst.model.Login;
import com.cst.model.RBModel;
import com.cst.model.User;
import com.cst.repository.PlayerRepository;

@Controller
@RequestMapping("/productClone")
public class PlayerController {
	
	Logger logger = LoggerFactory.getLogger(PlayerController.class);

	@Autowired
	private RunningBackInterface service;
	
	@Autowired
	private PlayerRepository orderRepo;
	
	public static RBEntity orderEnt;
	
	/**
	 * Displays the Orders Page
	 * @param model - Auto Injected Model
	 * @param user - Auto Injected User
	 * @return productClone - Application Dashboard
	 */
	@GetMapping("/")
    public String displayProducts(Model model, User user) {
		
		//Log the API call
    	logger.info("Entering PlayerController.displayProducts()");
		
        model.addAttribute("title", "Product Form");
        model.addAttribute("user", new Login().getUsername());
        model.addAttribute("runningback", new RBModel());
        return "productClone";
    }
	
	
	
	/**
	 * Handles the Response of viewing Orders
	 * @param productClone - Injection of Product Model
	 * @param bindingResult - Injection of Binding Result
	 * @param model - Injection of Model
	 * @return products - View Products Page
	 */
	@PostMapping("/doProductClone")
	public String ProductPage(@ModelAttribute("runningbacks") RBModel productClone, BindingResult bindingResult, Model model) {		
		
		//Log the API call
    	logger.info("Entering PlayerController.ProductPage()");
			
		// Check for validation errors
		if (bindingResult.hasErrors()) {
			model.addAttribute("title", "Login Form");
			return "login";
		}
		
		model.addAttribute("Running Back Form", productClone); 
		model.addAttribute("runningbacks", service.getRunningBacks());
		return "runningbacks";
	}
	
	/**
	 * Displays the Dashboard
	 * @param login - Injection of Login
	 * @param model - Injection of Model
	 * @param bindingResult - Injection of BindingResult
	 * @return - viewOrders - View Orders Page
	 */
	// View Orders Response
	@GetMapping("/viewOrders")
	public String viewOrder(@ModelAttribute Login login, Model model, BindingResult bindingResult)
	{		
		//Log the API call
    	logger.info("Entering PlayerController.viewOrder()");
		
		model.addAttribute("title" , "View All Orders");
		model.addAttribute("rbEntity", new RBEntity());
		model.addAttribute("runningbacks" , service.getRunningBacks());
		model.addAttribute("login", new Login());
		
		return "viewOrders";
	}
	
	public static Login login = new Login();
	
	/**
	 * Displays the Display page
	 * @param login - Injection of Login Model
	 * @param model - Injection of Model
	 * @return viewOrders - View Orders Page
	 */
	@SuppressWarnings("static-access")
	@GetMapping("/display")
	public String loginUser(@ModelAttribute Login login, Model model) {		
		
		//Log the API call
    	logger.info("Entering PlayerController.loginUser()");
		
		this.login  = login;
		
		// Display something
		model.addAttribute("title", "Login Form");
		model.addAttribute("runningbacks", service.getRunningBacks());
		model.addAttribute("rbEntity", new RBEntity());
		
		
		return "viewOrders";
	}
	
	/**
	 * Shows the Edit Order Page Based on Order Id Selected
	 * @param rbId - Injection of Integer
	 * @param id - Injection of Integer
	 * @param form - Injection of Order Entity Entity
	 * @param session - Injection of HttpSession Attribute
	 * @param model - Injection of Model
	 * @param login - Injection of Login Model
	 * @return editOrder - Edit Order Page based on Order Id
	 */
	@GetMapping("/editOrder/{rbId}")
	public String displayFoundId (@RequestParam(required = false) Integer rbId, Integer id, @ModelAttribute("form") RBEntity form, HttpSession session, Model model, Login login ) {
		
		//Log the API call
    	logger.info("Entering PlayerController.displayFoundId()");
		
		if (form.getRbId() > 0) {
		}
		RBEntity ue;
		ue = orderRepo.findByRbId(form.getRbId());
		PlayerController.orderEnt = new RBEntity(ue);

		System.out.println("/editOrder RB ID: " + form.getRbId() + " " + "Player Name: " + form.getName() + " " +form.toString() );
		model.addAttribute("rbEntity", form);
		model.addAttribute("rbEntity", PlayerController.orderEnt);
		model.addAttribute("login", new Login());
		
		return "editOrder";
	}
	
	/**
	 * Creates Mapping for Order Deletion
	 * @param rbId - Injection of Integer
	 * @param id - Injection of Integer
	 * @param form - Injection of Order Entity Entity
	 * @param session - Injection of HttpSession Attribute
	 * @param model - Injection of Model
	 * @param login - Injection of Login Model
	 * @return removeOrder - Shows Remove Order Page for Order with the Id of orderId
	 */
	@GetMapping("/removeOrder/{rbId}")
	public String deleteSingle(@RequestParam(required = false) Integer rbId, Integer id, @ModelAttribute("form") RBEntity form, HttpSession session, Model model, Login login ) {
		
		//Log the API call
    	logger.info("Entering PlayerController.deleteSingle()");
			
		if (form.getRbId() > 0) {
		}
		RBEntity ue;
		ue = orderRepo.findByRbId(form.getRbId());
		PlayerController.orderEnt = new RBEntity(ue);
		
		System.out.println("/removeOrder RB ID: " + form.getRbId() + " " + "Player Name: " + form.getName() + " " +form.toString() );
		model.addAttribute("rbEntity", form);
		model.addAttribute("rbEntity", PlayerController.orderEnt);
		model.addAttribute("login", new Login());
			
		return "removeOrder";
	}
		
	/**
	 * Update Order Page Based on OrderId
	 * @param login - Auto Injection of Login Model
	 * @param rbEntity - Auto Injection of Order Entity Entity
	 * @param model - Auto Injection of Model
	 * @param bindingResult - Auto Injection of Binding Result
	 * @param backs - Auto Injection of Orders Entity
	 * @return viewOrder - Takes User back to the Dashboard
	 */
	@PostMapping("/changeOrder")
	public String updateOrder(@ModelAttribute Login login, RBEntity rbEntity, Model model, BindingResult bindingResult, Backs backs )
	{
		//Log the API call
    	logger.info("Entering PlayerController.updateOrder()");
		
		rbEntity.setRbId(rbEntity.getRbId());
		rbEntity.setRank(rbEntity.getRank());
		rbEntity.setName(rbEntity.getName());
		rbEntity.setTeam(rbEntity.getTeam());
		rbEntity.setByeWeek(rbEntity.getByeWeek());
		rbEntity.setPoints(rbEntity.getPoints());
		rbEntity.setRushAttempts(rbEntity.getRushAttempts());
		rbEntity.setRushYards(rbEntity.getRushYards());
		rbEntity.setRushTds(rbEntity.getRushTds());
		rbEntity.setReceptions(rbEntity.getReceptions());
		rbEntity.setRecYards(rbEntity.getRecYards());
		rbEntity.setRecTds(rbEntity.getRecTds());
		rbEntity.setFirstDowns(rbEntity.getFirstDowns());
		rbEntity.setHundredYardGame(rbEntity.getHundredYardGame());
		rbEntity.setTwoHundredYardGame(rbEntity.getTwoHundredYardGame());
		rbEntity.setFourtyYardPlay(rbEntity.getFourtyYardPlay());
		rbEntity.setFourtyYardTds(rbEntity.getFourtyYardTds());
		rbEntity.setPassCompleted(rbEntity.getPassCompleted());
		rbEntity.setPassYards(rbEntity.getPassYards());
		rbEntity.setPassTds(rbEntity.getPassTds());
		rbEntity.setFumbles(rbEntity.getFumbles());
		rbEntity.setFumblesLost(rbEntity.getFumblesLost());
		rbEntity.setTargetShare(rbEntity.getTargetShare());
		rbEntity.setPointsGame(rbEntity.getPointsGame());
		
		orderRepo.save(rbEntity);
		
		model.addAttribute("title", "Player Updated");
		model.addAttribute("rbEntity", new RBEntity());
		model.addAttribute("runningbacks", service.getRunningBacks());
		model.addAttribute("editOrder", rbEntity);
		model.addAttribute("runningbacks", rbEntity);
		model.addAttribute("login", new Login());
		
		return viewOrder(login, model, bindingResult); //changed from "viewOrders"
	}
	
	/**
	 * Handles Update Order Response Based on Order Id
	 * @param login - Auto Injection of Login Model
	 * @param rbEntity - Auto Injection of Order Entity Entity
	 * @param model - Auto Injection of Model
	 * @param bindingResult - Auto Injection of Binding Result
	 * @param backs - Auto Injection of Orders Entity
	 * @return viewOrders - Dashboard after Update Occurs
	 */
		@PostMapping("/removeOrder")
		public String deleteOrder(@ModelAttribute Login login, RBEntity rbEntity, Model model, BindingResult bindingResult, Backs backs )
		{
			//Log the API call
	    	logger.info("Entering PlayerController.deleteOrder()");
			
			rbEntity.setRbId(rbEntity.getRbId());
			rbEntity.setRank(rbEntity.getRank());
			rbEntity.setName(rbEntity.getName());
			rbEntity.setTeam(rbEntity.getTeam());
			rbEntity.setByeWeek(rbEntity.getByeWeek());
			rbEntity.setPoints(rbEntity.getPoints());
			rbEntity.setRushAttempts(rbEntity.getRushAttempts());
			rbEntity.setRushYards(rbEntity.getRushYards());
			rbEntity.setRushTds(rbEntity.getRushTds());
			rbEntity.setReceptions(rbEntity.getReceptions());
			rbEntity.setRecYards(rbEntity.getRecYards());
			rbEntity.setRecTds(rbEntity.getRecTds());
			rbEntity.setFirstDowns(rbEntity.getFirstDowns());
			rbEntity.setHundredYardGame(rbEntity.getHundredYardGame());
			rbEntity.setTwoHundredYardGame(rbEntity.getTwoHundredYardGame());
			rbEntity.setFourtyYardPlay(rbEntity.getFourtyYardPlay());
			rbEntity.setFourtyYardTds(rbEntity.getFourtyYardTds());
			rbEntity.setPassCompleted(rbEntity.getPassCompleted());
			rbEntity.setPassYards(rbEntity.getPassYards());
			rbEntity.setPassTds(rbEntity.getPassTds());
			rbEntity.setFumbles(rbEntity.getFumbles());
			rbEntity.setFumblesLost(rbEntity.getFumblesLost());
			rbEntity.setTargetShare(rbEntity.getTargetShare());
			rbEntity.setPointsGame(rbEntity.getPointsGame());
			
			orderRepo.delete(rbEntity);
			
			model.addAttribute("title", "Player Updated");
			model.addAttribute("rbEntity", new RBEntity());
			model.addAttribute("runningbacks", service.getRunningBacks());
			model.addAttribute("editOrder", rbEntity);
			model.addAttribute("runningbacks", rbEntity);
			model.addAttribute("login", new Login());
			
			return viewOrder(login, model, bindingResult); //changed from "viewOrders"
		}
	
		/**
		* Handles Add Order Response
		* @param login - Auto Injection of Login Model
		* @param rbEntity - Auto Injection of Order Entity Entity
		* @param model - Auto Injection of Model
		* @param bindingResult - Auto Injection of Binding Result
		* @param backs - Auto Injection of Orders Entity
		* @return viewOrder - Dashboard after Adding Desired Order
		*/
		@PostMapping("/addOrder")
		public String addOrder(@ModelAttribute Login login, RBEntity rbEntity, Model model, BindingResult bindingResult, Backs backs)
		{
			//Log the API call
	    	logger.info("Entering PlayerController.addOrder()");
			
			System.out.println("/addOrder RB ID: " + rbEntity.getRbId() + " " + rbEntity.toString() );
			
			rbEntity.setRbId(rbEntity.getRbId());
			rbEntity.setRank(rbEntity.getRank());
			rbEntity.setName(rbEntity.getName());
			rbEntity.setTeam(rbEntity.getTeam());
			rbEntity.setByeWeek(rbEntity.getByeWeek());
			rbEntity.setPoints(rbEntity.getPoints());
			rbEntity.setRushAttempts(rbEntity.getRushAttempts());
			rbEntity.setRushYards(rbEntity.getRushYards());
			rbEntity.setRushTds(rbEntity.getRushTds());
			rbEntity.setReceptions(rbEntity.getReceptions());
			rbEntity.setRecYards(rbEntity.getRecYards());
			rbEntity.setRecTds(rbEntity.getRecTds());
			rbEntity.setFirstDowns(rbEntity.getFirstDowns());
			rbEntity.setHundredYardGame(rbEntity.getHundredYardGame());
			rbEntity.setTwoHundredYardGame(rbEntity.getTwoHundredYardGame());
			rbEntity.setFourtyYardPlay(rbEntity.getFourtyYardPlay());
			rbEntity.setFourtyYardTds(rbEntity.getFourtyYardTds());
			rbEntity.setPassCompleted(rbEntity.getPassCompleted());
			rbEntity.setPassYards(rbEntity.getPassYards());
			rbEntity.setPassTds(rbEntity.getPassTds());
			rbEntity.setFumbles(rbEntity.getFumbles());
			rbEntity.setFumblesLost(rbEntity.getFumblesLost());
			rbEntity.setTargetShare(rbEntity.getTargetShare());
			rbEntity.setPointsGame(rbEntity.getPointsGame());
			
			orderRepo.save(rbEntity);
			
			model.addAttribute("title", "Player Created");
			model.addAttribute("rbEntity", new RBEntity());
			model.addAttribute("runningbacks", service.getRunningBacks());
			model.addAttribute("runningbacks", rbEntity);
			model.addAttribute("login", new Login());

			return viewOrder(login, model, bindingResult);
		}
		
		/**
		 * Used to Search for a Specific Player (Search Bar)
		 * @param login - Auto Injection of Login Model
		 * @param model - Auto Injection of Model
		 * @param searchTerm - Auto Injection of String type
		 * @return viewOrders - Dashboard with orders being searched for
		 */
		@RequestMapping(path = { "/search" })
		public String search(@ModelAttribute Login login, Model model, String searchTerm) {
			
			//Log the API call
	    	logger.info("Entering PlayerController.search()");
			
			System.out.println(searchTerm);
			ArrayList<RBModel> tempList = new ArrayList<RBModel>();
			if (searchTerm.isEmpty())
				model.addAttribute("runningbacks", service.getRunningBacks());
			else {
				try {
					String[] entry = searchTerm.split(":");
					switch (entry[0]) {
						case "id":
							service.getRunningBacks().forEach((p) -> {
								if (p.getRbId() == Integer.parseInt(entry[1]))
									tempList.add(p);
							});
							model.addAttribute("runningbacks", tempList);
							break;
						case "name":
							service.getRunningBacks().forEach((p) -> {
								if (p.getName().equalsIgnoreCase(entry[1]))
									tempList.add(p);
							});
							model.addAttribute("runningbacks", tempList);
							break;
						case "team":
							service.getRunningBacks().forEach((p) -> {
								if (p.getTeam().equalsIgnoreCase(entry[1]))
									tempList.add(p);
							});
							model.addAttribute("runningbacks", tempList);
							break;
						case "rank":
							service.getRunningBacks().forEach((p) -> {
								if (p.getRank() == Integer.parseInt(entry[1]))
									tempList.add(p);
							});
							model.addAttribute("runningbacks", tempList);
							break;
						case "points":
							service.getRunningBacks().forEach((p) -> {
								if (p.getPoints() == Float.parseFloat(entry[1]))
									tempList.add(p);
							});
							model.addAttribute("runningbacks", tempList);
							break;
						case "rushYards":
							service.getRunningBacks().forEach((p) -> {
								if (p.getRushYards() == Float.parseFloat(entry[1]))
									tempList.add(p);
							});
							model.addAttribute("runningbacks", tempList);
							break;
						case "rushTds":
							service.getRunningBacks().forEach((p) -> {
								if (p.getRushTds() == Integer.parseInt(entry[1]))
									tempList.add(p);
							});
							model.addAttribute("runningbacks", tempList);
							break;
						default:
							model.addAttribute("runningbacks", new ArrayList<RBModel>());
							break;
					}
				} catch (Exception e) {
					model.addAttribute("runningbacks", tempList);
					model.addAttribute("rbEntity", new RBEntity());
					return "viewOrders";
				}
			}
			model.addAttribute("rbEntity", new RBEntity());
			return "viewOrders";
		}
	
}

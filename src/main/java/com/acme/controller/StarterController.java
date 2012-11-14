package com.acme.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.acme.database.StarterDAO;
import com.acme.model.Starter;

 
@Controller
@RequestMapping("/starter")
public class StarterController {
	@Autowired
	private StarterDAO starterDAO;
	
	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		List<Starter> starterList = starterDAO.getStarters();
		model.addAttribute("starterList", starterList);
		return "starter";
 
	}

	public StarterDAO getStarterDAO() {
		return starterDAO;
	}

	public void setStarterDAO(StarterDAO starterDAO) {
		this.starterDAO = starterDAO;
	}

	
 
}


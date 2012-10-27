package com.acme.controller;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.acme.database.GameDAO;
import com.acme.database.GameDAOImpl;
import com.acme.model.Game;

 
@Controller
@RequestMapping("/schedule")
public class ScheduleController {
 
	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		GameDAO gameDAO = new GameDAOImpl();
		List<Game> gameList = gameDAO.getGames();
		model.addAttribute("gameList", gameList);
		return "schedule";
 
	}
 
}


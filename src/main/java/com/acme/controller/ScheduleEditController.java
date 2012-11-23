package com.acme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.acme.database.GameDAO;
import com.acme.model.Game;


@Controller 
@RequestMapping("/scheduleEdit")
public class ScheduleEditController {
	@Autowired
	private GameDAO gameDAO;
	
	@RequestMapping(method = RequestMethod.GET)
	public String showEdit(ModelMap model){
		return "scheduleEdit";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView saveSchedule(@RequestParam("week") Integer week, @RequestParam("homeScore") Integer homeScore, @RequestParam("awayScore") Integer awayScore, @RequestParam("winLoss") String winLoss) {
		Game game = new Game();
		game.setWeek(week);
		game.setHomeScore(homeScore);
		game.setAwayScore(awayScore);
		game.setWinLoss(winLoss);
		gameDAO.update(game);
		return new ModelAndView("redirect:schedule");
	}

	public GameDAO getGameDAO() {
		return gameDAO;
	}

	public void setGameDAO(GameDAO gameDAO) {
		this.gameDAO = gameDAO;
	}
}

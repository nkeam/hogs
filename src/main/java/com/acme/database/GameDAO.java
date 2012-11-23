package com.acme.database;

import java.util.List;

import com.acme.model.Game;

public interface GameDAO {

	/**
	 * Gets a Game
	 * 
	 * @return Game
	 * @author Nicholas Keam
	 * @since 10/21/2012
	 */
	List<Game> getGames();
	
	/**
	 * Updates game
	 * @param game
	 * @return
	 */
	Game update(Game game);
	
}

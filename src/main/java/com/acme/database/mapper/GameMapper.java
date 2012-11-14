package com.acme.database.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;

import com.acme.model.Game;

public class GameMapper implements RowMapper<Game> {
	private static final Logger logger = Logger.getLogger(GameMapper.class);
	protected static String formatString = "MM/dd 'at' h:mm a z";
	protected static String formatStringNoTime = "MM/dd";
	@Override
	public Game mapRow(ResultSet resultSet, int line) throws SQLException {

		SimpleDateFormat format = new SimpleDateFormat(formatString);
		SimpleDateFormat formatNoTime = new SimpleDateFormat(formatStringNoTime);
		Game game = new Game();
		game.setId(resultSet.getInt("id"));
		game.setWeek(resultSet.getInt("week"));
		game.setHomeTeam(resultSet.getString("home"));
		game.setAwayTeam(resultSet.getString("away"));
		game.setWinLoss(resultSet.getString("wl"));
		game.setHomeScore(resultSet.getInt("homescore"));
		game.setAwayScore(resultSet.getInt("awayScore"));
		try {
			if(game.isByeWeek()){
				game.setDate(formatNoTime.parse(resultSet.getString("date")));
			}
			else{
				game.setDate(format.parse(resultSet.getString("date")));
			}
		}catch (ParseException e) {
			logger.error("GameMapper.mapRow parseException while trying to parse date from database.", e);
		}
		return game;
	}
}

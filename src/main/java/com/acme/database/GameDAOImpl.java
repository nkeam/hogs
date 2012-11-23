package com.acme.database;

import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

import com.acme.database.mapper.GameMapper;
import com.acme.model.Game;

public class GameDAOImpl implements GameDAO {
	private static final Logger logger = Logger.getLogger(GameDAOImpl.class);
	//Connects to our database
	private DataSource dataSource;
	@Override
	public List<Game> getGames() {
		logger.trace("GameDAOImpl.getGames");
		JdbcTemplate select = new JdbcTemplate(dataSource);
		String sql = "select * from schedule order by week asc";
		logger.debug("sql: "+sql);
		return select.query(sql, new GameMapper());
	}
	
	//implementing a method from some interface:
	@Override
	public Game update(Game game){
		JdbcTemplate template = new JdbcTemplate(dataSource);
		String sql = "update schedule set homescore = ?, awayscore = ?, wl = ? where week = ?";
		Object[] args = new Object[]{
			game.getHomeScore(),game.getAwayScore(),game.getWinLoss(),game.getWeek()
		};
		template.update(sql, args);
		return game;
	}
	public DataSource getDataSource() {
		return dataSource;
	}
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
}

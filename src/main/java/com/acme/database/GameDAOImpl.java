package com.acme.database;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.acme.model.Game;

public class GameDAOImpl implements GameDAO {
	private static final Logger logger = Logger.getLogger(GameDAOImpl.class);
	//Connects to our database
	//private DataSource dataSource;
	private SessionFactory sessionFactory;
	@Override
	public List<Game> getGames() {
		
		
		
		return sessionFactory.getCurrentSession().createQuery("from Game").list();
		
		/*
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
	
	*/
	}
	
	protected List<Game> getWinningGames() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Game.class);
		criteria.add(Restrictions.eq("winLoss", "Win"));
		return criteria.list();
	}
	
	@Override
	public Game update(Game game){
		 sessionFactory.getCurrentSession().saveOrUpdate(game);
		 return game;
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}

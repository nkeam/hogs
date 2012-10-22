package com.acme.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.acme.model.Game;

public class GameDAOImpl implements GameDAO {

	private static String formatString = "MM/dd 'at' h:mm a z";
	private static String formatStringNoTime = "MM/dd";


	@Override
	public List<Game> getGames() {
		SimpleDateFormat format = new SimpleDateFormat(formatString);
		SimpleDateFormat formatNoTime = new SimpleDateFormat(formatStringNoTime);


		List<Game>games = new ArrayList<Game>();
		try {
			Class.forName("org.sqlite.JDBC");
			Connection c;
			c = DriverManager.getConnection("jdbc:sqlite:C:\\Dev\\Databases\\hogs.db","","");
			Statement st = c.createStatement();
			String sql = "select * from schedule order by week asc";
			ResultSet resultSet = st.executeQuery(sql);

			while(resultSet.next()){
				Game game = new Game();
				game.setId(resultSet.getInt("id"));
				game.setWeek(resultSet.getInt("week"));
				game.setHomeTeam(resultSet.getString("home"));
				game.setAwayTeam(resultSet.getString("away"));
				game.setWinLoss(resultSet.getString("wl"));
				game.setHomeScore(resultSet.getInt("homescore"));
				game.setAwayScore(resultSet.getInt("awayScore"));
				//TODO: make exception handling tighter
				if(game.isByeWeek()){
					game.setDate(formatNoTime.parse(resultSet.getString("date")));
				}else{
					game.setDate(format.parse(resultSet.getString("date")));
				}


				games.add(game);
			}
			c.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return games;
	}

}

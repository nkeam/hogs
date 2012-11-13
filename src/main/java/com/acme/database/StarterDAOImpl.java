package com.acme.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.acme.model.Starter;

public class StarterDAOImpl implements StarterDAO {
	
	private String driverName;
	private String url;
	private String userName;
	private String password;
	
	protected Connection connect(){
		Connection c = null;
		try {
			Class.forName(driverName);
			c = DriverManager.getConnection(url,userName,password);
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}
	@Override
	public List<Starter> getStarters() {
		List<Starter>starters = new ArrayList<Starter>();
		Connection c = connect();
		Statement st;
		if(c != null){
		try {
			st = c.createStatement();
			String sql = "select * from roster";
			ResultSet resultSet = st.executeQuery(sql);
			while(resultSet.next()){
				Starter starter = new Starter();
				starter.setNumber(resultSet.getInt("number"));
				starter.setFirstName(resultSet.getString("firstname"));
				starter.setLastName(resultSet.getString("lastname"));
				starter.setPosition(resultSet.getString("position"));
				starter.setYears(resultSet.getInt("year"));
				starter.setCollege(resultSet.getString("college"));
				
				starters.add(starter);
			}
			c.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		}
		return starters;
	}
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}

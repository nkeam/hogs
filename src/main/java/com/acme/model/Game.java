package com.acme.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Game implements Serializable{
	private static final long serialVersionUID = 3211209536089918806L;
	private int id;
	private int week;
	private String homeTeam;
	private String awayTeam;
	private String winLoss;
	private int homeScore;
	private int awayScore;
	private Date date;
	private static String formatString = "MM/dd 'at' h:mm a z";
	private static String formatStringNoTime = "MM/dd";

	public boolean isByeWeek(){
		//is null safe
		return ("Bye".equals(winLoss));
	}
	public String getFormattedDate(){
		String formatStringToUse = formatString;
		if(isByeWeek()){
			formatStringToUse = formatStringNoTime;
		}
		SimpleDateFormat format = new SimpleDateFormat(formatStringToUse);		
		String formattedDate = format.format(date);
		return formattedDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getWeek() {
		return week;
	}
	public void setWeek(int week) {
		this.week = week;
	}
	public String getHomeTeam() {
		return homeTeam;
	}
	public void setHomeTeam(String homeTeam) {
		this.homeTeam = homeTeam;
	}
	public String getAwayTeam() {
		return awayTeam;
	}
	public void setAwayTeam(String awayTeam) {
		this.awayTeam = awayTeam;
	}
	public String getWinLoss() {
		return winLoss;
	}
	public void setWinLoss(String winLoss) {
		this.winLoss = winLoss;
	}
	public int getHomeScore() {
		return homeScore;
	}
	public void setHomeScore(int homeScore) {
		this.homeScore = homeScore;
	}
	public int getAwayScore() {
		return awayScore;
	}
	public void setAwayScore(int awayScore) {
		this.awayScore = awayScore;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
}

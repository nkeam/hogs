
package com.acme.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="schedule")
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

	@Transient
	public boolean isByeWeek(){
		//is null safe
		return ("Bye".equals(winLoss));
	}
	@Transient
	public String getFormattedDate(){
		String formatStringToUse = formatString;
		if(isByeWeek()){
			formatStringToUse = formatStringNoTime;
		}
		SimpleDateFormat format = new SimpleDateFormat(formatStringToUse);		
		String formattedDate = format.format(date);
		return formattedDate;
	}
	@Id
	@GeneratedValue(strategy=IDENTITY)
	@Column(name="id", unique=true,nullable=false)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="week", unique=true,nullable=false)
	public int getWeek() {
		return week;
	}
	public void setWeek(int week) {
		this.week = week;
	}
	@Column(name="home")
	public String getHomeTeam() {
		return homeTeam;
	}
	public void setHomeTeam(String homeTeam) {
		this.homeTeam = homeTeam;
	}
	@Column(name="away")
	public String getAwayTeam() {
		return awayTeam;
	}
	public void setAwayTeam(String awayTeam) {
		this.awayTeam = awayTeam;
	}
	@Column(name="wl")
	public String getWinLoss() {
		return winLoss;
	}
	public void setWinLoss(String winLoss) {
		this.winLoss = winLoss;
	}
	@Column(name="homescore")
	public int getHomeScore() {
		return homeScore;
	}
	public void setHomeScore(int homeScore) {
		this.homeScore = homeScore;
	}
	@Column(name="awayscore", unique=true,nullable=false)
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

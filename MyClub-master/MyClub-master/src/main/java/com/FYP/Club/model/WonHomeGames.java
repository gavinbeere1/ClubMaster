package com.FYP.Club.model;

public class WonHomeGames {
	
	String datePlayed;
	int HomeScore;
	int AwayScore;
	String HomeTeam;
	String AwayTeam;
	
	
	
	
	public WonHomeGames() {
		super();
	}




	public WonHomeGames(String datePlayed, int homeScore, int awayScore,
			String homeTeam, String awayTeam) {
		super();
		this.datePlayed = datePlayed;
		HomeScore = homeScore;
		AwayScore = awayScore;
		HomeTeam = homeTeam;
		AwayTeam = awayTeam;
	}




	public String getDatePlayed() {
		return datePlayed;
	}




	public void setDatePlayed(String datePlayed) {
		this.datePlayed = datePlayed;
	}




	public int getHomeScore() {
		return HomeScore;
	}




	public void setHomeScore(int homeScore) {
		HomeScore = homeScore;
	}




	public int getAwayScore() {
		return AwayScore;
	}




	public void setAwayScore(int awayScore) {
		AwayScore = awayScore;
	}




	public String getHomeTeam() {
		return HomeTeam;
	}




	public void setHomeTeam(String homeTeam) {
		HomeTeam = homeTeam;
	}




	public String getAwayTeam() {
		return AwayTeam;
	}




	public void setAwayTeam(String awayTeam) {
		AwayTeam = awayTeam;
	}
	
	
	
	

}

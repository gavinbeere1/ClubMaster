package com.FYP.Club.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;




@Entity
public class PlayerStat {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long playerSeasonStatId;
	private int carries;
	private double carriesScore;
	private int ballPlacement;
	private double ballPlacementScore;
	private int tackle;
	private double tackleScore;
	private int ruck;
	private double ruckScore;
	private int triesScored;
	private String season;
    private String club;
	
	public PlayerStat()
	{
		
	}



	public PlayerStat(Long playerSeasonStatId, int carries, double carriesScore,
			int ballPlacement, double ballPlacementScore, int tackle,
			double tackleScore, int ruck, double ruckScore, int triesScored,
			String season, String club) {
		super();
		this.playerSeasonStatId = playerSeasonStatId;
		this.carries = carries;
		this.carriesScore = carriesScore;
		this.ballPlacement = ballPlacement;
		this.ballPlacementScore = ballPlacementScore;
		this.tackle = tackle;
		this.tackleScore = tackleScore;
		this.ruck = ruck;
		this.ruckScore = ruckScore;
		this.triesScored = triesScored;
		this.season = season;
		this.club = club;
	}



	public double getCarriesScore() {
		return carriesScore;
	}



	public void setCarriesScore(double carriesScore) {
		this.carriesScore = carriesScore;
	}



	public int getBallPlacement() {
		return ballPlacement;
	}



	public void setBallPlacement(int ballPlacement) {
		this.ballPlacement = ballPlacement;
	}



	public double getBallPlacementScore() {
		return ballPlacementScore;
	}



	public void setBallPlacementScore(double ballPlacementScore) {
		this.ballPlacementScore = ballPlacementScore;
	}



	public double getTackleScore() {
		return tackleScore;
	}



	public void setTackleScore(double tackleScore) {
		this.tackleScore = tackleScore;
	}



	public double getRuckScore() {
		return ruckScore;
	}



	public void setRuckScore(double ruckScore) {
		this.ruckScore = ruckScore;
	}



	public Long getPlayerSeasonStatId() {
		return playerSeasonStatId;
	}

	public void setPlayerSeasonStatId(Long playerSeasonStatId) {
		this.playerSeasonStatId = playerSeasonStatId;
	}

	public int getCarries() {
		return carries;
	}

	public void setCarries(int carries) {
		this.carries = carries;
	}


	public int getTackle() {
		return tackle;
	}

	public void setTackle(int tackle) {
		this.tackle = tackle;
	}

	public int getRuck() {
		return ruck;
	}

	public void setRuck(int ruck) {
		this.ruck = ruck;
	}

	public int getTriesScored() {
		return triesScored;
	}

	public void setTriesScored(int triesScored) {
		this.triesScored = triesScored;
	}

	public String getSeason() {
		return season;
	}

	public void setSeason(String season) {
		this.season = season;
	}

	public String getClub() {
		return club;
	}

	public void setClub(String club) {
		this.club = club;
	}
	
	
	
	

}


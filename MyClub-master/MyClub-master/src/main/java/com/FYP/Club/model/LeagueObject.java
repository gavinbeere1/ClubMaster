package com.FYP.Club.model;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class LeagueObject {
	
	int pos;
	String name;
	int played;
	int won;
	int drew;
	int lost;
	int pointsFor;
	int pointsAgainst;
	int pointsDifference;
	int Tb;
	int lb;
	int pts;
	
	
	
	
	
	public LeagueObject() {
		super();
	}


	public LeagueObject(int pos, String name, int played, int won, int drew,
			int lost, int pointsFor, int pointsAgainst, int pointsDifference,
			int tb, int lb, int pts) {
		super();
		this.pos = pos;
		this.name = name;
		this.played = played;
		this.won = won;
		this.drew = drew;
		this.lost = lost;
		this.pointsFor = pointsFor;
		this.pointsAgainst = pointsAgainst;
		this.pointsDifference = pointsDifference;
		Tb = tb;
		this.lb = lb;
		this.pts = pts;
	}


	public ArrayList<LeagueObject> MyLeagueObject() throws IOException
	{
		
	      ArrayList<LeagueObject> tables = new ArrayList<LeagueObject>();

  Document doc = Jsoup.connect("http://www.irishrugby.ie/club/ulsterbankleagueandcup/tables.php").get();
	  
	  
	  
	  Elements kelime = doc.select("tr[id^=leaguetab25146-0]");
	    for(Element sectd:kelime){
	        Elements tds = sectd.select("td"); 
	        
	        LeagueObject lo = new LeagueObject();
	        
	        
	              String result = tds.get(0).text();
	               String result1 = tds.get(1).text();
	               String result2 = tds.get(2).text();
	               String result3 = tds.get(3).text();
	               String result4 = tds.get(4).text();
	               String result5 = tds.get(5).text();
	               String result6 = tds.get(6).text();
	               String result7 = tds.get(7).text();
	               String result8 = tds.get(8).text();
	               String result9 = tds.get(9).text();
	               String result10 = tds.get(10).text();
	               String result11 = tds.get(11).text();
	               String result12 = tds.get(12).text();


	               lo.setPos(Integer.parseInt(result));
	               lo.setName(result2);
	               lo.setPlayed(Integer.parseInt(result3));
	               lo.setWon(Integer.parseInt(result4));
	               lo.setDrew(Integer.parseInt(result5));
	               lo.setLost(Integer.parseInt(result6));
	               lo.setPointsFor(Integer.parseInt(result7));
	               lo.setPointsAgainst(Integer.parseInt(result8));
	               lo.setPointsDifference(Integer.parseInt(result9));
	               lo.setTb(Integer.parseInt(result10));
	               lo.setLb(Integer.parseInt(result11));
	               lo.setPts(Integer.parseInt(result12));

	               tables.add(lo);

	    }
		return tables;
		
}

	public int getPos() {
		return pos;
	}


	public void setPos(int pos) {
		this.pos = pos;
	}


	public String getName() {
		return name;
	}











	public void setName(String name) {
		this.name = name;
	}











	public int getPlayed() {
		return played;
	}





	public void setPlayed(int played) {
		this.played = played;
	}





	public int getWon() {
		return won;
	}





	public void setWon(int won) {
		this.won = won;
	}





	public int getDrew() {
		return drew;
	}





	public void setDrew(int drew) {
		this.drew = drew;
	}





	public int getLost() {
		return lost;
	}





	public void setLost(int lost) {
		this.lost = lost;
	}





	public int getPointsFor() {
		return pointsFor;
	}





	public void setPointsFor(int pointsFor) {
		this.pointsFor = pointsFor;
	}





	public int getPointsAgainst() {
		return pointsAgainst;
	}





	public void setPointsAgainst(int pointsAgainst) {
		this.pointsAgainst = pointsAgainst;
	}





	public int getPointsDifference() {
		return pointsDifference;
	}





	public void setPointsDifference(int pointsDifference) {
		this.pointsDifference = pointsDifference;
	}





	public int getTb() {
		return Tb;
	}





	public void setTb(int tb) {
		Tb = tb;
	}





	public int getLb() {
		return lb;
	}





	public void setLb(int lb) {
		this.lb = lb;
	}





	public int getPts() {
		return pts;
	}





	public void setPts(int pts) {
		this.pts = pts;
	}
	
	
	
	
	

}

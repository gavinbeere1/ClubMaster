package com.FYP.Club.controller;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.FYP.Club.model.Game;
import com.FYP.Club.model.PlayerStat;
import com.FYP.Club.model.Team;
import com.FYP.Club.model.UserLogin;
import com.FYP.Club.model.WonHomeGames;
import com.FYP.Club.repository.GameRepository;
import com.FYP.Club.repository.TeamRepository;

@Controller
@RequestMapping("/chart")
public class BarChart3D {
	
    Team team = new Team();

	   
	@Autowired
	TeamRepository teamRepository;
	
	@Autowired
	GameRepository gameRepository;
	
	@RequestMapping(value = "/bar", method={RequestMethod.POST, RequestMethod.GET})
	   public void AcceptPlayer(HttpServletResponse response) throws ConcurrentModificationException, IOException{
		
		
		 Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
	      String email = loggedInUser.getName(); // getName() is springs way to get the logged in user name, which in my case is their email (i.e what they login with)

//	      UserLogin user = userRepository.findByUserName(email);
	      
	      ArrayList<Team> teams = (ArrayList<Team>) teamRepository.findAll();
		   
		  for (Team t : teams)
		  {
			  for(UserLogin ul : t.getUserLogins())
			  {
				  if(ul.getUserName().equals(email))
				  {
					  team = t;
				      break;

				  }
			  }
		  }
		
		
		
		  response.setContentType("image/png");
		  
		  CategoryDataset pdSet = createDataSet();

		  JFreeChart barChart = createChart(pdSet, team.getTeamName());
			         
		  try
		  {
			  ChartUtilities.writeChartAsPNG(response.getOutputStream(), barChart, 750, 400);
			  response.getOutputStream().close();
		  }
		  catch (IOException ex)
		  {
			  ex.printStackTrace();
		  }
		  
		
	}
	
	
	  private CategoryDataset createDataSet()
	  {
//		  final String fait = "FAIT";              
//	      final String audi = "AUDI";              
//	      final String ford = "FORD";              
//	      final String speed = "Speed";              
//	      final String popular = "Popular";              
//	      final String mailage = "Mailage";              
//	      final String userrating = "User Rating";              
//	      final String safety = "safety";       
	      
	      
		  
		  
		  
		  
		  DefaultCategoryDataset dpd = new DefaultCategoryDataset(); 
		  
		  
		  ArrayList<Game> Agames = gameRepository.findByAwaySideId(team.getId());

		  
			
		  
			for (Game g : Agames)
			  {
				  String result = g.getFinalScore();
				  result.trim();
				  
				  if (!result.equals("v"))
				  {
				  ///result2 = home side
				  String[] output = result.split("-");
				  int result1 = Integer.parseInt(output[0].trim());
				  int result2 = Integer.parseInt(output[1].trim());

					

					if (result1 < result2)
					{
						result2 = result2 - result1;
						dpd.addValue(result2,"Won Away" , g.getHomeSide().getTeamName());

						
					}
					
					else
					{
						result1 = result1 - result2;
						dpd.addValue(result1,"Lost Away" ,g.getHomeSide().getTeamName());

					}

					
				  }
				
			  }
			  
		
		  ArrayList<Game> Hgames = gameRepository.findByHomeSideId(team.getId());
		  ArrayList<WonHomeGames> WHGames = new ArrayList<WonHomeGames>();
		  
		  WonHomeGames WonHomeGames;
		  
		  
			for (Game g : Hgames)
			  {
				  String result = g.getFinalScore();
				  result.trim();
				  
				  if (!result.equals("v"))
				  {
				  ///result2 = home side
				  String[] output = result.split("-");
				  int result1 = Integer.parseInt(output[0].trim());
				  int result2 = Integer.parseInt(output[1].trim());

					if (result1 < result2)
					{

						
						result2 = result2 - result1;
						dpd.addValue(result2,"Lost Home" ,g.getAwaySide().getTeamName());
					}
					else
					{
						result1 = result1-result2;
						dpd.addValue(result1,"Won Home" ,g.getAwaySide().getTeamName());
					}
				  }
			  }
			 
			
			
			
		  

		  return dpd;
	  }
	
	  private JFreeChart createChart(CategoryDataset dpd, String chartTitle) throws IOException
	  {
		  JFreeChart barchart = ChartFactory.createBarChart3D( 
			         team.getTeamName() + " Win/Loss" ,  // chart title                   
			         "Teams", "Points Difference", dpd ,         // data 
			         PlotOrientation.VERTICAL, true ,            // include legend                   
			         true, 
			         false);
		  


		  return barchart;
		  
		  
		  

	  }
	
	
	
	
	
	
	
	
	
	
	}
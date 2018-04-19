package com.FYP.Club.controller;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.FYP.Club.model.PlayerStat;
import com.FYP.Club.model.Team;
import com.FYP.Club.model.UserLogin;
import com.FYP.Club.repository.UserLoginRepository;


@Controller
@RequestMapping("/charts")
public class MyPieChart {
	
	 
	
	 @Autowired
		UserLoginRepository userRepository;
	
	 
	
     
     
	  @RequestMapping(value = "/piechart", method=RequestMethod.GET)
	    public void drawPieChart(HttpServletResponse response, Model model) {
	        
		  Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
		     String email = loggedInUser.getName(); // getName() is springs way to get the logged in user name, which in my case is their email (i.e what they login with)

		     UserLogin user = userRepository.findByUserName(email);

//		   model.addAttribute("user", user);

	
	
		  
		  
		  response.setContentType("image/png");
		  PieDataset pdSet = createDataSet();
		  JFreeChart chart = createChart(pdSet, user.getFirstName() + " " + user.getLastName() + ": Total Games Break Down Chart");
		  
		  
		  try
		  {
			  ChartUtilities.writeChartAsPNG(response.getOutputStream(), chart, 750, 400);
			  response.getOutputStream().close();
		  }
		  catch (IOException ex)
		  {
			  ex.printStackTrace();
		  }
		  
			

		  
		  
	    }
	  
	  
	  private PieDataset createDataSet()
	  {
		  DefaultPieDataset dpd = new DefaultPieDataset();
		  
		  Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
		     String email = loggedInUser.getName(); // getName() is springs way to get the logged in user name, which in my case is their email (i.e what they login with)

		     UserLogin user = userRepository.findByUserName(email);
		  
	      Set<PlayerStat> cueList = user.getPlayerStats();
		  
	      
	      int ruck = 0;
	      int carries = 0;
	      int tackle =0;
	      int tries = 0;
	      int ballPlacement = 0;
	      
	      for (PlayerStat s: cueList) {
	    	    
	    	  ruck = ruck + s.getRuck();
	    	  carries = carries + s.getCarries();
	    	  tries = tries + s.getTriesScored();
	    	  tackle = tackle + s.getTackle();
	    	  ballPlacement = ballPlacement + s.getBallPlacement();

	    	}
	      int other = 100 - (ruck + carries + tackle + tries + ballPlacement);
	      
	      dpd.setValue("Rucks", ruck);
	      dpd.setValue("Carries", carries);
	      dpd.setValue("Tackles", tackle);
	      dpd.setValue("Tries", tries);
	      dpd.setValue("Ball Placement", ballPlacement);

	      dpd.setValue("Other", other);
	     

		  return dpd;
	  }
	  
	  
	  
	  
	  private JFreeChart createChart(PieDataset pdSet, String chartTitle)
	  {
		  JFreeChart chart = ChartFactory.createPieChart3D(chartTitle, pdSet, true, true, false);
		  PiePlot3D plot = (PiePlot3D) chart.getPlot();
		  plot.setStartAngle(290);
		  plot.setDirection(Rotation.CLOCKWISE);
		  plot.setForegroundAlpha(0.9f);
		   PieSectionLabelGenerator gen = new StandardPieSectionLabelGenerator(
		            "{0}: {1} ({2})", new DecimalFormat("0"), new DecimalFormat("0%"));
		        plot.setLabelGenerator(gen);
		  return chart;
		  
	  }

}

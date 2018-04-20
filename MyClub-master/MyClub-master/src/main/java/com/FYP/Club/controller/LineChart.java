package com.FYP.Club.controller;

import java.io.*;
import java.security.Principal;
import java.text.DecimalFormat;
import java.util.ConcurrentModificationException;

import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart; 
import org.jfree.chart.ChartFactory; 
import org.jfree.chart.ChartUtilities; 
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.util.Rotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.FYP.Club.model.Team;
import com.FYP.Club.model.UserLogin;
import com.FYP.Club.repository.TeamRepository;
import com.FYP.Club.repository.UserLoginRepository;

@Controller
@RequestMapping("/linecharts")
public class LineChart {
	
	 @Autowired
		TeamRepository teamRepository;
	 
	 @RequestMapping
	 
	  public static void main( String[ ] args ) throws Exception {
	      DefaultCategoryDataset line_chart_dataset = new DefaultCategoryDataset();
	      line_chart_dataset.addValue( 15 , "schools" , "1970" );
	      line_chart_dataset.addValue( 30 , "schools" , "1980" );
	      line_chart_dataset.addValue( 60 , "schools" , "1990" );
	      line_chart_dataset.addValue( 120 , "schools" , "2000" );
	      line_chart_dataset.addValue( 240 , "schools" , "2010" ); 
	      line_chart_dataset.addValue( 300 , "schools" , "2014" );

	      JFreeChart lineChartObject = ChartFactory.createLineChart(
	         "Schools Vs Years","Year",
	         "Schools Count",
	         line_chart_dataset,PlotOrientation.VERTICAL,
	         true,true,false);

	      int width = 640;    /* Width of the image */
	      int height = 480;   /* Height of the image */ 
	      File lineChart = new File( "LineChart.jpeg" ); 
	      ChartUtilities.saveChartAsJPEG(lineChart ,lineChartObject, width ,height);
	   }
	}

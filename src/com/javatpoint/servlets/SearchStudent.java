package com.javatpoint.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

import java.util.*;
import com.google.gson.Gson;
import com.google.gson.JsonObject;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javatpoint.beans.CaseBasicInfo;
import com.javatpoint.beans.ComplexQueryRes;
import com.javatpoint.beans.StudentBean;
import com.javatpoint.dao.CaseBasicInfoDao;
import com.javatpoint.dao.ComplexQueryDao;
import com.javatpoint.dao.StudentDao;
@WebServlet("/SearchStudent")
public class SearchStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		    String query = request.getParameter("Query");
		//    String graph = request.getParameter("Graph");
		    String graph="colnum";
		    List<ComplexQueryRes> result = new ArrayList<ComplexQueryRes>();
		    int queryType = 0;
		    switch(query) {
		       case "Is there any correlation between the number of occupants and the possibility of crashes?":
		   		   result= ComplexQueryDao.result_Query1();
		   		   queryType = 1;
		   		   break;
		       case "Which county in NY state is the one where motor vehicle crashes happen most?":
		   		   result= ComplexQueryDao.result_Query2();
		   		   queryType = 2;
		   		   break;
		       case "Provide a rank of all brands of cars according to the numbers of crashes they were involved.":
		    	       result= ComplexQueryDao.result_Query3();
		    	       queryType = 3;
		    	       break;
		       case "Is there any relationship between the age of a vehicle and the happening rate of a traffic accident?":
		    	       result= ComplexQueryDao.result_Query11();
		    	       queryType = 11;
		    	       break;
		       case "Can those traffic control devices actually help to decrease the happening rate of accidents?":
		    	   		result= ComplexQueryDao.result_Query4();
		    	   		queryType = 4;
		    	   		break;
		       case "Which period is the peak of occurrences of traffic accidents? Morning? Afternoon? Night?":
		    	   		result= ComplexQueryDao.result_Query10();
		    	   		queryType = 10;
		    	   		break;
		       case "Sort the number of accidents according to different weather conditions and conclude what kinds of weather conditions are more likely to occur traffic accidents?":
		    	   		result= ComplexQueryDao.result_Query5();
		    	   		queryType = 5;
		    	   		break;
		       case "What kind of accident are most related to those vehicles have more than 6 engine cylinders?":
		    	   		result= ComplexQueryDao.result_Query7();
		    	   		queryType = 7;
		    	   		break;
		       case "What is the ratio of collisions between vehicles?":
		    	   		result= ComplexQueryDao.result_Query6();
		    	   		queryType = 6;
		    	   		break;
		       case "Do road conditions have a significant impact on crash? What kind of road is more likely to occur a crash?":
		    	   		result= ComplexQueryDao.result_Query8();
		    	   		queryType = 8;
		    	   		break;
		       case "What kind of factors are more likely to be related with a traffic accident?":
		    	   		result= ComplexQueryDao.result_Query9();
		    	   		queryType = 9;
		    	   		break;
		    	   default :
		    		    break;
		    }
		    	   
			//List<CaseBasicInfo> bean= CaseBasicInfoDao.getCaseBasicInfoByEFilters(Weather_Condition,"Dry","Curve and Level");
		//	List<StudentBean>  temp=StudentDao.getRecordByRollno(name,sex);
			
			
			
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("</script>");
			out.println("<title>Search Student</title>");
			out.println("<link rel='stylesheet' href='resources/bootstrap.min.css'/>");
			out.println("<link rel='stylesheet' href='style.css'/>");
			out.println("</head>");
			out.println("<body>");
			request.getRequestDispatcher("navaccountant.html").include(request, response);
			out.println("<div class='container'>");
			
		
			out.println("<h1>Search Student</h1>");
		/*	out.println("<table class='table table-bordered table-striped'>");
			out.print("<tr><th>Rollno</th><th>Name</th><th>Email</th><th>Sex</th><th>Course</th><th>Fee</th><th>paid</th><th>due</th><th>address</th><th>contact</th><th>Edit</th><th>Delete</th>");
			for(StudentBean bean:temp){
				
				out.print("<tr><td>"+bean.getRollno()+"</td><td>"+bean.getName()+"</td><td>"+bean.getEmail()+"</td><td>"+bean.getSex()+"</td><td>"+bean.getCourse()+"</td><td>"+bean.getFee()+"</td><td>"+bean.getPaid()+"</td><td>"+bean.getDue()+"</td><td>"+bean.getAddress()+"</td><td>"+bean.getContact()+"</td><td><a href='EditStudentForm?rollno="+bean.getRollno()+"'>Edit</a></td><td><a href='DeleteStudent?rollno="+bean.getRollno()+"'>Delete</a></td></tr>");
			} 
			out.println("</table>");*/
			request.setAttribute("list", result);
			request.setAttribute("type", queryType);
			
			out.println("</div>");
			if(graph.equals("pie")) {
				request.getRequestDispatcher("pie1.jsp").forward(request, response);
			}
			if(graph.equals("colnum")) {
				request.getRequestDispatcher("Search.jsp").forward(request, response);
			}
		//	request.getRequestDispatcher("Search.jsp").forward(request, response);
			//request.getRequestDispatcher("footer.html").include(request, response);
			out.println("</body>");
			out.println("</html>");
			
			out.close();
		}
}

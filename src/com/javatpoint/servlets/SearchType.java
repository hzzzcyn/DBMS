package com.javatpoint.servlets;  

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javatpoint.beans.CaseBasicInfo;
import com.javatpoint.beans.CaseExternalInfo;
import com.javatpoint.beans.CaseVehicleInfo;
import com.javatpoint.beans.StudentBean;
import com.javatpoint.dao.StudentDao;
import com.javatpoint.dao.CaseBasicInfoDao;
import com.javatpoint.dao.CaseExternalInfoDao;
import com.javatpoint.dao.CaseVehicleInfoDao;
@WebServlet("/SearchType")
public class SearchType extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String ID=request.getParameter("Case ID");
		String type=request.getParameter("Information Types");
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>View Student Form</title>");
		out.println("<link rel='stylesheet' href='resources/bootstrap.min.css'/>");
		out.println("<link rel='stylesheet' href='style.css'/>");
		out.println("</head>");
		out.println("<body>");
		request.getRequestDispatcher("navaccountant.html").include(request, response);
		out.println("<div class='container'>");
		if(type.equals("Case ID")) request.getRequestDispatcher("ID.html").include(request, response);
		if(type.equals("Basic Info")) request.getRequestDispatcher("BasicInfo.html").include(request, response);
		if(type.equals("Vehicle Info")) request.getRequestDispatcher("VehicleInfo.html").include(request, response);
		if(type.equals("External Info")) request.getRequestDispatcher("ExternalInfo.html").include(request, response);
        
		
		out.println("</div>");
		request.getRequestDispatcher("footer.html").include(request, response);
		out.println("</body>");
		out.println("</html>");
		
		out.close();
	}

}

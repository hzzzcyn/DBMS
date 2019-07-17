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
@WebServlet("/ViewStudent")
public class ViewStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
	//	List<CaseBasicInfo> bean=new ArrayList<CaseBasicInfo>();
		String ID=request.getParameter("Case ID");
		//String traffic_control=request.getParameter("traffic control");
		//String number_of_vehicles_involved=request.getParameter("number of vehicles involved");
		String Weather_Condition=request.getParameter("Weather Condition");
		String Road_Surface=request.getParameter("Road Surface");
		String Pedestrians_Bicyclist_Action=request.getParameter("Pedestrians Bicyclist Action");
		List<CaseVehicleInfo> bean= CaseVehicleInfoDao.getCaseVehicleInfoByBFilters("None","Saturday","Deer");
		
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
		
		out.print("<h1>View Students</h1>");
	
		out.println("<table class='table table-bordered table-striped'>");
		out.print("<tr><th>caseID</th><th>eventDescriptor</th><th>trafficControl</th><th>collisionTypeDescriptor</th><th>county</th><th>municipality</th><th>time</th><th>numOfVehicles</th>");
		for(CaseVehicleInfo c:bean) {
			out.print("<tr><td>"+c.getFuelType()+"</td><tr>");
		}

		out.println("</table>");

		out.println("</div>");
		request.getRequestDispatcher("footer.html").include(request, response);
		out.println("</body>");
		out.println("</html>");
		
		out.close();
	}

}

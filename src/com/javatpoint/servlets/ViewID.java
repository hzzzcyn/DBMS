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
import com.javatpoint.dao.*;
@WebServlet("/ViewID")
public class ViewID extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
	//	List<CaseBasicInfo> bean=new ArrayList<CaseBasicInfo>();
		String ID=request.getParameter("Case ID");
		//String trafficControl = request.getParameter("traffic control");
		//String dayOfWeek = request.getParameter("Day of Week");
		//String eventDescriptor = request.getParameter("even_descriptor");
		//String weatherCondition = request.getParameter("Weather Condition");
		//String roadSurface = request.getParameter("Road Surface");
		//String roadDescriptor = request.getParameter("Road Descriptor");
		//String fuelType = request.getParameter("Fuel Type");
		//String stateOfRegistration = request.getParameter("State of Registration");
		//String vehicleMake = request.getParameter("Vehicle Make");
		String infoUNeed = request.getParameter("Info You Need");
		
		CaseBasicInfo singleBasicRes = new CaseBasicInfo();
		CaseVehicleInfo singleVehicleRes = new CaseVehicleInfo();
		CaseExternalInfo singleExternalRes = new CaseExternalInfo();
		//List<CaseBasicInfo> listBasicInfo = new ArrayList<CaseBasicInfo>();
		//List<CaseVehicleInfo> listVehicleInfo = new ArrayList<CaseVehicleInfo>();
		//List<CaseExternalInfo> listExternalInfo = new ArrayList<CaseExternalInfo>();
		
		if (infoUNeed.equals("Basic Info")) {
			singleBasicRes= CaseBasicInfoDao.getCaseBasicInfoByCaseID(ID);
		} else if (infoUNeed.equals("Vehicle Info")) {
			singleVehicleRes = CaseVehicleInfoDao.getCaseVehicleInfoByCaseID(ID);
		} else if (infoUNeed.equals("External Info")) {
			singleExternalRes = CaseExternalInfoDao.getCaseExternalInfoByCaseID(ID);
		}
		//List<CaseVehicleInfo> bean= CaseVehicleInfoDao.getCaseVehicleInfoByBFilters("None","Saturday","Deer");
		
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
		//out.print("<tr><th>caseID</th><th>eventDescriptor</th><th>trafficControl</th><th>collisionTypeDescriptor</th><th>county</th><th>municipality</th><th>time</th><th>numOfVehicles</th>");
	//	out.print("<tr><td>"+singleBasicRes.getCaseID()+"</td><td>"+singleBasicRes.getEventDescriptor()+"</td><td>"+singleBasicRes.getTrafficControl()+"</td><td>"+singleBasicRes.getCollisionTypeDescriptor()+"</td><td>"+singleBasicRes.getCounty()+"</td><td>"+singleBasicRes.getMunicipality()+"</td><td>"+singleBasicRes.getTime()+"</td><td>"+singleBasicRes.getNumOfVehicles()+"</td><tr>");
		if(infoUNeed.equals("Basic Info")) {
			out.print("<tr><th>caseID</th><th>eventDescriptor</th><th>trafficControl</th><th>collisionTypeDescriptor</th><th>county</th><th>municipality</th><th>time</th><th>numOfVehicles</th>");
			out.print("<tr><td>"+singleBasicRes.getCaseID()+"</td><td>"+singleBasicRes.getEventDescriptor()+"</td><td>"+singleBasicRes.getTrafficControl()+"</td><td>"+singleBasicRes.getCollisionTypeDescriptor()+"</td><td>"+singleBasicRes.getCounty()+"</td><td>"+singleBasicRes.getMunicipality()+"</td><td>"+singleBasicRes.getTime()+"</td><td>"+singleBasicRes.getNumOfVehicles()+"</td><tr>");

		} else if(infoUNeed.equals("Vehicle Info")) {
			out.print("<tr><th>caseID</th><th>vehicleID</th><th>fuelType</th><th>stateOfRegistration</th><th>registrationClass</th><th>vehicleMake</th><th>vehicleYear</th><th>engineCylinder</th><th>numberOfOccupants</th>");
			out.print("<tr><td>"+singleVehicleRes.getCaseID()+"</td><td>"+singleVehicleRes.getVehicleID()+"</td><td>"+singleVehicleRes.getFuelType()+"</td><td>"+singleVehicleRes.getStateofRegistration()+"</td><td>"+singleVehicleRes.getRegistrationClass()+"</td><td>"+singleVehicleRes.getVehicleMake()+"</td><td>"+singleVehicleRes.getVehicleYear()+"</td><td>"+singleVehicleRes.getEngineCylinder()+"</td><td>"+singleVehicleRes.getNumberofOccupants()+"</td><tr>");

		} else if(infoUNeed.equals("External Info")) {
			out.print("<tr><th>caseID</th><th>weatherCondition</th><th>roadSurface</th><th>roadDescriptor</th><th>pedestriansBicyclistAction</th>");
			out.print("<tr><td>"+singleExternalRes.getCaseID()+"</td><td>"+singleExternalRes.getWeatherCondition()+"</td><td>"+singleExternalRes.getRoadSurface()+"</td><td>"+singleExternalRes.getRoadDescriptor()+"</td><td>"+singleExternalRes.getPedestriansBicyclistAction()+"</td><tr>");

		}
		/**
		 * out.print("<tr><th>caseID</th><th>eventDescriptor</th><th>trafficControl</th><th>collisionTypeDescriptor</th><th>county</th><th>municipality</th><th>time</th><th>numOfVehicles</th>");
		for(CaseVehicleInfo c:bean) {
			out.print("<tr><td>"+c.getFuelType()+"</td><tr>");
		}
		 */

		out.println("</table>");

		out.println("</div>");
		request.getRequestDispatcher("footer.html").include(request, response);
		out.println("</body>");
		out.println("</html>");
		
		out.close();
	}

}

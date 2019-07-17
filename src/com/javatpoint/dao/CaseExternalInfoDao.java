package com.javatpoint.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.javatpoint.beans.CaseBasicInfo;
import com.javatpoint.beans.CaseExternalInfo;
import com.javatpoint.beans.CaseVehicleInfo;


public class CaseExternalInfoDao {

	public static CaseExternalInfo getCaseExternalInfoByCaseID(String caseID){
		CaseExternalInfo caseExternalInfo = new CaseExternalInfo();
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement
					("SELECT i.case_ID, w.weather_condition, r.road_surface, r.road_descriptor, p.pedestrian_bicyclist_action"
					+ " FROM Weather w, Road r, Pedestrians p, Involve_In i"
					+ " WHERE i.case_ID = ?"
					+ " AND w.case_ID = i.case_ID"
					+ " AND r.case_ID = i.case_ID"
					+ " AND i.pedestrians_ID = p.pedestrians_ID");
			ps.setString(1,caseID);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				caseExternalInfo.setCaseID(rs.getString(1));
				caseExternalInfo.setWeatherCondition(rs.getString(2));
				caseExternalInfo.setRoadSurface(rs.getString(3));
				caseExternalInfo.setRoadDescriptor(rs.getString(4));
				caseExternalInfo.setPedestriansBicyclistAction(rs.getString(5));
			}
			con.close();
		}catch(Exception ex){System.out.println(ex);}
		
		return caseExternalInfo;
	}
	
	public static List<CaseExternalInfo> getCaseExternalInfoByVFilters(String fuelType, String stateOfRegistration, String vehicleMake){
		List<CaseExternalInfo> list=new ArrayList<CaseExternalInfo>();
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement
					("SELECT i.case_ID, w.weather_condition, r.road_surface, r.road_descriptor, p.pedestrian_bicyclist_action"
					+ " FROM Weather w, Road r, Pedestrians p, Involve_In i, Vehicles v"
					+ " WHERE i.pedestrians_ID = p.pedestrians_ID"
					+ " AND w.case_ID = i.case_ID"
					+ " AND r.case_ID = i.case_ID"
					+ " AND i.case_vehicle_ID = v.case_vehicle_ID"
					+ " AND v.fuel_type = ?"
					+ " AND v.state_of_registration = ?"
					+ " AND v.vehicle_Make = ?");
			ps.setString(1, fuelType);
			ps.setString(2, stateOfRegistration);
			ps.setString(3, vehicleMake);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				CaseExternalInfo caseExternalInfo = new CaseExternalInfo();
				caseExternalInfo.setCaseID(rs.getString(1));
				caseExternalInfo.setWeatherCondition(rs.getString(2));
				caseExternalInfo.setRoadSurface(rs.getString(3));
				caseExternalInfo.setRoadDescriptor(rs.getString(4));
				caseExternalInfo.setPedestriansBicyclistAction(rs.getString(5));
				list.add(caseExternalInfo);
			}
			con.close();
		}catch(Exception ex){System.out.println(ex);}
		
		return list; 
	}
	
	public static List<CaseExternalInfo> getCaseExternalInfoByBFilters(String trafficControl, String dayOfWeek, String eventDescriptor){
		List<CaseExternalInfo> list=new ArrayList<CaseExternalInfo>();
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement
					("SELECT i.case_ID, w.weather_condition, r.road_surface, r.road_descriptor, p.pedestrian_bicyclist_action"
					+ " FROM Weather w, Road r, Time t, Cases c, Pedestrians p, Involve_In i"
					+ " WHERE c.case_ID = w.case_ID"
					+ " AND c.case_ID = r.case_ID"
					+ " AND c.case_ID = t.case_ID"
					+ " AND c.case_ID = i.case_ID"
					+ " AND i.pedestrians_ID = p.pedestrians_ID"
					+ " AND c.traffic_control = ?"
					+ " AND t.day_of_week = ?"
					+ " AND c.event_descriptor = ?");
			ps.setString(1, trafficControl);
			ps.setString(2, dayOfWeek);
			ps.setString(3, eventDescriptor);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				CaseExternalInfo caseExternalInfo = new CaseExternalInfo();
				caseExternalInfo.setCaseID(rs.getString(1));
				caseExternalInfo.setWeatherCondition(rs.getString(2));
				caseExternalInfo.setRoadSurface(rs.getString(3));
				caseExternalInfo.setRoadDescriptor(rs.getString(4));
				caseExternalInfo.setPedestriansBicyclistAction(rs.getString(5));
				list.add(caseExternalInfo);
			}
			con.close();
		}catch(Exception ex){System.out.println(ex);}
		
		return list; 
	}
}
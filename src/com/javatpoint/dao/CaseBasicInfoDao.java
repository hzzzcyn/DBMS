package com.javatpoint.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.javatpoint.beans.CaseBasicInfo;
import com.javatpoint.beans.StudentBean;

public class CaseBasicInfoDao {

	public static CaseBasicInfo getCaseBasicInfoByCaseID(String caseID){
		CaseBasicInfo caseBasicInfo = new CaseBasicInfo();
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement
					("SELECT c.case_ID, c.event_descriptor, c.traffic_control, c.collision_type_descriptor, c.number_of_vehicles_involved, l.county, l.municipality, t.t_time"
					+ " FROM Cases c, Location l, Time t"
					+ " WHERE c.case_ID = ?"
					+ " AND t.case_ID = ?"
					+ " AND c.location_ID = l.location_ID");
			ps.setString(1,caseID);
			ps.setString(2,caseID);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				caseBasicInfo.setCaseID(rs.getString(1));
				caseBasicInfo.setEventDescriptor(rs.getString(2));
				caseBasicInfo.setTrafficControl(rs.getString(3));
				caseBasicInfo.setCollisionTypeDescriptor(rs.getString(4));
				caseBasicInfo.setNumOfVehicles(rs.getInt(5));
				caseBasicInfo.setCounty(rs.getString(6));
				caseBasicInfo.setMunicipality(rs.getString(7));
				caseBasicInfo.setTime(rs.getTimestamp(8));
			}
			con.close();
		}catch(Exception ex){System.out.println(ex);}
		
		return caseBasicInfo; 
	}
	
	public static List<CaseBasicInfo> getCaseBasicInfoByFilters(String trafficControl, String weatherCondition, String roadSurface, String pedestrianBicyclistAction){
		List<CaseBasicInfo> list=new ArrayList<CaseBasicInfo>();
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement
					("SELECT c.case_ID, c.event_descriptor, c.traffic_control, c.collision_type_descriptor, c.number_of_vehicles_involved, l.county, l.municipality, t.t_time"
					+ " FROM Cases c, Location l, Time t, Weather w, Road r, Pedestrians p, Involve_in i"
					+ " WHERE c.case_ID = t.case_ID"
					+ " AND c.location_ID = l.location_ID"
					+ " AND c.case_ID = w.case_ID"
					+ " AND c.case_ID = r.case_ID"
					+ " AND c.case_ID = i.case_ID"
					+ " AND i.pedestrians_ID = p.pedestrians_ID"
					+ " AND c.traffic_control = ?"
					+ " AND w.weather_condition = ?"
					+ " AND r.road_surface = ?"
					+ " AND p.pedestrian_cicyclist_action = ?");
			ps.setString(1,trafficControl);
			ps.setString(2, weatherCondition);
			ps.setString(3, roadSurface);
			ps.setString(4, pedestrianBicyclistAction);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				CaseBasicInfo caseBasicInfo = new CaseBasicInfo();
				caseBasicInfo.setCaseID(rs.getString(1));
				caseBasicInfo.setEventDescriptor(rs.getString(2));
				caseBasicInfo.setTrafficControl(rs.getString(3));
				caseBasicInfo.setCollisionTypeDescriptor(rs.getString(4));
				caseBasicInfo.setNumOfVehicles(rs.getInt(5));
				caseBasicInfo.setCounty(rs.getString(6));
				caseBasicInfo.setMunicipality(rs.getString(7));
				caseBasicInfo.setTime(rs.getTimestamp(8));
				list.add(caseBasicInfo);
			}
			con.close();
		}catch(Exception ex){System.out.println(ex);}
		
		return list; 
	}
	
	public static List<CaseBasicInfo> getCaseBasicInfoByEFilters(String weatherCondition, String roadSurface, String roadDescriptor){
		List<CaseBasicInfo> list=new ArrayList<CaseBasicInfo>();
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement
					("SELECT c.case_ID, c.event_descriptor, c.traffic_control, c.collision_type_descriptor, c.number_of_vehicles_involved, l.county, l.municipality, t.t_time"
					+ " FROM Cases c, Location l, Time t, Weather w, Road r, Pedestrians p, Involve_in i"
					+ " WHERE c.case_ID = t.case_ID"
					+ " AND c.location_ID = l.location_ID"
					+ " AND c.case_ID = w.case_ID"
					+ " AND c.case_ID = r.case_ID"
					+ " AND c.case_ID = i.case_ID"
					+ " AND i.pedestrians_ID = p.pedestrians_ID"
					+ " AND w.weather_condition = ?"
					+ " AND r.road_surface = ?"
					+ " AND r.road_descriptor = ?");
			ps.setString(1,weatherCondition);
			ps.setString(2, roadSurface);
			ps.setString(3, roadDescriptor);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				CaseBasicInfo caseBasicInfo = new CaseBasicInfo();
				caseBasicInfo.setCaseID(rs.getString(1));
				caseBasicInfo.setEventDescriptor(rs.getString(2));
				caseBasicInfo.setTrafficControl(rs.getString(3));
				caseBasicInfo.setCollisionTypeDescriptor(rs.getString(4));
				caseBasicInfo.setNumOfVehicles(rs.getInt(5));
				caseBasicInfo.setCounty(rs.getString(6));
				caseBasicInfo.setMunicipality(rs.getString(7));
				caseBasicInfo.setTime(rs.getTimestamp(8));
				list.add(caseBasicInfo);
			}
			con.close();
		}catch(Exception ex){System.out.println(ex);}
		
		return list; 
	}
	
	
	public static List<CaseBasicInfo> getCaseBasicInfoByVFilters(String fuelType, String stateOfRegistration, String vehicleMake){
		List<CaseBasicInfo> list=new ArrayList<CaseBasicInfo>();
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement
					("SELECT c.case_ID, c.event_descriptor, c.traffic_control, c.collision_type_descriptor, c.number_of_vehicles_involved, l.county, l.municipality, t.t_time"
					+ " FROM Cases c, Location l, Time t, Vehicles v, Involve_in i"
					+ " WHERE c.case_ID = t.case_ID"
					+ " AND c.location_ID = l.location_ID"
					+ " AND c.case_ID = i.case_ID"
					+ " AND i.case_vehicle_ID = v.case_vehicle_ID"
					+ " AND v.fuel_Type = ?"
					+ " AND v.state_of_registration = ?"
					+ " AND v.vehicle_make = ?");
			ps.setString(1, fuelType);
			ps.setString(2, stateOfRegistration);
			ps.setString(3, vehicleMake);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				CaseBasicInfo caseBasicInfo = new CaseBasicInfo();
				caseBasicInfo.setCaseID(rs.getString(1));
				caseBasicInfo.setEventDescriptor(rs.getString(2));
				caseBasicInfo.setTrafficControl(rs.getString(3));
				caseBasicInfo.setCollisionTypeDescriptor(rs.getString(4));
				caseBasicInfo.setNumOfVehicles(rs.getInt(5));
				caseBasicInfo.setCounty(rs.getString(6));
				caseBasicInfo.setMunicipality(rs.getString(7));
				caseBasicInfo.setTime(rs.getTimestamp(8));
				list.add(caseBasicInfo);
			}
			con.close();
		}catch(Exception ex){System.out.println(ex);}
		
		return list; 
	}
	
	
}

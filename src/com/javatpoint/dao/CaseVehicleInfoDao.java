package com.javatpoint.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.javatpoint.beans.CaseVehicleInfo;


public class CaseVehicleInfoDao {

	public static CaseVehicleInfo getCaseVehicleInfoByCaseID(String caseID){
		CaseVehicleInfo caseVehicleInfo = new CaseVehicleInfo();
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement
					("SELECT i.case_ID, i.case_vehicle_ID, v.fuel_type, v.state_of_registration, v.registration_class, v.vehicle_make, v.vehicle_year, v.engine_cylinder, v.number_of_occupants"
					+ " FROM Vehicles v, Involve_In i"
					+ " WHERE i.case_ID = ?"
					+ " AND i.case_vehicle_ID = v.case_vehicle_ID");
			ps.setString(1,caseID);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				caseVehicleInfo.setCaseID(rs.getString(1));
				caseVehicleInfo.setVehicleID(rs.getInt(2));
				caseVehicleInfo.setFuelType(rs.getString(3));
				caseVehicleInfo.setStateofRegistration(rs.getString(4));
				caseVehicleInfo.setRegistrationClass(rs.getString(5));
				caseVehicleInfo.setVehicleMake(rs.getString(6));
				caseVehicleInfo.setVehicleYear(rs.getInt(7));
				caseVehicleInfo.setEngineCylinder(rs.getInt(8));
				caseVehicleInfo.setNumberofOccupants(rs.getInt(9));
			}
			con.close();
		}catch(Exception ex){System.out.println(ex);}
		
		return caseVehicleInfo;
	}
	
	public static List<CaseVehicleInfo> getCaseVehicleInfoByEFilters(String weatherCondition, String roadSurface, String roadDescriptor){
		List<CaseVehicleInfo> list=new ArrayList<CaseVehicleInfo>();
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement
					("SELECT i.case_ID, i.case_vehicle_ID, v.fuel_type, v.state_of_registration, v.registration_class, v.vehicle_make, v.vehicle_year, v.engine_cylinder, v.number_of_occupants"
					+ " FROM Cases c, Vehicles v, Weather w, Road r, Involve_in i"
					+ " WHERE c.case_ID = i.case_ID"
					+ " AND i.case_vehicle_ID = v.case_vehicle_ID"
					+ " AND c.case_ID = w.case_ID"
					+ " AND c.case_ID = r.case_ID"
					+ " AND w.weather_condition = ?"
					+ " AND r.road_surface = ?"
					+ " AND r.road_descriptor = ?");
			ps.setString(1,weatherCondition);
			ps.setString(2, roadSurface);
			ps.setString(3, roadDescriptor);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				CaseVehicleInfo caseVehicleInfo = new CaseVehicleInfo();
				caseVehicleInfo.setCaseID(rs.getString(1));
				caseVehicleInfo.setVehicleID(rs.getInt(2));
				caseVehicleInfo.setFuelType(rs.getString(3));
				caseVehicleInfo.setStateofRegistration(rs.getString(4));
				caseVehicleInfo.setRegistrationClass(rs.getString(5));
				caseVehicleInfo.setVehicleMake(rs.getString(6));
				caseVehicleInfo.setVehicleYear(rs.getInt(7));
				caseVehicleInfo.setEngineCylinder(rs.getInt(8));
				caseVehicleInfo.setNumberofOccupants(rs.getInt(9));
				list.add(caseVehicleInfo);
			}
			con.close();
		}catch(Exception ex){System.out.println(ex);}
		
		return list; 
	}
	
	public static List<CaseVehicleInfo> getCaseVehicleInfoByBFilters(String trafficControl, String dayOfWeek, String eventDescriptor){
		List<CaseVehicleInfo> list=new ArrayList<CaseVehicleInfo>();
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement
					("SELECT i.case_ID, i.case_vehicle_ID, v.fuel_type, v.state_of_registration, v.registration_class, v.vehicle_make, v.vehicle_year, v.engine_cylinder, v.number_of_occupants"
					+ " FROM Cases c, Vehicles v, Involve_in i, Time t"
					+ " WHERE c.case_ID = i.case_ID"
					+ " AND i.case_vehicle_ID = v.case_vehicle_ID"
					+ " AND c.case_ID = t.case_ID"
					+ " AND c.traffic_control = ?"
					+ " AND t.day_of_week = ?"
					+ " AND c.event_descriptor = ?");
			ps.setString(1, trafficControl);
			ps.setString(2, dayOfWeek);
			ps.setString(3, eventDescriptor);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				CaseVehicleInfo caseVehicleInfo = new CaseVehicleInfo();
				caseVehicleInfo.setCaseID(rs.getString(1));
				caseVehicleInfo.setVehicleID(rs.getInt(2));
				caseVehicleInfo.setFuelType(rs.getString(3));
				caseVehicleInfo.setStateofRegistration(rs.getString(4));
				caseVehicleInfo.setRegistrationClass(rs.getString(5));
				caseVehicleInfo.setVehicleMake(rs.getString(6));
				caseVehicleInfo.setVehicleYear(rs.getInt(7));
				caseVehicleInfo.setEngineCylinder(rs.getInt(8));
				caseVehicleInfo.setNumberofOccupants(rs.getInt(9));
				list.add(caseVehicleInfo);
			}
			con.close();
		}catch(Exception ex){System.out.println(ex);}
		
		return list; 
	}
}

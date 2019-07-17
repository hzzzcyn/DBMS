package com.javatpoint.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.javatpoint.beans.CaseBasicInfo;
import com.javatpoint.beans.ComplexQueryRes;

public class ComplexQueryDao {

	//1.Is there any correlation between the number of occupants and the ratios of crashes?
	public static List<ComplexQueryRes> result_Query1(){
		List<ComplexQueryRes> list=new ArrayList<ComplexQueryRes>();
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement
					("SELECT A.NUMBER_OF_OCCUPANTS, A.NUM/R.TOTAL as precentage" 
					+" FROM (SELECT DISTINCT NUMBER_OF_OCCUPANTS, COUNT(*) AS NUM" 
							+" FROM Vehicles v, Cases c, INVOLVE_IN I" 
					        +" WHERE v.case_vehicle_ID = I.case_vehicle_ID "
					        +" AND I.CASE_ID = C.CASE_ID" 
					        +" GROUP BY v.number_of_occupants) A, "
					        +"(SELECT COUNT(*) AS Total FROM Cases) R" 
					+" ORDER BY precentage DESC");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				ComplexQueryRes res = new ComplexQueryRes();
				res.setNumOfOccupants(rs.getInt(1));
				res.setPercentage(rs.getDouble(2));
				list.add(res);
			}
			con.close();
		}catch(Exception ex){System.out.println(ex);}
		
		return list; 
	}
	
	//2. Which county in NY state is the one where motor vehicle crashes happen most?
	public static List<ComplexQueryRes> result_Query2(){
		List<ComplexQueryRes> list=new ArrayList<ComplexQueryRes>();
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement
					("SELECT DISTINCT s.County, s.Num/r.total AS Percentage" 
					+" FROM (SELECT COUNT(*) AS total FROM Cases) r, " 
					      +"(SELECT DISTINCT l.County, COUNT(*) AS NUM" 
					      +" FROM Location l, Cases c" 
					      +" WHERE l.location_ID = c.location_ID" 
					      +" GROUP BY l.County) s" 
					+" ORDER BY Percentage DESC");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				ComplexQueryRes res = new ComplexQueryRes();
				res.setCounty(rs.getString(1));
				res.setPercentage(rs.getDouble(2));
				list.add(res);
			}
			con.close();
		}catch(Exception ex){System.out.println(ex);}
		
		return list; 
	}
	
	//3. Provide a rank of all brands of cars according to the numbers of crashes they were involved.
	public static List<ComplexQueryRes> result_Query3(){
		List<ComplexQueryRes> list=new ArrayList<ComplexQueryRes>();
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement
					("SELECT r.vehicle_make, r.Num, r.Num/s.total AS Percentage" 
			        +" FROM (SELECT v.vehicle_make, COUNT(*) AS Num\n" 
						  +" FROM Vehicles v" 
			              +" GROUP BY v.vehicle_make) r, " 
						  +"(SELECT COUNT(*) AS total FROM Vehicles) s" 
					+" ORDER BY r.Num DESC");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				ComplexQueryRes res = new ComplexQueryRes();
				res.setVehicleMake(rs.getString(1));
				res.setPercentage(rs.getDouble(3));
				list.add(res);
			}
			con.close();
		}catch(Exception ex){System.out.println(ex);}
		
		return list; 
	}
	
	//4. Can those traffic control devices actually help to decrease the happening rate of accidents?
	public static List<ComplexQueryRes> result_Query4(){
		List<ComplexQueryRes> list=new ArrayList<ComplexQueryRes>();
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement
					("SELECT r.Traffic_control, r.Num/s.Total AS Percentage" 
			        +" FROM (SELECT c.Traffic_control, COUNT(*) AS Num" 
						  +" FROM Cases c" 
			              +" GROUP BY c.Traffic_control) r, " 
						 +" (SELECT COUNT(*) AS Total FROM Cases c) s");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				ComplexQueryRes res = new ComplexQueryRes();
				res.setTrafficControl(rs.getString(1));
				res.setPercentage(rs.getDouble(2));
				list.add(res);
			}
			con.close();
		}catch(Exception ex){System.out.println(ex);}
		
		return list; 
	}
	
	//5. Sort the number of accidents according to different weather conditions and 
	//conclude what kinds of weather conditions are more likely to occur traffic accidents.
	public static List<ComplexQueryRes> result_Query5(){
		List<ComplexQueryRes> list=new ArrayList<ComplexQueryRes>();
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement
					("SELECT DISTINCT WEATHER_CONDITION, V.NUM/S.TOTAL AS Precentage" 
			        +" FROM (SELECT w.WEATHER_Condition, count(*) as num" 
						  +" FROM Cases c, Weather w" 
			              +" WHERE c.CASE_ID = w.CASE_ID" 
						  +" GROUP BY w.weather_condition) V,"
						 + "(SELECT COUNT(*) AS Total FROM Cases c) s" 
				    +" ORDER BY Precentage DESC");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				ComplexQueryRes res = new ComplexQueryRes();
				res.setWeatherCondition(rs.getString(1));
				res.setPercentage(rs.getDouble(2));
				list.add(res);
			}
			con.close();
		}catch(Exception ex){System.out.println(ex);}
		
		return list; 
	}
	
	//6. What is the ratio of collisions between vehicles？
	public static List<ComplexQueryRes> result_Query6(){
		List<ComplexQueryRes> list=new ArrayList<ComplexQueryRes>();
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement
					("SELECT r.number_of_vehicles_involved, (r.Num/s.Total) AS Percentage" 
			        +" FROM (SELECT c.number_of_vehicles_involved, COUNT(*) AS Num" 
						  +" FROM Cases c" 
			              +" GROUP BY c.number_of_vehicles_involved) r, " 
						  +" (SELECT COUNT(*) AS Total FROM Cases c) s" 
					+" ORDER BY r.number_of_vehicles_involved ASC");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				ComplexQueryRes res = new ComplexQueryRes();
				res.setNumOfInvolvedVehicle(rs.getInt(1));
				res.setPercentage(rs.getDouble(2));
				list.add(res);
			}
			con.close();
		}catch(Exception ex){System.out.println(ex);}
		
		return list; 
	}
	
	//7. What kind of accident are most related to those vehicles have more than 6 engine cylinders?
	public static List<ComplexQueryRes> result_Query7(){
		List<ComplexQueryRes> list=new ArrayList<ComplexQueryRes>();
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement
					("SELECT r.Collision_type_descriptor, (r.Num/s.Total) AS Percentage" 
			        +" FROM((SELECT DISTINCT c.Collision_type_descriptor, COUNT(*) AS Num" 
						  +" FROM Cases c, Vehicles v, Involve_in I" 
			              +" WHERE I.Case_vehicle_ID = v.Case_vehicle_ID "
			              +" AND c.case_ID = I.case_ID "
			              +" AND v.engine_cylinder >= 6" 
			              +" GROUP BY c.Collision_type_descriptor)) r, " +
			               "(SELECT COUNT(*) AS Total" 
			              +" FROM (SELECT DISTINCT c.Case_ID, c.Collision_type_descriptor" 
			                    +" FROM Cases c, Vehicles v, Involve_in I" 
			                    +" WHERE I.Case_vehicle_ID = v.Case_vehicle_ID "
			                    +" AND c.case_ID = I.case_ID" 
			                    +" AND v.engine_cylinder >= 6)) s" 
			         +" ORDER BY Percentage DESC");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				ComplexQueryRes res = new ComplexQueryRes();
				res.setCollisionTypeDescriptor(rs.getString(1));
				res.setPercentage(rs.getDouble(2));
				list.add(res);
			}
			con.close();
		}catch(Exception ex){System.out.println(ex);}
		
		return list; 
	}
	
	//8. Do road conditions have a significant impact on crash? 
	//What kind of road is more likely to occur a crash?
	public static List<ComplexQueryRes> result_Query8(){
		List<ComplexQueryRes> list=new ArrayList<ComplexQueryRes>();
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement
					("SELECT s.road_surface, s.num/m.total AS precentage" 
			        +" FROM (SELECT r.road_surface, COUNT(*) AS num" 
						  +" FROM road r, cases c" 
			              +" WHERE r.case_ID = c.case_ID" 
						  +" GROUP BY r.road_surface) s, " 
			              +"(SELECT COUNT(*) AS total FROM CASES) m" 
				    +" ORDER BY precentage DESC");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				ComplexQueryRes res = new ComplexQueryRes();
				res.setRoadCondition(rs.getString(1));
				res.setPercentage(rs.getDouble(2));
				list.add(res);
			}
			con.close();
		}catch(Exception ex){System.out.println(ex);}
		
		return list; 
	}
	
	//9. What kind of factors are more likely to be related with a traffic accident?
	public static List<ComplexQueryRes> result_Query9(){
		List<ComplexQueryRes> list=new ArrayList<ComplexQueryRes>();
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement
					("SELECT r.factor1 AS factor, r.num/s.total AS precentage" 
			        +" FROM (SELECT f.factor1, COUNT(*) AS num" 
						  +" FROM contributing_factors f, involve_in i, cases c" 
			              +" WHERE i.factor_ID = f.factor_ID"
			              +" AND c.case_ID = i.case_ID" 
			              +" GROUP BY f.factor1) r, " 
			              +" (SELECT COUNT(*) AS total FROM CASES) s" 
			        +" ORDER BY precentage DESC");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				ComplexQueryRes res = new ComplexQueryRes();
				res.setFactor(rs.getString(1));
				res.setPercentage(rs.getDouble(2));
				list.add(res);
			}
			con.close();
		}catch(Exception ex){System.out.println(ex);}
		
		return list; 
	}
	
	//10. Which period is the peak of occurrences of traffic accidents? Morning? Afternoon? Night?
	public static List<ComplexQueryRes> result_Query10(){
		List<ComplexQueryRes> list=new ArrayList<ComplexQueryRes>();
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement
					("SELECT"
			          +" CASE" 
						+" WHEN t.timeslot >= 00.00 AND t.timeslot < 06.00 THEN 'Night'" 
			            +" WHEN t.timeslot >= 06.00 AND t.timeslot < 12.00 THEN 'Morning'" 
						+" WHEN t.timeslot >= 12.00 AND t.timeslot < 18.00 THEN 'Afternoon'" 
			            +" WHEN t.timeslot >= 18.00 AND t.timeslot < 24.00 THEN 'Evening'" 
						+" ELSE NULL" +
			           " END time_label, COUNT(*) AS Num" 
				   +" FROM (SELECT TO_CHAR(T_TIME, 'HH24.MM') AS timeslot FROM TIME) t" 
			       +" GROUP BY" 
				     +" CASE" 
			           +" WHEN t.timeslot >= 00.00 AND t.timeslot < 06.00 THEN 'Night'" 
				       +" WHEN t.timeslot >= 06.00 AND t.timeslot < 12.00 THEN 'Morning'" 
			           +" WHEN t.timeslot >= 12.00 AND t.timeslot < 18.00 THEN 'Afternoon'" 
				       +" WHEN t.timeslot >= 18.00 AND t.timeslot < 24.00 THEN 'Evening'" 
			           +" ELSE NULL" 
				     +" END");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				ComplexQueryRes res = new ComplexQueryRes();
				res.setTimeLabel(rs.getString(1));
				res.setNumber(rs.getInt(2));
				list.add(res);
			}
			con.close();
		}catch(Exception ex){System.out.println(ex);}
		
		return list; 
	}
	
	//11. Is there any relationship between the age of a vehicle and the happening rate of a traffic accident?
	public static List<ComplexQueryRes> result_Query11(){
		List<ComplexQueryRes> list=new ArrayList<ComplexQueryRes>();
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement
					("SELECT r.DIE , r.Num/s.total AS Percentage" 
			        +" FROM (SELECT TO_CHAR(T_TIME, 'YYYY')-v.vehicle_year as DIE, COUNT(*) AS num" 
					      +" FROM TIME t, CASES c, vehicles v, involve_in i" 
			              +" WHERE c.case_ID = t.case_ID" 
					      +" AND i.case_ID = c.case_ID" 
			              +" AND i.case_vehicle_ID = v.case_vehicle_ID" 
					      +" GROUP BY TO_CHAR(T_TIME, 'YYYY')-v.vehicle_year) r, " 
			              +" (SELECT COUNT(*) AS total FROM CASES) s" 
					 +" ORDER BY r.DIE ASC");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				ComplexQueryRes res = new ComplexQueryRes();
				res.setVehicleAge(rs.getInt(1));
				res.setPercentage(rs.getDouble(2));
				list.add(res);
			}
			con.close();
		}catch(Exception ex){System.out.println(ex);}
		
		return list; 
	}
}

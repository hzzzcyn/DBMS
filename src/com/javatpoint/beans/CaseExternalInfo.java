package com.javatpoint.beans;

import java.sql.*;

public class CaseExternalInfo {
 
private String CaseID;
private String weatherCondition, roadSurface, roadDescriptor;
private String pedestriansBicyclistAction;

    

public CaseExternalInfo() {
	super();
}

public CaseExternalInfo(String caseID, String weatherCondition, String roadSurface, String roadDescriptor,
   String pedestriansBicyclistAction) {
	  super();
	  CaseID = caseID;
	  this.weatherCondition = weatherCondition;
	  this.roadSurface = roadSurface;
	  this.roadDescriptor = roadDescriptor;
	  this.pedestriansBicyclistAction = pedestriansBicyclistAction;
}
 
public String getCaseID() {
	return CaseID;
 }
 public void setCaseID(String caseID) {
	 CaseID = caseID;
 }
 public String getWeatherCondition() {
	 return weatherCondition;
 }
 public void setWeatherCondition(String weatherCondition) {
	 this.weatherCondition = weatherCondition;
 }
 public String getRoadSurface() {
	 return roadSurface;
 }
 public void setRoadSurface(String roadSurface) {
	 this.roadSurface = roadSurface;
 }
 public String getRoadDescriptor() {
	 return roadDescriptor;
 }
 public void setRoadDescriptor(String roadDescriptor) {
	 this.roadDescriptor = roadDescriptor;
 }
 public String getPedestriansBicyclistAction() {
	 return pedestriansBicyclistAction;
 }
 public void setPedestriansBicyclistAction(String pedestriansBicyclistAction) {
	 this.pedestriansBicyclistAction = pedestriansBicyclistAction;
 }
    
 

}
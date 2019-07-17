package com.javatpoint.beans;

import java.sql.*;

public class CaseBasicInfo {
	
private String caseID, eventDescriptor, trafficControl, collisionTypeDescriptor;
private String county, municipality;
private Timestamp time;
private int numOfVehicles;


public CaseBasicInfo() {
	super();
}


public CaseBasicInfo(String caseID, String eventDescriptor, String trafficControl, String collisionTypeDescriptor,
		String county, String municipality, Timestamp time, int numOfVehicles) {
	super();
	this.caseID = caseID;
	this.eventDescriptor = eventDescriptor;
	this.trafficControl = trafficControl;
	this.collisionTypeDescriptor = collisionTypeDescriptor;
	this.county = county;
	this.municipality = municipality;
	this.time = time;
	this.numOfVehicles = numOfVehicles;
}


public String getCaseID() {
	return caseID;
}


public void setCaseID(String caseID) {
	this.caseID = caseID;
}


public String getEventDescriptor() {
	return eventDescriptor;
}


public void setEventDescriptor(String eventDescriptor) {
	this.eventDescriptor = eventDescriptor;
}


public String getTrafficControl() {
	return trafficControl;
}


public void setTrafficControl(String trafficControl) {
	this.trafficControl = trafficControl;
}


public String getCollisionTypeDescriptor() {
	return collisionTypeDescriptor;
}


public void setCollisionTypeDescriptor(String collisionTypeDescriptor) {
	this.collisionTypeDescriptor = collisionTypeDescriptor;
}


public String getCounty() {
	return county;
}


public void setCounty(String county) {
	this.county = county;
}


public String getMunicipality() {
	return municipality;
}


public void setMunicipality(String municipality) {
	this.municipality = municipality;
}


public Timestamp getTime() {
	return time;
}


public void setTime(Timestamp time) {
	this.time = time;
}


public int getNumOfVehicles() {
	return numOfVehicles;
}


public void setNumOfVehicles(int numOfVehicles) {
	this.numOfVehicles = numOfVehicles;
}


}

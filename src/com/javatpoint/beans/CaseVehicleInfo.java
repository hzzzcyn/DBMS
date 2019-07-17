package com.javatpoint.beans;


public class CaseVehicleInfo {
 
private String caseID;
private String FuelType, StateofRegistration, RegistrationClass,VehicleMake;
private int VehicleID, VehicleYear,EngineCylinder,NumberofOccupants;



public CaseVehicleInfo() {
	super();
}

public CaseVehicleInfo(String caseID, int vehicleID, String fuelType, String stateofRegistration,
		String registrationClass, String vehicleMake, int vehicleYear, int engineCylinder, int numberofOccupants) {
	super();
	this.caseID = caseID;
	VehicleID = vehicleID;
	FuelType = fuelType;
	StateofRegistration = stateofRegistration;
	RegistrationClass = registrationClass;
	VehicleMake = vehicleMake;
	VehicleYear = vehicleYear;
	EngineCylinder = engineCylinder;
	NumberofOccupants = numberofOccupants;
}

public String getCaseID() {
	 return caseID;
 }

 public void setCaseID(String caseID) {
	 this.caseID = caseID;
 }

 public int getVehicleID() {
	 return VehicleID;
 }

 public void setVehicleID(int vehicleID) {
	 this.VehicleID = vehicleID;
 }

 public String getFuelType() {
	 return FuelType;
 }

 public void setFuelType(String fuelType) {
	 this.FuelType = fuelType;
 }

 public String getStateofRegistration() {
	 return StateofRegistration;
 }

 public void setStateofRegistration(String stateofRegistration) {
	 this.StateofRegistration = stateofRegistration;
 }

 public String getRegistrationClass() {
	 return RegistrationClass;
 }

 public void setRegistrationClass(String registrationClass) {
	 RegistrationClass = registrationClass;
 }

 public String getVehicleMake() {
	 return VehicleMake;
 }

 public void setVehicleMake(String vehicleMake) {
	 this.VehicleMake = vehicleMake;
 }

 public int getVehicleYear() {
	 return VehicleYear;
 }

 public void setVehicleYear(int vehicleYear) {
	 this.VehicleYear = vehicleYear;
 }

 public int getEngineCylinder() {
	 return EngineCylinder;
 }

 public void setEngineCylinder(int engineCylinder) {
	 this.EngineCylinder = engineCylinder;
 }

 public int getNumberofOccupants() {
	 return NumberofOccupants;
 }

 public void setNumberofOccupants(int numberofOccupants) {
	 this.NumberofOccupants = numberofOccupants;
 }
    
   
 
}
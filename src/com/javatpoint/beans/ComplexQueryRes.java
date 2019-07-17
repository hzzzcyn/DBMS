package com.javatpoint.beans;

public class ComplexQueryRes {
	
private String county, vehicleMake, trafficControl, roadCondition;
private String timeLabel, weatherCondition, collisionTypeDescriptor, factor;
private int numOfOccupants, numOfInvolvedVehicle, number, vehicleAge;
private double percentage;


public ComplexQueryRes() {
	super();
}


public String getRoadCondition() {
	return roadCondition;
}


public String getFactor() {
	return factor;
}


public int getNumber() {
	return number;
}


public void setNumber(int number) {
	this.number = number;
}


public void setFactor(String factor) {
	this.factor = factor;
}


public void setRoadCondition(String roadCondition) {
	this.roadCondition = roadCondition;
}


public int getNumOfOccupants() {
	return numOfOccupants;
}



public void setNumOfOccupants(int numOfOccupants) {
	this.numOfOccupants = numOfOccupants;
}



public String getCounty() {
	return county;
}


public void setCounty(String county) {
	this.county = county;
}


public String getVehicleMake() {
	return vehicleMake;
}


public void setVehicleMake(String vehicleMake) {
	this.vehicleMake = vehicleMake;
}


public int getVehicleAge() {
	return vehicleAge;
}


public void setVehicleAge(int vehicleAge) {
	this.vehicleAge = vehicleAge;
}


public String getTrafficControl() {
	return trafficControl;
}


public void setTrafficControl(String trafficControl) {
	this.trafficControl = trafficControl;
}


public String getTimeLabel() {
	return timeLabel;
}


public void setTimeLabel(String timeLabel) {
	this.timeLabel = timeLabel;
}


public String getWeatherCondition() {
	return weatherCondition;
}


public void setWeatherCondition(String weatherCondition) {
	this.weatherCondition = weatherCondition;
}


public String getCollisionTypeDescriptor() {
	return collisionTypeDescriptor;
}


public void setCollisionTypeDescriptor(String collisionTypeDescriptor) {
	this.collisionTypeDescriptor = collisionTypeDescriptor;
}


public int getNumOfInvolvedVehicle() {
	return numOfInvolvedVehicle;
}


public void setNumOfInvolvedVehicle(int numOfInvolvedVehicle) {
	this.numOfInvolvedVehicle = numOfInvolvedVehicle;
}


public double getPrecentage() {
	return percentage;
}


public void setPercentage(double percentage) {
	this.percentage = percentage;
}


}


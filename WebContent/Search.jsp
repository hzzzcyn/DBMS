<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.google.gson.Gson"%>
<%@ page import="com.google.gson.JsonObject"%>
<%@ page import="com.javatpoint.beans.CaseBasicInfo"%>
<%@ page import="com.javatpoint.beans.ComplexQueryRes"%>
<%
Gson gsonObj = new Gson();
Map<Object,Object> map = null;
String dataPoints = null;
List<Map<Object,Object>> list = new ArrayList<Map<Object,Object>>();

List<ComplexQueryRes>  temp=(List<ComplexQueryRes>)request.getAttribute("list");
int queryType = Integer.parseInt(request.getAttribute("type").toString());

if (queryType == 1){
double q0to5=0,q6to10=0,q11to40=0,q41to70=0,q71to100=0,unknown=0;
	for(ComplexQueryRes bean:temp){	
		int c = bean.getNumOfOccupants();
		if(c>=0 && c<=5){
			q0to5 += c;
		}else if(c>=6 && c<=10){
			q6to10 += c;
		}else if(c>= 11 && c<=40){
			q11to40 += c;
		}else if(c>=41 && c<=70){
			q41to70 += c;
		}else if(c>=71 && c<= 120){
			q71to100 += c;
		}else{
			unknown += c;
		}
	
	}

map = new HashMap<Object,Object>(); map.put("label","q0to5");map.put("y",q0to5);map.put("exploded", true); list.add(map);
map = new HashMap<Object,Object>(); map.put("label","q6to10");map.put("y",q6to10); list.add(map);
map = new HashMap<Object,Object>(); map.put("label","q11to40");map.put("y",q11to40); list.add(map);
map = new HashMap<Object,Object>(); map.put("label","q41to70");map.put("y",q41to70); list.add(map);
map = new HashMap<Object,Object>(); map.put("label","q71to100");map.put("y",q71to100); list.add(map);
map = new HashMap<Object,Object>(); map.put("label","unknown");map.put("y",unknown); list.add(map);
dataPoints = gsonObj.toJson(list);

}

if (queryType == 2){
double NASSAU=0,ERIE=0,MONROE=0,WESTCHESTER=0,SUFFOLK=0,OTHERS=0;

for(ComplexQueryRes bean:temp){	
	switch (bean.getCounty()){
	case "NASSAU" :
		NASSAU = bean.getPrecentage();
		break;
	case "ERIE" :
		ERIE = bean.getPrecentage();
		break;
	case "MONROE" :
		MONROE = bean.getPrecentage();
		break;
	case "WESTCHESTER" :
		WESTCHESTER = bean.getPrecentage();
		break;
	case "SUFFOLK" :
		SUFFOLK = bean.getPrecentage();
		break;
	default:
		OTHERS += bean.getPrecentage();
		break;
	}
}

map = new HashMap<Object,Object>(); map.put("label","NASSAU");map.put("y",NASSAU);map.put("exploded", true); list.add(map);
map = new HashMap<Object,Object>(); map.put("label","ERIE");map.put("y",ERIE); list.add(map);
map = new HashMap<Object,Object>(); map.put("label","MONROE");map.put("y",MONROE); list.add(map);
map = new HashMap<Object,Object>(); map.put("label","WESTCHESTER");map.put("y",WESTCHESTER); list.add(map);
map = new HashMap<Object,Object>(); map.put("label","SUFFOLK");map.put("y",SUFFOLK); list.add(map);
map = new HashMap<Object,Object>(); map.put("label","OTHERS");map.put("y",OTHERS); list.add(map);

dataPoints = gsonObj.toJson(list);

}
else if (queryType == 3)
{
	double NULL=0,FORD=0,TOYOT=0,CHEVR=0,HONDA=0,NISSA=0,DODGE=0,HYUND=0,OTHERS=0;
	
	for(ComplexQueryRes bean:temp){	
		if(bean.getVehicleMake()==null) NULL = bean.getPrecentage();
		else{
			
		switch (bean.getVehicleMake()){
		
		
		case "FORD" :
			FORD = bean.getPrecentage();
			break;
		case "TOYOT" :
			TOYOT = bean.getPrecentage();
			break;
		case "CHEVR" :
			CHEVR = bean.getPrecentage();
			break;
		case "HONDA" :
			HONDA = bean.getPrecentage();
			break;
			case "NISSA" :
			NISSA = bean.getPrecentage();
			break;
		case "DODGE" :
			DODGE = bean.getPrecentage();
			break;
		case "HYUND" :
			HYUND = bean.getPrecentage();
			break;
		default:
			OTHERS += bean.getPrecentage();
			break;
		}
		}
	}

	map = new HashMap<Object,Object>(); map.put("label","NULL");map.put("y",NULL);map.put("exploded", true); list.add(map);
	map = new HashMap<Object,Object>(); map.put("label","FORD");map.put("y",FORD); list.add(map);
	map = new HashMap<Object,Object>(); map.put("label","TOYOT");map.put("y",TOYOT); list.add(map);
	map = new HashMap<Object,Object>(); map.put("label","CHEVR");map.put("y",CHEVR); list.add(map);
	map = new HashMap<Object,Object>(); map.put("label","HONDA");map.put("y",HONDA); list.add(map);
	map = new HashMap<Object,Object>(); map.put("label","NISSA");map.put("y",NISSA); list.add(map);
	map = new HashMap<Object,Object>(); map.put("label","DODGE");map.put("y",DODGE); list.add(map);
	map = new HashMap<Object,Object>(); map.put("label","HYUND");map.put("y",HYUND); list.add(map);
	map = new HashMap<Object,Object>(); map.put("label","OTHERS");map.put("y",OTHERS); list.add(map);

dataPoints = gsonObj.toJson(list);
}
else if (queryType == 4)
{
	double None=0,Traffic_Signal=0,Stop_Sign=0,Unknown=0,No_Passing_Zone=0,OTHERS=0;
	for(ComplexQueryRes bean:temp){	
		switch (bean.getTrafficControl()){
		case "None" :
			None = bean.getPrecentage();
			break;
		case "Traffic_Signal" :
			Traffic_Signal = bean.getPrecentage();
			break;
		case "Stop_Sign" :
			Stop_Sign = bean.getPrecentage();
			break;
		case "Unknown" :
			Unknown = bean.getPrecentage();
			break;
		case "No_Passing_Zone" :
			No_Passing_Zone = bean.getPrecentage();
			break;
		default:
			OTHERS += bean.getPrecentage();
			break;
		}
	}


	map = new HashMap<Object,Object>(); map.put("label","None");map.put("y",None);map.put("exploded", true); list.add(map);
	map = new HashMap<Object,Object>(); map.put("label","Traffic_Signal");map.put("y",Traffic_Signal); list.add(map);
	map = new HashMap<Object,Object>(); map.put("label","Stop_Sign");map.put("y",Stop_Sign); list.add(map);
	map = new HashMap<Object,Object>(); map.put("label","Unknown");map.put("y",Unknown); list.add(map);
	map = new HashMap<Object,Object>(); map.put("label","No_Passing_Zone");map.put("y",No_Passing_Zone); list.add(map);
	map = new HashMap<Object,Object>(); map.put("label","OTHERS");map.put("y",OTHERS); list.add(map);

    dataPoints = gsonObj.toJson(list);
}
else if (queryType == 5){
	double Clear=0,Cloudy=0,Snow=0,Unknown=0,Rain=0,SleetHailFreezingRain=0,FogSmogSmoke=0,Other=0;
	
	for(ComplexQueryRes bean:temp){	
		switch (bean.getWeatherCondition()){
		case "Clear" :
			Clear = bean.getPrecentage();
			break;
		case "Cloudy" :
			Cloudy = bean.getPrecentage();
			break;
		case "Snow" :
			Snow = bean.getPrecentage();
			break;
		case "Unknown" :
			Unknown = bean.getPrecentage();
			break;
		case "Rain" :
			Rain = bean.getPrecentage();
			break;
			case "SleetHailFreezingRain" :
			SleetHailFreezingRain = bean.getPrecentage();
			break;
		case "FogSmogSmoke" :
			FogSmogSmoke = bean.getPrecentage();
			break;
		case "Other":
			Other = bean.getPrecentage();
			break;
		}
	}


	map = new HashMap<Object,Object>(); map.put("label","Clear");map.put("y",Clear);map.put("exploded", true); list.add(map);
	map = new HashMap<Object,Object>(); map.put("label","Cloudy");map.put("y",Cloudy); list.add(map);
	map = new HashMap<Object,Object>(); map.put("label","Snow");map.put("y",Snow); list.add(map);
	map = new HashMap<Object,Object>(); map.put("label","Unknown");map.put("y",Unknown); list.add(map);
	map = new HashMap<Object,Object>(); map.put("label","Rain");map.put("y",Rain); list.add(map);
	map = new HashMap<Object,Object>(); map.put("label","SleetHailFreezingRain");map.put("y",SleetHailFreezingRain); list.add(map);
	map = new HashMap<Object,Object>(); map.put("label","FogSmogSmoke");map.put("y",FogSmogSmoke); list.add(map);
	map = new HashMap<Object,Object>(); map.put("label","Other");map.put("y",Other); list.add(map);

dataPoints = gsonObj.toJson(list);
}
else if (queryType == 6){
	double one=0, two=0, three=0, rangea=0, rangeb=0, rangec=0;
	;
	for(ComplexQueryRes bean:temp){	
		int a = bean.getNumOfInvolvedVehicle();
		if (a==1){
			one = a;
		}else if(a==2){
			two = a;
		}else if(a==3){
			three = a;
		}else if(a>=4 && a<=13){
			rangea += a;
		}else if(a>=14 && a<=22){
			rangeb += a;
		}else if(a>=23 && a<=31){
			rangec += a;
		}
	}


	map = new HashMap<Object,Object>(); map.put("label","one");map.put("y",one);map.put("exploded", true); list.add(map);
	map = new HashMap<Object,Object>(); map.put("label","two");map.put("y",two); list.add(map);
	map = new HashMap<Object,Object>(); map.put("label","three");map.put("y",three); list.add(map);
	map = new HashMap<Object,Object>(); map.put("label","rangea");map.put("y",rangea); list.add(map);
	map = new HashMap<Object,Object>(); map.put("label","rangeb");map.put("y",rangeb); list.add(map);
	map = new HashMap<Object,Object>(); map.put("label","rangec");map.put("y",rangec); list.add(map);

	dataPoints = gsonObj.toJson(list);

}


else if (queryType == 7){
	double OTHER=0,REAREND=0,RIGHTANGLE=0,OVERTAKING=0,Unknown=0,LEFTTURN=0,SIDESWIPE=0,HEADON=0,RIGHTTURN=0;
	
	for(ComplexQueryRes bean:temp){	
		switch (bean.getCollisionTypeDescriptor()){
		case "OTHER" :
			OTHER = bean.getPrecentage();
			break;
		case "REAREND" :
			REAREND = bean.getPrecentage();
			break;
		case "RIGHTANGLE" :
			RIGHTANGLE = bean.getPrecentage();
			break;
		case "OVERTAKING" :
			OVERTAKING = bean.getPrecentage();
			break;
		case "Unknown" :
			Unknown = bean.getPrecentage();
			break;
		case "LEFTTURN" :
			LEFTTURN = bean.getPrecentage();
			break;
		case "SIDESWIPE" :
			SIDESWIPE = bean.getPrecentage();
			break;
		case "HEADON" :
			HEADON = bean.getPrecentage();
			break;
		case "RIGHTTURN" :
			RIGHTTURN = bean.getPrecentage();
			break;
		}
	}


	map = new HashMap<Object,Object>(); map.put("label","OTHER");map.put("y",OTHER);map.put("exploded", true); list.add(map);
	map = new HashMap<Object,Object>(); map.put("label","REAREND");map.put("y",REAREND); list.add(map);
	map = new HashMap<Object,Object>(); map.put("label","RIGHTANGLE");map.put("y",RIGHTANGLE); list.add(map);
	map = new HashMap<Object,Object>(); map.put("label","OVERTAKING");map.put("y",OVERTAKING); list.add(map);
	map = new HashMap<Object,Object>(); map.put("label","Unknown");map.put("y",Unknown); list.add(map);
	map = new HashMap<Object,Object>(); map.put("label","LEFTTURN");map.put("y",LEFTTURN); list.add(map);
	map = new HashMap<Object,Object>(); map.put("label","SIDESWIPE");map.put("y",SIDESWIPE); list.add(map);
	map = new HashMap<Object,Object>(); map.put("label","HEADON");map.put("y",HEADON); list.add(map);
	map = new HashMap<Object,Object>(); map.put("label","RIGHTTURN");map.put("y",RIGHTTURN); list.add(map);

dataPoints = gsonObj.toJson(list);
	}

else if (queryType == 8){
	double Dry=0,SnowIce=0,Wet=0,Unknown=0,Slush=0,Other=0, Muddy=0,Flooded_Water=0;
	
	for(ComplexQueryRes bean:temp){	
		switch (bean.getRoadCondition()){
		case "Dry" :
			Dry = bean.getPrecentage();
			break;
		case "SnowIce" :
			SnowIce = bean.getPrecentage();
			break;
		case "Wet" :
			Wet = bean.getPrecentage();
			break;
		case "Unknown" :
			Unknown = bean.getPrecentage();
			break;
		case "Slush" :
			Slush = bean.getPrecentage();
			break;
		case "Other" :
			Other = bean.getPrecentage();
			break;
		case "Muddy" :
			Muddy = bean.getPrecentage();
			break;
		case "Flooded_Water" :
			Flooded_Water = bean.getPrecentage();
			break;
		}
	}


	map = new HashMap<Object,Object>(); map.put("label","Dry");map.put("y",Dry);map.put("exploded", true); list.add(map);
	map = new HashMap<Object,Object>(); map.put("label","SnowIce");map.put("y",SnowIce); list.add(map);
	map = new HashMap<Object,Object>(); map.put("label","Wet");map.put("y",Wet); list.add(map);
	map = new HashMap<Object,Object>(); map.put("label","Unknown");map.put("y",Unknown); list.add(map);
	map = new HashMap<Object,Object>(); map.put("label","Slush");map.put("y",Slush); list.add(map);
	map = new HashMap<Object,Object>(); map.put("label","Other");map.put("y",Other); list.add(map);
	map = new HashMap<Object,Object>(); map.put("label","Muddy");map.put("y",Muddy); list.add(map);
	map = new HashMap<Object,Object>(); map.put("label","Flooded_Water");map.put("y",Flooded_Water); list.add(map);

	dataPoints = gsonObj.toJson(list);

}
else if (queryType == 9){
	double HUMAN=0,ENVMT=0,VEHICLE=0,Unknown=0;
	
	
		for(ComplexQueryRes bean:temp){	
			if(bean.getFactor()==null) Unknown = bean.getPrecentage();
			else{
			switch (bean.getFactor()){
			case "HUMAN" :
				HUMAN = bean.getPrecentage();
				break;
			case "ENVMT" :
				ENVMT = bean.getPrecentage();
				break;
			case "VEHICLE" :
				VEHICLE = bean.getPrecentage();
				break;
			
			}
			}
		}
		map = new HashMap<Object,Object>(); map.put("label","HUMAN");map.put("y",HUMAN);map.put("exploded", true); list.add(map);
		map = new HashMap<Object,Object>(); map.put("label","ENVMT");map.put("y",ENVMT); list.add(map);
		map = new HashMap<Object,Object>(); map.put("label","VEHICLE");map.put("y",VEHICLE); list.add(map);
		map = new HashMap<Object,Object>(); map.put("label","Unknown");map.put("y",Unknown); list.add(map);

		dataPoints = gsonObj.toJson(list);

}
else if (queryType == 11){
	double k0to10=0,k11to20=0,k21to30=0,k31to40=0,k41to50=0,k51to60=0,k61to90=0,k91to120=0,UNKNOWN=0;
	
	for(ComplexQueryRes bean:temp){	
		int b = bean.getVehicleAge();
		if (b>= -2 && b<=10){
			k0to10 += b;
		} else if(b>= 11 && b<=20){
			k11to20 += b;
		}else if(b>=21 && b<=30){
			k21to30 +=b;
		}else if(b>= 31 && b<=40){
			k31to40 += b;
		}else if(b>= 41 && b<=50){
			k41to50 += b;
		}else if(b>= 51 && b<=60){
			k51to60 += b;
		}else if(b>= 61 && b<=90){
			k61to90 += b;
		}else if(b>= 91 && b<=120){
			k91to120 += b;
		}else{
			UNKNOWN += b;
		}
	}


	map = new HashMap<Object,Object>(); map.put("label","[0,10]");map.put("y",k0to10);map.put("exploded", true); list.add(map);
	map = new HashMap<Object,Object>(); map.put("label","[11,20]");map.put("y",k11to20); list.add(map);
	map = new HashMap<Object,Object>(); map.put("label","[21,30]");map.put("y",k21to30); list.add(map);
	map = new HashMap<Object,Object>(); map.put("label","[31,40]");map.put("y",k31to40); list.add(map);
	map = new HashMap<Object,Object>(); map.put("label","[41,50]");map.put("y",k41to50); list.add(map);
	map = new HashMap<Object,Object>(); map.put("label","[51,60]");map.put("y",k51to60); list.add(map);
	map = new HashMap<Object,Object>(); map.put("label","[61,90]");map.put("y",k61to90); list.add(map);
	map = new HashMap<Object,Object>(); map.put("label","[91,120]");map.put("y",k91to120); list.add(map);
	map = new HashMap<Object,Object>(); map.put("label","UNKNOWN");map.put("y",UNKNOWN); list.add(map);

	dataPoints = gsonObj.toJson(list);
	}






%>
 
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="resources/bootstrap.min.css"/>
<link rel="stylesheet" href="style.css"/>
<script type="text/javascript">
window.onload = function() { 
 
var chart = new CanvasJS.Chart("chartContainer", {
	theme: "light2",
	title: {
		text: "Iron Ore Production in India"
	},
	axisX: {
		title: "Fiscal Year"
	},
	axisY: {
		title: "Production ( in million tonnes )"
	},
	data: [{
		type: "line",
		yValueFormatString: "#,##0mn tonnes",
		dataPoints : <%out.print(dataPoints);%>
	}]
});
chart.render();
 
}
</script>
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="index.html">Traffic Accident</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li><a href="index.html">Home</a></li>
        <li><a href="AddStudentForm">Add Student</a></li>
        <li><a href="ViewStudent">Basic Search</a></li>
        <li><a href="SearchStudentForm">Visual Search</a></li>
        <li><a href="LogoutAccountant">Logout</a></li>
        </ul>

    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>

<div id="chartContainer" style="height: 370px; width: 100%;"></div>
<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
</body>
</html>
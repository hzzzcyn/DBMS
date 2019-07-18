--------------------------------------------------------
--  File created - Friday-March-01-2019   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table LOCATION
--------------------------------------------------------

  CREATE TABLE "LOCATION" 
   (	"LOCATION_ID" VARCHAR2(40 BYTE) PRIMARY KEY, 
	"DOT_REFERENCE_MAKER" VARCHAR2(30 BYTE), 
	"COUNTY" VARCHAR2(20 BYTE), 
	"MUNICIPALITY" VARCHAR2(30 BYTE)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL FOR SEQUENCE OF LOCATION_ID
--------------------------------------------------------
CREATE SEQUENCE SEQ_LOCATION
    MINVALUE 1
    START WITH 1
    INCREMENT BY 1
    CACHE 200000 ;
--------------------------------------------------------
--  DDL FOR TRIGGER OF SEQUENCE OF LOCATION_ID
--------------------------------------------------------
  create or replace trigger LOCATION_TRI
  before insert on LOCATION
  for each row
  begin
  select concat('L',to_char(SEQ_LOCATION.nextval,'fm000000')) into :new.LOCATION_ID from dual;
  end LOCATION_TRI;
  /
--------------------------------------------------------
--  DDL for Table PEDESTRIANS
--------------------------------------------------------
  CREATE TABLE "PEDESTRIANS" 
   (	"PEDESTRIANS_ID" VARCHAR2(40 BYTE) PRIMARY KEY, 
	"PEDESTRIAN_BICYCLIST_ACTION" VARCHAR2(80 BYTE)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL FOR SEQUENCE OF PEDESTRIANS_ID
--------------------------------------------------------
CREATE SEQUENCE SEQ_PEDESTRIANS
    MINVALUE 1
    START WITH 1
    INCREMENT BY 1
    CACHE 200000 ;
--------------------------------------------------------
--  DDL FOR TRIGGER OF SEQUENCE OF PEDESTRIANS_ID
--------------------------------------------------------
  create or replace trigger PEDESTRIANS_TRI
  before insert on PEDESTRIANS
  for each row
  begin
  select concat('P',to_char(SEQ_PEDESTRIANS.nextval,'fm000000')) into :new.PEDESTRIANS_ID from dual;
  end PEDESTRIANS_TRI;
  /
--------------------------------------------------------
--  DDL for Table CASES
--------------------------------------------------------
  CREATE TABLE "CASES" 
   (	"CASE_ID" VARCHAR2(40 BYTE) PRIMARY KEY, 
	"POLICE_REPORT" VARCHAR2(1 BYTE), 
	"CRASH_DESCRIPTOR" VARCHAR2(50 BYTE), 
	"EVENT_DESCRIPTOR" VARCHAR2(60 BYTE),
    "TRAFFIC_CONTROL" VARCHAR2(40 BYTE),
    "COLLISION_TYPE_DESCRIPTOR" VARCHAR2(50 BYTE),
	"NUMBER_OF_VEHICLES_INVOLVED" NUMBER(*,0),
    "LOCATION_ID" VARCHAR2(40 BYTE),
    FOREIGN KEY("LOCATION_ID") REFERENCES LOCATION("LOCATION_ID")
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL FOR SEQUENCE OF CASE_ID
--------------------------------------------------------
CREATE SEQUENCE SEQ_CASES
    MINVALUE 1
    START WITH 1
    INCREMENT BY 1
    CACHE  1000001;
--------------------------------------------------------
--  DDL FOR SEQUENCE OF CLOCATION_ID
--------------------------------------------------------
CREATE SEQUENCE SEQ_CLOCATION
    MINVALUE 1
    START WITH 1
    INCREMENT BY 1
    CACHE 100001;
--------------------------------------------------------
--  DDL FOR TRIGGER OF SEQUENCE OF CASE_ID AND CLOCATION_ID
--------------------------------------------------------
  create or replace trigger CASES_TRI
  before insert on CASES
  for each row
  begin
  select concat('C',to_char(SEQ_CASES.nextval,'fm000000')) into :new.CASE_ID from dual;
  select concat('L',to_char(SEQ_CLOCATION.nextval,'fm000000')) into :new.LOCATION_ID from dual;
  end CASES_TRI;
  /
--------------------------------------------------------
--  DDL for Table CONTRIBUTING_FACTORS
--------------------------------------------------------
  CREATE TABLE "CONTRIBUTING_FACTORS" 
   (	"FACTOR_ID" VARCHAR2(40 BYTE) PRIMARY KEY, 
	"FACTOR1" VARCHAR2(10 BYTE), 
	"FACTOR1_DESCRIPTION" VARCHAR2(50 BYTE), 
	"FACTOR2" VARCHAR2(10 BYTE), 
	"FACTOR2_DESCRIPTION" VARCHAR2(50 BYTE)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
  
--------------------------------------------------------
--  DDL FOR SEQUENCE OF FACTOR_ID
--------------------------------------------------------
CREATE SEQUENCE SEQ_FACTOR
    MINVALUE 1
    START WITH 1
    INCREMENT BY 1
    CACHE 200000 ;
--------------------------------------------------------
--  DDL FOR TRIGGER OF SEQUENCE OF FACTOR_ID
--------------------------------------------------------
  create or replace trigger FACTOR_TRI
  before insert on CONTRIBUTING_FACTORS
  for each row
  begin
  select concat('F',to_char(SEQ_FACTOR.nextval,'fm000000')) into :new.FACTOR_ID from dual;
  end FACTOR_TRI;
  /
--------------------------------------------------------
--  DDL for Table DRIVER_BEHAVIORS
--------------------------------------------------------

  CREATE TABLE "DRIVER_BEHAVIORS" 
   (	"DRIVER_ID" VARCHAR2(40 BYTE) PRIMARY KEY, 
	"ACTION_PIROR_TO_ACCIDENT" VARCHAR2(40 BYTE)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
  
--------------------------------------------------------
--  DDL FOR SEQUENCE OF DRIVER_ID
--------------------------------------------------------
CREATE SEQUENCE SEQ_DRIVER
    MINVALUE 1
    START WITH 1
    INCREMENT BY 1
    CACHE 200000 ;
--------------------------------------------------------
--  DDL FOR TRIGGER OF SEQUENCE OF DRIVER_ID
--------------------------------------------------------
  create or replace trigger DRIVER_TRI
  before insert on DRIVER_BEHAVIORS
  for each row
  begin
  select concat('D',to_char(SEQ_DRIVER.nextval,'fm000000')) into :new.DRIVER_ID from dual;
  end DRIVER_TRI;
  /

--------------------------------------------------------
--  DDL for Table ROAD
--------------------------------------------------------
  CREATE TABLE "ROAD"
   (	"CASE_ID" VARCHAR2(40 BYTE), 
	"ROAD_SURFACE" VARCHAR2(20 BYTE), 
	"ROAD_DESCRIPTOR" VARCHAR2(30 BYTE)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL FOR SEQUENCE OF ROAD_ID
--------------------------------------------------------
CREATE SEQUENCE SEQ_ROAD
    MINVALUE 1
    START WITH 1
    INCREMENT BY 1
    CACHE 200000 ;
--------------------------------------------------------
--  DDL FOR TRIGGER OF SEQUENCE OF ROAD_ID
--------------------------------------------------------
  create or replace trigger ROAD_TRI
  before insert on ROAD
  for each row
  begin
  select concat('C',to_char(SEQ_ROAD.nextval,'fm000000')) into :new.CASE_ID from dual;
  end ROAD_TRI;
  /
--------------------------------------------------------
--  DDL for Table VEHICLES
--------------------------------------------------------
  CREATE TABLE "VEHICLES" 
   (	"CASE_VEHICLE_ID" NUMBER(*,0) PRIMARY KEY, 
	"NUMBER_OF_OCCUPANTS" NUMBER(*,0),  
	"REGISTRATION_CLASS" VARCHAR2(50 BYTE), 
	"FUEL_TYPE" VARCHAR2(30 BYTE), 
	"VEHICLE_YEAR" NUMBER(*,0), 
	"STATE_OF_REGISTRATION" VARCHAR2(20 BYTE), 
	"ENGINE_CYLINDER" VARCHAR2(30 BYTE), 
	"TYPE_AXIES_OF_TRUCK_OR_BUS" VARCHAR2(40 BYTE), 
	"VEHICLE_MAKE" VARCHAR2(30 BYTE), 
	"PARTIAL_VIN" VARCHAR2(30 BYTE)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table WEATHER
--------------------------------------------------------
  CREATE TABLE "WEATHER" 
   (	"CASE_ID" VARCHAR2(40 BYTE), 
	"WEATHER_CONDITION" VARCHAR2(40 BYTE)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL FOR SEQUENCE OF WEATHER_ID
--------------------------------------------------------
CREATE SEQUENCE SEQ_WEATHER
    MINVALUE 1
    START WITH 1
    INCREMENT BY 1
    CACHE 200000 ;
--------------------------------------------------------
--  DDL FOR TRIGGER OF SEQUENCE OF WEATHER_ID
--------------------------------------------------------
  create or replace trigger WEATHER_TRI
  before insert on WEATHER
  for each row
  begin
  select concat('C',to_char(SEQ_WEATHER.nextval,'fm000000')) into :new.CASE_ID from dual;
  end WEATHER_TRI;
  /
--------------------------------------------------------
--  DDL for Table TIME
--------------------------------------------------------
  CREATE TABLE "TIME" 
   (	"CASE_ID" VARCHAR2(40 BYTE),
         "T_TIME" TIMESTAMP,  
	"DAY_OF_WEEK" VARCHAR2(10 BYTE)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
  --------------------------------------------------------
--  DDL FOR SEQUENCE OF CASE_ID
--------------------------------------------------------
CREATE SEQUENCE SEQ_TIME
    MINVALUE 1
    START WITH 1
    INCREMENT BY 1
    CACHE 200000 ;
--------------------------------------------------------
--  DDL FOR TRIGGER OF SEQUENCE OF CASE_ID
--------------------------------------------------------
  create or replace trigger TIME_TRI
  before insert on TIME
  for each row
  begin
  select concat('C',to_char(SEQ_TIME.nextval,'fm000000')) into :new.CASE_ID from dual;
  end TIME_TRI;
  /
--------------------------------------------------------
--  DDL for Table INVOLVE_IN
--------------------------------------------------------

  CREATE TABLE "INVOLVE_IN" 
   (	"FACTOR_ID" VARCHAR2(40 BYTE), 
	"CASE_VEHICLE_ID" NUMBER(*,0), 
	"PEDESTRIANS_ID" VARCHAR2(40 BYTE), 
	"CASE_ID" VARCHAR2(40 BYTE),
    "DRIVER_ID" VARCHAR2(40 BYTE),
    FOREIGN KEY("FACTOR_ID") REFERENCES CONTRIBUTING_FACTORS("FACTOR_ID"),
    FOREIGN KEY("CASE_VEHICLE_ID") REFERENCES VEHICLES("CASE_VEHICLE_ID"),
    FOREIGN KEY("PEDESTRIANS_ID") REFERENCES PEDESTRIANS("PEDESTRIANS_ID"),
    FOREIGN KEY("CASE_ID") REFERENCES CASES("CASE_ID"),
    FOREIGN KEY("DRIVER_ID") REFERENCES DRIVER_BEHAVIORS("DRIVER_ID")
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL FOR SEQUENCE OF IFACTOR_ID
--------------------------------------------------------
CREATE SEQUENCE SEQ_IFACTOR_ID
    MINVALUE 1
    START WITH 1
    INCREMENT BY 1
    CACHE 200000 ;
--------------------------------------------------------
--  DDL FOR SEQUENCE OF IPEDESTRIANS_ID
--------------------------------------------------------
CREATE SEQUENCE SEQ_IPEDESTRIANS_ID
    MINVALUE 1
    START WITH 1
    INCREMENT BY 1
    CACHE 200000 ;
--------------------------------------------------------
--  DDL FOR SEQUENCE OF ICASE_ID
--------------------------------------------------------
CREATE SEQUENCE SEQ_ICASE_ID
    MINVALUE 1
    START WITH 1
    INCREMENT BY 1
    CACHE 200000 ;
--------------------------------------------------------
--  DDL FOR SEQUENCE OF IDRIVER_ID
--------------------------------------------------------
CREATE SEQUENCE SEQ_IDRIVER_ID
    MINVALUE 1
    START WITH 1
    INCREMENT BY 1
    CACHE 200000 ;
--------------------------------------------------------
--  DDL FOR TRIGGER OF SEQUENCE OF INVOLVE_IN
--------------------------------------------------------
  create or replace trigger INVOLVE_IN_TRI
  before insert on INVOLVE_IN
  for each row
  begin
  select concat('F',to_char(SEQ_IFACTOR_ID.nextval,'fm000000')) into :new.FACTOR_ID from dual;
  select concat('P',to_char(SEQ_IPEDESTRIANS_ID.nextval,'fm000000')) into :new.PEDESTRIANS_ID from dual;
  select concat('C',to_char(SEQ_ICASE_ID.nextval,'fm000000')) into :new.CASE_ID from dual;
  select concat('D',to_char(SEQ_IDRIVER_ID.nextval,'fm000000')) into :new.DRIVER_ID from dual;
  end INVOLVE_IN_TRI;
  /
REM INSERTING into CASES
SET DEFINE OFF;
REM INSERTING into CONTRIBUTING_FACTORS
SET DEFINE OFF;
REM INSERTING into DRIVER_BEHAVIORS
SET DEFINE OFF;
REM INSERTING into EXTERNAL_CONDITION
SET DEFINE OFF;
REM INSERTING into INVOLVE_IN
SET DEFINE OFF;
REM INSERTING into LOCATION
SET DEFINE OFF;
REM INSERTING into PEDESTRIANS
SET DEFINE OFF;
REM INSERTING into ROAD
SET DEFINE OFF;
REM INSERTING into VEHICLES
SET DEFINE OFF;
REM INSERTING into WEATHER
SET DEFINE OFF;
REM INSERTING into TIME
SET DEFINE OFF;
--------------------------------------------------------
--  DDL for Index SYS_C0036367
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C0036367" ON "CASES" ("CASE_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C0036377
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C0036377" ON "CONTRIBUTING_FACTORS" ("FACTOR_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C0036379
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C0036379" ON "DRIVER_BEHAVIORS" ("DRIVER_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C0036372
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C0036372" ON "LOCATION" ("LOCATION_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C0036378
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C0036378" ON "PEDESTRIANS" ("PEDESTRIANS_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C0036371
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C0036371" ON "VEHICLES" ("CASE_VEHICLE_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" ;

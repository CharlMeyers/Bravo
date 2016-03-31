DROP DATABASE People;

CREATE DATABASE People;

USE People;

CREATE TABLE Person (
	PersonID int Primary Key NOT NULL AUTO_INCREMENT,
	firstNames Varchar(30),
	surname Varchar(50),
	Emails Varchar(50),
	OrganizationID int,
	ResearchGroupID int,
	ResearchCategoryID int
);

CREATE TABLE Organization (
	OrganizationID int Primary Key NOT NULL AUTO_INCREMENT,
	names Varchar(50)
);

CREATE TABLE ResearchGroup (
	ResearchGroupID int Primary Key NOT NULL AUTO_INCREMENT,
	Name Varchar(50),
	StartDate Date,
	EndDate Date
);

CREATE TABLE ResearchCategory (
	ResearchCategoryID int Primary Key NOT NULL AUTO_INCREMENT,
	Name Varchar(50),
	EffectiveDate Date
);

Alter Table Person
ADD CONSTRAINT fk_OrganizationID FOREIGN KEY (OrganizationID)
REFERENCES Organization(OrganizationID);

Alter Table Person
ADD CONSTRAINT fk_ResearchGroupID FOREIGN KEY (ResearchGroupID)
REFERENCES ResearchGroup(ResearchGroupID);

Alter Table Person
ADD CONSTRAINT fk_ResearchCategoryID FOREIGN KEY (ResearchCategoryID)
REFERENCES ResearchCategory(ResearchCategoryID);

INSERT INTO Organization(names)
VALUES("Test Organization");

INSERT INTO ResearchCategory
(Name, EffectiveDate) VALUES('Test Research Category','2016-01-01');

INSERT INTO ResearchGroup
(Name, StartDate, EndDate)
VALUES('Test ResearchGroup Name','2016-01-01','2016-12-31');

INSERT INTO Person(firstNames,surname,Emails,OrganizationID,ResearchGroupID,ResearchCategoryID)
VALUES('Test Person', 'Test Surname','test@test.co.za',1,1,1);



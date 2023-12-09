CREATE DATABASE ufcd0787;

USE ufcd0787;

CREATE TABLE Persons (
	PersonID INT,
    FisrtName VARCHAR(255),
    LastName VARCHAR(255),
    Address VARCHAR(255),
    City VARCHAR(255)
);

CREATE TABLE Departamentos (
	Nome VARCHAR(255) NOT NULL,
    Num INT NOT NULL CHECK (NUM>0),
    GerentBi CHAR(9) DEFAULT "999999999",
    GerentData DATE
);
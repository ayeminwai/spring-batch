CREATE DATABASE TestDB;

GO

CREATE TABLE STOCK(
	ID INT ,
	CODE NVARCHAR(100),
	NAME NVARCHAR(100),
	QTY INT,
	PRICE [numeric](38, 10)
)
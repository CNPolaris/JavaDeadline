/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : localhost:3306
 Source Schema         : company

 Target Server Type    : SQL Server
 Target Server Version : 12000000
 File Encoding         : 65001

 Date: 27/04/2020 12:24:10
*/


-- ----------------------------
-- Table structure for chuku
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[company].[chuku]') AND type IN ('U'))
	DROP TABLE [company].[chuku]
GO

CREATE TABLE [chuku] (
  [lei] nvarchar(225) NULL,
  [name] nvarchar(225) NULL,
  [num] nvarchar(225) NULL,
  [price] nvarchar(225) NULL,
  [time] nvarchar(225) NULL,
  [danhao] nvarchar(225) NULL,
  [jingshouren] nvarchar(225) NULL,
  [operator] nvarchar(225) NULL
)
GO


-- ----------------------------
-- Records of chuku
-- ----------------------------
BEGIN TRANSACTION
GO

COMMIT
GO


-- ----------------------------
-- Table structure for employee
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[company].[employee]') AND type IN ('U'))
	DROP TABLE [company].[employee]
GO

CREATE TABLE [employee] (
  [Name] nvarchar(20) NOT NULL,
  [position] nvarchar(225) NULL,
  [tel] nvarchar(225) NULL,
  [addr] nvarchar(225) NULL,
  [school] nvarchar(225) NULL,
  [sex] nvarchar(225) NULL,
  [born] nvarchar(225) NULL,
  [time] nvarchar(225) NULL
)
GO


-- ----------------------------
-- Records of employee
-- ----------------------------
BEGIN TRANSACTION
GO

COMMIT
GO


-- ----------------------------
-- Table structure for fenlei
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[company].[fenlei]') AND type IN ('U'))
	DROP TABLE [company].[fenlei]
GO

CREATE TABLE [fenlei] (
  [lei] nvarchar(225) NULL
)
GO


-- ----------------------------
-- Records of fenlei
-- ----------------------------
BEGIN TRANSACTION
GO

COMMIT
GO


-- ----------------------------
-- Table structure for goods
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[company].[goods]') AND type IN ('U'))
	DROP TABLE [company].[goods]
GO

CREATE TABLE [goods] (
  [lei] nvarchar(225) NOT NULL,
  [name] nvarchar(225) NOT NULL,
  [num] nvarchar(225) NULL
)
GO


-- ----------------------------
-- Records of goods
-- ----------------------------
BEGIN TRANSACTION
GO

COMMIT
GO


-- ----------------------------
-- Table structure for kucun
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[company].[kucun]') AND type IN ('U'))
	DROP TABLE [company].[kucun]
GO

CREATE TABLE [kucun] (
  [num] nvarchar(255) NULL,
  [price] nvarchar(255) NULL,
  [endtime] nvarchar(225) NULL,
  [danhao] nvarchar(225) NULL,
  [time] nvarchar(225) NULL,
  [caigouhao] nvarchar(225) NULL,
  [jingshouren] nvarchar(225) NULL,
  [operator] nvarchar(225) NULL,
  [lei] nvarchar(225) NULL,
  [name] nvarchar(225) NULL
)
GO


-- ----------------------------
-- Records of kucun
-- ----------------------------
BEGIN TRANSACTION
GO

COMMIT
GO


-- ----------------------------
-- Table structure for news
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[company].[news]') AND type IN ('U'))
	DROP TABLE [company].[news]
GO

CREATE TABLE [news] (
  [news] nvarchar(225) NULL,
  [limite] nvarchar(225) NULL,
  [time] nvarchar(225) NULL
)
GO


-- ----------------------------
-- Records of news
-- ----------------------------
BEGIN TRANSACTION
GO

INSERT INTO [company].[news] VALUES (N'管理员abc登入系统', N'管理员', N'2015-12-15 15:38:19')
GO

COMMIT
GO


-- ----------------------------
-- Table structure for ruku_mounth
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[company].[ruku_mounth]') AND type IN ('U'))
	DROP TABLE [company].[ruku_mounth]
GO

CREATE TABLE [ruku_mounth] (
  [money] nvarchar(225) NULL,
  [time] nvarchar(225) NULL
)
GO


-- ----------------------------
-- Records of ruku_mounth
-- ----------------------------
BEGIN TRANSACTION
GO

COMMIT
GO


-- ----------------------------
-- Table structure for sponsor
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[company].[sponsor]') AND type IN ('U'))
	DROP TABLE [company].[sponsor]
GO

CREATE TABLE [sponsor] (
  [lei] nvarchar(225) NOT NULL,
  [name] nvarchar(225) NOT NULL,
  [tel] nvarchar(225) NOT NULL
)
GO


-- ----------------------------
-- Records of sponsor
-- ----------------------------
BEGIN TRANSACTION
GO

COMMIT
GO


-- ----------------------------
-- Table structure for users
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[company].[users]') AND type IN ('U'))
	DROP TABLE [company].[users]
GO

CREATE TABLE [users] (
  [name] nvarchar(225) NOT NULL,
  [password] nvarchar(225) NULL,
  [limite] nvarchar(225) NULL
)
GO


-- ----------------------------
-- Records of users
-- ----------------------------
BEGIN TRANSACTION
GO

INSERT INTO [company].[users] VALUES (N'abc', N'123456', N'管理员')
GO

COMMIT
GO


-- ----------------------------
-- Table structure for xiaoshou_day
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[company].[xiaoshou_day]') AND type IN ('U'))
	DROP TABLE [company].[xiaoshou_day]
GO

CREATE TABLE [xiaoshou_day] (
  [lei] nvarchar(225) NULL,
  [name] nvarchar(225) NULL,
  [money] nvarchar(225) NULL,
  [time] nvarchar(225) NULL
)
GO


-- ----------------------------
-- Records of xiaoshou_day
-- ----------------------------
BEGIN TRANSACTION
GO

COMMIT
GO


-- ----------------------------
-- Table structure for xiaoshou_mounth
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[company].[xiaoshou_mounth]') AND type IN ('U'))
	DROP TABLE [company].[xiaoshou_mounth]
GO

CREATE TABLE [xiaoshou_mounth] (
  [money] nvarchar(225) NULL,
  [time] nvarchar(225) NULL
)
GO


-- ----------------------------
-- Records of xiaoshou_mounth
-- ----------------------------
BEGIN TRANSACTION
GO

COMMIT
GO


-- ----------------------------
-- Primary Key structure for table employee
-- ----------------------------
ALTER TABLE [employee] ADD PRIMARY KEY CLUSTERED ([Name])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)
GO


-- ----------------------------
-- Primary Key structure for table goods
-- ----------------------------
ALTER TABLE [goods] ADD PRIMARY KEY CLUSTERED ([lei], [name])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)
GO


-- ----------------------------
-- Primary Key structure for table sponsor
-- ----------------------------
ALTER TABLE [sponsor] ADD PRIMARY KEY CLUSTERED ([lei], [name], [tel])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)
GO


-- ----------------------------
-- Primary Key structure for table users
-- ----------------------------
ALTER TABLE [users] ADD PRIMARY KEY CLUSTERED ([name])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)
GO


USE [master]
GO
/****** Object:  Database [StoreAssignment]    Script Date: 11/05/2021 10:41:37 ******/
CREATE DATABASE [StoreAssignment] ON  PRIMARY 
( NAME = N'StoreAssignment', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL10_50.SQLEXPRESS\MSSQL\DATA\StoreAssignment.mdf' , SIZE = 60672KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'StoreAssignment_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL10_50.SQLEXPRESS\MSSQL\DATA\StoreAssignment_log.LDF' , SIZE = 16576KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [StoreAssignment] SET COMPATIBILITY_LEVEL = 100
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [StoreAssignment].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [StoreAssignment] SET ANSI_NULL_DEFAULT OFF
GO
ALTER DATABASE [StoreAssignment] SET ANSI_NULLS OFF
GO
ALTER DATABASE [StoreAssignment] SET ANSI_PADDING OFF
GO
ALTER DATABASE [StoreAssignment] SET ANSI_WARNINGS OFF
GO
ALTER DATABASE [StoreAssignment] SET ARITHABORT OFF
GO
ALTER DATABASE [StoreAssignment] SET AUTO_CLOSE ON
GO
ALTER DATABASE [StoreAssignment] SET AUTO_CREATE_STATISTICS ON
GO
ALTER DATABASE [StoreAssignment] SET AUTO_SHRINK OFF
GO
ALTER DATABASE [StoreAssignment] SET AUTO_UPDATE_STATISTICS ON
GO
ALTER DATABASE [StoreAssignment] SET CURSOR_CLOSE_ON_COMMIT OFF
GO
ALTER DATABASE [StoreAssignment] SET CURSOR_DEFAULT  GLOBAL
GO
ALTER DATABASE [StoreAssignment] SET CONCAT_NULL_YIELDS_NULL OFF
GO
ALTER DATABASE [StoreAssignment] SET NUMERIC_ROUNDABORT OFF
GO
ALTER DATABASE [StoreAssignment] SET QUOTED_IDENTIFIER OFF
GO
ALTER DATABASE [StoreAssignment] SET RECURSIVE_TRIGGERS OFF
GO
ALTER DATABASE [StoreAssignment] SET  ENABLE_BROKER
GO
ALTER DATABASE [StoreAssignment] SET AUTO_UPDATE_STATISTICS_ASYNC OFF
GO
ALTER DATABASE [StoreAssignment] SET DATE_CORRELATION_OPTIMIZATION OFF
GO
ALTER DATABASE [StoreAssignment] SET TRUSTWORTHY OFF
GO
ALTER DATABASE [StoreAssignment] SET ALLOW_SNAPSHOT_ISOLATION OFF
GO
ALTER DATABASE [StoreAssignment] SET PARAMETERIZATION SIMPLE
GO
ALTER DATABASE [StoreAssignment] SET READ_COMMITTED_SNAPSHOT OFF
GO
ALTER DATABASE [StoreAssignment] SET HONOR_BROKER_PRIORITY OFF
GO
ALTER DATABASE [StoreAssignment] SET  READ_WRITE
GO
ALTER DATABASE [StoreAssignment] SET RECOVERY SIMPLE
GO
ALTER DATABASE [StoreAssignment] SET  MULTI_USER
GO
ALTER DATABASE [StoreAssignment] SET PAGE_VERIFY CHECKSUM
GO
ALTER DATABASE [StoreAssignment] SET DB_CHAINING OFF
GO
USE [StoreAssignment]
GO
/****** Object:  Table [dbo].[Material]    Script Date: 11/05/2021 10:41:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Material](
	[MaterialID] [int] IDENTITY(1,1) NOT NULL,
	[MaterialName] [nvarchar](255) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaterialID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Material] ON
INSERT [dbo].[Material] ([MaterialID], [MaterialName]) VALUES (1, N'Dây 86')
INSERT [dbo].[Material] ([MaterialID], [MaterialName]) VALUES (2, N'Dây 72')
SET IDENTITY_INSERT [dbo].[Material] OFF
/****** Object:  Table [dbo].[CustomerAccount]    Script Date: 11/05/2021 10:41:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CustomerAccount](
	[Username] [nvarchar](50) NOT NULL,
	[Password] [nvarchar](50) NOT NULL,
	[ROLE] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[Username] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[CustomerAccount] ([Username], [Password], [ROLE]) VALUES (N'admin', N'123', N'Admin')
INSERT [dbo].[CustomerAccount] ([Username], [Password], [ROLE]) VALUES (N'user', N'123', N'Customer')
INSERT [dbo].[CustomerAccount] ([Username], [Password], [ROLE]) VALUES (N'user1', N'123', N'Customer')
INSERT [dbo].[CustomerAccount] ([Username], [Password], [ROLE]) VALUES (N'user2', N'123', N'Customer')
/****** Object:  Table [dbo].[Category]    Script Date: 11/05/2021 10:41:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Category](
	[CategoryID] [int] IDENTITY(1,1) NOT NULL,
	[CategoryName] [nvarchar](255) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[CategoryID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Category] ON
INSERT [dbo].[Category] ([CategoryID], [CategoryName]) VALUES (1, N'Xe ga')
INSERT [dbo].[Category] ([CategoryID], [CategoryName]) VALUES (2, N'Xe số')
SET IDENTITY_INSERT [dbo].[Category] OFF
/****** Object:  Table [dbo].[Brand]    Script Date: 11/05/2021 10:41:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Brand](
	[BrandID] [int] IDENTITY(1,1) NOT NULL,
	[BrandName] [nvarchar](255) NOT NULL,
	[CategoryID] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[BrandID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Brand] ON
INSERT [dbo].[Brand] ([BrandID], [BrandName], [CategoryID]) VALUES (1, N'Airblade', 1)
INSERT [dbo].[Brand] ([BrandID], [BrandName], [CategoryID]) VALUES (2, N'Elegant', 2)
INSERT [dbo].[Brand] ([BrandID], [BrandName], [CategoryID]) VALUES (3, N'Blade', 2)
INSERT [dbo].[Brand] ([BrandID], [BrandName], [CategoryID]) VALUES (4, N'Wave alpha', 2)
INSERT [dbo].[Brand] ([BrandID], [BrandName], [CategoryID]) VALUES (5, N'Wave RSX', 2)
INSERT [dbo].[Brand] ([BrandID], [BrandName], [CategoryID]) VALUES (6, N'Future', 2)
INSERT [dbo].[Brand] ([BrandID], [BrandName], [CategoryID]) VALUES (7, N'Winner', 2)
INSERT [dbo].[Brand] ([BrandID], [BrandName], [CategoryID]) VALUES (8, N'Dream', 2)
INSERT [dbo].[Brand] ([BrandID], [BrandName], [CategoryID]) VALUES (9, N'Sirius', 2)
SET IDENTITY_INSERT [dbo].[Brand] OFF
/****** Object:  Table [dbo].[Product]    Script Date: 11/05/2021 10:41:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Product](
	[ProductID] [int] IDENTITY(1,1) NOT NULL,
	[ProductName] [nvarchar](255) NOT NULL,
	[Description] [nvarchar](1000) NULL,
	[BrandID] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[ProductID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Product] ON
INSERT [dbo].[Product] ([ProductID], [ProductName], [Description], [BrandID]) VALUES (19, N'Võng xe Airblade', N'Sản phẩm hot bán chạy nhất của cửa hàng, với độ bền cao, bóng loáng, tiện lợi trong việc treo đồ. Dòng dây 72 đem lại sự nhẹ nhàng bóng loáng, trong khi dòng 86 đem đến sự chắc chắn cứng cáp.', 1)
INSERT [dbo].[Product] ([ProductID], [ProductName], [Description], [BrandID]) VALUES (22, N'Võng xe Wave alpha', N'Dòng xe phổ biến tại thị trường việt nam, việc trang bị 1 chiếc gác ba ga đem lại nhiều lợi ích cho chiếc xe của bạn. Đặc biệt dòng dây 86 hoàn toàn mới giúp xe tránh va đập tốt hơn', 4)
INSERT [dbo].[Product] ([ProductID], [ProductName], [Description], [BrandID]) VALUES (23, N'Võng xe RSX', N'Tương tự dòng xe Alpha, RSX cũng là dòng xe phổ biến tại thị trường Việt Nam. Việc trang bị 1 chiếc võng cho xe của bạn là hoàn toàn cần thiết', 5)
INSERT [dbo].[Product] ([ProductID], [ProductName], [Description], [BrandID]) VALUES (24, N'Võng xe Elegant', N'Dòng xe mới tại thị trường Việt Nam, các sản phẩm võng xe cũng vô cùng đa dạng và đẹp', 2)
INSERT [dbo].[Product] ([ProductID], [ProductName], [Description], [BrandID]) VALUES (25, N'Võng xe Airblae loại không chữ', N'Khác với loại có chữ, loại không chữ mang đến cảm giác thanh lịch nhẹ nhàng, phù hợp với các dòng airblade đời cũ', 1)
INSERT [dbo].[Product] ([ProductID], [ProductName], [Description], [BrandID]) VALUES (26, N'Võng xe Winner', N'Dòng xe côn nổi bật trong giới trẻ, với thiết kế trẻ trung, đeo thêm võng sẽ tăng vẻ đẹp cho xe', 7)
INSERT [dbo].[Product] ([ProductID], [ProductName], [Description], [BrandID]) VALUES (27, N'Vòng chắn Dream', N'Dòng sản phẩm giá rẻ giúp bạn chắn va đập phần chống xe Dream, giúp xe bạn thêm cứng cáp', 8)
INSERT [dbo].[Product] ([ProductID], [ProductName], [Description], [BrandID]) VALUES (28, N'Võng xe Future', N'Dòng xe giá rẻ tại thị trường Việt nam, việc trang bị võng giúp xe bạn thêm chắc chắn, bền đẹp', 6)
INSERT [dbo].[Product] ([ProductID], [ProductName], [Description], [BrandID]) VALUES (29, N'Võng xe blade', N'Dòng xe số ổn định tại thị trường Việt Nam, dù không quá nổi trội. Trang bị võng sẽ giúp xe bạn có nhiều tiện ích hơn và bền vững hơn', 3)
INSERT [dbo].[Product] ([ProductID], [ProductName], [Description], [BrandID]) VALUES (31, N'Võng xe Dream', N'Dòng xe phổ cập tại Việt Nam, bền bỉ theo năm tháng, trang bị võng giúp xe bền đẹp hơn', 8)
INSERT [dbo].[Product] ([ProductID], [ProductName], [Description], [BrandID]) VALUES (32, N'Võng xe Sirius', N'Tương tự dòng xe Alpha, Sirius cũng là dòng xe phổ biến tại thị trường Việt Nam. Việc trang bị 1 chiếc võng cho xe của bạn là hoàn toàn cần thiết', 9)
SET IDENTITY_INSERT [dbo].[Product] OFF
/****** Object:  Table [dbo].[ProductWithMaterial]    Script Date: 11/05/2021 10:41:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ProductWithMaterial](
	[ProductWithMaterialID] [int] IDENTITY(1,1) NOT NULL,
	[ProductID] [int] NULL,
	[ProductPrice] [money] NULL,
	[MaterialID] [int] NULL,
	[ImageProduct] [varchar](200) NULL,
PRIMARY KEY CLUSTERED 
(
	[ProductWithMaterialID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[ProductWithMaterial] ON
INSERT [dbo].[ProductWithMaterial] ([ProductWithMaterialID], [ProductID], [ProductPrice], [MaterialID], [ImageProduct]) VALUES (21, 19, 65000.0000, 2, N'C:\Users\Admin\Documents\Assignment_PRJ\Assignment_PRJ\web\assets\img\store\vongABloai72.JPG')
INSERT [dbo].[ProductWithMaterial] ([ProductWithMaterialID], [ProductID], [ProductPrice], [MaterialID], [ImageProduct]) VALUES (23, 19, 70000.0000, 1, N'C:\Users\Admin\Documents\Assignment_PRJ\Assignment_PRJ\web\assets\img\store\VongABloai86.JPG')
INSERT [dbo].[ProductWithMaterial] ([ProductWithMaterialID], [ProductID], [ProductPrice], [MaterialID], [ImageProduct]) VALUES (24, 22, 30000.0000, 2, N'C:\Users\Admin\Documents\Assignment_PRJ\Assignment_PRJ\web\assets\img\store\vongAlpha72.JPG')
INSERT [dbo].[ProductWithMaterial] ([ProductWithMaterialID], [ProductID], [ProductPrice], [MaterialID], [ImageProduct]) VALUES (25, 22, 45000.0000, 1, N'C:\Users\Admin\Documents\Assignment_PRJ\Assignment_PRJ\web\assets\img\store\vongAlpha86.JPG')
INSERT [dbo].[ProductWithMaterial] ([ProductWithMaterialID], [ProductID], [ProductPrice], [MaterialID], [ImageProduct]) VALUES (26, 23, 30000.0000, 2, N'C:\Users\Admin\Documents\Assignment_PRJ\Assignment_PRJ\web\assets\img\store\vongAlpha72.JPG')
INSERT [dbo].[ProductWithMaterial] ([ProductWithMaterialID], [ProductID], [ProductPrice], [MaterialID], [ImageProduct]) VALUES (27, 23, 45000.0000, 1, N'C:\Users\Admin\Documents\Assignment_PRJ\Assignment_PRJ\web\assets\img\store\vongAlpha86.JPG')
INSERT [dbo].[ProductWithMaterial] ([ProductWithMaterialID], [ProductID], [ProductPrice], [MaterialID], [ImageProduct]) VALUES (28, 24, 47000.0000, 1, N'C:\Users\Admin\Documents\Assignment_PRJ\Assignment_PRJ\web\assets\img\store\vongElegpant86.JPG')
INSERT [dbo].[ProductWithMaterial] ([ProductWithMaterialID], [ProductID], [ProductPrice], [MaterialID], [ImageProduct]) VALUES (29, 25, 71000.0000, 2, N'C:\Users\Admin\Documents\Assignment_PRJ\Assignment_PRJ\web\assets\img\store\vongAbkochu72.JPG')
INSERT [dbo].[ProductWithMaterial] ([ProductWithMaterialID], [ProductID], [ProductPrice], [MaterialID], [ImageProduct]) VALUES (30, 25, 75000.0000, 1, N'C:\Users\Admin\Documents\Assignment_PRJ\Assignment_PRJ\web\assets\img\store\vongAbkochu86.JPG')
INSERT [dbo].[ProductWithMaterial] ([ProductWithMaterialID], [ProductID], [ProductPrice], [MaterialID], [ImageProduct]) VALUES (31, 26, 50000.0000, 1, N'C:\Users\Admin\Documents\Assignment_PRJ\Assignment_PRJ\web\assets\img\store\vongWinner86.JPG')
INSERT [dbo].[ProductWithMaterial] ([ProductWithMaterialID], [ProductID], [ProductPrice], [MaterialID], [ImageProduct]) VALUES (32, 27, 20000.0000, 2, N'C:\Users\Admin\Documents\Assignment_PRJ\Assignment_PRJ\web\assets\img\store\VongDream72.JPG')
INSERT [dbo].[ProductWithMaterial] ([ProductWithMaterialID], [ProductID], [ProductPrice], [MaterialID], [ImageProduct]) VALUES (33, 27, 25000.0000, 1, N'C:\Users\Admin\Documents\Assignment_PRJ\Assignment_PRJ\web\assets\img\store\VongDream86.JPG')
INSERT [dbo].[ProductWithMaterial] ([ProductWithMaterialID], [ProductID], [ProductPrice], [MaterialID], [ImageProduct]) VALUES (34, 28, 31000.0000, 1, N'C:\Users\Admin\Documents\Assignment_PRJ\Assignment_PRJ\web\assets\img\store\VongFuture86.jpg')
INSERT [dbo].[ProductWithMaterial] ([ProductWithMaterialID], [ProductID], [ProductPrice], [MaterialID], [ImageProduct]) VALUES (35, 29, 27000.0000, 1, N'C:\Users\Admin\Documents\Assignment_PRJ\Assignment_PRJ\web\assets\img\store\VongFuture86.jpg')
INSERT [dbo].[ProductWithMaterial] ([ProductWithMaterialID], [ProductID], [ProductPrice], [MaterialID], [ImageProduct]) VALUES (38, 31, 23000.0000, 2, N'C:\Users\Admin\Documents\Assignment_PRJ\temp\vongAlpha72.JPG')
INSERT [dbo].[ProductWithMaterial] ([ProductWithMaterialID], [ProductID], [ProductPrice], [MaterialID], [ImageProduct]) VALUES (39, 32, 24000.0000, 2, N'C:\Users\Admin\Documents\Assignment_PRJ\temp\vongAlpha72.JPG')
INSERT [dbo].[ProductWithMaterial] ([ProductWithMaterialID], [ProductID], [ProductPrice], [MaterialID], [ImageProduct]) VALUES (40, 32, 28000.0000, 1, N'C:\Users\Admin\Documents\Assignment_PRJ\temp\vongAlpha86.JPG')
SET IDENTITY_INSERT [dbo].[ProductWithMaterial] OFF
/****** Object:  Table [dbo].[HistoryBuy]    Script Date: 11/05/2021 10:41:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HistoryBuy](
	[Username] [nvarchar](50) NOT NULL,
	[ProductWithMaterialID] [int] NOT NULL,
	[DateBuy] [datetime] NOT NULL,
	[Quantity] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Username] ASC,
	[ProductWithMaterialID] ASC,
	[DateBuy] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[HistoryBuy] ([Username], [ProductWithMaterialID], [DateBuy], [Quantity]) VALUES (N'user', 21, CAST(0x0000ADD60141FAFD AS DateTime), 5)
INSERT [dbo].[HistoryBuy] ([Username], [ProductWithMaterialID], [DateBuy], [Quantity]) VALUES (N'user', 26, CAST(0x0000ADD60141FB03 AS DateTime), 3)
INSERT [dbo].[HistoryBuy] ([Username], [ProductWithMaterialID], [DateBuy], [Quantity]) VALUES (N'user', 30, CAST(0x0000ADD601689B22 AS DateTime), 5)
INSERT [dbo].[HistoryBuy] ([Username], [ProductWithMaterialID], [DateBuy], [Quantity]) VALUES (N'user', 33, CAST(0x0000ADD601689B2C AS DateTime), 5)
INSERT [dbo].[HistoryBuy] ([Username], [ProductWithMaterialID], [DateBuy], [Quantity]) VALUES (N'user', 34, CAST(0x0000ADD60141FB03 AS DateTime), 2)
INSERT [dbo].[HistoryBuy] ([Username], [ProductWithMaterialID], [DateBuy], [Quantity]) VALUES (N'user1', 21, CAST(0x0000ADD6014271ED AS DateTime), 6)
INSERT [dbo].[HistoryBuy] ([Username], [ProductWithMaterialID], [DateBuy], [Quantity]) VALUES (N'user1', 23, CAST(0x0000ADD6014271ED AS DateTime), 9)
INSERT [dbo].[HistoryBuy] ([Username], [ProductWithMaterialID], [DateBuy], [Quantity]) VALUES (N'user1', 24, CAST(0x0000ADD6014271EC AS DateTime), 5)
INSERT [dbo].[HistoryBuy] ([Username], [ProductWithMaterialID], [DateBuy], [Quantity]) VALUES (N'user2', 21, CAST(0x0000ADD601431442 AS DateTime), 3)
INSERT [dbo].[HistoryBuy] ([Username], [ProductWithMaterialID], [DateBuy], [Quantity]) VALUES (N'user2', 21, CAST(0x0000ADD6016597E9 AS DateTime), 8)
INSERT [dbo].[HistoryBuy] ([Username], [ProductWithMaterialID], [DateBuy], [Quantity]) VALUES (N'user2', 24, CAST(0x0000ADD6016597FD AS DateTime), 3)
INSERT [dbo].[HistoryBuy] ([Username], [ProductWithMaterialID], [DateBuy], [Quantity]) VALUES (N'user2', 27, CAST(0x0000ADD601431444 AS DateTime), 4)
INSERT [dbo].[HistoryBuy] ([Username], [ProductWithMaterialID], [DateBuy], [Quantity]) VALUES (N'user2', 31, CAST(0x0000ADD601431444 AS DateTime), 4)
/****** Object:  ForeignKey [fkbrand]    Script Date: 11/05/2021 10:41:38 ******/
ALTER TABLE [dbo].[Brand]  WITH CHECK ADD  CONSTRAINT [fkbrand] FOREIGN KEY([CategoryID])
REFERENCES [dbo].[Category] ([CategoryID])
GO
ALTER TABLE [dbo].[Brand] CHECK CONSTRAINT [fkbrand]
GO
/****** Object:  ForeignKey [FK__Product__BrandID__0CBAE877]    Script Date: 11/05/2021 10:41:38 ******/
ALTER TABLE [dbo].[Product]  WITH CHECK ADD FOREIGN KEY([BrandID])
REFERENCES [dbo].[Brand] ([BrandID])
GO
/****** Object:  ForeignKey [FK__ProductWi__Mater__1367E606]    Script Date: 11/05/2021 10:41:38 ******/
ALTER TABLE [dbo].[ProductWithMaterial]  WITH CHECK ADD FOREIGN KEY([MaterialID])
REFERENCES [dbo].[Material] ([MaterialID])
GO
/****** Object:  ForeignKey [FK__ProductWi__Produ__1273C1CD]    Script Date: 11/05/2021 10:41:38 ******/
ALTER TABLE [dbo].[ProductWithMaterial]  WITH CHECK ADD FOREIGN KEY([ProductID])
REFERENCES [dbo].[Product] ([ProductID])
GO
/****** Object:  ForeignKey [FK__HistoryBu__Produ__3F466844]    Script Date: 11/05/2021 10:41:38 ******/
ALTER TABLE [dbo].[HistoryBuy]  WITH CHECK ADD FOREIGN KEY([ProductWithMaterialID])
REFERENCES [dbo].[ProductWithMaterial] ([ProductWithMaterialID])
GO
/****** Object:  ForeignKey [FK__HistoryBu__Usern__3E52440B]    Script Date: 11/05/2021 10:41:38 ******/
ALTER TABLE [dbo].[HistoryBuy]  WITH CHECK ADD FOREIGN KEY([Username])
REFERENCES [dbo].[CustomerAccount] ([Username])
GO

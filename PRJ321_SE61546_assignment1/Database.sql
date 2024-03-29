USE [master]
GO
/****** Object:  Database [PRJ321_Assignment]    Script Date: 09/26/2015 22:26:09 ******/
CREATE DATABASE [PRJ321_Assignment] ON  PRIMARY 
( NAME = N'PRJ321_Assignment', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL10_50.SQL2008\MSSQL\DATA\PRJ321_Assignment.mdf' , SIZE = 2048KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'PRJ321_Assignment_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL10_50.SQL2008\MSSQL\DATA\PRJ321_Assignment_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [PRJ321_Assignment] SET COMPATIBILITY_LEVEL = 100
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [PRJ321_Assignment].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [PRJ321_Assignment] SET ANSI_NULL_DEFAULT OFF
GO
ALTER DATABASE [PRJ321_Assignment] SET ANSI_NULLS OFF
GO
ALTER DATABASE [PRJ321_Assignment] SET ANSI_PADDING OFF
GO
ALTER DATABASE [PRJ321_Assignment] SET ANSI_WARNINGS OFF
GO
ALTER DATABASE [PRJ321_Assignment] SET ARITHABORT OFF
GO
ALTER DATABASE [PRJ321_Assignment] SET AUTO_CLOSE OFF
GO
ALTER DATABASE [PRJ321_Assignment] SET AUTO_CREATE_STATISTICS ON
GO
ALTER DATABASE [PRJ321_Assignment] SET AUTO_SHRINK OFF
GO
ALTER DATABASE [PRJ321_Assignment] SET AUTO_UPDATE_STATISTICS ON
GO
ALTER DATABASE [PRJ321_Assignment] SET CURSOR_CLOSE_ON_COMMIT OFF
GO
ALTER DATABASE [PRJ321_Assignment] SET CURSOR_DEFAULT  GLOBAL
GO
ALTER DATABASE [PRJ321_Assignment] SET CONCAT_NULL_YIELDS_NULL OFF
GO
ALTER DATABASE [PRJ321_Assignment] SET NUMERIC_ROUNDABORT OFF
GO
ALTER DATABASE [PRJ321_Assignment] SET QUOTED_IDENTIFIER OFF
GO
ALTER DATABASE [PRJ321_Assignment] SET RECURSIVE_TRIGGERS OFF
GO
ALTER DATABASE [PRJ321_Assignment] SET  DISABLE_BROKER
GO
ALTER DATABASE [PRJ321_Assignment] SET AUTO_UPDATE_STATISTICS_ASYNC OFF
GO
ALTER DATABASE [PRJ321_Assignment] SET DATE_CORRELATION_OPTIMIZATION OFF
GO
ALTER DATABASE [PRJ321_Assignment] SET TRUSTWORTHY OFF
GO
ALTER DATABASE [PRJ321_Assignment] SET ALLOW_SNAPSHOT_ISOLATION OFF
GO
ALTER DATABASE [PRJ321_Assignment] SET PARAMETERIZATION SIMPLE
GO
ALTER DATABASE [PRJ321_Assignment] SET READ_COMMITTED_SNAPSHOT OFF
GO
ALTER DATABASE [PRJ321_Assignment] SET HONOR_BROKER_PRIORITY OFF
GO
ALTER DATABASE [PRJ321_Assignment] SET  READ_WRITE
GO
ALTER DATABASE [PRJ321_Assignment] SET RECOVERY FULL
GO
ALTER DATABASE [PRJ321_Assignment] SET  MULTI_USER
GO
ALTER DATABASE [PRJ321_Assignment] SET PAGE_VERIFY CHECKSUM
GO
ALTER DATABASE [PRJ321_Assignment] SET DB_CHAINING OFF
GO
EXEC sys.sp_db_vardecimal_storage_format N'PRJ321_Assignment', N'ON'
GO
USE [PRJ321_Assignment]
GO
/****** Object:  Table [dbo].[tbl_product]    Script Date: 09/26/2015 22:26:11 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tbl_product](
	[productID] [varchar](10) NOT NULL,
	[productName] [varchar](50) NOT NULL,
	[price] [float] NOT NULL,
	[quantity] [int] NOT NULL,
 CONSTRAINT [PK_tbl_product] PRIMARY KEY CLUSTERED 
(
	[productID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[tbl_product] ([productID], [productName], [price], [quantity]) VALUES (N'aqua', N'Aquafina', 0.75, 9)
INSERT [dbo].[tbl_product] ([productID], [productName], [price], [quantity]) VALUES (N'coca', N'Coca-Cola', 2.5, 260)
INSERT [dbo].[tbl_product] ([productID], [productName], [price], [quantity]) VALUES (N'mirinda', N'Mirinda', 1.75, 3)
INSERT [dbo].[tbl_product] ([productID], [productName], [price], [quantity]) VALUES (N'note1', N'Vinh Tien Notebook', 0.37, 105)
INSERT [dbo].[tbl_product] ([productID], [productName], [price], [quantity]) VALUES (N'note2', N'Fahasa Notebook', 0.47, 7)
INSERT [dbo].[tbl_product] ([productID], [productName], [price], [quantity]) VALUES (N'pepsi', N'Pepsi Cola', 2.4, 268)
/****** Object:  Table [dbo].[tbl_account]    Script Date: 09/26/2015 22:26:11 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tbl_account](
	[accountID] [varchar](10) NOT NULL,
	[customerName] [varchar](50) NOT NULL,
	[password] [varchar](20) NOT NULL,
	[email] [varchar](50) NOT NULL,
 CONSTRAINT [PK_tbl_account] PRIMARY KEY CLUSTERED 
(
	[accountID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY],
 CONSTRAINT [Unique_tbl_account] UNIQUE NONCLUSTERED 
(
	[email] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[tbl_account] ([accountID], [customerName], [password], [email]) VALUES (N'a', N'', N'', N'')
INSERT [dbo].[tbl_account] ([accountID], [customerName], [password], [email]) VALUES (N'conghau', N'Nguyen Viet Cong Hau', N'123456', N'hau@fpt.edu.vn')
INSERT [dbo].[tbl_account] ([accountID], [customerName], [password], [email]) VALUES (N'duy', N'Nguyen Van Duy', N'123456', N'duy@fpt.edu.vn')
INSERT [dbo].[tbl_account] ([accountID], [customerName], [password], [email]) VALUES (N'hao', N'Tran Van Hao', N'123456', N'hao@fpt.edu.vn')
INSERT [dbo].[tbl_account] ([accountID], [customerName], [password], [email]) VALUES (N'hoangtung', N'Hoang Trong Thanh Tung', N'123456', N'tung@fpt.edu.vn')
INSERT [dbo].[tbl_account] ([accountID], [customerName], [password], [email]) VALUES (N'testSign', N'Test', N'123456', N'test@test.com')
INSERT [dbo].[tbl_account] ([accountID], [customerName], [password], [email]) VALUES (N'testSign2', N'testSign2', N'123456', N'test@test.com.vn')
INSERT [dbo].[tbl_account] ([accountID], [customerName], [password], [email]) VALUES (N'van', N'Ha Thi Van', N'123456', N'van@fpt.edu.vn')
/****** Object:  Table [dbo].[tbl_order]    Script Date: 09/26/2015 22:26:11 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tbl_order](
	[orderID] [varchar](10) NOT NULL,
	[orderDate] [datetime] NOT NULL,
	[customerID] [varchar](10) NOT NULL,
	[total] [float] NOT NULL,
	[address] [varchar](250) NOT NULL,
	[phone] [varchar](11) NOT NULL,
 CONSTRAINT [PK_tbl_order] PRIMARY KEY CLUSTERED 
(
	[orderID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[tbl_order] ([orderID], [orderDate], [customerID], [total], [address], [phone]) VALUES (N'aaaeeee', CAST(0x0000A51B00000000 AS DateTime), N'conghau', 45.200000762939453, N'123 Hanoi', N'09839889798')
INSERT [dbo].[tbl_order] ([orderID], [orderDate], [customerID], [total], [address], [phone]) VALUES (N'aaxXxaa', CAST(0x0000A50700000000 AS DateTime), N'conghau', 7.4000000953674316, N'123 Saigon', N'09844444444')
INSERT [dbo].[tbl_order] ([orderID], [orderDate], [customerID], [total], [address], [phone]) VALUES (N'aidafdae', CAST(0x0000A51B00000000 AS DateTime), N'hoangtung', 6.8499999046325684, N'13 Tan Binh', N'08855333113')
INSERT [dbo].[tbl_order] ([orderID], [orderDate], [customerID], [total], [address], [phone]) VALUES (N'fas5465', CAST(0x0000A51F00000000 AS DateTime), N'conghau', 0, N'135 Sai Gon', N'09317546544')
INSERT [dbo].[tbl_order] ([orderID], [orderDate], [customerID], [total], [address], [phone]) VALUES (N'iiiaaaade', CAST(0x0000A51B00000000 AS DateTime), N'conghau', 0, N'1234 Saigon', N'08995757577')
INSERT [dbo].[tbl_order] ([orderID], [orderDate], [customerID], [total], [address], [phone]) VALUES (N'sfkjlkjaf', CAST(0x0000A4D600000000 AS DateTime), N'conghau', 18.8700008392334, N'156 Tan Binh', N'09858585533')
INSERT [dbo].[tbl_order] ([orderID], [orderDate], [customerID], [total], [address], [phone]) VALUES (N'skdfjlkee', CAST(0x0000A4FC00000000 AS DateTime), N'hoangtung', 96, N'144 Saigon', N'08858484848')
/****** Object:  Table [dbo].[tbl_orderDetail]    Script Date: 09/26/2015 22:26:11 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tbl_orderDetail](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[productID] [varchar](10) NOT NULL,
	[quantity] [int] NOT NULL,
	[unitPrice] [float] NULL,
	[unitItem] [varchar](10) NOT NULL,
	[total] [float] NULL,
	[orderID] [varchar](10) NOT NULL,
 CONSTRAINT [PK_tbl_orderDetail] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY],
 CONSTRAINT [Unique_tbl_orderDetail] UNIQUE NONCLUSTERED 
(
	[productID] ASC,
	[orderID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[tbl_orderDetail] ON
INSERT [dbo].[tbl_orderDetail] ([id], [productID], [quantity], [unitPrice], [unitItem], [total], [orderID]) VALUES (46, N'note1', 20, 0.37, N'cuon', 7.4000000953674316, N'aaxXxaa')
INSERT [dbo].[tbl_orderDetail] ([id], [productID], [quantity], [unitPrice], [unitItem], [total], [orderID]) VALUES (48, N'aqua', 6, 0.75, N'bottle', 4.5, N'aidafdae')
INSERT [dbo].[tbl_orderDetail] ([id], [productID], [quantity], [unitPrice], [unitItem], [total], [orderID]) VALUES (49, N'note2', 5, 0.47, N'cuon', 2.3499999046325684, N'aidafdae')
INSERT [dbo].[tbl_orderDetail] ([id], [productID], [quantity], [unitPrice], [unitItem], [total], [orderID]) VALUES (52, N'note1', 51, 0.37, N'cuon', 18.8700008392334, N'sfkjlkjaf')
INSERT [dbo].[tbl_orderDetail] ([id], [productID], [quantity], [unitPrice], [unitItem], [total], [orderID]) VALUES (54, N'aqua', 8, 0.75, N'bottle', 6, N'skdfjlkee')
INSERT [dbo].[tbl_orderDetail] ([id], [productID], [quantity], [unitPrice], [unitItem], [total], [orderID]) VALUES (55, N'coca', 10, 2.5, N'can', 25, N'skdfjlkee')
INSERT [dbo].[tbl_orderDetail] ([id], [productID], [quantity], [unitPrice], [unitItem], [total], [orderID]) VALUES (56, N'note1', 20, 0.37, N'cuon', 7.4, N'skdfjlkee')
INSERT [dbo].[tbl_orderDetail] ([id], [productID], [quantity], [unitPrice], [unitItem], [total], [orderID]) VALUES (58, N'pepsi', 24, 2.4, N'can', 57.599999999999994, N'skdfjlkee')
INSERT [dbo].[tbl_orderDetail] ([id], [productID], [quantity], [unitPrice], [unitItem], [total], [orderID]) VALUES (59, N'coca', 10, 2.5, N'can', 25, N'aaaeeee')
INSERT [dbo].[tbl_orderDetail] ([id], [productID], [quantity], [unitPrice], [unitItem], [total], [orderID]) VALUES (60, N'aqua', 6, 0.75, N'bottle', 4.5, N'aaaeeee')
INSERT [dbo].[tbl_orderDetail] ([id], [productID], [quantity], [unitPrice], [unitItem], [total], [orderID]) VALUES (62, N'pepsi', 5, 2.4, N'can', 12, N'aaaeeee')
INSERT [dbo].[tbl_orderDetail] ([id], [productID], [quantity], [unitPrice], [unitItem], [total], [orderID]) VALUES (63, N'note1', 10, 0.37, N'cuon', 3.7, N'aaaeeee')
SET IDENTITY_INSERT [dbo].[tbl_orderDetail] OFF
/****** Object:  ForeignKey [FK_tbl_order_tbl_account]    Script Date: 09/26/2015 22:26:11 ******/
ALTER TABLE [dbo].[tbl_order]  WITH CHECK ADD  CONSTRAINT [FK_tbl_order_tbl_account] FOREIGN KEY([customerID])
REFERENCES [dbo].[tbl_account] ([accountID])
GO
ALTER TABLE [dbo].[tbl_order] CHECK CONSTRAINT [FK_tbl_order_tbl_account]
GO
/****** Object:  ForeignKey [FK_tbl_orderDetail_tbl_order]    Script Date: 09/26/2015 22:26:11 ******/
ALTER TABLE [dbo].[tbl_orderDetail]  WITH CHECK ADD  CONSTRAINT [FK_tbl_orderDetail_tbl_order] FOREIGN KEY([orderID])
REFERENCES [dbo].[tbl_order] ([orderID])
GO
ALTER TABLE [dbo].[tbl_orderDetail] CHECK CONSTRAINT [FK_tbl_orderDetail_tbl_order]
GO
/****** Object:  ForeignKey [FK_tbl_orderDetail_tbl_product]    Script Date: 09/26/2015 22:26:11 ******/
ALTER TABLE [dbo].[tbl_orderDetail]  WITH CHECK ADD  CONSTRAINT [FK_tbl_orderDetail_tbl_product] FOREIGN KEY([productID])
REFERENCES [dbo].[tbl_product] ([productID])
GO
ALTER TABLE [dbo].[tbl_orderDetail] CHECK CONSTRAINT [FK_tbl_orderDetail_tbl_product]
GO

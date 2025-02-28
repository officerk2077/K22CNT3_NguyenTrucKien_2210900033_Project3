USE [master]
GO
/****** Object:  Database [ntk_QLBQ]    Script Date: 2/20/2025 4:15:37 PM ******/
CREATE DATABASE [ntk_QLBQ]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'ntk_QLBQ', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.MSSQLSERVER\MSSQL\DATA\ntk_QLBQ.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'ntk_QLBQ_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.MSSQLSERVER\MSSQL\DATA\ntk_QLBQ_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [ntk_QLBQ].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [ntk_QLBQ] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [ntk_QLBQ] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [ntk_QLBQ] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [ntk_QLBQ] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [ntk_QLBQ] SET ARITHABORT OFF 
GO
ALTER DATABASE [ntk_QLBQ] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [ntk_QLBQ] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [ntk_QLBQ] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [ntk_QLBQ] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [ntk_QLBQ] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [ntk_QLBQ] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [ntk_QLBQ] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [ntk_QLBQ] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [ntk_QLBQ] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [ntk_QLBQ] SET  ENABLE_BROKER 
GO
ALTER DATABASE [ntk_QLBQ] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [ntk_QLBQ] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [ntk_QLBQ] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [ntk_QLBQ] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [ntk_QLBQ] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [ntk_QLBQ] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [ntk_QLBQ] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [ntk_QLBQ] SET RECOVERY FULL 
GO
ALTER DATABASE [ntk_QLBQ] SET  MULTI_USER 
GO
ALTER DATABASE [ntk_QLBQ] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [ntk_QLBQ] SET DB_CHAINING OFF 
GO
ALTER DATABASE [ntk_QLBQ] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [ntk_QLBQ] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
EXEC sys.sp_db_vardecimal_storage_format N'ntk_QLBQ', N'ON'
GO
USE [ntk_QLBQ]
GO
/****** Object:  Table [dbo].[ntk_BaiViet]    Script Date: 2/20/2025 4:15:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ntk_BaiViet](
	[ntk_MaBaiViet] [int] IDENTITY(1,1) NOT NULL,
	[ntk_TieuDe] [nvarchar](255) NOT NULL,
	[ntk_NoDung] [text] NOT NULL,
	[ntk_MaQuanTriVien] [int] NULL,
	[ntk_NgayXuatBan] [date] NOT NULL,
	[ntk_TheLoai] [nvarchar](100) NULL,
	[ntk_HinhAnh] [nvarchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[ntk_MaBaiViet] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ntk_ChiTietBaiViet]    Script Date: 2/20/2025 4:15:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ntk_ChiTietBaiViet](
	[ntk_MaChiTietBaiViet] [int] IDENTITY(1,1) NOT NULL,
	[ntk_MaBaiViet] [int] NULL,
	[ntk_MaSach] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[ntk_MaChiTietBaiViet] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ntk_KhachHang]    Script Date: 2/20/2025 4:15:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ntk_KhachHang](
	[ntk_MaKhachHang] [int] IDENTITY(1,1) NOT NULL,
	[ntk_TenKhachHang] [nvarchar](100) NOT NULL,
	[ntk_Email] [nvarchar](100) NULL,
	[ntk_SoDienThoai] [nvarchar](15) NULL,
PRIMARY KEY CLUSTERED 
(
	[ntk_MaKhachHang] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ntk_NhaXuatBan]    Script Date: 2/20/2025 4:15:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ntk_NhaXuatBan](
	[ntk_MaNhaXuatBan] [int] IDENTITY(1,1) NOT NULL,
	[ntk_TenNhaXuatBan] [nvarchar](100) NOT NULL,
	[ntk_DiaChi] [text] NULL,
PRIMARY KEY CLUSTERED 
(
	[ntk_MaNhaXuatBan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ntk_QuanTriVien]    Script Date: 2/20/2025 4:15:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ntk_QuanTriVien](
	[ntk_MaQuanTriVien] [int] IDENTITY(1,1) NOT NULL,
	[ntk_TenQuanTriVien] [nvarchar](100) NOT NULL,
	[ntk_Email] [nvarchar](100) NOT NULL,
	[ntk_MatKhau] [nvarchar](255) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[ntk_MaQuanTriVien] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ntk_Sach]    Script Date: 2/20/2025 4:15:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ntk_Sach](
	[ntk_MaSach] [int] IDENTITY(1,1) NOT NULL,
	[ntk_TieuDe] [nvarchar](255) NOT NULL,
	[ntk_ISBN] [nvarchar](13) NULL,
	[ntk_Gia] [decimal](10, 2) NOT NULL,
	[ntk_MaTacGia] [int] NULL,
	[ntk_MaNhaXuatBan] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[ntk_MaSach] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ntk_TacGia]    Script Date: 2/20/2025 4:15:37 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ntk_TacGia](
	[ntk_MaTacGia] [int] IDENTITY(1,1) NOT NULL,
	[ntk_TenTacGia] [nvarchar](100) NOT NULL,
	[ntk_ThongTinLienHe] [text] NULL,
PRIMARY KEY CLUSTERED 
(
	[ntk_MaTacGia] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[ntk_BaiViet] ON 

INSERT [dbo].[ntk_BaiViet] ([ntk_MaBaiViet], [ntk_TieuDe], [ntk_NoDung], [ntk_MaQuanTriVien], [ntk_NgayXuatBan], [ntk_TheLoai], [ntk_HinhAnh]) VALUES (1, N'Khám Phá Vẻ Đẹp Việt Nam', N'Vi?t Nam là m?t d?t nu?c xinh d?p v?i nhi?u danh lam th?ng c?nh...', 1, CAST(N'2023-10-01' AS Date), N'Du lịch', N'https://example.com/image1.jpg')
INSERT [dbo].[ntk_BaiViet] ([ntk_MaBaiViet], [ntk_TieuDe], [ntk_NoDung], [ntk_MaQuanTriVien], [ntk_NgayXuatBan], [ntk_TheLoai], [ntk_HinhAnh]) VALUES (2, N'Công Nghệ Thông Tin Trong Thế Kỷ 21', N'Công ngh? thông tin dã thay d?i cách chúng ta s?ng và làm vi?c...', 2, CAST(N'2023-10-02' AS Date), N'Công nghệ', N'https://example.com/image2.jpg')
SET IDENTITY_INSERT [dbo].[ntk_BaiViet] OFF
GO
SET IDENTITY_INSERT [dbo].[ntk_ChiTietBaiViet] ON 

INSERT [dbo].[ntk_ChiTietBaiViet] ([ntk_MaChiTietBaiViet], [ntk_MaBaiViet], [ntk_MaSach]) VALUES (1, 1, 1)
INSERT [dbo].[ntk_ChiTietBaiViet] ([ntk_MaChiTietBaiViet], [ntk_MaBaiViet], [ntk_MaSach]) VALUES (2, 1, 2)
INSERT [dbo].[ntk_ChiTietBaiViet] ([ntk_MaChiTietBaiViet], [ntk_MaBaiViet], [ntk_MaSach]) VALUES (3, 2, 2)
INSERT [dbo].[ntk_ChiTietBaiViet] ([ntk_MaChiTietBaiViet], [ntk_MaBaiViet], [ntk_MaSach]) VALUES (4, 2, 3)
SET IDENTITY_INSERT [dbo].[ntk_ChiTietBaiViet] OFF
GO
SET IDENTITY_INSERT [dbo].[ntk_KhachHang] ON 

INSERT [dbo].[ntk_KhachHang] ([ntk_MaKhachHang], [ntk_TenKhachHang], [ntk_Email], [ntk_SoDienThoai]) VALUES (1, N'Trần Văn A', N'tranvana@example.com', N'0123456789')
INSERT [dbo].[ntk_KhachHang] ([ntk_MaKhachHang], [ntk_TenKhachHang], [ntk_Email], [ntk_SoDienThoai]) VALUES (2, N'Nguyễn Thị B', N'nguyenthita@example.com', N'0987654321')
INSERT [dbo].[ntk_KhachHang] ([ntk_MaKhachHang], [ntk_TenKhachHang], [ntk_Email], [ntk_SoDienThoai]) VALUES (3, N'Lê Văn C', N'levanc@example.com', N'0912345678')
SET IDENTITY_INSERT [dbo].[ntk_KhachHang] OFF
GO
SET IDENTITY_INSERT [dbo].[ntk_NhaXuatBan] ON 

INSERT [dbo].[ntk_NhaXuatBan] ([ntk_MaNhaXuatBan], [ntk_TenNhaXuatBan], [ntk_DiaChi]) VALUES (1, N'NXB Trẻ', N'123 Ðu?ng ABC, TP.HCM')
INSERT [dbo].[ntk_NhaXuatBan] ([ntk_MaNhaXuatBan], [ntk_TenNhaXuatBan], [ntk_DiaChi]) VALUES (2, N'HarperCollins', N'456 XYZ Street, New York')
INSERT [dbo].[ntk_NhaXuatBan] ([ntk_MaNhaXuatBan], [ntk_TenNhaXuatBan], [ntk_DiaChi]) VALUES (3, N'Nhà Xuất Bản Kim Đồng', N'789 Ðu?ng DEF, Hà N?i')
SET IDENTITY_INSERT [dbo].[ntk_NhaXuatBan] OFF
GO
SET IDENTITY_INSERT [dbo].[ntk_QuanTriVien] ON 

INSERT [dbo].[ntk_QuanTriVien] ([ntk_MaQuanTriVien], [ntk_TenQuanTriVien], [ntk_Email], [ntk_MatKhau]) VALUES (1, N'Nguyễn Văn A', N'adminA@example.com', N'hashed_password_1')
INSERT [dbo].[ntk_QuanTriVien] ([ntk_MaQuanTriVien], [ntk_TenQuanTriVien], [ntk_Email], [ntk_MatKhau]) VALUES (2, N'Trần Thị B', N'adminB@example.com', N'hashed_password_2')
SET IDENTITY_INSERT [dbo].[ntk_QuanTriVien] OFF
GO
SET IDENTITY_INSERT [dbo].[ntk_Sach] ON 

INSERT [dbo].[ntk_Sach] ([ntk_MaSach], [ntk_TieuDe], [ntk_ISBN], [ntk_Gia], [ntk_MaTacGia], [ntk_MaNhaXuatBan]) VALUES (1, N'Kính Vạn Hoa', N'9786046999999', CAST(150000.00 AS Decimal(10, 2)), 1, 1)
INSERT [dbo].[ntk_Sach] ([ntk_MaSach], [ntk_TieuDe], [ntk_ISBN], [ntk_Gia], [ntk_MaTacGia], [ntk_MaNhaXuatBan]) VALUES (2, N'The Alchemist', N'9780062315007', CAST(200000.00 AS Decimal(10, 2)), 2, 2)
INSERT [dbo].[ntk_Sach] ([ntk_MaSach], [ntk_TieuDe], [ntk_ISBN], [ntk_Gia], [ntk_MaTacGia], [ntk_MaNhaXuatBan]) VALUES (3, N'Harry Potter and the Philosopher''s Stone', N'9780747532699', CAST(250000.00 AS Decimal(10, 2)), 3, 3)
SET IDENTITY_INSERT [dbo].[ntk_Sach] OFF
GO
SET IDENTITY_INSERT [dbo].[ntk_TacGia] ON 

INSERT [dbo].[ntk_TacGia] ([ntk_MaTacGia], [ntk_TenTacGia], [ntk_ThongTinLienHe]) VALUES (1, N'Nguyễn Nhật Ánh', N'nguyennhatanh@example.com')
INSERT [dbo].[ntk_TacGia] ([ntk_MaTacGia], [ntk_TenTacGia], [ntk_ThongTinLienHe]) VALUES (2, N'Paulo Coelho', N'paulocoelho@example.com')
INSERT [dbo].[ntk_TacGia] ([ntk_MaTacGia], [ntk_TenTacGia], [ntk_ThongTinLienHe]) VALUES (3, N'J.K. Rowling', N'jkrowling@example.com')
INSERT [dbo].[ntk_TacGia] ([ntk_MaTacGia], [ntk_TenTacGia], [ntk_ThongTinLienHe]) VALUES (4, N'Nguyễn Nhật Ánh', N'nguyennhatanh@example.com')
INSERT [dbo].[ntk_TacGia] ([ntk_MaTacGia], [ntk_TenTacGia], [ntk_ThongTinLienHe]) VALUES (5, N'Paulo Coelho', N'paulocoelho@example.com')
INSERT [dbo].[ntk_TacGia] ([ntk_MaTacGia], [ntk_TenTacGia], [ntk_ThongTinLienHe]) VALUES (6, N'J.K. Rowling', N'jkrowling@example.com')
SET IDENTITY_INSERT [dbo].[ntk_TacGia] OFF
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__ntk_Quan__5ED4453EB78C9FDB]    Script Date: 2/20/2025 4:15:37 PM ******/
ALTER TABLE [dbo].[ntk_QuanTriVien] ADD UNIQUE NONCLUSTERED 
(
	[ntk_Email] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__ntk_Sach__E5A2FFE354D1AA9C]    Script Date: 2/20/2025 4:15:37 PM ******/
ALTER TABLE [dbo].[ntk_Sach] ADD UNIQUE NONCLUSTERED 
(
	[ntk_ISBN] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
ALTER TABLE [dbo].[ntk_BaiViet]  WITH CHECK ADD FOREIGN KEY([ntk_MaQuanTriVien])
REFERENCES [dbo].[ntk_QuanTriVien] ([ntk_MaQuanTriVien])
GO
ALTER TABLE [dbo].[ntk_ChiTietBaiViet]  WITH CHECK ADD FOREIGN KEY([ntk_MaBaiViet])
REFERENCES [dbo].[ntk_BaiViet] ([ntk_MaBaiViet])
GO
ALTER TABLE [dbo].[ntk_ChiTietBaiViet]  WITH CHECK ADD FOREIGN KEY([ntk_MaSach])
REFERENCES [dbo].[ntk_Sach] ([ntk_MaSach])
GO
ALTER TABLE [dbo].[ntk_Sach]  WITH CHECK ADD FOREIGN KEY([ntk_MaTacGia])
REFERENCES [dbo].[ntk_TacGia] ([ntk_MaTacGia])
GO
ALTER TABLE [dbo].[ntk_Sach]  WITH CHECK ADD FOREIGN KEY([ntk_MaNhaXuatBan])
REFERENCES [dbo].[ntk_NhaXuatBan] ([ntk_MaNhaXuatBan])
GO
USE [master]
GO
ALTER DATABASE [ntk_QLBQ] SET  READ_WRITE 
GO

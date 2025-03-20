
DROP DATABASE IF EXISTS ntk_qlbq;
CREATE DATABASE ntk_qlbq CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE ntk_qlbq;

CREATE TABLE TacGia (
    MaTacGia INT AUTO_INCREMENT PRIMARY KEY,
    TenTacGia VARCHAR(255) NOT NULL,
    ThongTinLienHe TEXT DEFAULT NULL,
    TrangThai ENUM('HoatDong', 'KhongHoatDong', 'ChoDuyet') NOT NULL DEFAULT 'HoatDong'
) ENGINE=InnoDB;

CREATE TABLE NhaXuatBan (
    MaNhaXuatBan INT AUTO_INCREMENT PRIMARY KEY,
    TenNhaXuatBan VARCHAR(100) NOT NULL,
    DiaChi TEXT DEFAULT NULL
) ENGINE=InnoDB;


CREATE TABLE BaiViet (
    MaBaiViet INT AUTO_INCREMENT PRIMARY KEY,
    TieuDe VARCHAR(255) NOT NULL,
    NoiDung TEXT NOT NULL,
	MaUser INT,
    NgayXuatBan DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    TheLoai VARCHAR(100) DEFAULT NULL,
    FOREIGN KEY (MaUser) REFERENCES User(MaUser) ON DELETE SET NULL
) ENGINE=InnoDB;


CREATE TABLE Sach (
    MaSach INT AUTO_INCREMENT PRIMARY KEY,
    TieuDe VARCHAR(255) NOT NULL,
    NamXuatBan INT NOT NULL,
    MaTacGia INT DEFAULT NULL,
    MaNhaXuatBan INT DEFAULT NULL,
    SoTrang INT DEFAULT NULL,
    MoTa TEXT DEFAULT NULL,
    FOREIGN KEY (MaTacGia) REFERENCES TacGia(MaTacGia) ON DELETE SET NULL,
    FOREIGN KEY (MaNhaXuatBan) REFERENCES NhaXuatBan(MaNhaXuatBan) ON DELETE SET NULL
) ENGINE=InnoDB;


CREATE TABLE User (
    MaUser INT AUTO_INCREMENT PRIMARY KEY,
    TenNguoiDung VARCHAR(100) NOT NULL,
    Email VARCHAR(100) NOT NULL UNIQUE,
    MatKhau VARCHAR(255) NOT NULL
) ENGINE=InnoDB;


INSERT INTO TacGia (TenTacGia, ThongTinLienHe, TrangThai) VALUES
    ('Nguyễn Nhật Ánh', 'nguyennhatanh@example.com', 'HoatDong'),
    ('Paulo Coelho', 'paulocoelho@example.com', 'KhongHoatDong'),
    ('Haruki Murakami', 'harukimurakami@example.com', 'ChoDuyet');


INSERT INTO NhaXuatBan (TenNhaXuatBan, DiaChi) VALUES
    ('NXB Kim Đồng', 'Hà Nội'),
    ('Nhà Xuất Bản Trẻ', 'TP.HCM');


INSERT INTO BaiViet (TieuDe, NoiDung, MaUser, NgayXuatBan, TheLoai) VALUES
    ('Hành Trình Văn Hóa', 'Lịch sử và văn hóa của Việt Nam qua các thời kỳ...', 1, NOW(), 'Lịch Sử'),
    ('Công Nghệ và Cuộc Sống', 'Tác động của công nghệ lên xã hội hiện đại...', 2, NOW(), 'Công Nghệ');


INSERT INTO Sach (TieuDe, NamXuatBan, MaTacGia, MaNhaXuatBan) VALUES
    ('Kính Vạn Hoa', 1995, 1, 1),
    ('The Alchemist', 1988, 2, 2),
    ('Harry Potter and the Philosopher\'s Stone', 1997, 3, 1);


INSERT INTO User (TenNguoiDung, Email, MatKhau) VALUES
    ('admin', 'admin@example.com', 'hashed_admin_password'),
    ('user1', 'user1@example.com', 'hashed_user1_password'),
    ('user2', 'user2@example.com', 'hashed_user2_password'),
    'admin2', 'user2@example.com', '123456');


SHOW TABLES;
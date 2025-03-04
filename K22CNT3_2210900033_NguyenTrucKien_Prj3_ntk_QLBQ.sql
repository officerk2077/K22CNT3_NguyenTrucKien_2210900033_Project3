-- Tạo database ntk_qlbq
CREATE DATABASE IF NOT EXISTS ntk_qlbq
CHARACTER SET utf8mb4
COLLATE utf8mb4_unicode_ci;

USE ntk_qlbq;

-- Tạo bảng ntk_QuanTriVien (bảng cha không có khóa ngoại)
CREATE TABLE ntk_QuanTriVien (
    ntk_MaQuanTriVien INT AUTO_INCREMENT PRIMARY KEY,
    ntk_TenQuanTriVien VARCHAR(100) NOT NULL,
    ntk_Email VARCHAR(100) NOT NULL,
    ntk_MatKhau VARCHAR(255) NOT NULL,
    UNIQUE KEY UQ_ntk_QuanTriVien_ntk_Email (ntk_Email)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Tạo bảng ntk_TacGia (bảng cha không có khóa ngoại)
CREATE TABLE ntk_TacGia (
    ntk_MaTacGia INT AUTO_INCREMENT PRIMARY KEY,
    ntk_TenTacGia VARCHAR(100) NOT NULL,
    ntk_ThongTinLienHe TEXT DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Tạo bảng ntk_NhaXuatBan (bảng cha không có khóa ngoại)
CREATE TABLE ntk_NhaXuatBan (
    ntk_MaNhaXuatBan INT AUTO_INCREMENT PRIMARY KEY,
    ntk_TenNhaXuatBan VARCHAR(100) NOT NULL,
    ntk_DiaChi TEXT DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Tạo bảng ntk_BaiViet (bao gồm khóa ngoại ntk_MaQuanTriVien)
CREATE TABLE ntk_BaiViet (
    ntk_MaBaiViet INT AUTO_INCREMENT PRIMARY KEY,
    ntk_TieuDe VARCHAR(255) NOT NULL,
    ntk_NoDung TEXT NOT NULL,
    ntk_MaQuanTriVien INT DEFAULT NULL,
    ntk_NgayXuatBan DATE NOT NULL,
    ntk_TheLoai VARCHAR(100) DEFAULT NULL,
    ntk_HinhAnh VARCHAR(255) DEFAULT NULL,
    FOREIGN KEY (ntk_MaQuanTriVien) REFERENCES ntk_QuanTriVien(ntk_MaQuanTriVien) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Tạo bảng ntk_Sach (bao gồm khóa ngoại ntk_MaTacGia và ntk_MaNhaXuatBan)
CREATE TABLE ntk_Sach (
    ntk_MaSach INT AUTO_INCREMENT PRIMARY KEY,
    ntk_TieuDe VARCHAR(255) NOT NULL,
    ntk_ISBN VARCHAR(13) DEFAULT NULL,
    ntk_Gia DECIMAL(10,2) NOT NULL,
    ntk_MaTacGia INT DEFAULT NULL,
    ntk_MaNhaXuatBan INT DEFAULT NULL,
    UNIQUE KEY UQ_ntk_Sach_ntk_ISBN (ntk_ISBN),
    FOREIGN KEY (ntk_MaTacGia) REFERENCES ntk_TacGia(ntk_MaTacGia) ON DELETE SET NULL,
    FOREIGN KEY (ntk_MaNhaXuatBan) REFERENCES ntk_NhaXuatBan(ntk_MaNhaXuatBan) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Tạo bảng ntk_ChiTietBaiViet (bao gồm khóa ngoại ntk_MaBaiViet và ntk_MaSach)
CREATE TABLE ntk_ChiTietBaiViet (
    ntk_MaChiTietBaiViet INT AUTO_INCREMENT PRIMARY KEY,
    ntk_MaBaiViet INT DEFAULT NULL,
    ntk_MaSach INT DEFAULT NULL,
    FOREIGN KEY (ntk_MaBaiViet) REFERENCES ntk_BaiViet(ntk_MaBaiViet) ON DELETE SET NULL,
    FOREIGN KEY (ntk_MaSach) REFERENCES ntk_Sach(ntk_MaSach) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Tạo bảng ntk_KhachHang (bảng độc lập, không có khóa ngoại trong script này)
CREATE TABLE ntk_KhachHang (
    ntk_MaKhachHang INT AUTO_INCREMENT PRIMARY KEY,
    ntk_TenKhachHang VARCHAR(100) NOT NULL,
    ntk_Email VARCHAR(100) DEFAULT NULL,
    ntk_SoDienThoai VARCHAR(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Chèn dữ liệu (INSERT), đảm bảo dữ liệu khớp với khóa ngoại
INSERT INTO ntk_QuanTriVien (ntk_TenQuanTriVien, ntk_Email, ntk_MatKhau) VALUES
    ('Nguyễn Văn A', 'adminA@example.com', 'hashed_password_1'),
    ('Trần Thị B', 'adminB@example.com', 'hashed_password_2');

INSERT INTO ntk_TacGia (ntk_TenTacGia, ntk_ThongTinLienHe) VALUES
    ('Nguyễn Nhật Ánh', 'nguyennhatanh@example.com'),
    ('Paulo Coelho', 'paulocoelho@example.com'),
    ('J.K. Rowling', 'jkrowling@example.com');

INSERT INTO ntk_NhaXuatBan (ntk_TenNhaXuatBan, ntk_DiaChi) VALUES
    ('NXB Trẻ', '123 Đường ABC, TP.HCM'),
    ('HarperCollins', '456 XYZ Street, New York'),
    ('Nhà Xuất Bản Kim Đồng', '789 Đường DEF, Hà Nội');

INSERT INTO ntk_BaiViet (ntk_TieuDe, ntk_NoDung, ntk_MaQuanTriVien, ntk_NgayXuatBan, ntk_TheLoai, ntk_HinhAnh) VALUES
    ('Khám Phá Vẻ Đẹp Việt Nam', 'Việt Nam là một đất nước xinh đẹp với nhiều danh lam thắng cảnh...', 1, '2023-10-01', 'Du lịch', 'https://example.com/image1.jpg'),
    ('Công Nghệ Thông Tin Trong Thế Kỷ 21', 'Công nghệ thông tin đã thay đổi cách chúng ta sống và làm việc...', 2, '2023-10-02', 'Công nghệ', 'https://example.com/image2.jpg');

INSERT INTO ntk_Sach (ntk_TieuDe, ntk_ISBN, ntk_Gia, ntk_MaTacGia, ntk_MaNhaXuatBan) VALUES
    ('Kính Vạn Hoa', '9786046999999', 150000.00, 1, 1),
    ('The Alchemist', '9780062315007', 200000.00, 2, 2),
    ('Harry Potter and the Philosopher''s Stone', '9780747532699', 250000.00, 3, 3);

INSERT INTO ntk_ChiTietBaiViet (ntk_MaBaiViet, ntk_MaSach) VALUES
    (1, 1), (1, 2), (2, 2), (2, 3);

INSERT INTO ntk_KhachHang (ntk_TenKhachHang, ntk_Email, ntk_SoDienThoai) VALUES
    ('Trần Văn A', 'tranvana@example.com', '0123456789'),
    ('Nguyễn Thị B', 'nguyenthita@example.com', '0987654321'),
    ('Lê Văn C', 'levanc@example.com', '0912345678');
    
    USE ntk_qlbq;

-- Kiểm tra tất cả các bảng
SHOW TABLES;

-- Kiểm tra khóa ngoại
SELECT 
    TABLE_NAME, 
    COLUMN_NAME, 
    CONSTRAINT_NAME, 
    REFERENCED_TABLE_NAME, 
    REFERENCED_COLUMN_NAME
FROM 
    INFORMATION_SCHEMA.KEY_COLUMN_USAGE
WHERE 
    TABLE_SCHEMA = 'ntk_qlbq' 
    AND REFERENCED_TABLE_NAME IS NOT NULL;

-- Kiểm tra dữ liệu và quan hệ
SELECT * FROM ntk_QuanTriVien;
SELECT * FROM ntk_BaiViet WHERE ntk_MaQuanTriVien NOT IN (SELECT ntk_MaQuanTriVien FROM ntk_QuanTriVien); -- Kiểm tra khóa ngoại
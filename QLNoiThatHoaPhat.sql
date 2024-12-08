CREATE DATABASE QLNoiThatHoaPhat
Use QLNoiThatHoaPhat

Create Table login(
UserName nvarchar(50) NOT NULL PRIMARY KEY,
Pass nvarchar(50) NULL,
)

Create Table NoiThat(
MaNoiThat nvarchar(20) NOT NULL PRIMARY KEY,
TenNoiThat nvarchar(50) NOT NULL,
Mau nvarchar(20),
KieuLoai nvarchar(20),
ChatLieu nvarchar(20),
DonGia Int
)

Create Table NhanVien(
MaNhanVien nvarchar(20) NOT NULL PRIMARY KEY,
TenNhanVien nvarchar(50) NOT NULL,
GioiTinh nvarchar(10),
SDT nvarchar(20),
CongViec nvarchar(20)
)

Create Table KhachHang(
MaKhach nvarchar(20) NOT NULL PRIMARY KEY,
TenKhach nvarchar(20) NOT NULL,
DiaChi nvarchar(50),
SDT nvarchar(20)
)

Create Table HoaDon(
MaHoaDon nvarchar(20) NOT NULL PRIMARY KEY,
MaNoiThat nvarchar(20) NOT NULL FOREIGN KEY REFERENCES NoiThat,
MaKhach nvarchar(20) NOT NULL FOREIGN KEY REFERENCES KhachHang,
MaNhanVien nvarchar(20) NOT NULL FOREIGN KEY REFERENCES NhanVien,
SoLuong Int,
TongGia Int
)


insert into login values('admin', '123')

--insert Nội thất
Insert into NoiThat values('NT01',N'Sofa Coastal 2 chỗ KD1085-18',N'Xanh',N'Sofa',N'Gỗ',2000000)
Insert into NoiThat values('NT02',N'Tủ Kệ Tivi Gỗ MOHO OSLO 201',N'Trắng',N'Tủ',N'Gỗ',2900000)
Insert into NoiThat values('NT03',N'Giường Ngủ Gỗ Cao Su MOHO NEXO 301 Màu Nâu',N'Xám',N'Giường',N'Gỗ cao su',6400000)
Insert into NoiThat values('NT04',N'HỆ TỦ BẾP MOHO KITCHEN DÒNG PREMIUM',N'Nâu',N'Tủ bếp',N'Nhôm',45000000)
Insert into NoiThat values('NT05',N'Bàn Trà Gỗ Thông MOHO VLINE 501',N'Nâu',N'Bàn',N'Gỗ thông',1900000)
Insert into NoiThat values('NT06',N'Ghế Văn Phòng Chân Xoay MOHO MAJOR 701',N'Đen',N'Ghế văn phòng',N'Nhựa',19000000)
Insert into NoiThat values('NT07',N'Ghế Nhựa Hòa Phát',N'Xanh',N'Ghế',N'Nhựa',20000)
--insert nhân viên
Insert into NhanVien values('NV01',N'Mai Thành Công',N'Nam','0869886594',N'Seller')
--insert Khách hàng
Insert into KhachHang values('KH01',N'Nguyễn Văn A',N'Hà Nội','0358171829')
Insert into KhachHang values('KH02',N'Lionel Messi',N'Argentina','0346534345')
Insert into KhachHang values('KH03',N'Cristiano Ronaldo',N'Portugal','01257125793')
Insert into KhachHang values('KH04',N'Oleksandr Kostyliev',N'Ukraine','058917253534')
Insert into KhachHang values('KH05',N'Jonathan Jablonowski',N'American','053495733453')
--insert Hóa Đơn
Insert into HoaDon values('HD01','NT01','KH01','NV01',2,0)
Insert into HoaDon values('HD02','NT02','KH01','NV01',1,0)
Insert into HoaDon values('HD03','NT03','KH01','NV01',3,0)
Insert into HoaDon values('HD04','NT04','KH01','NV01',2,0)
Insert into HoaDon values('HD05','NT05','KH01','NV01',1,0)
Insert into HoaDon values('HD06','NT06','KH01','NV01',4,0)
Insert into HoaDon values('HD07','NT07','KH01','NV01',10,0)


CREATE OR ALTER TRIGGER capnhatTongGia
ON HoaDon
AFTER INSERT, UPDATE
AS
BEGIN
    SET NOCOUNT ON;

    UPDATE HD
    SET TongGia = HD.SoLuong * NT.DonGia
    FROM HoaDon HD
    INNER JOIN inserted I ON HD.MaHoaDon = I.MaHoaDon
    INNER JOIN NoiThat NT ON HD.MaNoiThat = NT.MaNoiThat;
END;

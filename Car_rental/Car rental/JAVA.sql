create database mydatabase
use mydatabase

CREATE TABLE account 
(
    username varchar(30) PRIMARY KEY,
    pass varchar(20) CHECK (LEN(pass) >= 6) NOT NULL
);
select * from account
INSERT INTO account (username, pass) VALUES ('admin', '123456789');

CREATE TABLE car 
(
    CARID varchar(30) PRIMARY KEY,
    BRAND varchar(20) NOT NULL,
    MODEL varchar(20) NOT NULL,
    car_status bit NOT NULL default 1, 
    LICENSE_PLATE varchar(15) NOT NULL,
    PRICE float NOT NULL
);
ALTER TABLE car
ADD Total_time int DEFAULT 0,
    total_bill float DEFAULT 0,
    total_payment float DEFAULT 0;
CREATE TABLE customer
(
    CUSID varchar(30) PRIMARY KEY,
    HoTen varchar(20) NOT NULL,
    DiaChi varchar(20) NOT NULL,
    SoDienThoai varchar(20) NOT NULL,
    Email varchar(50) NOT NULL
);

CREATE TABLE car_rented
(
    CARID varchar(30),
    CUSID varchar(30),
    RENTID varchar(30) PRIMARY KEY,
    RENTDATE date NOT NULL,
    RETURNDATE date NOT NULL
    FOREIGN KEY (CARID) REFERENCES car(CARID),
    FOREIGN KEY (CUSID) REFERENCES customer(CUSID)
);

create table tempNgayTra
(
    RENTID varchar(30) PRIMARY KEY,
    RETURNDATE date NOT NULL
);
INSERT INTO customer (CUSID, HoTen, DiaChi, SoDienThoai, Email)
VALUES
    ('CUS001', 'Nguyen Van Khanh', 'TP.HCM', '0901234567', 'khanh@example.com'),
    ('CUS002', 'Tran Thi Huong', 'TP.HCM', '0912345678', 'huong@example.com'),
    ('CUS003', 'Le Minh Tuan', 'TP.HCM', '0923456789', 'tuan@example.com'),
    ('CUS004', 'Pham Thi Mai', 'TP.HCM', '0934567890', 'mai@example.com'),
    ('CUS005', 'Hoang Van An', 'TP.HCM', '0945678901', 'an@example.com');
select * from customer

INSERT INTO car (CARID, BRAND, MODEL, car_status, LICENSE_PLATE, PRICE)
VALUES('C000', 'Nissan', 'Altima', 0, 'JKL012', 26000.00),
    ('C001', 'Toyota', 'Camry', 1, 'ABC123', 25000.00),
    ('C002', 'Honda', 'Civic', 1, 'XYZ789', 22000.00),
    ('C003', 'Ford', 'Mustang', 1, 'DEF456', 35000.00),
    ('C004', 'Chevrolet', 'Malibu', 1, 'GHI789', 28000.00),
	('C005', 'Nissan', 'Altima', 0, 'JKL012', 26000.00);
UPDATE car
SET 
    Total_time = 0,
    total_bill = 0.0,
    total_payment = 0.0
WHERE CARID 
CREATE FUNCTION hien_thi_tra_xe()
RETURNS TABLE 
AS
RETURN (
    SELECT
        cr.RENTID,
        cr.CARID,
        cr.CUSID,
        c.PRICE * DATEDIFF(day, cr.RENTDATE, cr.RETURNDATE) AS Fees,
		DATEDIFF(day, cr.RETURNDATE, nt.RETURNDATE) as NgayDelay,
	    (c.PRICE * DATEDIFF(day, cr.RETURNDATE, nt.RETURNDATE)) as TienPhat,
        nt.RETURNDATE
    FROM
        car_rented cr
    JOIN
        car c ON cr.CARID = c.CARID
	JOIN 
	    tempNgayTra nt ON cr.RENTID = nt.RENTID
);

select * from hien_thi_tra_xe()
drop function hien_thi_tra_xe

CREATE FUNCTION hien_thi_hoa_don()
RETURNS TABLE 
AS
RETURN (
    SELECT
        cr.RENTID,
        cr.CARID,
        cr.CUSID,

        c.PRICE * DATEDIFF(day, cr.RENTDATE, cr.RETURNDATE) AS Fees,

        cr.RENTDATE,
        cr.RETURNDATE
    FROM
        car_rented cr
    JOIN
        car c ON cr.CARID = c.CARID
);


SELECT * FROM hien_thi_hoa_don();

INSERT INTO car_rented (CUSID, HoTen, DiaChi, SoDienThoai, Email)
VALUES

select * from car_rented
select * from car
update car set car_status = 1
delete from car_rented
CREATE PROCEDURE cap_nhat_thong_tin_xe
    @p_carid varchar(30)
AS
BEGIN
    DECLARE @v_total_time int;
    DECLARE @v_total_bill float;
    DECLARE @v_total_payment float;

    -- Tính toán tổng thời gian, tổng hóa đơn và tổng thanh toán dựa trên thông tin thuê xe
    SELECT 
        @v_total_time = COALESCE(SUM(DATEDIFF(day, cr.RENTDATE, nt.RETURNDATE)), 0),
        @v_total_bill = COALESCE(COUNT(cr.RENTID), 0),
        @v_total_payment = COALESCE(SUM((DATEDIFF(day, cr.RENTDATE, nt.RETURNDATE) * c.PRICE)), 0)
    FROM 
        car_rented cr
    JOIN 
        car c ON cr.CARID = c.CARID
    JOIN 
        tempNgayTra nt ON cr.RENTID = nt.RENTID
    WHERE 
        c.CARID = @p_carid;

    -- Cập nhật thông tin của xe
    UPDATE car
    SET 
        Total_time = COALESCE(Total_time, 0) + @v_total_time,
        total_bill = COALESCE(total_bill, 0) + @v_total_bill,
        total_payment = COALESCE(total_payment, 0) + @v_total_payment
    WHERE 
        CARID = @p_carid;
END;
CREATE PROCEDURE reset_car_statistics
AS
BEGIN
    UPDATE car
    SET 
        Total_time = 0,
        total_bill = 0.0,
        total_payment = 0.0;
END;

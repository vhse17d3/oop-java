
-- Bảng lưu trữ thông tin về khách hàng
CREATE TABLE Customers (
    customer_id INT PRIMARY KEY,
    name VARCHAR(255),
    email VARCHAR(255),
    phone VARCHAR(15),
    address VARCHAR(255)
);

-- Bảng lưu trữ thông tin về ô tô
CREATE TABLE Cars (
    car_id INT PRIMARY KEY,
    make VARCHAR(255),
    model VARCHAR(255),
    year INT,
    color VARCHAR(50),
    rental_fee DECIMAL(10, 2)
	quantity INT DEFAULT 0 CHECK (quantity >= 0);
);

-- Bảng lưu trữ thông tin về nhân viên
CREATE TABLE Employees (
    employee_id INT PRIMARY KEY,
    name VARCHAR(255),
    email VARCHAR(255),
    phone VARCHAR(15),
	salary DECIMAL(10, 2);
);
-- Bảng lưu trữ thông tin về người dùng (bao gồm cả khách hàng và nhân viên)
CREATE TABLE Users (
    user_id INT IDENTITY(1,1) PRIMARY KEY,
    username VARCHAR(255),
    password VARCHAR(255) CHECK (LEN(password) >= 6),
    customer_id INT,
    employee_id INT,
    role INT CHECK (role IN (1, 2, 3)) DEFAULT 1,
    FOREIGN KEY (customer_id) REFERENCES Customers(customer_id),
    FOREIGN KEY (employee_id) REFERENCES Employees(employee_id)
);

-- Cập nhật giá trị của cột role dựa trên employee_id và customer_id
UPDATE Users
SET role = 2 -- Nhân viên
WHERE employee_id IS NOT NULL;

UPDATE Users
SET role = 3 -- Khách hàng
WHERE customer_id IS NOT NULL;
-- Bảng lưu trữ thông tin về hóa đơn
CREATE TABLE Invoices (
    invoice_id INT PRIMARY KEY,
    customer_id INT,
    employee_id INT,
    car_id INT,
    rental_start_date DATE CHECK (rental_start_date >= GETDATE()),
    rental_end_date DATE,
    total_cost DECIMAL(10, 2),
    is_paid BIT,
    FOREIGN KEY (customer_id) REFERENCES Customers(customer_id),
    FOREIGN KEY (employee_id) REFERENCES Employees(employee_id),
    FOREIGN KEY (car_id) REFERENCES Cars(car_id) ,
    CONSTRAINT CHK_RentalDates CHECK (rental_end_date >= DATEADD(DAY, 1, rental_start_date))
);
-- Bảng lưu trữ thông tin về các sự kiện hoạt động trên hệ thống (ví dụ: ghi log)
/*
CREATE TABLE SystemEvents (
    event_id INT PRIMARY KEY,
    event_type VARCHAR(255),
    event_description TEXT,
    event_date TIMESTAMP
);
*/
-- check role 
-- DROP PROCEDURE CheckUserRole;
CREATE PROCEDURE CheckUserRole
    @user_id INT
AS
BEGIN
    SET NOCOUNT ON;

    DECLARE @role INT;

    -- Lấy vai trò từ bảng Users
    SELECT @role = role
    FROM Users
    WHERE user_id = @user_id;

    -- Kiểm tra vai trò và in thông báo tương ứng
    IF @role = 1
    BEGIN
        PRINT 'Người dùng là quản lý.';
        -- Thực hiện các hành động phù hợp với quản lý
    END
    ELSE IF @role = 2
    BEGIN
        PRINT 'Người dùng là nhân viên.';
        -- Thực hiện các hành động phù hợp với nhân viên
    END
    ELSE IF @role = 3
    BEGIN
        PRINT 'Người dùng là khách hàng.';
        -- Thực hiện các hành động phù hợp với khách hàng
    END
    ELSE
    BEGIN
        PRINT 'Vai trò không hợp lệ.';
        -- Thực hiện các hành động phù hợp với các trường hợp khác
    END;
END;

-- Thêm một tài khoản admin với vai trò quản lý
INSERT INTO Users (user_id, username, password, role)
VALUES (1, 'admin', '123456789', 1);

select * from Users
-- Thêm dữ liệu nhân viên
INSERT INTO Employees (employee_id, name, email, phone,salary)
VALUES
    (1, N'Nguyen Tuan Minh', 'minh.nguyen@example.com', '123456789',700),
    (2, N'Tran Manh Long', 'long.tran@example.com', '987654321',700),
    (3, N'Le Xuan Thuc', 'thuc.le@example.com', '456789123' ,700)
-- Thêm tài khoản đăng nhập cho nhân viên
INSERT INTO Users ( username, password, employee_id, role)
VALUES
    ( 'nguyen_tuan_minh', '123456', 1, 2), -- Nhân viên
    ( 'tran_manh_long', '123456', 2, 2),   -- Nhân viên 
    ( 'le_xuan_thuc', '123456', 3, 2);     -- Nhân viên
-- Truy vấn tất cả thông tin về nhân viên
SELECT * FROM Employees;
-- Thêm 10 loại xe vào bảng Cars
INSERT INTO Cars (car_id, make, model, year, color, rental_fee, quantity)
VALUES
    (1, 'Toyota', 'Camry', 2022, 'Blue', 50.00, 5),
    (2, 'Honda', 'Accord', 2022, 'Silver', 55.00, 8),
    (3, 'Ford', 'Mustang', 2022, 'Red', 70.00, 3),
    (4, 'Chevrolet', 'Malibu', 2022, 'White', 48.00, 6),
    (5, 'Nissan', 'Altima', 2022, 'Black', 52.00, 7),
    (6, 'Hyundai', 'Sonata', 2022, 'Gray', 46.00, 4),
    (7, 'BMW', '3 Series', 2022, 'Green', 80.00, 2),
    (8, 'Mercedes-Benz', 'C-Class', 2022, 'Silver', 75.00, 9),
    (9, 'Audi', 'A4', 2022, 'Blue', 78.00, 1),
    (10, 'Lexus', 'ES', 2022, 'Black', 85.00, 10);
select * from cars
-- Thêm tài khoản người dùng vào bảng Customers
INSERT INTO Customers (customer_id, name, email, phone, address)
VALUES
    (4, 'Nguyen Van A', 'van.a@example.com', '111111111', 'ABC Street, City'),
    (5, 'Tran Thi B', 'thi.b@example.com', '222222222', 'XYZ Street, City');
-- Truy vấn tất cả thông tin về nhân viên
SELECT * FROM Customers;
INSERT INTO Users (user_id, username, password, customer_id, role)
VALUES 
		(4, 'usera', '123456', 4, 3),
		(5, 'userb', '123456', 5, 3);
--thông tin về các loại ô tô có sẵn để thuê
CREATE VIEW CarAvailabilityView AS
SELECT
    c.car_id,
    c.make,
    c.model,
    c.year,
    c.color,
    c.rental_fee,
    c.quantity AS total_quantity,
    ISNULL(rq.rented_quantity, 0) AS rented_quantity,
    c.quantity - ISNULL(rq.rented_quantity, 0) AS available_quantity
FROM
    Cars c
LEFT JOIN
    (
        SELECT
            car_id,
            COUNT(*) AS rented_quantity
        FROM
            Invoices
        WHERE
            is_paid = 1
            AND rental_end_date >= GETDATE()
        GROUP BY
            car_id
    ) rq ON c.car_id = rq.car_id;
SELECT * FROM CarAvailabilityView;
-- view thông tin nhân viên 
CREATE VIEW EmployeeInfoView AS
SELECT e.employee_id, e.name AS employee_name, e.email, e.phone, e.salary, u.username, u.password -- phải đổi tên 1 cột vì join 2 bảng không được tên giống nhau
FROM Employees e
LEFT JOIN Users u ON e.employee_id = u.employee_id;
select * from EmployeeInfoView
-- thủ tục sửa nhân viên 
-- DROP PROCEDURE IF EXISTS UpdateUserAndEmployeeInfo;
exec UpdateUserAndEmployeeInfo( 
CREATE PROCEDURE UpdateUserAndEmployeeInfo
    @username NVARCHAR(255),
    @password NVARCHAR(255),
	@employee_id INT,
    @name NVARCHAR(255),
    @email NVARCHAR(255),
    @phone NVARCHAR(15),
    @salary DECIMAL(10, 2)
AS
BEGIN
    SET NOCOUNT ON;

    -- Sửa thông tin trong bảng Users
    UPDATE Users
    SET
        username = @username,
        password = @password
    WHERE
        employee_id = @employee_id;

    -- Sửa thông tin trong bảng Employees
    UPDATE Employees
    SET
        name = @name,
        email = @email,
        phone = @phone,
        salary = @salary
    WHERE
        employee_id = @employee_id;
END;
-- thêm nhân viên 	
CREATE PROCEDURE AddUserAndEmployee
    @username NVARCHAR(255),
    @password NVARCHAR(255),
    @employee_id INT,
    @name NVARCHAR(255),
    @email NVARCHAR(255),
    @phone NVARCHAR(15),
    @salary DECIMAL(10, 2)
AS
BEGIN
    SET NOCOUNT ON;

    -- Thêm vào bảng Employees
    INSERT INTO Employees (employee_id, name, email, phone, salary)
    VALUES (@employee_id, @name, @email, @phone, @salary);

    -- Thêm vào bảng Users
    INSERT INTO Users (username, password, employee_id, role)
    VALUES (@username, @password, @employee_id, 2); -- Role 2 cho nhân viên
END;
-- DROP PROCEDURE IF EXISTS DeleteUserAndEmployee; 
CREATE PROCEDURE DeleteUserAndEmployee
    @username NVARCHAR(255),
    @password NVARCHAR(255),
	@employee_id INT,
    @name NVARCHAR(255),
    @email NVARCHAR(255),
    @phone NVARCHAR(15),
    @salary DECIMAL(10, 2)
AS
BEGIN
    SET NOCOUNT ON;

    -- Xóa từ bảng Users
    DELETE FROM Users
    WHERE employee_id = @employee_id
      AND username = @username
      AND password = @password;

    -- Xóa từ bảng Employees
    DELETE FROM Employees
    WHERE employee_id = @employee_id
      AND name = @name
      AND email = @email
      AND phone = @phone
      AND salary = @salary;
END;


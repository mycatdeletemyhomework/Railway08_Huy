#Final assignment - Task 1:
#Tạo table với các ràng buộc và kiểu dữ liệu
#Thêm ít nhất 3 bản ghi vào table

DROP DATABASE IF EXISTS ThucTap;
CREATE DATABASE ThucTap;
USE ThucTap;

DROP TABLE IF EXISTS Country;
CREATE TABLE Country
(
country_id			TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
country_name		VARCHAR(30) UNIQUE KEY
);

DROP TABLE IF EXISTS Location;
CREATE TABLE Location
(
location_id			TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
street_address		VARCHAR(50) UNIQUE KEY,
postal_code			INT UNSIGNED UNIQUE KEY,
country_id			TINYINT UNSIGNED,
FOREIGN KEY(country_id)	REFERENCES Country(country_id)
);

DROP TABLE IF EXISTS Employee;
CREATE TABLE Employee
(
employee_id			TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
full_name			VARCHAR (30),
email				VARCHAR (30) UNIQUE KEY CHECK (email LIKE '%@%' ),
location_id			TINYINT UNSIGNED,
FOREIGN KEY(location_id) REFERENCES Location(location_id) ON DELETE SET NULL
);

INSERT INTO Country	
						(country_name)
VALUES					('Vietnam'),
                        ('USA'),
                        ('Canada');

INSERT INTO Location	
						(street_address, 			postal_code,	country_id	)
VALUES					('458 Minh Khai, HN', 		10000, 			1			),
                        ('8 Bird Street, WA', 		40290, 			2			),
                        ('7 Richmond Street, TO', 	42077, 			3			);
                        
INSERT INTO Employee	
						(full_name, 			email, 					location_id	)
VALUES					('Bui Quang Huy', 		'qhuy0168@gmail.com',	1			),
                        ('Raymond Reddington', 	'nn02@gmail.com', 		2			),
                        ('Elizabeth Keen', 		'nn03@gmail.com', 		3			);

#Final assignment - Task 2
#Lấy tất cả các nhân viên thuộc Việt nam

SELECT	Employee.employee_id ,Employee.full_name
FROM 	Employee, Location, Country
WHERE	Employee.location_id = Location.location_id
		AND Location.country_id = Country.country_id
        AND Country.country_name = 'Vietnam'
;

#Lấy ra tên quốc gia của employee có email là "nn03@gmail.com"
SELECT	Country.country_name
FROM	Country, Location, Employee
WHERE	Country.country_id = Location.country_id
		AND	Location.location_id = Employee.location_id
        AND	Employee.email = 'nn03@gmail.com'
        
#Thống kê mỗi country, mỗi location có bao nhiêu employee đang làm việc
SELECT		Country.country_name AS Country, Location.street_address AS Address, COUNT(Employee.employee_id) AS Number_of_employees
FROM		Country, Location, Employee
WHERE		Country.country_id = Location.country_id
			AND	Location.location_id = Employee.location_id
GROUP BY	Country.country_name, Location.street_address


#Final assignment - Task 3
#Tạo trigger cho table Employee chỉ cho phép insert mỗi quốc gia có tối đa 10 employee
DROP TRIGGER IF EXISTS task3;
DELIMITER $$
CREATE TRIGGER task3
BEFORE INSERT ON thuctap.employee
FOR EACH ROW
BEGIN
IF NEW.location_id
IN (
	SELECT	location.location_id
	FROM	location
	WHERE	location.country_id 
		IN (
		WITH maximised_country_list AS
		(
		SELECT 		country.country_id, COUNT(employee.employee_id) AS country_count
		FROM		employee, location, country
		WHERE		employee.location_id = location.location_id AND location.country_id = country.country_id
		GROUP BY 	country.country_id
		)
		SELECT		maximised_country_list.country_id
		FROM		maximised_country_list
		WHERE		maximised_country_list.country_count = 10
		)
) THEN
	SIGNAL SQLSTATE '42000'
	SET MESSAGE_TEXT = 'Maximum number of employee reached for this location (please check if the location or country is full of vacancy)';
END IF;
END $$
DELIMITER ;

#Final assignment - Task 3
#Hãy cấu hình table sao cho khi xóa 1 location nào đó thì tất cả employee ở location đó sẽ có location_id = null
/* Bài làm:
UPDATE FOREIGN KEY ở Table Employee:
FOREIGN KEY(location_id) REFERENCES Location(location_id)
> FOREIGN KEY(location_id) REFERENCES Location(location_id) ON DELETE SET NULL
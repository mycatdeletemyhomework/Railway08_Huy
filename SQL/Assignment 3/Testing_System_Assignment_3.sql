USE 		Testing_System_Assignment_2;

-- Question 1: Thêm ít nhất 10 record vào mỗi table
#sr pass

-- Question 2:  Lấy ra tất cả các phòng ban
SELECT 		DepartmentName 
FROM 		Department;

-- Question 3: Lấy ra id của phòng ban "Sale"
SELECT 		DepartmentID, DepartmentName
FROM 		department
WHERE 		DepartmentName = 'Sale'
;

-- Question 4: : Lấy ra thông tin account có full name dài nhất
SELECT *
FROM 		`account`
WHERE 		LENGTH(FullName) = (SELECT MAX(LENGTH(FullName)) FROM `account`)
;

-- Question 4: Lấy ra thông tin account có full name dài nhất (2)
-- This method only able to fetch 1 data from the top
SELECT *
FROM 		`account`
ORDER BY 	LENGTH(FullName) DESC LIMIT 1
;

-- Question 5:  Lấy ra thông tin account có full name dài nhất và thuộc phòng ban có id = 3
SELECT *
FROM 		`account`
GROUP BY 	DepartmentID
HAVING 		DepartmentID = 3
ORDER BY 	LENGTH(FullName) DESC LIMIT 1
;

-- Question 5:  Lấy ra thông tin account có full name dài nhất và thuộc phòng ban có id = 3 (another answer)
SELECT 		*, MAX(LENGTH(FullName))
FROM 		`account`
WHERE 		DepartmentID = 3
;

-- Question 6: Lấy ra tên group đã tham gia trước ngày 20/12/2019
SELECT 		GroupName, CreateDate
FROM 		`group`
WHERE 		CreateDate >= '2019-12-20' 
;

-- Question 7: Lấy ra ID của question có >= 4 câu trả lời
SELECT 		QuestionID
FROM 		answer
GROUP BY 	QuestionID
HAVING 		COUNT(QuestionID) >= 4
;

-- Question 8: Lấy ra các mã đề thi có thời gian thi >= 60 phút và được tạo trước ngày 20/12/2019
SELECT 		ExamID, Duration, CreateDate
FROM 		exam
WHERE 		Duration >= 60 AND CreateDate >= '2019-12-20' 
;

-- Question 9:  Lấy ra 5 group được tạo gần đây nhất
SELECT 		GroupID, GroupName, CreateDate
FROM 		`group`
ORDER BY 	CreateDate DESC LIMIT 5
;

-- Question 10: Đếm số nhân viên thuộc department có id = 2
SELECT 		COUNT(DepartmentID) AS Number_of_accounts
FROM 		`account`
WHERE 		DepartmentID = 2
;

-- Question 10: Đếm số nhân viên each group
SELECT 		DepartmentID, COUNT(DepartmentID) AS Number_of_accounts
FROM 		`account`
GROUP BY 	DepartmentID
;

-- Question 11: Select User with full name begins with 'D' and end with 'l'
SELECT 		AccountID, Username, FullName
FROM 		`account`
WHERE 		FullName LIKE 'D%L'
;

-- Question 12: Xóa tất cả các exam được tạo trước ngày 20/12/2019
DELETE
FROM		exam
WHERE		CreateDate <= '2019-12-20'
;

-- Question 13: Xóa tất cả các question có nội dung bắt đầu bằng từ "What do you"
DELETE
FROM		question
WHERE		Content LIKE 'What do you%'
;

-- Question 14: Update thông tin của account có id = 5 thành tên "Nguyễn Bá Lộc" và  email thành loc.nguyenba@vti.com.vn
UPDATE 
			`account`
SET 		FullName	= 'Nguyễn Bá Lộc',
			Email		= 'loc.nguyenba@vti.com.vn'
WHERE 		AccountID = 5
;

-- Question 15: update account có id = 5 sẽ thuộc group có id = 4
UPDATE
			groupaccount
SET			GroupID		= 4
WHERE		AccountID	= 5
;

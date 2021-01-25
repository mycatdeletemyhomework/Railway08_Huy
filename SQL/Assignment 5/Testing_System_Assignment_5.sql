USE Testing_System;

-- Question 1: Tạo view có chứa danh sách nhân viên thuộc phòng ban sale
DROP VIEW IF EXISTS	employees_list_sale;
CREATE VIEW employees_list_sale AS
	SELECT		`account`.FullName, `account`.Username, department.DepartmentName
    FROM 		`account`, department
    WHERE		department.DepartmentName = 'Sale'
;

SELECT			employees_list_all.FullName, employees_list_all.Username
FROM			employees_list_all
;

-- Question 2: Tạo view có chứa thông tin các account tham gia vào nhiều group nhất
DROP VIEW IF EXISTS employees_with_many_groups;
CREATE VIEW	employees_with_many_groups AS
	SELECT		`account`.AccountID, `account`.Username, `account`.FullName
	FROM		`account`, groupaccount
	WHERE		`account`.AccountID = groupaccount.AccountID
	GROUP BY 	`account`.AccountID
	HAVING		COUNT(groupaccount.AccountID) >= ALL
												(			#get number of the groups that each member joined in	
												SELECT		COUNT(groupaccount.GroupID)
												FROM		`account`, groupaccount
												WHERE		`account`.AccountID = groupaccount.AccountID
												GROUP BY	`account`.AccountID
												)
;

SELECT 			*
FROM 			employees_with_many_groups
;

-- Question 3: Tạo view có chứa câu hỏi có những content quá dài (content quá 300 từ được coi là quá dài) và xóa nó đi (delete views, delete record in view or delete from database?)
DROP VIEW IF EXISTS too_long_question;
CREATE VIEW too_long_question AS
	SELECT 		question.QuestionID, question.Content
    FROM		question
    WHERE		LENGTH(Content) > 300
;

-- Question 4: Tạo view có chứa danh sách các phòng ban có nhiều nhân viên nhất
DROP VIEW IF EXISTS department_with_many_employees;
CREATE VIEW	department_with_many_employees AS
	SELECT		department.DepartmentID, department.DepartmentName
	FROM		`account`, department
	WHERE		`account`.DepartmentID = department.DepartmentID
	GROUP BY 	department.DepartmentID
	HAVING		COUNT(`account`.DepartmentID) >= ALL
												(			#get number of members in every department	
												SELECT		COUNT(`account`.AccountID)
												FROM		`account`
												GROUP BY	`account`.DepartmentID
												)
;

SELECT 			*
FROM 			department_with_many_employees
;

-- Question 5: Tạo view có chứa tất các các câu hỏi do user họ Nguyễn tạo (Based on the database, I will change 'user họ Nguyễn' to 'name: Tully Fermer')
DROP VIEW IF EXISTS question_by_Tully;
CREATE VIEW question_by_Tully AS
	SELECT		question.QuestionID, question.Content
    FROM		question, `account`
    WHERE		question.CreatorID = `account`.AccountID AND `account`.FullName = 'Tully Fermer'
;

SELECT 			*
FROM 			question_by_Tully
;

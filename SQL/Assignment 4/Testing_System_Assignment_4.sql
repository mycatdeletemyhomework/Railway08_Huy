USE Testing_System;

/* Exercise 1: Join */
-- Question 1: Viết lệnh để lấy ra danh sách nhân viên và thông tin phòng ban của họ (USED WHERE SYNTAX)
SELECT 		`account`.AccountID, `account`.FullName, department.DepartmentName
FROM 		`account`, department
WHERE 		`account`.DepartmentID = department.DepartmentID
;

-- Question 2: Question 2: Viết lệnh để lấy ra thông tin các account được tạo sau ngày 20/12/2010 

-- Question 3: Viết lệnh để lấy ra tất cả các developer (USED WHERE SYNTAX)
SELECT 		`account`.FullName
FROM 		`account`, `position`
WHERE 		`account`.PositionID = `position`.PositionID AND `position`.PositionName = 'Developer'
;

-- Question 4: Viết lệnh để lấy ra danh sách các phòng ban có >3 nhân viên (USED JOIN SYNTAX)
SELECT 		department.DepartmentName
FROM 		department
JOIN 		`account` ON department.DepartmentID = `account`.DepartmentID
GROUP BY 	department.DepartmentID
HAVING 		COUNT(department.DepartmentID) > 3
;

-- Question 5: Viết lệnh để lấy ra danh sách câu hỏi được sử dụng trong đề thi nhiều nhất 
SELECT 		question.QuestionID, question.Content, COUNT(question.QuestionID)
FROM 		question
JOIN 		examquestion ON question.QuestionID = examquestion.QuestionID
GROUP BY 	question.QuestionID
ORDER BY 	COUNT(question.QuestionID) DESC
;

-- Question 6: Thông kê mỗi category Question được sử dụng trong bao nhiêu Question
SELECT 		question.CategoryID, COUNT(question.CategoryID) AS Category_count
FROM 		question
GROUP BY 	question.CategoryID
;

-- Question 7: Thông kê mỗi Question được sử dụng trong bao nhiêu Exam (USED JOIN SYNTAX)
SELECT 		question.QuestionID, question.Content, COUNT(examquestion.QuestionID)
FROM 		question
JOIN 		examquestion ON question.QuestionID = examquestion.QuestionID
GROUP BY 	examquestion.QuestionID
;

-- Question 8: Lấy ra Question có nhiều câu trả lời nhất (USED ORDER BY DESC)
SELECT 		question.QuestionID, question.Content, COUNT(question.QuestionID)
FROM 		question
JOIN		answer ON question.QuestionID = answer.QuestionID
GROUP BY	question.QuestionID
ORDER BY	COUNT(question.QuestionID) DESC
;

-- Question 9: Thống kê số lượng account trong mỗi group
SELECT 		groupaccount.GroupID, COUNT(groupaccount.AccountID) AS Number_group_member
FROM		groupaccount
GROUP BY	groupaccount.GroupID
;

-- Question 10: Tìm chức vụ có ít người nhất (USED WHERE SYNTAX)
SELECT		`position`.PositionName, COUNT(`position`.PositionID) AS position_count
FROM		`position`, `account`
WHERE		`position`.PositionID = `account`.PositionID
GROUP BY	`position`.PositionID
ORDER BY 	COUNT(`position`.PositionID) ASC
;

-- Question 11: Thống kê mỗi phòng ban có bao nhiêu dev, test, scrum master, PM (USE WHERE SYNTAX)
SELECT		department.DepartmentName, `position`.PositionName, COUNT(`account`.PositionID) AS HeadCount
FROM		`account`, `position`, department
WHERE		`account`.PositionID = `position`.PositionID AND `account`.DepartmentID = department.DepartmentID
GROUP BY	`position`.PositionName
ORDER BY	department.DepartmentName, `position`.PositionName #default sort as ASC
;

-- Question 13: Lấy ra số lượng câu hỏi của mỗi loại tự luận hay trắc nghiệm (WHERE SYNTAX)
SELECT		typequestion.TypeName, COUNT(question.TypeID) AS NumberOfQuestions
FROM		typequestion ,question
WHERE		question.TypeID = typequestion.TypeID
GROUP BY	typequestion.TypeID 							#TypeName or TypeID equally
HAVING		typequestion.TypeName IN ('Essay Question', 'Multiple Choice Question')
;

-- Question 14:Lấy ra group không có account nào (USING JOIN SYNTAX)
# LEFT EXCLUDING JOIN
SELECT		`group`.GroupName
FROM		`group`
LEFT JOIN	groupaccount
ON			`group`.GroupID = groupaccount.GroupID
WHERE		groupaccount.GroupID IS NULL
;

-- Question 15:Lấy ra group không có account nào (Ủa???)

-- Question 16: Lấy ra question không có answer nào
# vẫn là LEFT EXCLUDING JOIN thoy hoặc là RIGHT :)
SELECT		question.QuestionID
FROM		question
LEFT JOIN	answer
ON			question.QuestionID = answer.QuestionID
WHERE		answer.QuestionID IS NULL
ORDER BY	question.QuestionID ASC
;

/* Exercise 2: Union */
-- Question 17a: Lấy các account thuộc nhóm thứ 1 
SELECT		`account`.Username
FROM		`account`
JOIN		groupaccount
ON			`account`.AccountID = groupaccount.AccountID
WHERE		groupaccount.GroupID = 1
;

-- Question 17b: Lấy các account thuộc nhóm thứ 2
SELECT		`account`.Username
FROM		`account`
JOIN		groupaccount
ON			`account`.AccountID = groupaccount.AccountID
WHERE		groupaccount.GroupID = 2
;

-- Question 17c: Ghép 2 kết quả từ câu a) và câu b) sao cho không có record nào trùng nhau
SELECT		`account`.Username
FROM		`account`
JOIN		groupaccount
ON			`account`.AccountID = groupaccount.AccountID
WHERE		groupaccount.GroupID = 1

UNION 		#UNION will remove duplicate

SELECT		`account`.Username
FROM		`account`
JOIN		groupaccount
ON			`account`.AccountID = groupaccount.AccountID
WHERE		groupaccount.GroupID = 2

-- Question 18a: Lấy các group có lớn hơn 5 thành viên
SELECT 		`group`.GroupName
FROM 		`group`
JOIN 		groupaccount ON `group`.GroupID = groupaccount.GroupID
GROUP BY 	`group`.GroupID
HAVING 		COUNT(groupaccount.AccountID) > 5
;

-- Question 18a: Lấy các group có nhỏ hơn 7 thành viên
SELECT 		`group`.GroupName
FROM 		`group`
JOIN 		groupaccount ON `group`.GroupID = groupaccount.GroupID
GROUP BY 	`group`.GroupID
HAVING 		COUNT(groupaccount.AccountID) <7
;

-- Question 18c:  Ghép 2 kết quả từ câu a) và câu b)
SELECT 		`group`.GroupName
FROM 		`group`
JOIN 		groupaccount ON `group`.GroupID = groupaccount.GroupID
GROUP BY 	`group`.GroupID
HAVING 		COUNT(groupaccount.AccountID) > 5

UNION

SELECT 		`group`.GroupName
FROM 		`group`
JOIN 		groupaccount ON `group`.GroupID = groupaccount.GroupID
GROUP BY 	`group`.GroupID
HAVING 		COUNT(groupaccount.AccountID) <7
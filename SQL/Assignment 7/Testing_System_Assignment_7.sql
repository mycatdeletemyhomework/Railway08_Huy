USE Testing_System;

/*==========================================================================================================*/
-- Question 1: Tạo trigger không cho phép người dùng nhập vào Group có ngày tạo 1 năm trước
DROP TRIGGER IF EXISTS old_groups;
DELIMITER $$
CREATE TRIGGER old_groups
BEFORE INSERT ON `group`
FOR EACH ROW
BEGIN
    IF DATE_SUB(NOW(), INTERVAL 1 YEAR) > NEW.CreateDate THEN
    SIGNAL SQLSTATE '42000'
    SET MESSAGE_TEXT = 'The group is older than 1 year';
    END IF;
END $$
DELIMITER ;
-- test: insert a group which is more than 1 year old
INSERT INTO `group`	(GroupName,		CreatorID,	CreateDate	)
VALUES				('Warlocks',	2,			'2019-12-20');

/*==========================================================================================================*/
-- Question 2: Tạo trigger Không cho phép người dùng thêm bất kỳ user nào vào
-- department "Sale" nữa, khi thêm thì hiện ra thông báo "Department: Sale" cannot add more user"
DROP TRIGGER IF EXISTS department_sale;
DELIMITER $$
CREATE TRIGGER department_sale
BEFORE INSERT ON `account`
FOR EACH ROW
BEGIN
	IF	(SELECT 	department.DepartmentName
		 FROM 		department, `account`
		 WHERE		department.DepartmentID = `account`.DepartmentID AND NEW.DepartmentID = department.DepartmentID
         ORDER BY 	department.DepartmentName LIMIT 1) = 'Sale'  THEN
    SIGNAL SQLSTATE '42000'
    SET MESSAGE_TEXT = 'Department: Sale cannot add more user';
    END IF;
END $$
DELIMITER ;
-- test: add new account to Sale department
INSERT INTO `account`	(Email,						Username, 	Fullname,			DepartmentID,	CreateDate	)
VALUES					('assignment2@gmail.com',	'ass2',		'assignment2',		3,				NOW()		);

/*==========================================================================================================*/
-- Question 3: Cấu hình 1 group có nhiều nhất là 5 user
DROP TRIGGER IF EXISTS maximum_users;
DELIMITER $$
CREATE TRIGGER maximum_users
BEFORE INSERT ON groupaccount
FOR EACH ROW
BEGIN
    IF 		(SELECT 	COUNT(groupaccount.AccountID)
			 FROM		groupaccount
			 GROUP BY	GroupID
			 HAVING		groupaccount.GroupID = NEW.GroupID) >= 5 THEN
    SIGNAL SQLSTATE '42000'
    SET MESSAGE_TEXT = 'Reached maximum user number';
    END IF;
END $$
DELIMITER ;  
#test: GroupID = 1 already has 5 users
INSERT INTO groupaccount 	(GroupID,	AccountID	)
VALUES						(1,			12			);

/*==========================================================================================================*/
-- Question 4: 	Cấu hình 1 bài thi có nhiều nhất là 10 Question 
-- 				(since database did not have 10 question count in examquestion, test with maximum 2 question per exam)
DROP TRIGGER IF EXISTS maximum_question;
DELIMITER $$
CREATE TRIGGER maximum_question
BEFORE INSERT ON examquestion
FOR EACH ROW
BEGIN
    IF 		(SELECT 	COUNT(examquestion.QuestionID)
			 FROM		examquestion
			 GROUP BY	ExamID
			 HAVING		examquestion.ExamID = NEW.ExamID) >= 2 THEN 
    SIGNAL SQLSTATE '42000'
    SET MESSAGE_TEXT = 'Maximum number of question reached';
    END IF;
    
END $$
DELIMITER ;
#test: ExamID = 2 already have 2 questions
INSERT INTO examquestion 	(ExamID,	QuestionID	)
VALUES						(3,			6			);

/*==========================================================================================================*/
-- Question 5:	Question 5: Tạo trigger không cho phép người dùng xóa tài khoản có email là
-- 				admin@gmail.com (đây là tài khoản admin, không cho phép user xóa),
-- 				còn lại các tài khoản khác thì sẽ cho phép xóa và sẽ xóa tất cả các thông
-- 				tin liên quan tới user đó

DROP TRIGGER IF EXISTS admin_user;
DELIMITER $$
CREATE TRIGGER admin_user
BEFORE DELETE ON `account`
FOR EACH ROW
BEGIN
	IF	(SELECT	`account`.Email
		 FROM	`account`
         HAVING	`account`.Email = OLD.Email) = 'admin@gmail.com' THEN
	SIGNAL SQLSTATE '42000'
    SET MESSAGE_TEXT = 'Admin account can not be deleted';
    END IF;
END $$
DELIMITER ;
-- test: delete admin account
DELETE FROM	`account`
WHERE		Email = 'admin@gmail.com';

/*==========================================================================================================*/
-- Question 6: 	Không sử dụng cấu hình default cho field DepartmentID của table
-- 				Account, hãy tạo trigger cho phép người dùng khi tạo account không điền
-- 				vào departmentID thì sẽ được phân vào phòng ban "waiting Department"

DROP TRIGGER IF EXISTS waiting_room;
DELIMITER $$
CREATE TRIGGER waiting_room
BEFORE INSERT ON `account`
FOR EACH ROW
BEGIN
	IF		NEW.DepartmentID IS NULL
    THEN	SET NEW.DepartmentID = 7;
    END IF;
END $$
DELIMITER ;

INSERT INTO `account`	(Email,						Username, 	Fullname		)
VALUES					('assignment6@gmail.com',	'ass6',		'assignment6'	);

/*==========================================================================================================*/
-- Question 7: 	Cấu hình 1 bài thi chỉ cho phép user tạo tối đa 4 answers cho mỗi
-- 			question, trong đó có tối đa 2 đáp án đúng
DROP TRIGGER IF EXISTS answer_standard;
DELIMITER $$
CREATE TRIGGER answer_standard
BEFORE INSERT ON answer
FOR EACH ROW
BEGIN
#set maximum answer count = 4
	IF	(SELECT 	COUNT(answer.AnswerID)
		 FROM		answer
		 GROUP BY	QuestionID
		 HAVING		answer.QuestionID = NEW.QuestionID) >= 4 THEN
    SIGNAL SQLSTATE '42000'
    SET MESSAGE_TEXT = 'Maximum number of anwsers reached for this question';
    END IF;
#set maximum answer = 'True' count = 2
    IF	(SELECT 	COUNT(answer.AnswerID)
		 FROM		answer
		 GROUP BY	QuestionID
		 HAVING		answer.QuestionID = NEW.QuestionID AND NEW.isCorrect = 'True') >= 2 THEN
    SIGNAL SQLSTATE '42000'
	SET MESSAGE_TEXT = 'Maximum number of TRUE anwsers reached for this question';
    END IF;
END $$
DELIMITER $$
#test 1: number of answer >= 4
INSERT INTO	answer	(Content,					QuestionID, isCorrect	)
VALUES				('Assignment 7 - test 1',	1, 			'TRUE'		);
#test 2: number of isCorrect >= 2
INSERT INTO	answer	(Content,					QuestionID, isCorrect	)
VALUES				('Assignment 7 - test 2',	4, 			'TRUE'		);

/*==========================================================================================================*/
-- Question 8:	Viết trigger sửa lại dữ liệu cho đúng:
-- 				Nếu người dùng nhập vào gender của account là nam, nữ, chưa xác định
-- 				Thì sẽ đổi lại thành M, F, U cho giống với cấu hình ở database
DROP TRIGGER IF EXISTS gender_rule;
DELIMITER $$
CREATE TRIGGER gender_rule
BEFORE INSERT ON `account`
FOR EACH ROW
BEGIN
	DECLARE	temp_gender VARCHAR(10);
	SELECT	NEW.Gender INTO temp_gender;
	IF		temp_gender = 'Nam' THEN SET NEW.Gender = 'M';
    ELSEIF	temp_gender = 'Nữ' THEN SET NEW.Gender = 'F';
    ELSE	SET NEW.Gender = 'U';
    END IF;
END $$
DELIMITER ;
#test 1: Gender = null > 'U'
INSERT INTO `account`	(Email,						Username, 	Fullname,			DepartmentID,	CreateDate	)
VALUES					('assignment8-1@gmail.com',	'ass8-1',	'assignment8-1',	3,				NOW()		);
#test 2: Gender = 'Nam' > 'M'
INSERT INTO `account`	(Email,						Username, 	Fullname,			Gender,			CreateDate	)
VALUES					('assignment8-3@gmail.com',	'ass8-3',	'assignment8-3',	'Nam',			NOW()		);
#test 3: Gender = 'Nữ' > 'F'
INSERT INTO `account`	(Email,						Username, 	Fullname,			Gender,			CreateDate	)
VALUES					('assignment8-4@gmail.com',	'ass8-4',	'assignment8-4',	'Nữ',			NOW()		);
/*==========================================================================================================*/

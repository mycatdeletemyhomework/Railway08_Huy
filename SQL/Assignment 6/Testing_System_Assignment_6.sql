USE Testing_System;
SET GLOBAL log_bin_trust_function_creators = 1;

# -----------------------------------------------------------------------------------------------------------
-- Question 1: Tạo store để người dùng nhập vào tên phòng ban và in ra tất cả các account thuộc phòng ban đó
DROP PROCEDURE IF EXISTS get_account_from_department;

DELIMITER $$
CREATE PROCEDURE get_account_from_department (IN department_name VARCHAR(50))
	BEGIN
        SELECT			`account`.Username
		FROM			department, `account`
        WHERE			department.DepartmentID = `account`.DepartmentID AND department.DepartmentName = department_name
		;
	END $$
DELIMITER ;

CALL	get_account_from_department('Sale');


# -----------------------------------------------------------------------------------------------------------
-- Question 2: Tạo store để in ra số lượng account trong mỗi group
-- USING STORED PROCEDURE --
DROP PROCEDURE IF EXISTS number_of_accounts;

DELIMITER $$
CREATE PROCEDURE number_of_accounts(IN group_number TINYINT, OUT o_number_of_accounts TINYINT)
	BEGIN
		SELECT			COUNT(`account`.AccountID) INTO o_number_of_accounts
        FROM			`account`, groupaccount
        WHERE			`account`.AccountID = groupaccount.AccountID AND groupaccount.GroupID = group_number;
	END $$
DELIMITER ;

SET @v_number_of_accounts = '';
CALL number_of_accounts('1', @v_number_of_accounts);
SELECT @v_number_of_accounts;

-- USING FUNCTION --
DROP FUNCTION IF EXISTS number_of_accountsf;

DELIMITER $$
CREATE FUNCTION number_of_accountsf (group_numberf TINYINT) RETURNS TINYINT
	BEGIN
		DECLARE	o_number_of_accountsf TINYINT;
        
		SELECT	COUNT(`account`.AccountID) INTO o_number_of_accountsf
		FROM	`account`, groupaccount
        WHERE	`account`.AccountID = groupaccount.AccountID AND groupaccount.GroupID = group_numberf;
        
        RETURN	o_number_of_accountsf;
	END $$
DELIMITER ;

SELECT	number_of_accountsf(1);

# -----------------------------------------------------------------------------------------------------------
-- Question 3: Tạo store để thống kê mỗi type question có bao nhiêu question được tạo trong tháng hiện tại
-- USING FUNCTION --

DROP FUNCTION IF EXISTS number_of_questions;

DELIMITER $$
CREATE FUNCTION number_of_questions (type_name VARCHAR(50)) RETURNS TINYINT
BEGIN
	DECLARE	o_number_of_questions TINYINT;
    SELECT	COUNT(question.QuestionID) INTO o_number_of_questions
    FROM	question, typequestion
    WHERE	question.TypeID = typequestion.TypeID 
			AND typequestion.TypeName = type_name
            AND	MONTH(question.CreateDate) = MONTH(NOW())
            AND YEAR(question.CreateDate) = YEAR(NOW())
            ;
    RETURN	o_number_of_questions;
END $$
DELIMITER ;

SELECT		number_of_questions('Constant Sum Question');

# -----------------------------------------------------------------------------------------------------------
-- Question 4: Tạo store để trả ra id của type question có nhiều câu hỏi nhất

-- Trong trường hợp type có >= 2 type question có nhiều câu hỏi nhất > function không thể cho ra được 2 kết quả
-- > tạo function kiếm số count của question có nhiều câu hỏi nhất
-- > dùng function này trong các thuật toán tiếp theo

# FUNCTION TÌM SỐ COUNT MAX CỦA QUESTION TYPE
DROP FUNCTION IF EXISTS most_questioned_number;

DELIMITER $$
CREATE FUNCTION most_questioned_number () RETURNS TINYINT
BEGIN
	DECLARE		o_most_questioned_number TINYINT;
    
	SELECT		typequestion.TypeName, COUNT(question.QuestionID) -- INTO o_most_questioned_number
	FROM		question, typequestion
	WHERE		question.TypeID = typequestion.TypeID
    GROUP BY	typequestion.TypeID
    HAVING		COUNT(question.QuestionID) >= ALL (	SELECT		COUNT(question.QuestionID)
													FROM		question, typequestion
                                                    WHERE		question.TypeID = typequestion.TypeID
                                                    GROUP BY	typequestion.TypeID );
    RETURN	o_most_questioned_number;
END $$
DELIMITER ;

DROP FUNCTION IF EXISTS most_questioned_number;

DELIMITER $$
CREATE FUNCTION most_questioned_number () RETURNS TINYINT
BEGIN
	DECLARE		o_most_questioned_number TINYINT;
    
	SELECT		typequestion.TypeName, COUNT(question.QuestionID) -- INTO o_most_questioned_number
	FROM		question, typequestion
	WHERE		question.TypeID = typequestion.TypeID
    GROUP BY	typequestion.TypeID
    HAVING		COUNT(question.QuestionID) = ( SELECT MAX(So_Cau_Hoi) FROM (SELECT		COUNT(question.QuestionID) AS So_Cau_Hoi
																			FROM		question, typequestion
																			WHERE		question.TypeID = typequestion.TypeID
																			GROUP BY	typequestion.TypeID ) AS t;
    RETURN	o_most_questioned_number;
END $$
DELIMITER ;

# DÙNG FUNCTION ĐỂ SELECT CÁC QUESTION ID SỬ DỤNG NHIỀU NHẤT
SELECT			typequestion.TypeID
FROM			typequestion, question
WHERE			typequestion.TypeID = question.TypeID
GROUP BY		typequestion.TypeID
HAVING			COUNT(question.QuestionID) =  most_questioned_number ()

# -----------------------------------------------------------------------------------------------------------
-- Question 5: Sử dụng store ở question 4 để tìm ra tên của type question
SELECT			typequestion.TypeName
FROM			typequestion, question
WHERE			typequestion.TypeID = question.TypeID
GROUP BY		typequestion.TypeID
HAVING			COUNT(question.QuestionID) =  most_questioned_number ()

# -----------------------------------------------------------------------------------------------------------
-- Question 6:	Viết 1 store cho phép người dùng nhập vào 1 chuỗi và trả về group có tên
-- 				chứa chuỗi của người dùng nhập vào hoặc trả về user có username chứa
-- 				chuỗi của người dùng nhập vào
--				
DROP TEMPORARY TABLE IF EXISTS	string_list;
CREATE TEMPORARY TABLE string_list (user_group VARCHAR(50));

DROP PROCEDURE IF EXISTS string_finder;
DELIMITER $$
CREATE PROCEDURE string_finder (IN searching_string VARCHAR(10))
BEGIN
	INSERT INTO	string_list
	SELECT		`account`.Username
    FROM		`account`
    WHERE		`account`.Username LIKE CONCAT('%', searching_string,'%')
    ;
    INSERT INTO	string_list
	SELECT		`group`.GroupName
    FROM		`group`
    WHERE		`group`.GroupName LIKE CONCAT('%', searching_string,'%')
    ;
END $$
DELIMITER ;

CALL string_finder ('as');
SELECT * FROM string_list;
    
-- Question 7: Viết 1 store cho phép người dùng nhập vào thông tin fullName, email và trong store sẽ tự động gán:
-- username sẽ giống email nhưng bỏ phần @..mail đi
-- positionID: sẽ có default là developer
-- departmentID: sẽ được cho vào 1 phòng chờ
-- Sau đó in ra kết quả tạo thành công

DROP PROCEDURE IF EXISTS insert_new_account;

DELIMITER $$
CREATE PROCEDURE insert_new_account (IN full_name VARCHAR(50), IN email_address VARCHAR(50))
BEGIN
	INSERT INTO `account` (Email, FullName, Username, PositionID, DepartmentID)
    VALUES 	(
			(SELECT	email_address),
            (SELECT full_name),
            (SELECT	SUBSTRING_INDEX(email_address, '@', 1)),
            (SELECT	`position`.PositionID
			 FROM	`position`
             WHERE	`position`.PositionName = 'Developer'),
			(SELECT	department.DepartmentID
             FROM	department
             WHERE	department.DepartmentName = 'Waiting Room')
			);
            
	SELECT 	*
    FROM	`account`
    WHERE	`account`.Email = email_address
    ;
	END $$
DELIMITER ;
# ROW COUNT - TÌM SỐ LƯỢNG BẢN GHI BỊ ẢNH HƯỞNG BỞI CÁC LỆNH INSERT UPDATE DELETE 
CALL insert_new_account ('Assigment 6-7', 'assignment67@gmail.com');

-- Question 8: Viết 1 store cho phép người dùng nhập vào Essay hoặc Multiple-Choice
-- để thống kê câu hỏi essay hoặc multiple-choice nào có content dài nhất

DROP PROCEDURE IF EXISTS longest_content;
DELIMITER $$
CREATE PROCEDURE longest_content (IN question_type ENUM ('Essay Question', 'Multiple Choice Question'))
BEGIN
	SELECT 		question.QuestionID, question.Content
    FROM		question, typequestion
    WHERE		question.TypeID = typequestion.TypeID 
				AND typequestion.TypeName = question_type
    ORDER BY	LENGTH(question.Content) DESC LIMIT 1
	;
    END $$
DELIMITER ;

CALL longest_content('Multiple Choice Question');

/* LENGTH(content) = (SELECT MAX(LENGTH(content)) FROM question WHERE ... */

-- Question 9: Viết 1 store cho phép người dùng xóa exam dựa vào ID
DROP PROCEDURE IF EXISTS delete_exams;
DELIMITER $$

-- Question 10: Xóa trong 2 bảng, xóa trong từng bảng, k dùng on delete cascade
-- dùng interval

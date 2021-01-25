DROP DATABASE IF EXISTS Testing_System;
CREATE DATABASE Testing_System;
USE Testing_System;

DROP TABLE IF EXISTS Department;
CREATE TABLE Department(
DepartmentID			TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
DepartmentName			VARCHAR(30) UNIQUE KEY CHECK (LENGTH(DepartmentName)>=4)
);

DROP TABLE IF EXISTS `Position`;
CREATE TABLE `Position` (
PositionID				TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
PositionName			VARCHAR(30)
);

DROP TABLE IF EXISTS `Account`;
CREATE TABLE `Account` (
AccountID				SMALLINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
Email					VARCHAR(50) UNIQUE KEY NOT NULL CHECK (LENGTH(Email)>=10),
Username				VARCHAR(50) UNIQUE KEY NOT NULL CHECK (LENGTH(Username)>=4),
FullName				VARCHAR(50) NOT NULL,
Gender					VARCHAR(10), #updated: ENUM('M', 'F', 'U') > VARCHAR TO CREATE TRIGGER
DepartmentID			TINYINT UNSIGNED, #updated: DEFAULT(1) > no DEFAULT TO CREATE TRIGGER
PositionID				TINYINT UNSIGNED DEFAULT(1),
CreateDate				DATE DEFAULT(NOW()),
FOREIGN KEY(DepartmentID) REFERENCES Department(DepartmentID),
FOREIGN KEY(PositionID)	REFERENCES `Position`(PositionID)
);

DROP TABLE IF EXISTS `Group`;
CREATE TABLE `Group` (
GroupID					TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
GroupName				VARCHAR(50) UNIQUE KEY NOT NULL,
CreatorID				SMALLINT UNSIGNED,
CreateDate				DATE DEFAULT(NOW()),
FOREIGN KEY(CreatorID) REFERENCES `Account`(AccountID)
);

DROP TABLE IF EXISTS GroupAccount;
CREATE TABLE GroupAccount (
GroupID					TINYINT UNSIGNED NOT NULL,
AccountID				SMALLINT UNSIGNED NOT NULL,
JoinDate				DATE DEFAULT(NOW()),
FOREIGN KEY(GroupID) REFERENCES `Group`(GroupID),
FOREIGN KEY(AccountID) REFERENCES `Account`(AccountID)
);

DROP TABLE IF EXISTS TypeQuestion;
CREATE TABLE TypeQuestion (
TypeID					TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
TypeName				VARCHAR(50) NOT NULL
);

DROP TABLE IF EXISTS CategoryQuestion;
CREATE TABLE CategoryQuestion (
CategoryID				TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
CategoryName			VARCHAR(50) UNIQUE KEY NOT NULL
);

DROP TABLE IF EXISTS Question;
CREATE TABLE Question (
QuestionID				TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
Content					TEXT NOT NULL,
CategoryID				TINYINT UNSIGNED NOT NULL,
TypeID					TINYINT UNSIGNED NOT NULL,
CreatorID				SMALLINT UNSIGNED,
CreateDate				DATE DEFAULT(NOW()),
FOREIGN KEY(CategoryID) REFERENCES CategoryQuestion(CategoryID),
FOREIGN KEY(TypeID)	REFERENCES TypeQuestion(TypeID),
FOREIGN KEY(CreatorID) REFERENCES `Account`(AccountID)
);

DROP TABLE IF EXISTS Answer;
CREATE TABLE Answer (
AnswerID				TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
Content					TEXT NOT NULL,
QuestionID				TINYINT UNSIGNED NOT NULL,
isCorrect				ENUM ('True', 'False'),
FOREIGN KEY(QuestionID) REFERENCES Question(QuestionID)
);

DROP TABLE IF EXISTS Exam;
CREATE TABLE Exam (
ExamID					SMALLINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
`Code`					CHAR(4) UNIQUE KEY NOT NULL DEFAULT(1),
Title					VARCHAR(50) NOT NULL,
CategoryID				TINYINT UNSIGNED NOT NULL,
Duration				TINYINT UNSIGNED,
CreatorID				SMALLINT UNSIGNED,
CreateDate				DATE DEFAULT(NOW()),
FOREIGN KEY(CategoryID) REFERENCES CategoryQuestion(CategoryID),
FOREIGN KEY(CreatorID) REFERENCES `Account`(AccountID)
);

DROP TABLE IF EXISTS ExamQuestion;
CREATE TABLE ExamQuestion (
ExamID					SMALLINT UNSIGNED NOT NULL,
QuestionID				TINYINT UNSIGNED NOT NULL,
FOREIGN KEY(ExamID) REFERENCES Exam(ExamID),
FOREIGN KEY(QuestionID) REFERENCES Question(QuestionID)
);

-- INSERT DATA TO TABLES

INSERT INTO Department	
						(DepartmentName)
VALUES					('Production'),
						('Research and Development'),
                        ('Sale'),
                        ('Marketing'),
                        ('Human Resource Management'),
                        ('Accounting and Finance'),
                        ('Waiting Room');
                        
INSERT INTO `position`	
						(PositionName)
VALUES					('Developer'),
						('Tester'),
						('Comtor'),
						('Business Analysis'),
						('Quality Assurance'),
						('Project Manager'),
						('Solution Architect'),
						('Scrum Master');
                        
INSERT INTO `account`
						(Email,								 Username,			 FullName,					DepartmentID,		PositionID )
VALUES					('tfermer0@ucla.edu', 				'tfermer0', 		'Tully Fermer', 			1, 					1		   ),
						('tgatchell1@bbb.org', 				'tgatchell1', 		'Tuck Gatchell', 			2, 					1		   ),
						('bsoutherell2@tripadvisor.com', 	'bsoutherell2', 	'Beatrisa Fermer', 			3, 					2		   ),
						('dtomley3@nymag.com', 				'dtomley3', 		'Denis Tomley', 			2, 					1		   ),
						('asteaning4@paginegialle.it', 		'asteaning4', 		'Allis Steaning', 			5, 					5		   ),
						('rwynrehame5@census.gov', 			'rwynrehame5', 		'Rodina Wynrehame', 		6, 					6		   ),
						('atanti6@eventbrite.com', 			'atanti6', 			'Amabelle Tanti', 			5, 					7		   ),
						('olewington7@seesaa.net', 			'olewington7', 		'Ophelia Lewington', 		1, 					5		   ),
						('glinklater8@w3.org', 				'glinklater8', 		'Germain Linklater', 		5, 					1		   ),
						('mmcorkil9@reference.com', 		'mmcorkil9', 		'Michaeline McOrkil', 		2, 					2		   ),
						('cjonuzia@irs.gov', 				'cjonuzia', 		'Cheri Jonuzi', 			3, 					3		   ),
						('tlamontb@ow.ly', 					'tlamontb', 		'Tessi Lamont', 			3, 					3		   ),
						('dkelsallc@ftc.gov', 				'dkelsallc', 		'Dosi Kelsall', 			4, 					4		   ),
						('cbleackleyd@myspace.com', 		'cbleackleyd', 		'Carley Bleackley', 		5, 					8		   ),
						('agerrarde@altervista.org', 		'agerrarde', 		'Annnora Gerrard', 			3, 					4		   ),
						('mkevisf@photobucket.com', 		'mkevisf', 			'Mae Kevis', 				4, 					3		   ),
						('ewahlbergg@independent.co.uk', 	'ewahlbergg', 		'Etienne Wahlberg', 		6, 					7		   ),
						('fcoyh@baidu.com', 				'fcoyh', 			'Fionna Coy', 				5, 					7		   ),
						('lcuruclisi@eepurl.com', 			'lcuruclisi', 		'Lorettalorna Curuclis', 	2, 					8		   ),
						('eribeiroj@unblog.fr', 			'eribeiroj', 		'Elsey Ribeiro', 			5, 					2		   );
                        
INSERT INTO `group`
						(GroupName,					CreatorID, 		CreateDate 		)
VALUES					('Annihilators',			1,				'2020-04-02'	),
						('Avengers',				3,				'2019-03-02'	),
						('Bad to The Bone',			5,				'2018-01-09'	),
						('Black Panthers',			7,				'2021-01-09'	),
						('Black Widows',			9,				'2016-01-09'	),
						('Blitzkrieg ',				11,				'2018-01-08'	),
						('Braindead Zombies',		13,				'2017-01-08'	),
						('Brewmaster Crew',			15,				'2015-08-04'	),
						('Brute Force',				17,				'2015-06-21'	),
						('Butchers ',				19,				'2019-05-11'	);
                        
INSERT INTO groupaccount
						(GroupID, 	AccountID, 		JoinDate	)
VALUES					(1,		 	1,				'2020-01-01'),
						(1,			2,				'2020-01-01'),
						(2,			1,				'2020-01-01'),
						(2,			4,				'2020-01-01'),
						(3,			5,				'2020-01-01'),
						(3,			2,				'2020-01-01'),
						(4,			7,				'2020-01-01'),
						(4,			8,				'2020-01-01'),
						(5,			9,				'2020-01-01'),
						(5,			10,				'2020-01-01'),
						(6,			11,				'2020-01-01'),
						(6,			12,				'2020-01-01'),
						(7,			13,				'2020-01-01'),
						(7,			14,				'2020-01-01'),
						(8,			15,				'2020-01-01'),
						(8,			16,				'2020-01-01'),
						(1,			17,				'2020-01-01'),
						(1,			18,				'2020-01-01'),
						(1,			19,				'2020-01-01');
                        
INSERT INTO typequestion
						(TypeName)
VALUES					('Essay Question'),
						('Multiple Choice Question'),
						('Rank Order Scaling Question'),
						('Text Slider Question'),
						('Likert Scale Question'),
						('Semantic Differential Scale'),
						('Stapel Scale Question'),
						('Constant Sum Question'),
						('Comment Box Open Ended Question'),
						('Text Question');
                        
INSERT INTO categoryquestion
						(CategoryName)
VALUES					('Java'),
						('C'),
                        ('Python'),
						('C++'),
						('C#'),
						('Visual Basic .Net'),
						('JavaScript'),
						('PHP'),
						('Swift'),
						('SQL');
                        
INSERT INTO question
						(Content, CategoryID, TypeID, CreatorID)
VALUES					('Please explain what you understand by computer programming.', 1, 1, 1),
						('Can you enumerate and explain the various types of errors that can occur during the execution of a computer program?', 1, 2, 3),
                        ('Please explain an algorithm. What are some of its important features?', 2, 2, 5),
                        ('What do you understand by maintaining and updating a computer program?', 2, 4, 7),
                        ('Please provide a brief explanation on variables.', 2, 4, 9),
                        ('Every programming language has reserved words. What are they? Give some examples.', 3, 4, 11),
                        ('What do you understand by loops? Briefly explain the various types of loops.', 3, 6, 13),
                        ('Please explain program documentation. Why is it important?', 3, 8, 15),
                        ('What are constants? Explain their types.', 3, 8, 17),
                        ('Please explain the operators.', 5, 1, 19),
                        ('Program documentation is the written description of the algorithm(s), coding method, design, testing, and proper use of a particular computer program. It is valuable for those who use the program on a day-to-day basis and also for the programmer(s) who are meant to correct, modify, and update the computer program. Program documentation is the written description of the algorithm(s), coding method, design, testing, and proper use of a particular computer program. It is valuable for those who use the program on a day-to-day basis and also for the programmer(s) who are meant to correct, modify, and update the computer program.', 2, 2, 1);
                        
INSERT INTO answer
						(Content, QuestionID, isCorrect)
VALUES					('Also known as coding or programming, computer programming is the process of encoding an algorithm into a notation, typically a computer program, by means of some programming language so that it can be executed by a computer.', 1, 'True'),
						('Three types of errors can occur during the execution of a computer program.', 1, 'False'),
                        ('An algorithm can be defined as a set of finite steps that when followed helps in accomplishing a particular task. Important features of an algorithm are clarity, efficiency, and finiteness.', 1, 'False'),
                        ('The maintenance and updating process of a computer program starts post its successful installation. While program maintenance is the continuous process of monitoring the computer program for bugs and errors, updating the computer program means making it better with minor and major changes over time.', 3, 'True'),
                        ('Variables are used for storing the input of a program as well as the computational results during program execution. These are actually named memory locations. The value stored in a variable can change during the program execution.', 3, 'False'),
                        ('Reserved words, also known as keywords, are the words that have predefined meanings in a particular programming language. These reserved words can’t be used or redefined for serving other purposes. Following are some examples of reserved words.', 4, 'True'),
                        ('A loop is a structure in programming that can repeat a defined set of statements for a set number of times or until a particular condition is satisfied. There are three important types of loops.', 4, 'True'),
                        ('Program documentation is the written description of the algorithm(s), coding method, design, testing, and proper use of a particular computer program. It is valuable for those who use the program on a day-to-day basis and also for the programmer(s) who are meant to correct, modify, and update the computer program.', 5, 'False'),
                        ('A constant is a programming entity whose value can’t be changed or modified during program execution. Constants are of two main types.', 5, 'True'),
                        ('Operators are used for performing certain operations on data in a computer program. These are represented by symbols. For example, / represent mathematical division while * represents multiplication.', 1, 'False');
               
INSERT INTO exam
						(`Code`,		 Title, 							CategoryID, 	Duration, 	CreatorID )
VALUES					('E001', 		'Exam for Java', 					1, 			 	60, 		1		  ),
						('E002', 		'Exam for C', 						2, 			 	120, 		3		  ),
						('E003', 		'Exam for Python', 					3, 				180, 		5		  ),
						('E004', 		'Exam for C++', 					4, 				20, 		7		  ),
						('E005', 		'Exam for C#', 						5, 				120, 		9		  ),
						('E006', 		'Exam for Visual Basic .Net', 		6, 				180, 		11		  ),
						('E007', 		'Exam for JavaScript', 				7, 				60, 		13		  ),
						('E008', 		'Exam for PHP', 					8, 				30, 		15		  ),
						('E009', 		'Exam for Swift', 					9, 				45, 		17		  ),
						('E010', 		'Exam for SQL', 					10, 			45, 		19		  );
                        
INSERT INTO examquestion
						(ExamID, 	QuestionID )
VALUES					(1, 		1		   ),
						(2, 		1		   ),
						(3, 		1		   ),
						(4, 		1		   ),
						(5, 		2		   ),
						(6, 		2		   ),
						(7, 		2		   ),
						(8, 		2		   ),
						(3, 		10		   ),
						(10, 		9		   );
                        

/* 2021-01-19 member 테이블 생성 */
CREATE DATABASE hitthegoal;

CREATE TABLE member (
	id INT AUTO_INCREMENT NOT NULL,
    member_id VARCHAR(10) NOT NULL,
    member_pw VARCHAR(20) NOT NULL,
    member_name VARCHAR(20) NOT NULL,
    email VARCHAR(30) NOT NULL,
    phone VARCHAR(30),
    profile_img VARCHAR(100),
    create_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY(id)
);
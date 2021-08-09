/* 2021-01-19 member 테이블 생성 */
/* 2021-01-21 team, team_member, goal, penalty, approval 테이블 생성 */
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

CREATE TABLE team (
	id INT AUTO_INCREMENT NOT NULL,
    team_name VARCHAR(20) NOT NULL,
    king INT,
    quantity INT DEFAULT 1,
    create_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY(id),
    FOREIGN KEY(king) REFERENCES member(id) ON UPDATE SET NULL
);

CREATE TABLE team_member (
	team_id INT NOT NULL,
    member_id INT NOT NULL,
    is_king BOOLEAN,
    create_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY(team_id, member_id),
    FOREIGN KEY(team_id) REFERENCES team(id) ON DELETE CASCADE,
    FOREIGN KEY(member_id) REFERENCES member(id)
);

CREATE TABLE goal (
	id INT AUTO_INCREMENT NOT NULL,
	team_id INT NOT NULL,
    term INT NOT NULL,
    member_id INT NOT NULL,
    contents VARCHAR(500) NOT NULL,
    is_achived BOOLEAN DEFAULT FALSE,
    create_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY(id),
    FOREIGN KEY(team_id) REFERENCES team(id) ON DELETE CASCADE,
    FOREIGN KEY(member_id) REFERENCES member(id)
);

CREATE TABLE penalty (
	id INT AUTO_INCREMENT NOT NULL,
    team_id INT NOT NULL,
    term INT NOT NULL,
    member_id INT NOT NULL,
    contents VARCHAR(500) NOT NULL,
    is_achived BOOLEAN DEFAULT FALSE,
	create_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    approvals INT DEFAULT 0,
    PRIMARY KEY(id),
    FOREIGN KEY(team_id) REFERENCES team(id) ON DELETE CASCADE,
    FOREIGN KEY(member_id) REFERENCES member(id)
);

CREATE TABLE approval (
	penalty_id INT NOT NULL,
    member_id INT NOT NULL,
    create_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY(penalty_id, member_id),
    FOREIGN KEY(penalty_id) REFERENCES penalty(id),
    FOREIGN KEY(member_id) REFERENCES member(id)
);
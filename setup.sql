CREATE DATABASE chatbot_db;
CREATE USER 'j2ee_user'@'%' IDENTIFIED BY 'J2ee@user';
GRANT ALL PRIVILEGES ON chatbot_db.* TO 'j2ee_user'@'%';

CREATE TABLE conversations(
	id int PRIMARY KEY AUTO_INCREMENT,
    user_query varchar(255) ,
    chatbot_response varchar(255),
    timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

## Use to run mysql db docker image, optional if you're not using a local mysqldb
# docker run --name mysqldb -p 3306:3306 -e MYSQL_ALLOW_EMPTY_PASSWORD=yes -d mysql

# connect to mysql and run as root user
#Create Databases
CREATE DATABASE ars_dev;

#Create database service accounts
CREATE USER 'ars_dev_user'@'localhost' IDENTIFIED BY 'password';
CREATE USER 'ars_dev_user'@'%' IDENTIFIED BY 'password';

#Database grants
GRANT SELECT ON ars_dev.* to 'ars_dev_user'@'localhost';
GRANT INSERT ON ars_dev.* to 'ars_dev_user'@'localhost';
GRANT DELETE ON ars_dev.* to 'ars_dev_user'@'localhost';
GRANT UPDATE ON ars_dev.* to 'ars_dev_user'@'localhost';

GRANT SELECT ON ars_dev.* to 'ars_dev_user'@'%';
GRANT INSERT ON ars_dev.* to 'ars_dev_user'@'%';
GRANT DELETE ON ars_dev.* to 'ars_dev_user'@'%';
GRANT UPDATE ON ars_dev.* to 'ars_dev_user'@'%';


#Create table
create table input (id bigint not null auto_increment, test_name varchar(255), test_run_id varchar(255), result BIT, started_at DATETIME, finished_at DATETIME, response_time_ms integer not null, primary key (id));

#Stored Procedure
DELIMITER $$

DROP PROCEDURE IF EXISTS `ars_dev`.`getRecord` $$
CREATE PROCEDURE `ars_dev`.`getRecord` (
    IN in_id INTEGER,
    OUT out_name VARCHAR(255),
    OUT out_result BIT,
    OUT out_time INTEGER)
BEGIN
    SELECT test_name, result, response_time_ms
    INTO out_name, out_result, out_time
    FROM input where id = in_id;
END $$

DELIMITER ;


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
GRANT EXECUTE ON PROCEDURE ars_dev.RP_INST_ALERT to 'ars_dev_user'@'localhost';
GRANT ALL ON ars_dev.RP_INST_ALERT to 'ars_dev_user'@'localhost';

GRANT SELECT ON ars_dev.* to 'ars_dev_user'@'%';
GRANT INSERT ON ars_dev.* to 'ars_dev_user'@'%';
GRANT DELETE ON ars_dev.* to 'ars_dev_user'@'%';
GRANT UPDATE ON ars_dev.* to 'ars_dev_user'@'%';
GRANT EXECUTE ON PROCEDURE ars_dev.RP_INST_ALERT to 'ars_dev_user'@'%';
GRANT ALL ON ars_dev.RP_INST_ALERT to 'ars_dev_user'@'%';


use ars_dev;


#Create table
create table input (id bigint not null auto_increment, test_name varchar(255), test_run_id varchar(255), result BIT, started_at TIMESTAMP, finished_at TIMESTAMP, response_time_ms integer not null, test_origin integer not null, primary key (id));

#Example Stored Procedure
DELIMITER $$

DROP PROCEDURE IF EXISTS `ars_dev`.`getRecord` $$
CREATE PROCEDURE `ars_dev`.`getRecord` (
    IN in_id INTEGER,
    OUT out_name VARCHAR(255),
    OUT out_result BIT,
    OUT out_time INTEGER
    )
BEGIN
    SELECT test_name, result, response_time_ms
    INTO out_name, out_result, out_time
    FROM input where id = in_id;
END $$
DELIMITER ;





CREATE TABLE alert (
    `ALERT_ID` bigint(16) NOT NULL,
    `CATEGORY` varchar(100) COLLATE utf8_bin NOT NULL,
    `COMPONENT` varchar(50) COLLATE utf8_bin NOT NULL,
    `PRIORITY` varchar(2) COLLATE utf8_bin NOT NULL,
    `ALERT_SOURCE` varchar(50) COLLATE utf8_bin NOT NULL,
    `ALERT_TIME` datetime NOT NULL,
    `ALERT_TITLE` varchar(255) COLLATE utf8_bin NOT NULL,
    `RESULTS_LINK` text COLLATE utf8_bin,
    `ERROR_COUNT` double NOT NULL DEFAULT '0',
    PRIMARY KEY (`ALERT_ID`),
    KEY `IDX_ALERT` (`CATEGORY`,`COMPONENT`,`PRIORITY`,`ALERT_SOURCE`),
    KEY `IDX_TIME` (`ALERT_TIME`)
);


DELIMITER $$
DROP PROCEDURE IF EXISTS `ars_dev`.`RP_INST_ALERT` $$
CREATE PROCEDURE `ars_dev`.`RP_INST_ALERT`(
    IN v_alert_id BIGINT(16),
    IN v_category varchar(45),
    IN v_component varchar(45),
    IN v_priority varchar(45),
    IN v_source varchar(45),
    IN v_alert_time TIMESTAMP,
    IN v_title varchar(45),
    IN v_link varchar(255),
    IN v_result_count double,
    OUT RETURN_CODE INTEGER,
    OUT ERR_MSG VARCHAR(150)
)
BEGIN
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
        BEGIN
            GET DIAGNOSTICS CONDITION 1
                @SQL_STATE = RETURNED_SQLSTATE,
                @ERROR_NO = MYSQL_ERRNO;
            SET ERR_MSG = CONCAT('Error occurred while inserting into alert_relay.alert table, Sql State: ',@SQL_STATE, ', Error No: ', @ERROR_NO);
            SET RETURN_CODE = -101;
            ROLLBACK;
        END;
    INSERT INTO alert
    VALUES (v_alert_id,
            v_category,
            v_component,
            v_priority,
            v_source,
            convert_tz(v_alert_time, '-07:00', '+00:00'),
            v_title,
            v_link,
            v_result_count);
    COMMIT;
        SET RETURN_CODE = 0;
    SET ERR_MSG = 'SUCCESS';
END $$
DELIMITER ;
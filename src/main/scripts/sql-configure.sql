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

#Mysql server
#https://hub.docker.com/_/mysql/
sudo docker run --name some-mysql -it -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root mysql --character-set-server=utf8mb4 --collation-server=utf8mb4_unicode_ci

#PhpMyAdmin
#https://hub.docker.com/r/phpmyadmin/phpmyadmin/
sudo docker run --name myadmin -it -e PMA_HOST=35.240.183.27:3306 -p 80:80 phpmyadmin/phpmyadmin

#Spring Cloud Config Server
#https://hub.docker.com/r/hyness/spring-cloud-config-server/
docker run -it -p 8888:8888 -e SPRING_PROFILES_ACTIVE=vault hyness/spring-cloud-config-server
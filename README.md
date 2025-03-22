# backend-box


## this is a feedback system


Before building the Docker image, compile your project:
### 1 mvn clean package -DskipTests

Then build the Docker image:
### 2 docker build -t backend_box .
### 3 docker-compose up --build


docker run -d \
--name mysql-local \
-p 3306:3306 \
-e MYSQL_ROOT_PASSWORD=rootpassword \
-e MYSQL_DATABASE=feedback_db \
mysql
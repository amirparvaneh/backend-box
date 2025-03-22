# backend-box


## this is a feedback system


Before building the Docker image, compile your project:
### 1 mvn clean package -DskipTests

Then build the Docker image:
### 2 docker build -t backend_box .
### 3 docker-compose up --build
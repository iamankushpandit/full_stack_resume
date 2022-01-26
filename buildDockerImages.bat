cd demographic
call mvn clean install
call mvnw spring-boot:build-image -Dspring-boot.build-image.imageName=com.example.resume/demographic
cd ..
cd education
call mvn clean install
call mvnw spring-boot:build-image -Dspring-boot.build-image.imageName=com.example.resume/education
cd ..
cd experience
call mvn clean install
call mvnw spring-boot:build-image -Dspring-boot.build-image.imageName=com.example.resume/experience
cd ..
cd headline
call mvn clean install
call mvnw spring-boot:build-image -Dspring-boot.build-image.imageName=com.example.resume/headline
cd ..
cd responsibilities
call mvn clean install
call mvnw spring-boot:build-image -Dspring-boot.build-image.imageName=com.example.resume/responsibilities
cd ..
cd tools
call mvn clean install
call mvnw spring-boot:build-image -Dspring-boot.build-image.imageName=com.example.resume/tools
cd ..
cd mycv
call docker build -t com.example.resume/frontend:latest .
cd ..
docker-compose up -d
timeout 10
call start http://localhost:3000
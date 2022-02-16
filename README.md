# Full Stack Resume

This project is a POC project to show how a full stack application can be started.  To demonstrate this I wanted to make a web application that utlizes micro services.

## Stack

|Component|Description| 
|----------|-------------|
|Services|Micro services are build using SpringBoot, Java 8, Maven and Reactor.|
|Front End|The UI is based on React and Node JS.| 
|Database|PostgreSQL|
|Containerization|Docker, Docker Compose|


## Idea
The idea is to build a resume application where the collection of different attributes of a candidate can demonstarte the use of the stack mentioned above. Utilizing the micro frontend and micro service architecture it will be a good idea to divide all these attribute section in to a vertical slice i.e. Each section of the resume should be supported by different set of micro services so that if one fails the whole resume UI should be effected.

Also even thought the rest services did not need to be fully CRUD in this resume web application they were designed to be fully CRUD so that if the application is ever advanced to be a used for other applicant there can be other UI components that can be created for entering and updating details.

## Architecture
![Architecture](https://github.com/iamankushpandit/full_stack_resume/blob/main/fsr.png?raw=true)

The application is divided in to 3 layers. These 3 layers can be divided in to 8 services:
#### A. Fornt-end : 
  1. resume-frontend : This service is built using react js and node js and dockerized.
#### B. Data Base : 
  1. postgres : This service is a postgresql db with table listed in the image above and dockerized.
#### C. Rest services:
  1. demographicservice : This service is a CRUD springboot service that manages demograophic information for a candidate. 
  2. educationservice : This service is a CRUD springboot service that manages education infomration like degrees and certification for a candidate. 
  3. experienceservice : This service is a CRUD springboot service that manages experience infomration like Job profiles, Awards, Conference and open source contributions for a candidate
  4. headlineservice : This service is a CRUD springboot service that manages one paragraph detailing infomation about a candidate. 
  5. responsibilitiesservice : This service is a CRUD springboot service that manages responsibilities inforamation for a candidate. 
  6. toolsservice : This service is a CRUD springboot service that manages education infomration like skills in different tools for a candidate. 

#### Docker Compose
Docker compose is used to tie all of the services together. The yml file describes
a. Container name
b. Any Environment variables.
c. Internal and external port
d. dependency within each other
e. volumes if applicable. 

Initially in the development process this is all setup locally to test.  For the local environment, for each service a docker image is created.
For the maven based back end services the following command was used.
```
mvnw spring-boot:build-image -Dspring-boot.build-image.imageName=com.example.resume/<service-name>
```
For the frontend service the following command was used.
```  
docker build -t com.example.resume/frontend:latest 
```  
For the data base the base and latest postgresql image was used.

When the ``` docker-compose up ``` is executed on the directory containing the docker-compose yml file, Docker will download the latest image which in this case was local and then bring them up based on the dependency defined.

## Outcome
A local web application is created whoes UI is hosted on http:\\localhost:3000 and the respective backend services on their ports specified in the application.properties file. The postgresql databased starts on 5432 port. The UI is designed to be open on the computer or a phone browser.

## Cloud
### Heroku
#### Failure
### AWS
#### Failure
#### Work Around

## Outcome

## CI-CD

## Future Thoughts:
Breaking the UI in to micro front end architecture.

https://bit.ly/3LkzcX5

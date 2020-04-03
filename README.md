# govtech-assessment-project-2020

### Introduction
This basic springboot project required MongoDB as a datasource, locally or dockerize.

### Setup Environment

You may run this application locally within Intellij, by setup the 

**application.properties** file


#### Setting Datasource conection Properties

```properties
spring.data.mongodb.host=localhost
spring.data.mongodb.port=27017
spring.data.mongodb.database=GAP
spring.data.mongodb.repositories.type=auto
```

Run on Intellij

Try (http://localhost:8080/users)


### Run on Docker ENV

Use the docker mongoDB private IP,
to search for Mongo docker private ip
```bash
Docker inspect <containerID> | grep "IPAddress"
```

[Example] 172.17.0.2
```properties
spring.data.mongodb.host=172.17.0.2
spring.data.mongodb.port=27017
spring.data.mongodb.database=GAP
spring.data.mongodb.repositories.type=auto
```


### To run application on Docker Env
- maven build - deploy
- run terminal cmd 
```
cd/..<PROJECT_DIR>

docker build  -f Dockerfile -t govtech-assessment-project .

docker run -d -p 8080:8080 govtech-assessment-project

```

Try (http://localhost:8080/users)


For any issues setting up
My Email `programmnighup@gmail.com`
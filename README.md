Hello and welcome to my portfolio. Here, I have added a few of my recent projects. 
  1.  Donation Database


		Intro:

      		A Project using Talend Open Studio for an enterprise using an Oracle and an Azure SQL database. 
      	Purpose:

     		For an employee at a nonprofit organization to be able to insert donation lists into the database by importing a
      		filled out CSV file into Talend Open Studio rather than inputting records manually. This project also verifies
      		the integrity of the records being inserted and rejects the values that are not acceptable. For example, a record
      		has an address that is not in the city where donations are being collected from. In this case, the program will
      		create a new rejected values CSV file or use an existing one if there is one, and add the rejected row
      		to the CSV file.
Job Overview: 
	
 ![Job Design Overview](https://github.com/amaansheikhh/Portfolio/assets/98118572/053c9c09-508c-497c-a94a-cf3585e38763)


ERD:
	
 ![ERD UPDATED_2023-11-17](https://github.com/amaansheikhh/Portfolio/assets/98118572/65934335-dd4d-4025-ba2c-f0cfd9c102fe)

2. Java Springboot Application

Intro: 

	A Java project that I created in my Enterprise Java Development class using Thymeleaf and Spring. 
 	The project uses the following dependencies: 
 		1. Spring Data JPA
  		2. Spring Security
   		3. Thymeleaf
    	4. Spring Web
     	5. H2 Database
Purpose: 

	I created this application for an assignment. However, it is a great example of database security and assigning privileges using Java. 

How it works: 

	Once the project has been executed, it will be available on the local host. The port configured is 8080. Therefore, it is then 
 	accessible from 'http://localhost:8080/'. The user will then have two options, to authenticate a user or a manager. 
  	One user and one manager have been configured by default.
  		
    		User: 
   				Username: bugs
     			Password: bunny
       		Manager: 
       			Username: daffy
				Password: duck
    
	
  	To add a user, log in as a manager(daffy) and create a user with either user or manager privileges.
   Adding a user: 
   
   ![image](https://github.com/amaansheikhh/Portfolio/assets/98118572/93ac4b9b-fad5-4811-a8d3-0f48648f7f4c)

   Logging into the new user that was created: 
   	
![image](https://github.com/amaansheikhh/Portfolio/assets/98118572/cbbbd7ec-2ac5-45c1-bd47-7a01bd61cb87)
![image](https://github.com/amaansheikhh/Portfolio/assets/98118572/248a2440-5451-4303-ae4c-c28403fbb4eb)

  	The source code for this application is in the 'JavaSpringSecurityProject_2' branch. 
  
   
3. CRUD JPA Project

	Intro:
	

		In this project, I made a CRUD(Create, Read, Update, Delete) library database in Java using JPA (Java Persistence API)
		which allows us to map objects to a relational database table.
	
 	Purpose:

  		

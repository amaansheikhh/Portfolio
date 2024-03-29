Hello and welcome to my portfolio. Here, I have added a few(5) of my recent projects. 
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

	I created this application for an assignment. However, it is a great example of database security and assigning privileges 
 	using Java. 

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

   		Made in IntelliJ IDEA.

	Intro:
	

		In this project, I made a CRUD(Create, Read, Update, Delete) library database in Java using JPA (Java Persistence API)
		which allows us to map objects to a relational database table.
	
 	Purpose:

		This application was made to be a character database which could also be used as an employee database after renaming a
		few fields.    
  		
	How it works:

		Similarly to project #3, this project requires you to open an IDE and execute the application. After executing,
		the application will be ready for use at 'http://localhost:8080/'.
		New Avengers can be added to the database and added Avengers can be edited or deleted.
		After any changes have been submitted, the database is then updated immediately.

		Accessing the database: 
			Navigate to 'http://localhost:8080/h2-console'.
   			A login page will appear. Use the following credentials to log in. 
			Driver Class: 'org.h2.Driver'
   			JDBC URL: 'jdbc:h2:mem:sheridandb'
			Username: 'sa'
   			The password field should be left empty.
   		 Once the connect button has been pressed, the database should appear (figure 3.4).   

Home Page: 

![image](https://github.com/amaansheikhh/Portfolio/assets/98118572/e2d39dfe-e2b4-4aaf-8e73-6ee37a8338c2) (figure 3.1)

Adding an avenger: 

![image](https://github.com/amaansheikhh/Portfolio/assets/98118572/7cb0d051-a387-4437-9549-7b70527dbf9a) 
(figure 3.2) 

![image](https://github.com/amaansheikhh/Portfolio/assets/98118572/b5f75e51-1dce-479b-880b-852eee2fc948) 
(figure 3.3)

Database SELECT statement after adding an avenger: 

![image](https://github.com/amaansheikhh/Portfolio/assets/98118572/68ba5bd8-256a-4355-abcb-3890858e03f9)

(figure 3.4).

	The source code for this application is in the 'JavaCrudJpaProject_3' branch. 

4. Simple greeting card generator app made with Angular.

    	Made in Visual Studio Code using Javascript, Typescript, JSON, HTML & CSS.

 	Intro:

		This project is a card generator made using Angular.
	Purpose:

  		This application was made to generate cards based on the user's choice of message, color scheme, and either round
		or edge border style.

	How it works:

		Once the project is opened in Visual Studio Code, within the IDE, open a Command Prompt window and run the
		'ng serve' command. This will compile the program and launch it to a local host.
		Once the program has compiled successfully, it will be accessible from 'http://localhost:4200/'.
		The following page will appear: Refer to figure 4.1.

 	![image](https://github.com/amaansheikhh/Portfolio/assets/98118572/28fb3bc0-eb61-474f-975f-46602ea11d90)
	(Figure 4.1)

		Once the user chooses fields for the three drop-down lists, the user would click 'Click to create card' and the card
		will then appear. I have inserted two examples below. Please refer to figure 4.2 and 4.3.

	![image](https://github.com/amaansheikhh/Portfolio/assets/98118572/784eeaf0-0e2a-4b3e-9e6d-6fbe657d8c12)
	(Figure 4.2)

	![image](https://github.com/amaansheikhh/Portfolio/assets/98118572/898de581-c392-4a61-9e24-4a5a75f6d833)
	(Figure 4.3)

  		The source code for this application is in the 'AngularProj_4' branch. 

	
 
5. Employee Directory Application

    		Made in Apache Netbeans IDE 13.0 using Java and FXML.

 	Intro:

		Employee Directory Application made using JavaFX.

	Purpose:

		The purpose of this application is to act as an employee directory for a business. The application has the ability
		to add, edit, and delete employees. Unfortunately, the application does not have the feature to link to a database
		and the directory is therefore always going to be empty at start-up. If a business was to use this application, we
		would add the necessary feature of uploading the data inputted by the user into a database. This would ensure that
		the user is still able to see all of their data after reopening the application.

	UML Diagram:

	![UML DIAGRAM](https://github.com/amaansheikhh/Portfolio/assets/98118572/95d6b76e-7c50-4591-947c-ce335868443f)


	How it works:

		Once the project is executed in Apache Netbeans, the employee directory application will appear. Please refer to
  		figure 5.1. 
    
  	![image](https://github.com/amaansheikhh/Portfolio/assets/98118572/6fbbbd19-b102-4ff3-acc9-7de8789ea187)
  	(figure 5.1)
		
  		Once the user presses the "Add Employee" button, the Add Employee page will appear. Please refer to
    		figure 5.2. 
  	
  	![image](https://github.com/amaansheikhh/Portfolio/assets/98118572/b0777a0d-35ca-48c0-b97c-9f786af2b735)
  	(figure 5.2)


   		The user would then fill in the fields with an employee's details. Please refer to Figure 5.3 for an example.
   		After that, they would press submit. They will then notice that all of the fields will clear. The user has two options,
   		they can fill in the details of another employee that they want to add or they can press the home button. Now once the
   		user presses the Home button, they will be able to see the updated employee directory with the new employee added.
   		A screenshot of the updated employee list is below, please refer to Figure 5.4.
   		 
   	![image](https://github.com/amaansheikhh/Portfolio/assets/98118572/1324b827-a81c-417b-8141-99e35657858f)
   	(figure 5.3)
   	![image](https://github.com/amaansheikhh/Portfolio/assets/98118572/9a0b554b-00e2-4b00-b820-8217bdffe110)
   	                                                                                              (figure 5.4)

   		Now, let's look into editing an employee's information. By clicking on the employee from the home page list, a more info
   		page will appear. Please refer to Figure 5.5 for a screenshot showing what the page will look like. The user can press
   		edit or delete at the bottom of the page. Pressing edit will enable the fields to be editable so that the user can
   		change the employee's details. Once the user is done editing, pressing Save will make the changes and disable editing the
   		fields. Now once the user clicks home, they will see the updated values in the employee list. Pressing delete will remove
   		the employee permanently. 

   	![image](https://github.com/amaansheikhh/Portfolio/assets/98118572/9015f0c5-5563-4900-90d1-b40d1de10f01)
   	(figure 5.5)

		The source code for this project is available under 'EmployeeDirectory-JavaFX' branch.  

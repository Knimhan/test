#Steps to run the project :
> This project is java maven project so once you unzip the directory.  Please follow the below steps:

-----------------------------------------------------------------------------------------------------------------------
#### Step 1. Open terminal and goto the basediretory :

	cd /path_to_project/HeavenHRTest

#### Step 2. Run Project
##### a. Using Maven :
		You must have maven installed on your machine :
		If maven is not installed, use https://maven.apache.org/install.html to install.
		If maven is already installed : mvn spring-boot:run

#### Step 3. To check, the REST apis of web application. Open browser and go to below url:

		http://localhost:8080/swagger-ui.html

		Hurray !
		Application is ready to use.
------------------------------------------------------------------------------------------------------------------------
-
#### Step 4 : To run the test of the application :
		a. First stop the application(assuming you were already running the application using above steps) using following keys : ctrl+c

		b. As this project is Maven project. If you run project using maven commands, test will automatically starts while running the application. Using following commands on terminal to run application via maven.
	 	mvn clean install spring-boot:run


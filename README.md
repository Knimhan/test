# HeavenHRTest
## Task

Build a backend service that handles a (very simple) recruiting process. The process requires two types of objects: job offers and applications from candidates.
minimum required fields for the objects are:

    Offer:
        jobTitle (unique)
        startDate
        numberOfApplications

    Application:
        related offer
        candidate email (unique per Offer)
        resume text
        applicationStatus (APPLIED, INVITED, REJECTED, HIRED)
Not all of the fields have to be persisted. You may use ad hoc calculation, event sourcing, or whatever you see fit. These are the fields that must be returned by the API. You may add fields where necessary.

## Use cases

- user has to be able to create a job offer and read a single and list all offers.
- candidate has to be able to apply for an offer.
- user has to be able to read one and list all applications per offer.
- user has to be able to progress the status of an application.
- user has to be able to track the number of applications.
- status change triggers a notification (*)

(*) a log output will suffice as a notification here, but you should design it as if each status change triggers a completely different business case.

##Documentation
	Project name : HeavenHR Test
------------------------------------------------------------------------------------------------------------------------
##Steps to run the project:
	Please refer run-readme.md file.
------------------------------------------------------------------------------------------------------------------------
##Project Modules :
	This project consists of only back-end services
	
##Project architectural points:
	Points regarding the development phase:

#### 1. Modularise :
	For the time being I have modulerise the project on package level.
	Later we can also modularise in maven modules.

------------------------------------------------------------------------------------------------------------------------
#### 2. DTO :
	It stands for Data Transfer Object.
	In this project DTO are used to send as response object from rest controller.

------------------------------------------------------------------------------------------------------------------------
#### 3. RESTful API design :	
	Backend consists following restful apis i.e.
	a. /api/offers - used for all offer related services
	b. /api/applications - used for application services.

------------------------------------------------------------------------------------------------------------------------
#### 4. Exception Handler via Aspect :
	Added aspect for exception handling at rest layer and send appropriate http status and error messages.
	1. com.heavenhr.web.business.error -> consists of all user defined errors
	2.com.heavenhr.web.business.rest.exception.RestResponseEntityExceptionHandler -> Takes care of throwing exceptions in user readable format. Handles exceptions like BadRequestException, NotFoundException and other runtime exceptions. Also, takes care of all ban validation exceptions like typeMismatch, methodArguments, messageNotReaadable.
	

------------------------------------------------------------------------------------------------------------------------
#### 5. Dozer mapper used :
	Dozer bean mapper is used to map two objects and its fields. Mappings files have been written in resources/dozer folder. Dozer mapper is used for offers, applications and date objects.
	

------------------------------------------------------------------------------------------------------------------------

#### 6. Plugins used :
	Lombok reduces boiler plate code by not writing getters and setters. sLombok : https://projectlombok.org/

------------------------------------------------------------------------------------------------------------------------
#### 7. Unit tests:
	Unit test written using testNG and only exception thrown use cases.

------------------------------------------------------------------------------------------------------------------------
#### 8. Testing and documentation for RESTful apis:
	Swagger : http://swagger.io/
	I’ve added swagger framework for testing the apis.

------------------------------------------------------------------------------------------------------------------------
#### 9. Comments :
	Entire code styling is influenced by Clean Code principle - Robert Martin
	Which says
	'Truth can only be found in one place: the code’.
	So you may not found any comments anywhere in the project.
	Keeping in mind that git can be used to manage version of file and method name should be kept as self explanatory. However, if you need comments on each file. I can do that too.

------------------------------------------------------------------------------------------------------------------------
#### 10. Design principles used in Project :
	a. SOLID (single responsibility, open-closed, Liskov subsitution, interface segregation, dependency inversion) principle,
	b. Composition over inheritance,
	c. DRY(Don’t repeat yourself),
	d. Test only exceptions,
	e. KISS(Keep it simple, stupid)

------------------------------------------------------------------------------------------------------------------------
#### 11. Area of improvements :
	a. Test cases:
	I have written only exception thrown test case we can also write the positive test cases in future.
	b. resumeText stored in applicationEntity have been stored as a String only. As this can be a large file we can use blob.
	c. CandidateEntity can be created and mapped to ApplicationEntity to maintain list of all applications by per applicant. 
	


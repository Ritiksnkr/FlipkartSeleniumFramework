# Flipkart

This project is developed to build Automation test classes for the https://www.flipkart.com/ site. This is assignment of widely used POM framework in selenium using Java as scripting language. Maven is used for dependency management and continuous development. TestNG is used to maintain test cases.

It has implementation of different profiles and including RemoteWebDriver, ,ExtentReport, Screenshot, Logger implementation and more.

## IDE used- 
* eclipse

## Technologies/tools/frameworks/libraries- 
* Java
* Selenium
* maven
* testng


# Steps to install the project:

## What you'll need to install:
Any code editor or IDE like eclipse, intellij, etc.

  * JDK 6 or later

  * Maven

  * TestNg
      
      
## Set up the project

* #### Downlaod project in your local machine and import the Project.

* #### src/test/java/com.pages Package contains Page Objects classes.
* #### src/test/java/com.tests package contains the Test classes.
* #### To change the browser, enter the browser name either chrome/edge/firefox inside /config.properties files.
* #### To check the error report goto Flipkart/ExtentReports/.
* #### To check Screenshots goto Flipkart/ScreenCaptures/.

* #### Downlaod the chrome driver as per your chrome browser version if required and put it inside src/main/resorces/Drivers/.

## Modes
#### Headless:
* To run tests in headless mode, change mode = headless in config.properties
#### Non-Headless:
* To run tests in non-headless mode, change mode = non-headless in config.properties

## In order to run the tests
  #### From Command Line:
  * open cmd.
  * cd [Path of project] like - c:/projectName.
  * mvn clean install.
  
  #### From IDE:
  * Run testng.xml as testng suite.



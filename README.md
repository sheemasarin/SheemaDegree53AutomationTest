# SheemaDegree53AutomationTest

**Framework followed** : The testsuite is in BDD format using cucumber framework ,Adhering to all best practices.
**Maven** : I have created a maven project and added all the dependencies required for Selenium,Cucumber,Testng,WebDriverManager etc in POM.xml file
**Folder Structure** : It has src-test-java .under src-test-java it has 
**Trainline.pageobjects** :I have declared page objects for the screens in the package
**trainline.framework** : I have created all the utilities in this package
**trainline** : stepDefinitions.java-It has selenium code to whwtever steps are there in feature file ,for each and every step there is mapping
                RunParallel.java - tests are executable from this class
Feature file : Feature file is present in the src-test-resources package
Reports : testng report is available as index.html report,emailable-report.html of test-output folder
                
## To Run
To Run test - Run RunParallel.java file with TestNg

## To Add tests
Add tests in resources/trainline folder
##Every example in scenario will run parallelly

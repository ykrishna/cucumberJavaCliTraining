**Run cucumber feature files using Cucumber CLI**

download all cucumber(2.4.0) dependencies from maven https://mvnrepository.com/search?q=io.cucumber
keep them all in bin folder

Folder Structure:

    -- bin
    -- features
    -- step_definitions


following jars needed as of today:

    cucumber-core-2.4.0.jar		
    cucumber-java8-2.4.0.jar	// use only for java8 lambda style
    cucumber-jvm-deps-1.0.6.jar	  
    hamcrest-core-1.3.jar		
    tag-expressions-1.1.1.jar  
    cucumber-java-2.4.0.jar		// recomended  
    cucumber-junit-2.4.0.jar	 
    gherkin-5.0.0.jar		
    junit-4.12.jar  
    selenium-server-standalone-3.11.0.jar
    
create a feature file under feature directory as documentation.feature 

    Feature: test feature

    Scenario Outline: test scenario
    Given I open "<site>" site
    Examples:
      | site             |
      | http://bbc.co.uk |

CLI runner:

    java -cp "bin/*:." cucumber.api.cli.Main --help  
    java -cp "bin/*:." cucumber.api.cli.Main features -p pretty --snippets camelcase

you will see following output

    Feature: test feature

    Scenario Outline: test scenario # features/documentation.feature:11
    Given I open "<site>" site

    Examples: 

    Scenario Outline: test scenario        # features/documentation.feature:15
    Given I open "http://bbc.co.uk" site # null

    1 Scenarios (1 undefined)
    1 Steps (1 undefined)
    0m0.013s


    You can implement missing steps with the snippets below:

    @Given("^I open \"([^\"]*)\" site$")
    public void iOpenSite(String arg1) {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
    }

now create a MyStepdefs.java as follows 
      
      package step_definitions; // package is very important

     //import cucumber.api.PendingException;
      import cucumber.api.java.en.Given;
      import org.openqa.selenium.WebDriver;
      import org.openqa.selenium.firefox.FirefoxDriver;
      import org.openqa.selenium.firefox.FirefoxOptions;


      public class MyStepdefs {
       @Given("^I open \"([^\"]*)\" site$")
       public void iOpenSite(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
       }
     }

compile code:

    javac -cp "bin/*:."  step_definitions/*.java

run code 

    java -cp "bin/*:." cucumber.api.cli.Main features -g step_definitions -p pretty 

you will see following output:

    Feature: test feature

    Scenario Outline: test scenario # features/documentation.feature:3
    Given I open "<site>" site

    Examples: 

    Scenario Outline: test scenario        # features/documentation.feature:7
    Given I open "http://bbc.co.uk" site # MyStepdefs.iOpenSite(String)

    1 Scenarios (1 passed)
    1 Steps (1 passed)
    0m0.094s


_glue option always looks for package name instead og path to step defs_


      

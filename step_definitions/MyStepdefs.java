/**
 * Created by krishnayalavarthi on 24/03/2018.
 */

package step_definitions;

//import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


public class MyStepdefs {

//    private FirefoxOptions options = new FirefoxOptions().setHeadless(true);
//    private WebDriver driver = new FirefoxDriver(options);

    @Given("^I open \"([^\"]*)\" site$")
    public void iOpenSite(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
//        driver.get(arg0);
//        driver.quit();
//        System.out.println("<----The End---->");
    }
}

package step_definitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;
import utilities.Driver;

public class Login_stepDefinitions {

    LoginPage loginPage = new LoginPage();

    @Given("User is on the login page")
    public void user_is_on_the_login_page() {
        Driver.get().get(ConfigurationReader.get("url"));
    }

    @When("User enter {string} and {string}")
    public void userEnterUsernameAndPassword(String username, String password)  {
        loginPage.login(username, password);
        WebDriverWait wait = new WebDriverWait(Driver.get(), 10);
        wait.until(ExpectedConditions.urlContains("dashboard"));

        String currentURL = Driver.get().getCurrentUrl();
        String expectedUrl = "http://library1.cydeo.com/#dashboard";

        Assert.assertEquals(expectedUrl, currentURL);

    }

    @Then("Verify user logged in successfully")
    public void verify_user_logged_in_successfully() {

    }



}

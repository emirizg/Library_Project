package step_definitions;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;
import utilities.Driver;

import static io.restassured.RestAssured.given;

public class Login_stepDefinitions {

    LoginPage loginPage = new LoginPage();

    String token;

    Response response;

    @Given("I logged Library api using {string} and {string}")
    public void i_logged_Library_api_using_and(String email, String password) {
        response = given().accept(ContentType.JSON)
                .and()
                .header("x-library-token", ConfigurationReader.get("token"))
                .when()
                .get(ConfigurationReader.get("base_url") + "/get_book_categories");




    }

    @When("I get the current user information from api")
    public void i_get_the_current_user_information_from_api() {


    }

    @Then("status code should be {int}")
    public void status_code_should_be(Integer int1) {
        Assert.assertEquals(response.getStatusCode(), 200);
    }


    @Given("User is on the login page")
    public void user_is_on_the_login_page() {
        Driver.get().get(ConfigurationReader.get("url"));
    }

    @When("Librarian enter {string} and {string}")
    public void LibrarianEnterUsernameAndPassword(String username, String password)  {
        loginPage.login(username, password);
        WebDriverWait wait = new WebDriverWait(Driver.get(), 10);
        wait.until(ExpectedConditions.urlContains("dashboard"));
    }

    @Then("Verify Librarian logged in successfully")
    public void verify_Librarian_logged_in_successfully() {
        String currentURL = Driver.get().getCurrentUrl();
        String expectedUrl = "http://library1.cydeo.com/#dashboard";
        Assert.assertEquals(expectedUrl, currentURL);
    }

    @When("Student enter {string} and {string}")
    public void student_enter_and(String username, String password) {
        loginPage.login(username, password);
        WebDriverWait wait = new WebDriverWait(Driver.get(), 10);
        wait.until(ExpectedConditions.urlContains("books"));
    }

    @Then("Verify Student logged in successfully")
    public void verify_Student_logged_in_successfully() {
        String currentURL = Driver.get().getCurrentUrl();
        String expectedUrl = "http://library1.cydeo.com/#books";
        Assert.assertEquals(expectedUrl, currentURL);
    }

    @When("User enter {string} and {string}")
    public void user_enter_and(String username, String password) {
        loginPage.login(username, password);
        WebDriverWait wait = new WebDriverWait(Driver.get(), 10);
        wait.until(ExpectedConditions.visibilityOf(loginPage.errorMessage));
    }

    @Then("Verify user can not log in")
    public void verify_user_can_not_log_in() {
        Assert.assertTrue(loginPage.errorMessage.isDisplayed());
    }



}

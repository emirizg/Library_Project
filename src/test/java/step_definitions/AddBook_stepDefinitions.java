package step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import utilities.ConfigurationReader;

import java.util.LinkedHashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class AddBook_stepDefinitions {

    Response response;

    @When("I post add book function in api")
    public void iPostAddBookFunctionInApi() {
        Map<String, Object> postRequestMap=new LinkedHashMap<>();

        postRequestMap.put("name", "Red Book");
        postRequestMap.put("isbn", "123456789-123");
        postRequestMap.put("year", 2000);
        postRequestMap.put("author", "Redhood");
        postRequestMap.put("book_category_id", 8);
        postRequestMap.put("description", "Mysterious");



        response = given().contentType("application/x-www-form-urlencoded")
                .and()
                .header("x-library-token", ConfigurationReader.get("token"))
                .body(postRequestMap)
                .when()
                .post(ConfigurationReader.get("base_url") + "/add_book");

        response.statusCode();
    }

    @Then("verify added book is visible on database")
    public void verifyAddedBookIsVisibleOnDatabase() {

    }
}

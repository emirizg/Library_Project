package utilities;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class LibraryAPIUtil {

    //teacher , student-member,student-leader
    //it will take user info from conf.properties
    public static String getTokenByRole(String role){
        //switch,if make sure you get correct user info
        //send request/get token/ return token
        String email, pass;

        switch (role) {

            case "librarian":
                email = Environment.LIBRARIAN_EMAIL;
                pass = Environment.LIBRARIAN_PASSWORD;
                break;
            case "student":
                email = Environment.STUDENT_EMAIL;
                pass = Environment.STUDENT_PASSWORD;
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + role);
        }

        String accessToken =
                given()
                        .accept(ContentType.JSON)
                        .queryParams("email",email,"password",pass)
                        .when()
                        .get(Environment.BASE_URL+"/sign")
                        .then()
                        .statusCode(200)
                        .extract().jsonPath().getString("accessToken");

        System.out.println(role+":"+accessToken);
        return "Bearer " + accessToken;



    }

}

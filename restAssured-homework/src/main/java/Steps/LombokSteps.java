package Steps;

import Data.Data;
import Models.BookingRequest;
import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

import static io.restassured.RestAssured.given;

public class LombokSteps {
    @Step("Get Response")
    public BookingRequest getResponse(String body) {

        var response = given()
                .filter(new AllureRestAssured())
                .contentType(ContentType.JSON)
                .cookie("token", getToken())
                .body(body)
                .when()
                .put("https://restful-booker.herokuapp.com/booking/" + Data.ID);
        response.then().statusCode(200);
        return response.as(BookingRequest.class);
    }

    private String getToken() {

        RestAssured.baseURI = "https://restful-booker.herokuapp.com";

        JSONObject auth = new JSONObject();
        auth.put("username", "admin");
        auth.put("password", "password123");

        Response authResponse =
                given()
                        .contentType(ContentType.JSON)
                        .body(auth.toJSONString())
                        .post("/auth");

        JsonPath jsonPath = authResponse.jsonPath();
        String token = jsonPath.getString("token");
        return token;
    }

}

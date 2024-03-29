package Api;

import AutoGeneratedPOJOs.ResponseFail;
import AutoGeneratedPOJOs.ResponsePOJO;
import AutoGeneratedPOJOs.User;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class RegisterAndGetUser {
    @Test
    public void registerUser() {
        RestAssured.baseURI = "https://reqres.in/api";

        JSONObject parameters = new JSONObject();
        parameters.put("email", "eve.holt@reqres.in");
        parameters.put("password", "pistol");

        JSONObject errorParameters = new JSONObject();
        errorParameters.put("email", "sydney@fife");

        Response response = given()
                .contentType(ContentType.JSON)
                .body(errorParameters)
                .post("/register");

        if (response.getStatusCode() == 200) {
            var castedResponse = response.as(ResponsePOJO.class);
            Assert.assertTrue(castedResponse.getId() == 4);
            Assert.assertEquals(castedResponse.getToken(), "QpwL5tke4Pnpja7X4");
        }

        if (response.getStatusCode() == 400) {
            var castedResponse = response.as(ResponseFail.class);
            Assert.assertEquals(castedResponse.getError(), "Missing password");
        }
    }

    @Test
    public void getUser() {
        RestAssured.baseURI = "https://reqres.in/api";

        JSONObject parameters = new JSONObject();
        parameters.put("name", "morpheus");
        parameters.put("job", "leader");

        var var = given()
                .contentType(ContentType.JSON)
                .body(parameters)
                .post("/users")
                .as(User.class);

        System.out.println(var.getId() + var.getName() + var.getJob());

    }
}

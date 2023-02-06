import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.assertThat;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class TokenAndHamcrest {

    @Test
    public void delete() {
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";
        int id = 13;

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

        Response response = given()
                .contentType(ContentType.JSON)
                .cookie("token", token)
                .delete("/booking/" + id);

        Assert.assertTrue(response.getStatusCode() == 201);
    }

    @Test
    public void hamcrest() {
        given()
                .when()
                .get("http://ergast.com/api/f1/2017/circuits.json")
                .then()
                .assertThat()
                .body("MRData.CircuitTable.Circuits.circuitId", hasItem("marina_bay"))
                .body("MRData.CircuitTable.Circuits.Location[1].country", equalTo("USA"))
                .body("MRData.CircuitTable.Circuits.Location[-1].country", equalTo("UAE"));

        String longitude = given()
                        .get("http://ergast.com/api/f1/2017/circuits.json")
                        .then()
                        .extract()
                        .path("MRData.CircuitTable.Circuits[-1].Location.long");

        assertThat(Double.parseDouble(longitude), anyOf(greaterThan(1.0), equalTo(10.0)));
    }
}

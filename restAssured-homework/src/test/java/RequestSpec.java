import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.junit.Test;
import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static io.restassured.RestAssured.given;

public class RequestSpec {

    int id = 2;

    @Test
    public void update() throws IOException {
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

        JSONObject bookingDetails = new JSONObject();
        bookingDetails.put("firstname", "Giorgi");
        bookingDetails.put("lastname", "Cxad");
        bookingDetails.put("totalprice", 12344);
        bookingDetails.put("depositpaid", true);

        JSONObject bookingDates = new JSONObject();
        bookingDates.put("checkin", "2023-02-03");
        bookingDates.put("checkout", "2023-02-04");

        bookingDetails.put("bookingdates", bookingDates);
        bookingDetails.put("additionalneeds", "Sleep");

        RequestSpecification request = given()
                .contentType(ContentType.JSON)
                .body(bookingDetails.toJSONString());

        Response response = given()
                .spec(request)
                .cookie("token", token)
                .put("booking/" + id)
                .then()
                .extract().response();

        System.out.println(response.getStatusCode());

        response.then()
                .log().ifStatusCodeIsEqualTo(200);
    }

    @Test
    public void validates() {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String currentTime = formatter.format(date);

        given()
                .baseUri("https://chercher.tech/sample/api/")
                .when()
                .get("/product/read")
                .then()
                .assertThat()
                .body("records[-1].name", equalTo("test"))
                .body("records.created", everyItem(lessThan(currentTime)))
                .extract().jsonPath();
    }
}
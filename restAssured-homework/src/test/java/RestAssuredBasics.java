import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class RestAssuredBasics {

    @BeforeTest
    public void before() {
        RestAssured.baseURI = "http://ergast.com/api/f1";
    }

    @DataProvider(name = "dp")
    public static Object[][] dataProvider() {

        Response response = given()
                .when()
                .get("/2017/circuits.json");
        System.out.println(response.asString());

        String firstCircuit = response.jsonPath().getString("MRData.CircuitTable.Circuits[1].circuitId");
        String firstCountry = response.jsonPath().getString("MRData.CircuitTable.Circuits[1].Location.country");
        String fifthCircuit = response.jsonPath().getString("MRData.CircuitTable.Circuits[5].circuitId");
        String fifthCountry = response.jsonPath().getString("MRData.CircuitTable.Circuits[5].Location.country");

//        given()
//                .when()
//                .get("/circuits/" + firstCircuit);
//
//       given()
//                .when()
//                .get("/circuits/" + fifthCircuit);


        return new Object[][] {
                {firstCircuit, firstCountry},
                {fifthCircuit, fifthCountry}
        };
    }

    @Test(dataProvider = "dp")
    public void APITest(String circuit, String country) {

        System.out.println(circuit);
        System.out.println(country);

        given()
                .pathParam("circuitId", circuit)
                .when()
                .get("/circuits/{circuitId}.json")
                .then()
                .assertThat()
                .body("MRData.CircuitTable.Circuits.Location[1].country", equalTo(country));
    }
}

package Step;

import Data.Data;
import Request.Envelope;
import Request.GetListByName;
import Response.ListByNameResponse;
import Services.RequestService;
import io.restassured.RestAssured;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Objects;

import static io.restassured.RestAssured.given;

public class StepClass {

    public ListByNameResponse getList(String name) throws FileNotFoundException {

        File file = new File(Objects.requireNonNull(getClass().getClassLoader().getResource("Request.xml")).getFile());

        Envelope getListRequestModel = RequestService.getListByName(name);
        RestAssured.baseURI = Data.BASE_URL;

        return given()
                .contentType("text/xml;charset=UTF-8").and()
                .header("SOAPAction", "http://tempuri.org/SOAP.Demo.GetListByName")
                .body(file)
                .when().log().all()
                .post(Data.BASE_URL)
                .then().log().ifError()
                //.assertThat().statusCode(200)
                .extract().body().xmlPath().getObject("Envelope.Body.GetListByNameResponse.GetListByNameResult.PersonIdentification", ListByNameResponse.class);
    }

}

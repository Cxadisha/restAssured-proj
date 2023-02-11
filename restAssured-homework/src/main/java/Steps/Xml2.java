package Steps;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;

import java.io.File;

public class Xml2 {

    public void validateStreetAndZip() {

        File file = new File(getClass().getClassLoader().getResource("findPersonRequest.xml").getFile());

        Response response = RestAssured.given()
                .baseUri("https://www.crcind.com")
                .basePath("/csp/samples/SOAP.Demo.CLS?WSDL=1")
                .header("SOAPAction", "http://tempuri.org/SOAP.Demo.FindPerson")
                .body(file)
                .post();

        String homeStreet = response.xmlPath().getString("Envelope.Body.FindPersonResponse.FindPersonResult.Home.Street");
        String officeZip = response.xmlPath().getString("Envelope.Body.FindPersonResponse.FindPersonResult.Office.Zip");

        Assert.assertEquals(homeStreet, "6894 Clinton Place");
        Assert.assertEquals(officeZip, "73302");

    }

}

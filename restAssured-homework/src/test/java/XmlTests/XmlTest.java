package XmlTests;

import Steps.Xml2;
import Steps.XmlResponseSteps;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import java.io.File;

public class XmlTest {

    public XmlResponseSteps xml = new XmlResponseSteps();
    public Xml2 xml2 = new Xml2();

    @Test
    public void continentsTest() {
        xml.validateCount().validateList().validateAnName().validateLastName();
    }

    @Test
    public void XmlTest2() {
        xml2.validateStreetAndZip();
    }
}

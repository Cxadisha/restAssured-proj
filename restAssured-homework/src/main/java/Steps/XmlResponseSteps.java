package Steps;

import Response.XmlResponse;
import org.junit.Assert;

public class XmlResponseSteps {

    public XmlResponse xmlResponse = new XmlResponse();

    public XmlResponseSteps validateCount() {
        Assert.assertEquals(xmlResponse.sNameCount, 6);
        return this;
    }

    public XmlResponseSteps validateList() {
        for (int continent = 0; continent < xmlResponse.continents.size(); continent++) {
            Assert.assertEquals(xmlResponse.continents.get(continent), xmlResponse.xmlContinents.get(continent));
        }
        return this;
    }

    public XmlResponseSteps validateAnName() {
        Assert.assertEquals(xmlResponse.AnName, "Antarctica");
        return this;
    }

    public void validateLastName() {
        Assert.assertEquals(xmlResponse.lastsName, "The Americas");
    }
}

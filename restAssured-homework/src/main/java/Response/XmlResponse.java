package Response;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import java.util.ArrayList;
import java.util.List;
import static io.restassured.RestAssured.given;

public class XmlResponse {

    public Response response = given().when().get("http://webservices.oorsprong.org/websamples.countryinfo/CountryInfoService.wso/ListOfContinentsByName");
    public XmlPath xmlPath = new XmlPath(response.asString());
    public int sNameCount = xmlPath.getInt("ArrayOftContinent.tContinent.sName.size()");
    public List<String> continents = new ArrayList<>(List.of("Africa", "Antarctica", "Asia", "Europe", "Ocenania", "The Americas"));
    public List<Object> xmlContinents = xmlPath.getList("ArrayOftContinent.tContinent.sName");
    public String AnName = xmlPath.getString("ArrayOftContinent.tContinent.find{it.sCode == 'AN'}.sName");
    public String lastsName = xmlPath.getString("ArrayOftContinent.tContinent[-1].sName");
}

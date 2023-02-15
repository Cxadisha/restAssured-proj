package Steps;

import Data.Data;
import Models.Records.BooksResponseModel;
import Models.Records.RecordModel;
import Models.Records.TokenModel;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

import static io.restassured.RestAssured.given;

public class RecordSteps {

    public RecordModel record = new RecordModel(Data.userName, Data.password);

    @Step
    public Response getResponseModel() {
        return given()
                .when()
                .baseUri(Data.URL)
                .basePath("/User")
                .contentType(ContentType.JSON)
                .body(record)
                .post();
    }

    @Step
    public RecordSteps validateBooksSize() {
        BooksResponseModel response = getResponseModel().as(BooksResponseModel.class);
        Assert.assertTrue(response.books().size() == 0);
        return this;
    }

    @Step
    public RecordSteps validateGeneratedToken() {

        var response = given()
                .when()
                .baseUri(Data.URL)
                .basePath("/GenerateToken")
                .contentType(ContentType.JSON)
                .body(record)
                .post();
        var responseClass = response.as(TokenModel.class);

        Assert.assertEquals(responseClass.status(), Data.SUCCESS);
        Assert.assertEquals(responseClass.result(), Data.RESULT);

        return this;
    }

    @Step
    public RecordSteps validateAuthorization() {

        var response = given()
                .when()
                .baseUri(Data.URL)
                .basePath("/Authorized")
                .contentType(ContentType.JSON)
                .body(record)
                .post();

        Boolean responseBool = response.body().as(Boolean.class);
        Assert.assertTrue(responseBool);
        return this;
    }
}

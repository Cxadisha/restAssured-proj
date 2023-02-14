package LombokTests;

import Data.Data;
import Data.dp;
import Models.BookingRequest;
import Steps.LombokSteps;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LombokTest {

    ObjectMapper mapper;
    LombokSteps lombokSteps = new LombokSteps();

    @Test(dataProvider = "dataProviderDP", dataProviderClass = dp.class)
    public void test(BookingRequest details) throws JsonProcessingException {

        mapper = new ObjectMapper();

        var response = lombokSteps.getResponse(mapper.writeValueAsString(details));

        Assert.assertEquals(response.getTotalPrice(), 123);
        System.out.println(response.getFirstname());
        System.out.println(Data.ID);
    }
}

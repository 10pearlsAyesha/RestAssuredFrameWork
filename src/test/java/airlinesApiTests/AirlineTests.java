package airlinesApiTests;

import RestUtils.RestUtils;
import airlinesApiTests.pojos.Airline;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class AirlineTests extends AirlineAPIs {
/*    static AllureRestAssured allureFilter = new AllureRestAssured()
            .setRequestTemplate("my-http-request.ftl")
            .setResponseTemplate("my-http-response.ftl");*/
    // TODO: Implement Airline tests here
    @Test
    @Story("REST-001")
    public void createAirLineTest() {
        String baseUrl = "https://api.instantwebtools.net/v1/airlines";

        String payLoad = Payloads.getAirlinePayloadViaString("252d3bca-d9bb-476c-9a97-562d685e235c", "10Pearls Airways", "Pakistan",
                "https://upload.wikimedia.org/wikipedia/en/thumb/9/9b/Qatar_Airways_Logo.svg/sri_lanka.png", "From Pakistan", "Karachi, Pakistan", "http://10pearls.com", "2004");
        Response response = RestUtils.performPost(baseUrl, payLoad, new HashMap<>());
        Assert.assertEquals(response.statusCode(), 200);
    }

    @Test
    @Story("REST-002")
    @Description("This is Creating a new Airline")
    public void createAirLineTestWithMap() {
        Map<String, Object> payLoad = Payloads.getAirlinePayloadByMap("252d3bca-d9bb-476c-9a97-562d685e235c", "10Pearls Airways", "Pakistan",
                "https://upload.wikimedia.org/wikipedia/en/thumb/9/9b/Qatar_Airways_Logo.svg/sri_lanka.png", "From Pakistan", "Karachi, Pakistan", "http://10pearls.com", "2004");
        Response response = createAline(payLoad);
        Assert.assertEquals(response.statusCode(), 200);
    }

    @Test
    @Story("REST-002")
    @Description("This is Creating a new Airline with Java/Data Faker")
    public void createAirLineTestWithJavaFaker() {
        Map<String, Object> payLoad = Payloads.getAirlinePayloadByFakerClass();
        Response response = createAline(payLoad);
        Assert.assertEquals(response.statusCode(), 200);
    }

    @Test
    @Story("REST-004")
    @Description("This is Creating a new Airline with Java/Data Faker")
    public void createAirLineTestWithPojo() {
        Airline payLoad = Payloads.getAirlinePayloadUsingPojo();
        Response response = createAline(payLoad);
        Assert.assertEquals(response.statusCode(), 200);
    }

    @Test
    @Story("REST-001")
    @Description("This is Getting Airline By ID")
    public void getAirlinesByID() {
        Response response = getAirline();
        Assert.assertEquals(response.statusCode(), 200, "Status code should be 200.");
        String actualId = response.jsonPath().getString("_id");
        Assert.assertEquals(actualId, "28321851-bfd1-4f46-bf5a-c0a3e099ff8e", "The AirlineID cannot be found!");
    }


}

package airlinesApiTests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.RestUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class AirlineTests {

    // TODO: Implement Airline tests here
    @Test
    public void createAirLineTestByPayloadString() {
        String baseUrl = "https://api.instantwebtools.net/v1/airlines";
        String payLoad = Payloads.getArilinePayloadViaString("252d3bca-d9bb-476c-9a97-562d685e235c","10Pearls Airways","Pakistan","https://upload.wikimedia.org/wikipedia/en/thumb/9/9b/Qatar_Airways_Logo.svg/sri_lanka.png","From Pakistan","Karachi, Pakistan","www.10pearls.com","2004");
        Response response = RestUtils.performPost(baseUrl, payLoad, new HashMap<>());

        Assert.assertEquals(response.statusCode(), 200);
    }

    @Test
    public void createAirLineTestByMap() {
        String baseUrl = "https://api.instantwebtools.net/v1/airlines";
        Map <String, Object> payLoad= Payloads.getArilinePayloadByMap("252d3bca-d9bb-476c-9a97-562d685e235c","10Pearls Airways","Pakistan","https://upload.wikimedia.org/wikipedia/en/thumb/9/9b/Qatar_Airways_Logo.svg/sri_lanka.png","From Pakistan","Karachi, Pakistan","www.10pearls.com","2004");

        Response response = RestUtils.performPost(baseUrl, payLoad, new HashMap<>());

        Assert.assertEquals(response.statusCode(), 200);
    }
}
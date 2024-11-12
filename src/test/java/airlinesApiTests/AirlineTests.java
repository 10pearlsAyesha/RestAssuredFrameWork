package airlinesApiTests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.RestUtils;

import java.util.HashMap;

public class AirlineTests {

    // TODO: Implement Airline tests here
    @Test
    public void createAirLineTest() {
        String baseUrl = "https://api.instantwebtools.net/v1/airlines";
        String payLoad = "{\n" +
                "    \"_id\": \"252d3bca-d9bb-476c-9a97-562d685e235c\",\n" +
                "    \"name\": \"10Pearls Airways\",\n" +
                "    \"country\": \"Pakistan\",\n" +
                "    \"logo\": \"https://upload.wikimedia.org/wikipedia/en/thumb/9/9b/Qatar_Airways_Logo.svg/sri_lanka.png\",\n" +
                "    \"slogan\": \"From Pakistan\",\n" +
                "    \"head_quaters\": \"Karachi, Pakistan\",\n" +
                "    \"website\": \"www.10pearls.com\",\n" +
                "    \"established\": \"2004\"\n" +
                "}";

        Response response = RestUtils.performPost(baseUrl, payLoad, new HashMap<>());

        Assert.assertEquals(response.statusCode(), 200);
    }

    @Test
    public void createAirLineTest2() {
        String baseUrl = "https://api.instantwebtools.net/v1/airlines";
        String payLoad = "{\n" +
                "    \"_id\": \"252d3bca-d9bb-476c-9a97-5624334c\",\n" +
                "    \"name\": \"Siraj Airways\",\n" +
                "    \"country\": \"Pakistan\",\n" +
                "    \"logo\": \"https://upload.wikimedia.org/wikipedia/en/thumb/9/9b/Qatar_Airways_Logo.svg/sri_lanka.png\",\n" +
                "    \"slogan\": \"From Pakistan\",\n" +
                "    \"head_quaters\": \"Karachi, Pakistan\",\n" +
                "    \"website\": \"www.10pearls.com\",\n" +
                "    \"established\": \"2004\"\n" +
                "}";

        Response response = RestUtils.performPost(baseUrl, payLoad, new HashMap<>());

        Assert.assertEquals(response.statusCode(), 200);
    }
}
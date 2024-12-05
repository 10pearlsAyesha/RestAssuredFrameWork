package airlinesApiTests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import RestUtils.RestUtils;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class CreateAndGetAirline {

    private String baseUrl = "https://api.instantwebtools.net/v1/airlines";
    public String createdAirlineId;

    @Test(priority = 1)
    public void createNewAirline() {
        String requestBody = "{\n" +
                "    \"name\": \"Ayesha3 Airline\",\n" +
                "    \"country\": \"Pakistan\",\n" +
                "    \"logo\": \"https://testlogo.com\",\n" +
                "    \"slogan\": \"Testing the Skies\",\n" +
                "    \"head_quaters\": \"New York, USA\",\n" +
                "    \"website\": \"https://testairline.com\",\n" +
                "    \"established\": \"2023\"\n" +
                "}";
        Response response = RestUtils.performPost(baseUrl, requestBody, new HashMap<>());
        Assert.assertEquals(response.statusCode(), 200);
        // Log the entire response for debugging
        System.out.println("Response Body: " + response.getBody().asString());
        createdAirlineId = response.jsonPath().getString("_id");
        // Handle the case where the ID is not found
        if (createdAirlineId == null) {
            System.out.println("ID not found in the response.");
        } else {
            System.out.println("Created Airline ID: " + createdAirlineId);
        }
    }

    @Test(priority = 2, dependsOnMethods = {"createNewAirline"})
    public void getAirlineById() {
        String baseUrl2 = baseUrl + "/" + createdAirlineId;;
        System.out.println(baseUrl2);
        Response response = RestUtils.performGet(baseUrl2, new HashMap<>());
        Assert.assertEquals(response.statusCode(), 200, "Status code should be 200.");
       String actualId = response.jsonPath().getString("_id");
        Assert.assertEquals(actualId, createdAirlineId, "The airline ID does not match the created ID.");

    }
}
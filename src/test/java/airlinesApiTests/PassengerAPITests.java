package airlinesApiTests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import org.testng.Assert;
import org.testng.annotations.Test;
import airlinesApiTests.pojos.Passenger;
import airlinesApiTests.pojos.Passenger.Airline;
import utils.BaseTest;

import java.util.Collections;

import static io.restassured.RestAssured.given;

public class PassengerAPITests extends BaseTest {

    static String passengerId;

    @Test(priority = 1, description = "Create a new passenger")
    public void createPassenger() {
        // Create airline object
        Airline airline = new Airline();
        airline.set_id("66038402-402d-4a3f-baef-7cb5f53697a8");
        airline.setName("Haulmer Airlines");

        // Create passenger object
        Passenger passenger = new Passenger();
        passenger.setName("John Doe");
        passenger.setTrips(5);
        passenger.setAirline(Collections.singletonList(airline));

        Response response = given()
                .contentType(ContentType.JSON)
                .body(passenger)
                .post("/passenger");

        // Log the response for debugging
        System.out.println("Response Body: " + response.getBody().asString());

        Assert.assertEquals(response.getStatusCode(), 200,
                "Expected status code 200, but received: " + response.getStatusCode());

        // Correctly extract the passenger ID
        passengerId = response.jsonPath().getString("_id");
        Assert.assertNotNull(passengerId, "Passenger ID is null");
    }

    @Test(priority = 2, dependsOnMethods = "createPassenger", description = "Read passenger details")
    public void readPassenger() {
        Response response = given()
                .get("/passenger/" + passengerId);

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().getString("name"), "John Doe");
    }

    @Test(priority = 3, dependsOnMethods = "createPassenger", description = "Update passenger name")
    public void updatePassengerName() {
        String updatedName = "Jane Doe";

        // Send the PATCH request to update the passenger name
        Response response = given()
                .contentType(ContentType.JSON)
                .body("{ \"name\": \"" + updatedName + "\" }")
                .patch("/passenger/" + passengerId);

        // Log the response for debugging
        System.out.println("Response Body (Update): " + response.getBody().asString());

        // Validate the status code and success message
        Assert.assertEquals(response.getStatusCode(), 200,
                "Expected status code 200, but received: " + response.getStatusCode());
        Assert.assertEquals(response.jsonPath().getString("message"), "Passenger data updated successfully.",
                "Update message does not match expected value.");

        // Perform a GET request to verify the name update
        Response getResponse = given()
                .get("/passenger/" + passengerId);

        // Log the response of the GET request for debugging
        System.out.println("Response Body (Verify Update): " + getResponse.getBody().asString());

        Assert.assertEquals(getResponse.getStatusCode(), 200,
                "Expected status code 200 for retrieving passenger, but received: " + getResponse.getStatusCode());

        // Validate the updated name
        String retrievedName = getResponse.jsonPath().getString("name");
        Assert.assertEquals(retrievedName, updatedName,
                "Updated name does not match expected value.");
    }


    @Test(priority = 4, dependsOnMethods = "createPassenger", description = "Delete passenger")
    public void deletePassenger() {
        // Perform DELETE request to remove the passenger
        Response response = given()
                .delete("/passenger/" + passengerId);

        // Log the DELETE response for debugging
        System.out.println("Response Body (Delete): " + response.getBody().asString());

        // Validate the status code and success message
        Assert.assertEquals(response.getStatusCode(), 200,
                "Expected status code 200, but received: " + response.getStatusCode());
        Assert.assertEquals(response.jsonPath().getString("message"), "Passenger data deleted successfully.",
                "Delete message does not match expected value.");

        // Perform a GET request to verify the deletion
        Response verifyResponse = given()
                .get("/passenger/" + passengerId);

        // Log the GET response for debugging
        System.out.println("Response Body (Verify Delete): " + verifyResponse.getBody().asString());

        // Verify the status code or response for the deleted passenger
        Assert.assertTrue(
                verifyResponse.getStatusCode() == 404 || verifyResponse.getStatusCode() == 204,
                "Expected status code 404 or 204 for deleted passenger, but received: " + verifyResponse.getStatusCode()
        );

        // If the server sends 204, ensure the response body is empty
        if (verifyResponse.getStatusCode() == 204) {
            Assert.assertTrue(verifyResponse.getBody().asString().isEmpty(),
                    "Expected an empty body for 204 response, but received: " + verifyResponse.getBody().asString());
        }
    }


}

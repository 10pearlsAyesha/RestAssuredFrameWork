package utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.Map;

public class RestUtils {
    // Implement REST API calls here
    // Example: GET, POST, PUT, DELETE methods

    public static Response performPost(String endPoint, Map <String,Object> requestPayload, Map<String, String> headers) {
        return RestAssured.given().log().all()
                .baseUri(endPoint)
                .contentType(ContentType.JSON)
                .headers(headers)
                .body(requestPayload)
                .post()
                .then()
                //.statusCode(200) // Assert status code is 200
                .log().all().extract().response();

    }
    public static Response performPost(String endPoint, String requestPayload, Map<String, String> headers) {
        return RestAssured.given().log().all()
                .baseUri(endPoint)
                .contentType(ContentType.JSON)
                .headers(headers)
                .body(requestPayload)
                .post()
                .then()
                //.statusCode(200) // Assert status code is 200
                .log().all().extract().response();

    }
    // Perform GET Request
    public static Response performGet(String endPoint, Map<String, String> headers) {
        return RestAssured.given().log().all()
                .baseUri(endPoint)
                .headers(headers)
                .get()
                .then()
                .log().all()
                .extract().response();
    }
}
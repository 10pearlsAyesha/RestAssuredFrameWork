package airlinesApiTests;

import RestUtils.RestUtils;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class AirlineAPIs {
    public Response createAline(Map<String, Object> createAirlinePayload) {
        String endPoint = (String) Base.dataFromJsonFile.get("createAirLineEndPoint");
        return RestUtils.performPost(endPoint, createAirlinePayload, new HashMap<>());
    }
}
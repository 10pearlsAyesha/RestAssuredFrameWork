package airlinesApiTests;

import utils.JsonUtils;

import java.io.IOException;
import java.util.Map;


public class Base {
    public static Map<String, Object> dataFromJsonFile;

    static{
        try{
            dataFromJsonFile = JsonUtils.getJsonDataAsMap("airlines/qa/airlineAPIData.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

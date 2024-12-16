package airlinesApiTests;

import airlinesApiTests.pojos.Airline;
import net.datafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

import java.util.HashMap;
import java.util.Map;

public class Payloads {
    public static String getAirlinePayloadViaString (String id, String name, String country, String logo,
                                                    String slogan, String head_quaters, String website, String established) {
        String payLoad = "{\n" +
                "    \"_id\": \""+id+"\",\n" +
                "    \"name\": \""+name+"\",\n" +
                "    \"country\": \""+country+"\",\n" +
                "    \"logo\": \""+logo+"\",\n" +
                "    \"slogan\": \""+slogan+"\",\n" +
                "    \"head_quaters\": \""+head_quaters+"\",\n" +
                "    \"website\": \""+website+"\",\n" +
                "    \"established\": \""+established+"\"\n" +
                "}";
        return payLoad;
    }

    public static Map<String, Object> getAirlinePayloadByMap(String id, String name, String country, String logo,
                                                             String slogan, String head_quaters, String website, String established) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("id", id);
        payload.put("name", name);
        payload.put("country", country);
        payload.put("logo", logo);
        payload.put("slogan", slogan);
        payload.put("head_quaters", head_quaters);
        payload.put("website", website);
        payload.put("established", established);
        return payload;
    }

    public static Map<String, Object> getAirlinePayloadByFakerClass() {
        Map<String, Object> payload = new HashMap<>();
        Faker faker = new Faker();

        payload.put("id", faker.number().digits(6));
        payload.put("name", faker.name().firstName());
        payload.put("country", faker.address().country());
        payload.put("logo", RandomStringUtils.randomAlphabetic(25));
        payload.put("slogan", RandomStringUtils.randomAlphabetic(25));
        payload.put("head_quaters", faker.address().city());
        payload.put("website", "https://" + RandomStringUtils.randomAlphabetic(10) + ".com");
        payload.put("established", faker.number().numberBetween(2000, 2023));

        return payload;
    }

    public static Airline getAirlinePayloadUsingPojo() {
        Faker faker = new Faker();
        return Airline
                .builder()
                .id(Integer.parseInt(faker.number().digits(6)))
                .name(faker.name().firstName())
                .country(faker.address().country())
                .logo(RandomStringUtils.randomAlphabetic (25))
                .slogan (RandomStringUtils.randomAlphabetic(20))
                .head_quaters(faker.address().cityName())
                .website("https://" + RandomStringUtils.randomAlphabetic (10) + ".com")
                .established(String.valueOf(faker.number().numberBetween (1900, 2020)))
                .build();
    }
}

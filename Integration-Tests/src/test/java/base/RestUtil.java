package base;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class RestUtil {

    public static String END_POINT = "";
    public static String REQUEST_BODY = "";
    public static Map<String, String> headers = new HashMap<>();
    Response response;

    public void setBaseURI(String baseURI) {
        RestAssured.baseURI = baseURI;
    }

    public void setEndpoint(String endpoint) {
        END_POINT = endpoint;
    }

    public void setRequestBody(String body) {
        REQUEST_BODY = body;
    }

    public void setHeader(String key, String value) {
        headers.put(key, value);
    }

    public Response hitEndpoint(String method) {

        if (method.equalsIgnoreCase("GET")) {
            response =
                    RestAssured.given()
                            .contentType(ContentType.JSON)
                            .headers(headers)
                            .when()
                            .get(END_POINT);

        } else if (method.equalsIgnoreCase("POST")) {
            response = RestAssured.given()
                    .contentType(ContentType.JSON)
                    .headers(headers)
                    .body(REQUEST_BODY)
                    .when()
                    .post(END_POINT);
        }
        return response;
    }

    public void verifyStatusCodeAs(int expectedStatusCode) {
        Assert.assertEquals(response.statusCode(), expectedStatusCode, "Status code is not matching with the expected : " + expectedStatusCode);
    }
}

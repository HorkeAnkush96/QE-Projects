package base.api;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import utilities.PropertiesFileReader;

public class RestUtil extends APIBaseTest {

	static String END_POINT;
	static String PAYLOAD;
	static String CONTENT_TYPE;
	static String TOKEN;
	static Map<String, String> headers = new HashMap<String, String>();

	public RestUtil() {
		propertiesFileReader= new PropertiesFileReader();
		RestAssured.baseURI = propertiesFileReader.getProperty("qa.base.uri");
	}

	public void setEndpoint(String endpoint) {
		END_POINT = endpoint;
	}

	public void setRequestPayload(String payload) {
		PAYLOAD = payload;
	}

	public void setToken(String token) {
		TOKEN = token;
	}

	public void setContentType(String type) {
		CONTENT_TYPE = type;
	}

	public Response hitEndpoint(String method) {

		if (method.equalsIgnoreCase("GET")) {

		} else if (method.equalsIgnoreCase("POST")) {
			response = RestAssured.given().contentType(CONTENT_TYPE).body(PAYLOAD).post(END_POINT);
			Assert.assertEquals(response.statusCode(), 200, "**** User unable to creat booking *****");
			System.out.println(response.asPrettyString());
		}

		return response;
	}

}

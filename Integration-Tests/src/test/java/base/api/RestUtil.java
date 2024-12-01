package base.api;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import pojos.ResponseDataPojo;
import utilities.PropertiesFileReader;

public class RestUtil extends APIBaseTest {

	static String END_POINT;
	static String PAYLOAD;
	static String CONTENT_TYPE;
	static String TOKEN;
	static Map<String, String> headers = new HashMap<String, String>();

	public RestUtil() {
		propertiesFileReader = new PropertiesFileReader();
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
		ObjectMapper mapper = new ObjectMapper();

		if (method.equalsIgnoreCase("GET")) {

		} else if (method.equalsIgnoreCase("POST")) {
			response = RestAssured.given().contentType(CONTENT_TYPE).body(PAYLOAD).post(END_POINT);
			Assert.assertEquals(response.statusCode(), 200, "**** User unable to creat booking *****");
			System.out.println(response.asPrettyString());
		}

		try {
			responseData = mapper.readValue(response.asString(), ResponseDataPojo.class);
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return response;
	}

}

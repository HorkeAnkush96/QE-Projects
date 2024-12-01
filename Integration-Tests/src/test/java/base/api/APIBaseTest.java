package base.api;

import io.restassured.response.Response;
import pojos.ResponseDataPojo;
import pojos.UserRequestData;
import utilities.PropertiesFileReader;

public class APIBaseTest {

	public static String TOKEN = "";

	PropertiesFileReader propertiesFileReader;

	public static RestUtil restUtil = new RestUtil();

	public static Response response;

	public static UserRequestData requestData = new UserRequestData();

	public static ResponseDataPojo responseData = new ResponseDataPojo();

}

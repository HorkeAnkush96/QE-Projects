package base.api;

public class RequestJsonData {

	public static String TOKEN_PAYLOAD = "{\"firstname\":\"%s\",\"lastname\":\"%s\",\"totalprice\":111,\"depositpaid\":true,\"bookingdates\":{\"checkin\":\"%s\",\"checkout\":\"%s\"},\"additionalneeds\":\"Breakfast\"}";

	public static String CREATE_USER_PAYLOAD = "{\"firstname\":\"%s\",\"lastname\":\"%s\",\"totalprice\":111,\"depositpaid\":true,\"bookingdates\":{\"checkin\":\"%s\",\"checkout\":\"%s\"},\"additionalneeds\":\"Breakfast\"}";

	public static String UPDATE_USER_PAYLOAD = "{\"firstname\":\"%s\",\"lastname\":\"%s\",\"totalprice\":111,\"depositpaid\":true,\"bookingdates\":{\"checkin\":\"%s\",\"checkout\":\"%s\"},\"additionalneeds\":\"Breakfast\"}";

}

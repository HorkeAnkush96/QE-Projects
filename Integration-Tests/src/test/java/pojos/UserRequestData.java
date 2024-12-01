package pojos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestData {

	@JsonProperty("firstname")
	public String firstname;

	@JsonProperty("lastname")
	public String lastname;

	@JsonProperty("totalprice")
	public int totalprice;

	@JsonProperty("depositpaid")
	public boolean depositpaid;

	@JsonProperty("bookingdates")
	public Bookingdates bookingdates;

	@JsonProperty("additionalneeds")
	public boolean additionalneeds;

	public class Bookingdates {

		@JsonProperty("checkin")
		public String checkin;

		@JsonProperty("checkout")
		public String checkout;
	}

}

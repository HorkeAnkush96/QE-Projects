package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseDataPojo {

	@JsonProperty("bookingid")
	public int bookingid;

	@JsonProperty("booking")
	public UserRequestData booking;
	
}

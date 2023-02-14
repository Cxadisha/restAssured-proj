package Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@JsonPropertyOrder({"firstname", "lastname", "totalprice", "depositpaid", "bookingdates", "additionalneeds"})
@JsonIgnoreProperties("saleprice") //TODO: 2nd
@JsonInclude(JsonInclude.Include.NON_NULL) //TODO: field level
public class BookingRequest {
	private String lastname;
	private String firstname;
	@JsonProperty("totalprice")
	private int totalPrice;
	@JsonProperty("depositpaid")
	private boolean depositPaid;
	private BookingDates bookingdates;
	@JsonProperty("additionalneeds")
	private String additionalNeeds;
	private int saleprice;
	private String passportNo;
}

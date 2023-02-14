package Models;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class BookingDates{

	@JsonProperty("checkin")
	private String checkIn;
	private String checkout;
}

package AutoGeneratedPOJOs;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseFail{

	@JsonProperty("error")
	private String error;

	public String getError(){
		return error;
	}
}
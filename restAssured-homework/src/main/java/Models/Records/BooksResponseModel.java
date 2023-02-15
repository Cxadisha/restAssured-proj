package Models.Records;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record BooksResponseModel(
		@JsonProperty("books")
		List<BooksItem> books,
		@JsonProperty("userID")
	 	String userID,
		@JsonProperty("username")
		String username
) {}
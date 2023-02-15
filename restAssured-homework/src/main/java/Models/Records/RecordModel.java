package Models.Records;

import com.fasterxml.jackson.annotation.JsonProperty;

public record RecordModel(
        @JsonProperty("userName")
        String userName,
        @JsonProperty("password")
        String password
) {}

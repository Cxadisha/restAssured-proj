package Models.Records;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record TokenModel(
        @JsonProperty("token")
        String token,
        @JsonProperty("expires")
        String expires,
        @JsonProperty("status")
        String status,
        @JsonProperty("result")
        String result
) {}
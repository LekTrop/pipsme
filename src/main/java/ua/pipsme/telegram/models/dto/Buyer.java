package ua.pipsme.telegram.models.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Buyer {

    @JsonProperty("full_name")
    private String fullName;

    private String phone;
    private String note;
}
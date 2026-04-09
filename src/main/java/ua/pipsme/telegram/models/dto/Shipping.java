package ua.pipsme.telegram.models.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Shipping {

    @JsonProperty("tracking_code")
    private String trackingCode;

    @JsonProperty("recipient_full_name")
    private String recipientFullName;

    @JsonProperty("recipient_phone")
    private String recipientPhone;

    @JsonProperty("full_address")
    private String fullAddress;

    @JsonProperty("delivery_service")
    private DeliveryService deliveryService;
}
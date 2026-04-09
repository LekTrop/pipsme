package ua.pipsme.telegram.models.dto;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class KeyCrmOrder {

    private Integer id;

    @JsonProperty("grand_total")
    private Double grandTotal;

    @JsonProperty("payment_status")
    private String paymentStatus;

    private List<Product> products;
    private Manager manager;
    private Status status;
    private Shipping shipping;
    private Buyer buyer;
    @JsonProperty("manager_comment")
    private String managerComment;

    @JsonProperty("assigned")
    private List<AssignedUser> assigned = new ArrayList<>();
}
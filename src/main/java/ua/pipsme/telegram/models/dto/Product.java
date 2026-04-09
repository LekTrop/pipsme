package ua.pipsme.telegram.models.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Product {

    private String name;
    private Double price;
    private Integer quantity;

    private List<Property> properties = new ArrayList<>();
}
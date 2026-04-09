package ua.pipsme.telegram.models.dto;

import lombok.Data;
import ua.pipsme.telegram.models.dto.Property;

import java.util.List;

@Data
public class Offer {

    private Integer id;
    private Double price;

    private List<Property> properties;
}
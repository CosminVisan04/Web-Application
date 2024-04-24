package com.example.backend.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Model representing temperature change data.
 * It includes data about the share of temperature change attributed to greenhouse gases (GHG) for a specific country and year.
 */
@Document(collection = "web")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TemperatureChangeData {
    /**
     * ISO country code.
     */
    @Field(name = "iso_code")
    private String countryCode;

    /**
     * Year of the temperature change data.
     */
    private Integer year;

    /**
     * Share of temperature change attributed to greenhouse gases for the specified year and country.
     */
    private Double share_of_temperature_change_from_ghg;
}

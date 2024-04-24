package com.example.backend.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Model representing temperature data.
 * It includes data about the impact of various greenhouse gases on temperature change for a specific continent and year.
 */
@Document(collection = "web")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TemperatureData {
    /**
     * Continent name.
     */
    @Field(name = "country")
    private String continent;

    /**
     * Year of the temperature data.
     */
    private Integer year;

    /**
     * Share of temperature change attributed to greenhouse gases for the specified year and continent.
     */
    private Double share_of_temperature_change_from_ghg;

    /**
     * Temperature change attributed to methane (CH4) for the specified year and continent.
     */
    private Double temperature_change_from_ch4;

    /**
     * Temperature change attributed to carbon dioxide (CO2) for the specified year and continent.
     */
    private Double temperature_change_from_co2;

    /**
     * Total temperature change attributed to greenhouse gases (GHG) for the specified year and continent.
     */
    private Double temperature_change_from_ghg;

    /**
     * Temperature change attributed to nitrous oxide (N2O) for the specified year and continent.
     */
    private Double temperature_change_from_n2o;
}

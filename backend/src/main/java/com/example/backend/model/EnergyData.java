package com.example.backend.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Model representing energy data.
 * It includes fields for population, energy consumption per capita, and energy consumption per GDP unit.
 */
@Document(collection = "web")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EnergyData {
    /**
     * ISO country code.
     */
    @Field(name = "iso_code")
    private String countryCode;

    /**
     * Year of the energy data.
     */
    private Integer year;

    /**
     * Population of the country in the specified year.
     */
    private Long population;

    /**
     * Energy consumption per capita for the specified year and country.
     */
    private Double energy_per_capita;

    /**
     * Energy consumption per GDP unit for the specified year and country.
     */
    private Double energy_per_gdp;
}

package com.example.backend.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Model representing emission data.
 * It includes fields for CO2, methane, nitrous oxide, and total greenhouse gases (GHG) emissions data.
 */
@Document(collection = "web")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmissionData {
    /**
     * ISO country code.
     */
    @Field(name = "iso_code")
    private String countryCode;

    @Field(name = "country")
    private String country;

    /**
     * Year of the emission data.
     */
    private Integer year;

    /**
     * CO2 emissions for the specified year and country.
     */
    private Double co2;

    /**
     * Methane emissions for the specified year and country.
     */
    private Double methane;

    /**
     * Nitrous oxide emissions for the specified year and country.
     */
    @Field(name = "nitrous_oxide")
    private Double nitrousOxide;

    /**
     * Total greenhouse gas emissions for the specified year and country.
     */
    @Field(name = "total_ghg")
    private Double totalGHG;
}

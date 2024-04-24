package com.example.backend.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Model representing country data.
 * It includes fields for country code, year, population, and GDP.
 */
@Document(collection = "web")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CountryData {
    /**
     * Unique identifier for the country data.
     */
    @Id
    private String id;

    /**
     * ISO country code.
     */
    @Field(name = "iso_code")
    private String countryCode;

    @Field(name = "country")
    private String country;

    /**
     * Year of the data.
     */
    private Integer year;

    /**
     * Population of the country in the specified year.
     */
    private Long population;

    /**
     * GDP of the country in the specified year.
     */
    private Double gdp;
}

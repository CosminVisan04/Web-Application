package com.example.backend.repository;

import com.example.backend.model.CountryData;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Repository interface for CountryData.
 * This interface extends MongoRepository, providing CRUD operations and custom query capabilities for CountryData objects.
 */
public interface CountryDataRepository extends MongoRepository<CountryData, String> {

    /**
     * Finds a CountryData object based on the provided country code and year.
     * 
     * @param countryCode The ISO country code used to find the data.
     * @param year The year used to find the data.
     * @return The CountryData object matching the country code and year, or null if no match is found.
     */
    CountryData findByCountryCodeAndYear(String countryCode, Integer year);
    CountryData findByCountryAndYear(String country, Integer year);
}

package com.example.backend.repository;

import com.example.backend.model.EmissionData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * Repository interface for EmissionData.
 * This interface extends MongoRepository, providing CRUD operations and custom query capabilities for EmissionData objects.
 */
public interface EmissionDataRepository extends MongoRepository<EmissionData, String> {

    /**
     * Finds a list of EmissionData objects based on the provided country code.
     * 
     * @param countryCode The ISO country code used to find the emission data.
     * @return A list of EmissionData objects matching the country code.
     */
    List<EmissionData> findByCountryCode(String countryCode);

    List<EmissionData> findByCountry(String countryCode);

    /**
     * Custom query to find a list of EmissionData objects where the year is greater than or equal to the specified year, for a given country code.
     * 
     * @param countryCode The ISO country code used for the query.
     * @param year The year used as a lower bound in the query.
     * @return A list of EmissionData objects matching the criteria.
     */
    @Query("{ 'countryCode' : ?0, 'year' : { $gte: ?1 } }")
    List<EmissionData> findByCountryCodeAndYearOngoing(String countryCode, Integer year);

    @Query("{ 'country' : ?0, 'year' : { $gte: ?1 } }")
    List<EmissionData> findByCountryAndYearOngoing(String countryCode, Integer year);
}

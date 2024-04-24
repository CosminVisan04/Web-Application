package com.example.backend.repository;

import com.example.backend.model.TemperatureData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * Repository interface for TemperatureData.
 * This interface extends MongoRepository, providing CRUD operations and custom query capabilities for TemperatureData objects.
 */
public interface TemperatureDataRepository extends MongoRepository<TemperatureData, String> {

    /**
     * Custom query to find a list of TemperatureData objects for a specified continent.
     * 
     * @param continent The continent name used to find the temperature data.
     * @return A list of TemperatureData objects matching the continent.
     */
    @Query("{'country' : ?0}")
    List<TemperatureData> findByContinent(String continent);

    /**
     * Custom query to find a list of TemperatureData objects for a specified continent and year, including all subsequent years.
     * 
     * @param continent The continent name used for the query.
     * @param year The year used as a starting point in the query.
     * @return A list of TemperatureData objects matching the continent and starting from the specified year.
     */
    @Query("{ 'country' : ?0, 'year' : { $gte: ?1 } }")
    List<TemperatureData> findByContinentAndYearOngoing(String continent, Integer year);
}

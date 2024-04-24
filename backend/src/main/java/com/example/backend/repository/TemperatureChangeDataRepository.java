package com.example.backend.repository;

import com.example.backend.model.TemperatureChangeData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 * Repository interface for TemperatureChangeData.
 * This interface extends MongoRepository, providing CRUD operations and custom query capabilities for TemperatureChangeData objects.
 */
public interface TemperatureChangeDataRepository extends MongoRepository<TemperatureChangeData, String> {

    /**
     * Custom query to find a paginated collection of TemperatureChangeData objects for a specified year.
     * 
     * @param year The year for which to find temperature change data.
     * @param page The pagination information including page size, number, and sorting criteria.
     * @return A page of TemperatureChangeData objects for the specified year.
     */
    @Query("{ 'year': ?0, 'share_of_temperature_change_from_ghg': { $gt: 0.0 }, 'iso_code': { $ne: null }}")
    Page<TemperatureChangeData> findByYear(Integer year, Pageable page);

    /**
     * Custom query to find a paginated collection of TemperatureChangeData objects between a range of years.
     * 
     * @param endYear The end year of the range for which to find temperature change data.
     * @param startYear The start year of the range for which to find temperature change data.
     * @param page The pagination information including page size, number, and sorting criteria.
     * @return A page of TemperatureChangeData objects within the specified year range.
     */
    @Query("{ 'year': { $gte: ?1, $lte: ?0 }, 'share_of_temperature_change_from_ghg': { $gt : 0.0 }, 'iso_code': { $ne: null }}")
    Page<TemperatureChangeData> findByYearAndGap(Integer endYear, Integer startYear,Pageable page);
}

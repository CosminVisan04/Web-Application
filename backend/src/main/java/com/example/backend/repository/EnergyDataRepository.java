package com.example.backend.repository;

import com.example.backend.model.EnergyData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 * Repository interface for EnergyData.
 * This interface extends MongoRepository, providing CRUD operations and custom query capabilities for EnergyData objects.
 */
public interface EnergyDataRepository extends MongoRepository<EnergyData, String> {

    /**
     * Custom query to find a paginated collection of EnergyData objects for a specified year.
     * 
     * @param year The year for which to find energy data.
     * @param page The pagination information including page size, number, and sorting criteria.
     * @return A page of EnergyData objects for the specified year.
     */
    @Query("{ 'year': ?0, 'iso_code': { $ne: null } }")
    Page<EnergyData> findByYear(Integer year, Pageable page);
}

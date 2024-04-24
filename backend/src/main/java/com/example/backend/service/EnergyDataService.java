package com.example.backend.service;

import com.example.backend.model.EnergyData;
import com.example.backend.repository.EnergyDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Service class for handling operations related to EnergyData.
 */
@Service
public class EnergyDataService {
    @Autowired
    private EnergyDataRepository repository;

    /**
     * Retrieves a paginated collection of EnergyData for a specified year.
     * 
     * @param year The year for which to retrieve energy data.
     * @param page The pagination information including page size, number, and sorting criteria.
     * @return A page of EnergyData for the specified year.
     */
    public Page<EnergyData> getEnergyDataByYear(Integer year, Pageable page) throws Exception {
        if(year < 0 ){
            throw new Exception("Negative value found! Please insert a valid value");
        }
        return repository.findByYear(year, page);
    }
}

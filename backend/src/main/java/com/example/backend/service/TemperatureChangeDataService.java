package com.example.backend.service;

import com.example.backend.model.TemperatureChangeData;
import com.example.backend.repository.TemperatureChangeDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Service class for handling operations related to TemperatureChangeData.
 */
@Service
public class TemperatureChangeDataService {
    @Autowired
    private TemperatureChangeDataRepository repository;

    /**
     * Retrieves a paginated collection of TemperatureChangeData for a specified year.
     * 
     * @param year The year for which to retrieve temperature change data.
     * @param gapYear Optional parameter specifying the number of years before the specified year to include in the data.
     * @param page The pagination information including page size, number, and sorting criteria.
     * @return A page of TemperatureChangeData for the specified year and gap year.
     */
    public Page<TemperatureChangeData> getTemperatureChangeDataByYear(Integer year, Integer gapYear, Pageable page) throws Exception {
        if(gapYear < 0 ){
            throw new Exception("Negative value found! Please insert a valid value");
        }
        if(year < 0 ){
            throw new Exception("Negative value found! Please insert a valid value");
        }
        if(gapYear != null){
            return repository.findByYearAndGap(year, year - gapYear, page);
        } else {
            return repository.findByYear(year, page);
        }
    }
}

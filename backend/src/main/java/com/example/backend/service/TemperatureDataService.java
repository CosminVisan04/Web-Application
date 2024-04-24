package com.example.backend.service;

import com.example.backend.model.TemperatureData;
import com.example.backend.repository.TemperatureDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Service class for handling operations related to TemperatureData.
 */
@Service
public class TemperatureDataService {
    @Autowired
    private TemperatureDataRepository repository;
    /**
     * Retrieves a list of TemperatureData for a given continent and, optionally, from a specific year onwards.
     * 
     * @param continent The continent for which to retrieve temperature data.
     * @param year Optional parameter to specify the starting year for the temperature data.
     * @return A list of TemperatureData matching the specified criteria.
     */
    public List<TemperatureData> getTemperatureDataByContinentAndPossibleYear(String continent, Integer year) throws Exception {
        if(year < 0 ){
            throw new Exception("Negative value found! Please insert a valid value");
        }
        if(year != null){
            return repository.findByContinentAndYearOngoing(continent, year);
        } else {
            return repository.findByContinent(continent);
        }
    }
}

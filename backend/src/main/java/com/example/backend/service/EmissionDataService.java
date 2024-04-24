package com.example.backend.service;

import com.example.backend.model.EmissionData;
import com.example.backend.repository.EmissionDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for handling operations related to EmissionData.
 */
@Service
public class EmissionDataService {
    @Autowired
    private EmissionDataRepository repository;

    /**
     * Retrieves a list of EmissionData for a given country code and, optionally, from a specific year onwards.
     * 
     * @param countryCode The country code for which to retrieve emission data.
     * @param year Optional parameter to specify the starting year for the emission data.
     * @return A list of EmissionData matching the specified criteria.
     */
    public List<EmissionData> getEmissionDataByCountryCodeAndPossibleYear(String countryCode, Integer year) throws Exception {
        if(year < 0 ){
            throw new Exception("Negative value found! Please insert a valid value");
        }
        if(year != null){
            if(countryCode.matches(("^[A-Z]+$"))){
                return repository.findByCountryCodeAndYearOngoing(countryCode, year);
            } else {
                return repository.findByCountryAndYearOngoing(countryCode, year);
            }
        } else {
            if(countryCode.matches(("^[A-Z]+$"))){
                return repository.findByCountryCode(countryCode);
            } else {
                return repository.findByCountry(countryCode);
            }
        }
    }
}

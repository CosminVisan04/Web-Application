package com.example.backend.controller;

import com.example.backend.model.EmissionData;
import com.example.backend.service.EmissionDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for managing emission data.
 * Provides an endpoint for retrieving emission data based on country code and optionally by year.
 */
@RestController
@RequestMapping("/countries")
public class EmissionDataController {
    @Autowired
    private EmissionDataService service;

    /**
     * Retrieves a list of emission data for a specified country code.
     * 
     * @param country_code The country code to retrieve data for.
     * @param year Optional parameter to specify the year of the emission data. 
     * @return A list of emission data for the specified country code and year.
     */
    @GetMapping("/{country_code}/emissions")
    public List<EmissionData> getEmissionDataByCountryCode(@PathVariable String country_code, @RequestParam(required = false) Integer year) throws Exception {
        return service.getEmissionDataByCountryCodeAndPossibleYear(country_code, year);
    }
}

package com.example.backend.controller;

import com.example.backend.model.TemperatureData;
import com.example.backend.service.TemperatureDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for managing temperature data.
 * Provides an endpoint for retrieving temperature data based on continent and optionally by year.
 */
@RestController
@RequestMapping("/continents")
public class TemperatureDataController {
    @Autowired
    private TemperatureDataService service;

    /**
     * Retrieves a list of temperature data for a specified continent.
     * 
     * @param continent The continent to retrieve temperature data for.
     * @param year Optional parameter to specify the year of the temperature data.
     * @return A list of temperature data for the specified continent and year.
     */
    @GetMapping("/{continent}/temperature-change")
    public List<TemperatureData> getTemperatureDataByCountryCode(@PathVariable String continent, @RequestParam(required = false) Integer year) throws Exception {
        return service.getTemperatureDataByContinentAndPossibleYear(continent, year);
    }
}

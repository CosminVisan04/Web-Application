package com.example.backend.controller;

import com.example.backend.service.CountryDataService;
import com.example.backend.model.CountryData;
import jakarta.websocket.OnError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for managing country data.
 * Provides endpoints for creating, retrieving, updating, and deleting country data.
 */
@RestController
@RequestMapping("/countries")
public class CountryDataController {
    @Autowired
    private CountryDataService service;

    /**
     * Creates a new country data entry.
     *
     * @param countryData The country data to create.
     * @return The created country data.
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CountryData createCountryData(@RequestBody  CountryData countryData) throws Exception {
        return service.addCountryData(countryData);
    }

    /**
     * Retrieves country data for a specific country code and year.
     *
     * @param country_code The country code.
     * @param year The year for the data.
     * @return The requested country data.
     */
    @GetMapping("/{country_code}/data/{year}")
    public CountryData getCountryDataByCountryCodeAndYear(@PathVariable String country_code, @PathVariable Integer year) throws Exception {
            return service.getCountryDataByCountryCodeAndYear(country_code, year);
    }

    /**
     * Updates the country data.
     *
     * @param countryData The country data to update.
     * @return The updated country data.
     */
    @PutMapping("/{country_code}/data/{year}")
    public CountryData modifyCountryData(@RequestBody  CountryData countryData) throws Exception {
        return service.updateCountryData(countryData);
    }

    /**
     * Deletes the country data for a specific country code and year.
     *
     * @param country_code The country code.
     * @param year The year for which the data is to be deleted.
     * @return A confirmation message.
     */
    @DeleteMapping("/{country_code}/data/{year}")
    public CountryData deleteCountryData(@PathVariable String country_code, @PathVariable Integer year) throws Exception {
        return service.deleteCountryData(country_code, year);
    }
}
package com.example.backend.controller;

import com.example.backend.model.TemperatureChangeData;
import com.example.backend.service.TemperatureChangeDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Controller for managing temperature change data.
 * Provides an endpoint for retrieving paginated temperature change data based on year,
 * number of previous years, number of countries, and ranking type.
 */
@RestController
@RequestMapping("/climate-change")
public class TemperatureChangeDataController {
    @Autowired
    private TemperatureChangeDataService service;

    /**
     * Retrieves paginated temperature change data for a specific year, potentially including data for a specified number of previous years.
     * The data can be sorted in descending or ascending order based on the share of temperature change from greenhouse gases.
     * 
     * @param year The year for which temperature change data is to be retrieved.
     * @param number_of_previous_years Optional parameter specifying the number of previous years to include in the data.
     * @param number_of_countries The number of countries for which data should be returned.
     * @param rank_type The ranking type (top / bottom)
     * @return A page of temperature change data for the specified year and conditions.
     */
    @GetMapping("/{year}")
    public Page<TemperatureChangeData> getTemperatureChangeDataByCountryCode(@PathVariable Integer year,
                                                                             @RequestParam(required = false) Integer number_of_previous_years,
                                                                             @RequestParam(required = true) Integer number_of_countries,
                                                                             @RequestParam(required = true) String rank_type) throws Exception {
        int size = number_of_countries;
        if(number_of_previous_years != null){
            size = number_of_countries * (number_of_previous_years + 1);
        }

        Pageable page;
        if(rank_type.equals("top")){
            page = PageRequest.of(0, size, Sort.Direction.DESC, "share_of_temperature_change_from_ghg");
        } else {
            page = PageRequest.of(0, size, Sort.by("share_of_temperature_change_from_ghg"));
        }

        return service.getTemperatureChangeDataByYear(year, number_of_previous_years, page);
    }
}

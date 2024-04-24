package com.example.backend.controller;

import com.example.backend.model.EnergyData;
import com.example.backend.service.EnergyDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Controller for managing energy data.
 * Provides an endpoint for retrieving paginated energy data based on a specific year.
 */
@RestController
@RequestMapping("/countries")
public class EnergyDataController {
    @Autowired
    private EnergyDataService service;

    /**
     * Retrieves paginated energy data for a specific year.
     * The data is sorted by population and the size of each page is determined by the batchSize parameter.
     * 
     * @param year The year for which energy data is to be retrieved.
     * @param batchSize The number of records to include in each page.
     * @return A page of energy data for the specified year, sorted by population.
     */
    @GetMapping("/{year}/energy-data")
    public Page<EnergyData> getEnergyDataByYear(@PathVariable Integer year,  @RequestParam(required = true) Integer batchSize) throws Exception {
        Pageable page = PageRequest.of(0, batchSize, Sort.by("population"));
        return service.getEnergyDataByYear(year, page);
    }
}

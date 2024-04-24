package com.example.backend.service;

import com.example.backend.model.CountryData;
import com.example.backend.repository.CountryDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service class for handling operations related to CountryData.
 */
@Service
public class CountryDataService {
    @Autowired
    private CountryDataRepository repository;

    /**
     * Adds new country data to the database.
     *
     * @param countryData The CountryData object to be saved.
     * @return The saved CountryData object.
     */
    public CountryData addCountryData(CountryData countryData) throws Exception {

        if(countryData.getYear() < 0 ){
            throw new Exception("Negative value found! Please insert a valid value");
        }
        if(countryData.getPopulation() < 0 ){
            throw new Exception("Negative value found! Please insert a valid value");
        }
        if(countryData.getGdp() < 0 ){
            throw new Exception("Negative value found! Please insert a valid value");
        }
        
        try{
            countryData.setCountry(countryData.getCountryCode());
            return repository.save(countryData);
        }catch (Exception e){
            throw new Exception("Trying to create existing data");
        }
    }

    /**
     * Retrieves country data based on country code and year.
     *
     * @param countryCode The country code of the data to be retrieved.
     * @param year The year of the data to be retrieved.
     * @return The CountryData object found, or null if not found.
     */
    public CountryData getCountryDataByCountryCodeAndYear(String countryCode, Integer year) throws Exception {

        if(year < 0 ){
            throw new Exception("Negative value found! Please insert a valid value");
        }

        if(countryCode.matches("^[A-Z]+$")){
            return repository.findByCountryCodeAndYear(countryCode, year);
        }
        return repository.findByCountryAndYear(countryCode, year);
    }

    /**
     * Updates existing country data.
     *
     * @param countryDataRequest The CountryData object containing the updated information.
     * @return The updated CountryData object.
     */
    public CountryData updateCountryData(CountryData countryDataRequest) throws Exception {

        CountryData tempCountryData;

        if(countryDataRequest.getYear() < 0 ){
            throw new Exception("Negative value found! Please insert a valid value");
        }
        if(countryDataRequest.getPopulation() < 0 ){
            throw new Exception("Negative value found! Please insert a valid value");
        }
        if(countryDataRequest.getGdp() < 0 ){
            throw new Exception("Negative value found! Please insert a valid value");
        }

        if(countryDataRequest.getCountryCode().matches("^[A-Z]+$")){
            tempCountryData = repository.findByCountryCodeAndYear(countryDataRequest.getCountryCode(), countryDataRequest.getYear());
        } else {
            tempCountryData = repository.findByCountryAndYear(countryDataRequest.getCountryCode(), countryDataRequest.getYear());
        }

        tempCountryData.setPopulation(countryDataRequest.getPopulation());
        tempCountryData.setGdp(countryDataRequest.getGdp());
        return repository.save(tempCountryData);
    }

    /**
     * Deletes country data based on country code and year.
     *
     * @param countryCode The country code of the data to be deleted.
     * @param year The year of the data to be deleted.
     * @return A confirmation message indicating successful deletion.
     */
    public CountryData deleteCountryData(String countryCode, Integer year) throws Exception {

        if(year < 0 ){
            throw new Exception("Negative value found! Please insert a valid value");
        }

        CountryData temp = null;
        try {
            if(countryCode.matches("^[A-Z]+$")){
                temp = repository.findByCountryCodeAndYear(countryCode, year);
                repository.delete(repository.findByCountryCodeAndYear(countryCode, year));
            } else {
                temp = repository.findByCountryAndYear(countryCode, year);
                repository.delete(repository.findByCountryAndYear(countryCode, year));
            }
            return temp;
        }catch (Exception e){
            throw new Exception("Trying to delete non-existing object");
        }
    }
}
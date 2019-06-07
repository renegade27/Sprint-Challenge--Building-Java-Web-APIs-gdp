package com.lambdaschool.sprintcountry.controller;

import com.lambdaschool.sprintcountry.SprintcountryApplication;
import com.lambdaschool.sprintcountry.exception.ResNotFoundException;
import com.lambdaschool.sprintcountry.model.Country;
import org.apache.coyote.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/country")
public class CountryController {

    private static final Logger logger = LoggerFactory.getLogger(CountryController.class);

    // localhost:8080/country/{id}
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getCountryDetail(@PathVariable long id) {
        logger.info("/country/" + id + " accessed");
        Country rtnCountry;
        if(SprintcountryApplication.ourCountryList.findCountry(c -> (c.getId() == id)) == null) {
            throw new ResNotFoundException("Country with id " + id + " not found");
        } else{
            rtnCountry = SprintcountryApplication.ourCountryList.findCountry(d -> (d.getId() == id));
        }
        return new ResponseEntity<>(rtnCountry, HttpStatus.OK);
    }

    @GetMapping(value="/stats/median")
    public ResponseEntity<?> getMedianCountry() {
        logger.info("/country/stats/median accessed");
        Country rtnCountry;
        int median;
        median = (SprintcountryApplication.ourCountryList.countryList.size() % 2) == 1 ? (SprintcountryApplication.ourCountryList.countryList.size() / 2) - 1 : SprintcountryApplication.ourCountryList.countryList.size() / 2 ;
        if(SprintcountryApplication.ourCountryList.countryList.get(median) == null) {
            throw new ResNotFoundException("Median country not accessible, check median int output.");
        } else {
            rtnCountry = SprintcountryApplication.ourCountryList.countryList.get(median);
        }
        return new ResponseEntity<>(rtnCountry, HttpStatus.OK);
    }
}

package com.lambdaschool.sprintcountry.controller;

import com.lambdaschool.sprintcountry.CountryList;
import com.lambdaschool.sprintcountry.SprintcountryApplication;
import com.lambdaschool.sprintcountry.exception.ResNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/")
public class GDPController {

    private static final Logger logger = LoggerFactory.getLogger(GDPController.class);

    @GetMapping("/names")
    public ResponseEntity<?> getNames() {
        logger.info("/names accessed");
        SprintcountryApplication.ourCountryList.countryList.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        if(SprintcountryApplication.ourCountryList.countryList.size() == 0 ) {
            throw new ResNotFoundException("Country list not accessible");
        }
        return new ResponseEntity<>(SprintcountryApplication.ourCountryList.countryList, HttpStatus.OK);
    }

    @GetMapping("/economy")
    public ResponseEntity<?> getEconomies() {
        logger.info("/economy accessed");
        SprintcountryApplication.ourCountryList.countryList.sort((c1, c2) -> Long.compare(c2.getGdp(), c1.getGdp()));
        if(SprintcountryApplication.ourCountryList.countryList.size() == 0 ) {
            throw new ResNotFoundException("Country list not accessible");
        }
        return new ResponseEntity<>(SprintcountryApplication.ourCountryList.countryList, HttpStatus.OK);
    }
}
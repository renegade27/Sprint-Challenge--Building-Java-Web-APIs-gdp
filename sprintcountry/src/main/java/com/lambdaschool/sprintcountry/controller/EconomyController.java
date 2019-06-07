package com.lambdaschool.sprintcountry.controller;

import com.lambdaschool.sprintcountry.SprintcountryApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@RestController
@RequestMapping("/economy")
public class EconomyController {

    private static final Logger logger = LoggerFactory.getLogger(EconomyController.class);

    @GetMapping("/table")
    public ModelAndView displayEcoTable() {
        logger.info("/economy/table accessed");
        SprintcountryApplication.ourCountryList.countryList.sort((c1, c2) -> Long.compare(c2.getGdp(), c1.getGdp()));
        ModelAndView mav = new ModelAndView();
        mav.setViewName("countries");
        mav.addObject("countryList", SprintcountryApplication.ourCountryList.countryList);
        return mav;
    }
}

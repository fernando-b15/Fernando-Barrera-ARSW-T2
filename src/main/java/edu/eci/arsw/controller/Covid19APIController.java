/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.controller;

import edu.eci.arsw.servive.Covid19APIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jm_14
 */
@RestController
@RequestMapping("/covid19")
public class Covid19APIController {
    @Autowired
    Covid19APIService covid19apiservice;

     @RequestMapping (method = RequestMethod.GET )
      public ResponseEntity<?> getAllCovid19(){
        try {
            String res = covid19apiservice.getCovidAllCountries();
            return new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }
       @RequestMapping(value = "/{country}",method = RequestMethod.GET)
    public ResponseEntity<?> getCasesByCountry(@PathVariable String country){

        try {
            String stats = covid19apiservice. getCovidByCountry(country);
            return new ResponseEntity<>(stats, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }

    }
    
}

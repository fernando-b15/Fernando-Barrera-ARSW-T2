/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.entities;

import java.time.LocalDateTime;
import org.json.JSONObject;

/**
 *
 * @author jm_14
 */
public class Country {
    private int confirmed;
    private int deaths;
    private int recovered;
    private String country;
    private JSONObject jsonObject;


    public Country(JSONObject jsonObject){
        this.jsonObject = jsonObject;
        confirmed = Integer.parseInt(jsonObject.get("confirmed").toString());
        deaths = Integer.parseInt(jsonObject.get("deaths").toString());
        recovered = Integer.parseInt(jsonObject.get("recovered").toString());
        country= jsonObject.get("country").toString();
        
    }

   

    public JSONObject getCountryObj(){
        jsonObject.put("deaths",deaths);
        jsonObject.put("confirmed",confirmed);
        jsonObject.put("recovered",recovered);
        return jsonObject;
    }    

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }



    public void setCountryObj(JSONObject jsonObject) {
        this.jsonObject = jsonObject;
    }
    
    public int getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(int confirmed) {
        this.confirmed+= confirmed;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths+= deaths;
    }

    public int getRecovered() {
        return recovered;
    }

    public void setRecovered(int recovered) {
        this.recovered+= recovered;
    }
    
}

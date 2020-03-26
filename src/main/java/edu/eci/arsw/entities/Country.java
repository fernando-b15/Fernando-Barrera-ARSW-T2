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
    private JSONObject jsonObject;


    public Country(JSONObject jsonObject){
        this.jsonObject = jsonObject;
        deaths = Integer.parseInt(jsonObject.get("deaths").toString());
        recovered = Integer.parseInt(jsonObject.get("recovered").toString());
        confirmed = Integer.parseInt(jsonObject.get("confirmed").toString());
    }

   

    public JSONObject getJsonObject(){
        jsonObject.put("deaths",deaths);
        jsonObject.put("confirmed",confirmed);
        jsonObject.put("recovered",recovered);
        return jsonObject;
    }    
    
}

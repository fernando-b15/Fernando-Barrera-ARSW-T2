/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.servive;

import com.mashape.unirest.http.exceptions.UnirestException;
import edu.eci.arsw.cache.CoronavirusStatsCache;
import edu.eci.arsw.entities.Country;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jm_14
 */
@Service
public class CoronavirusStatsService {
    @Autowired
    HttpConnectionService httpConnectionService;
    @Autowired
    CoronavirusStatsCache coronavirusStatsCache;
    public String getCovidAllCountries(){
        String res=null;
        try {
              res = httpConnectionService.getCovid19sAllCountries();
              JSONObject tempo = new JSONObject(res);
              JSONObject data = new JSONObject(tempo.get("data").toString());
              JSONArray covid19array = new JSONArray(data.get("covid19Stats").toString());
              HashMap<String, Country> sumprovin= new HashMap<>();
              for(int i = 0;i<covid19array.length();i++){
                  JSONObject sel = (JSONObject) covid19array.get(i);

                  if(sumprovin.containsKey(sel.get("country").toString())){             
                      Country countrysel=sumprovin.get(sel.get("country").toString());
                      countrysel.setConfirmed(Integer.parseInt(sel.get("confirmed").toString()));
                      countrysel.setDeaths(Integer.parseInt(sel.get("deaths").toString()));
                      countrysel.setRecovered(Integer.parseInt(sel.get("recovered").toString()));
                      
                  } else {
                      sumprovin.put(sel.get("country").toString(),new Country(sel));
                  }
              }    
              JSONArray listafinal = new JSONArray();
              for(String sel:sumprovin.keySet()){
                  listafinal.put((sumprovin.get(sel)).getCountryObj());
              } 
              return listafinal.toString();
              
        } catch (UnirestException ex) {
            Logger.getLogger(CoronavirusStatsService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
      
    }
    public String getCovidByCountry(String country){   
        try {
            String res=null;
            if(coronavirusStatsCache.isInCache(country)){
                System.out.println("si esta en cache");
                return coronavirusStatsCache.getRegisterByCountry(country);
            }
            else{
                JSONArray intentodegsonconcoord = new JSONArray();
                res = httpConnectionService.getCovid19ByCountry(country);
                JSONObject tempo = new JSONObject(res);
                JSONObject data = new JSONObject(tempo.get("data").toString());
                JSONArray covid19array = new JSONArray(data.get("covid19Stats").toString());
                String intentocoor = httpConnectionService.getCoordenadas(country);
                JSONArray coords = new JSONArray(intentocoor);
                JSONObject coordenadas = new JSONObject(coords.get(0).toString());
                JSONArray latlng = new JSONArray(coordenadas.get("latlng").toString());
                for(int i=0; i<covid19array.length();i++){
                    JSONObject tempo15 = (JSONObject) covid19array.get(i);
                    tempo15.put("coordenadas",new JSONObject("{\"latitud\":"+latlng.get(0).toString()+",\"longitud\":"+latlng.get(1).toString()+"}"));
                    intentodegsonconcoord.put(tempo15);
                }
                System.out.println(latlng.toString());
                coronavirusStatsCache.SaveRegisterByCountry(country,intentodegsonconcoord.toString());
                return intentodegsonconcoord.toString();
            }
           
          
        }
        catch (UnirestException ex) {
            Logger.getLogger(CoronavirusStatsService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
}

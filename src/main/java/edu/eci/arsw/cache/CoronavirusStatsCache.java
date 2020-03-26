/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.cache;

import java.time.LocalDateTime;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Service;

/**
 *
 * @author jm_14
 */
@Service
public class CoronavirusStatsCache {
    ConcurrentHashMap<String,String> cache;

    public CoronavirusStatsCache(){
        cache = new ConcurrentHashMap<>();
    }
    public void SaveRegisterByCountry(String key,String data){
        cache.put(key,data);
    }
    public String getRegisterByCountry(String key){

        return cache.get(key);
    }
    public boolean isInCache(String key){
        return cache.containsKey(key);
    }
}


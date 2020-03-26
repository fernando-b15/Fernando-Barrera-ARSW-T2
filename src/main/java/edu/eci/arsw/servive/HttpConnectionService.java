package edu.eci.arsw.servive;

import org.springframework.stereotype.Service;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
@Service
public class HttpConnectionService {
    public String getCoordenadas(String country) throws UnirestException{
        HttpResponse<String> response = Unirest.get("https://restcountries-v1.p.rapidapi.com/name/"+country)
                .header("x-rapidapi-host", "restcountries-v1.p.rapidapi.com")
                .header("x-rapidapi-key", "0e72bcd144msh8951afd83016cbbp115df0jsnf8ca2e9da0ec")
                .asString();
        return response.getBody();
    }

    public String getCovid19ByCountry(String country) throws UnirestException {
    	System.out.println("llega");
        HttpResponse<String> response = Unirest.get("https://covid-19-coronavirus-statistics.p.rapidapi.com/v1/stats?country="+country)
                .header("x-rapidapi-host", "covid-19-coronavirus-statistics.p.rapidapi.com")
                .header("x-rapidapi-key", "fe3b8f1042msh1ed0bfa435a69aep1ca144jsnfeb70957f448")
                .asString();
        return response.getBody();
    }
    public String getCovid19sAllCountries() throws UnirestException{
        HttpResponse<String> response = Unirest.get("https://covid-19-coronavirus-statistics.p.rapidapi.com/v1/stats")
                .header("x-rapidapi-host", "covid-19-coronavirus-statistics.p.rapidapi.com")
                .header("x-rapidapi-key", "fe3b8f1042msh1ed0bfa435a69aep1ca144jsnfeb70957f448")
                .asString();
        return response.getBody();
    }

}

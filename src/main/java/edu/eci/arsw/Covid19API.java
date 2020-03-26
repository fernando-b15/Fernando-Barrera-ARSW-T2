package edu.eci.arsw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.eci.arsw.cache.CoronavirusStatsCache;
import edu.eci.arsw.servive.CoronavirusStatsService;
import edu.eci.arsw.servive.HttpConnectionService;

@Controller
@SpringBootApplication
@ComponentScan("edu.eci.arsw")

public class Covid19API{
	@Autowired
	CoronavirusStatsService coronavirusStatsService;


    public static void main(String[] args) {
        SpringApplication.run(Covid19API.class, args);
    }
 
    @Bean
    public CommandLineRunner demo(CoronavirusStatsCache service) {
      return (args) -> {
    	  System.out.println(service.isInCache("Canada"));
    	  System.out.println(coronavirusStatsService.getCovidByCountry("Colombia"));
    	  System.out.println(service.isInCache("Colombia"));
    
    	  
        };   
    }
    
    
    
        
}
package com.tts.weatherapp.Service;


import com.tts.weatherapp.Models.Response;
// import com.tts.weatherapp.Models.ZipCode;
// // import com.tts.weatherapp.Repository.ZipCodeRepository;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
 
    // private ZipCodeRepository zipCodeRepository;
    
    @Value("${api_key}")
    private String apiKey;

    public Response getForecast(String zipCode){

        try {
        String url = "http://api.openweathermap.org/data/2.5/weather?zip=" + zipCode + "&appid=" + apiKey + "&units=imperial";
        
        RestTemplate restTemplate = new RestTemplate();



        return restTemplate.getForObject(url, Response.class);


       
        }
        catch (HttpClientErrorException ex) {
            Response response = new Response();
            response.setName("error");
            return response;
        }
    }

    // public ZipCode getRecentSearch(String zipCode){

    //     return zipCodeRepository.findByZipCode(zipCode);

    // }





    


}

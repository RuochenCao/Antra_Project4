package com.example.search.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SearchController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/weather/search")
    @HystrixCommand(fallbackMethod = "goingWrong")
    public ResponseEntity<?> getDetails() {
        // URL of the details service
        String detailsServiceUrl = "http://details/details/port";
        String restapiassign1ServiceUrl = "http://restapiassign1/restapiassign1/university/test";
        // Make an HTTP GET request to the details service
        ResponseEntity<String> response = restTemplate.getForEntity(detailsServiceUrl, String.class);
        ResponseEntity<String> response2 = restTemplate.getForEntity(restapiassign1ServiceUrl, String.class);
        // Return the response received from details service
        // Merge the responses as a single string
        String mergedResponse = response.getBody() + "\n" + response2.getBody();
        return new ResponseEntity<>(mergedResponse, HttpStatus.OK);
//        return new ResponseEntity<>(response2.getBody(), response2.getStatusCode());
//        return new ResponseEntity<>("this is search service", HttpStatus.OK);
    }

    public ResponseEntity<?> goingWrong() {
        return new ResponseEntity<>("Woops. Something going wrong...", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

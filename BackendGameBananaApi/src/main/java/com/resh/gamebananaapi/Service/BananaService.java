package com.resh.gamebananaapi.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;






@Service
public class BananaService {

    private static final String API_URL = "https://marcconrad.com/uob/banana/api.php?out=json";

    public Map<String, Object> getBananaPuzzle() {
        RestTemplate restTemplate = new RestTemplate();

        // Optional headers
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(MediaType.parseMediaTypes("application/json"));
        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

        // Fetch response as String
        ResponseEntity<String> response = restTemplate.exchange(
                API_URL,
                HttpMethod.GET,
                requestEntity,
                String.class
        );

        try {
            // Parse JSON manually
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(response.getBody(), Map.class);
        } catch (Exception e) {
            e.printStackTrace();
            // Return a safe error map
            return Map.of("error", "Failed to parse puzzle");
        }
    }
}


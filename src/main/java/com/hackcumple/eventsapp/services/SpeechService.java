package com.hackcumple.eventsapp.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.Objects;

@Service
public class SpeechService {

    @Value("${listenbycode.api.key}")
    private String apiKey;

    @Value("${listenbycode.api.url}")
    private String url;

    public String uploadAudio(String fileName) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        Resource resource = new ClassPathResource(fileName);
        MultiValueMap<String, Object> map= new LinkedMultiValueMap<>();
        map.add("appkey", apiKey);
        map.add("language", "pl-PL");
        map.add("file", resource);
        HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<>(map, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity response = restTemplate.postForEntity( url, request, Map.class );

        return ((Map)((Map) Objects.requireNonNull(response.getBody())).get("result")).get("orderId").toString();
    }

}

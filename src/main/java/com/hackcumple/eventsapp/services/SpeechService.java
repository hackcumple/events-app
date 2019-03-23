package com.hackcumple.eventsapp.services;

import com.hackcumple.eventsapp.data.Transcription.ListenApiResponse;
import com.hackcumple.eventsapp.data.Transcription.TranscriptionResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.File;
import java.util.Map;
import java.util.Objects;

@Service
public class SpeechService {

    @Value("${listenbycode.api.key}")
    private String apiKey;

    @Value("${listenbycode.api.url.upload}")
    private String uploadUrl;

    @Value("${listenbycode.api.url.download}")
    private String downloadUrl;

    public String uploadAudio(MultipartFile file) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        Resource resource = new ClassPathResource((new File(file.getOriginalFilename())).getPath());
        MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
        map.add("appkey", apiKey);
        map.add("language", "pl-PL");
        map.add("file", resource);
        HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<>(map, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity response = restTemplate.postForEntity(uploadUrl, request, Map.class);

        return ((Map) ((Map) Objects.requireNonNull(response.getBody())).get("transcriptionResult")).get("orderId").toString();
    }

    public void GetTranscriptionDetails(String idOrder) {
        TranscriptionResult transcription = GetTranscription("idOrder");
    }

    private TranscriptionResult GetTranscription(String idOrder) {
        HttpHeaders headers = new HttpHeaders();
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(downloadUrl)
                .queryParam("appkey", apiKey)
                .queryParam("orderid", idOrder);

        HttpEntity<?> entity = new HttpEntity<>(headers);

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<ListenApiResponse> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, ListenApiResponse.class);

        return response.getBody().getResult();
    }
}

package com.hackcumple.eventsapp.services;

import com.hackcumple.eventsapp.data.Transcription;
import com.hackcumple.eventsapp.data.WordDetails;
import com.hackcumple.eventsapp.data.transcriptionDTO.ListenApiResponse;
import com.hackcumple.eventsapp.data.transcriptionDTO.TranscriptionResult;
import com.hackcumple.eventsapp.data.transcriptionDTO.Word;
import com.hackcumple.eventsapp.repository.TranscriptionRepository;
import lombok.RequiredArgsConstructor;
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

import java.util.Comparator;
import java.util.List;
import java.io.File;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SpeechService {

    @Value("${listenbycode.api.key}")
    private String apiKey;

    @Value("${listenbycode.api.url.upload}")
    private String uploadUrl;

    @Value("${listenbycode.api.url.download}")
    private String downloadUrl;

    private final TranscriptionRepository transcriptionRepository;

    public String uploadAudio(MultipartFile file,Long presentationId) {
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

        Map body = (Map) response.getBody();
        String orderId = ((Map)body.get("result")).get("orderId").toString();

        Transcription transcription = new Transcription();
        transcription.setOrderId(orderId);
        transcription.setPresentationId(presentationId);
        transcriptionRepository.save(transcription);

        return orderId;
    }

    public Transcription GetTranscriptionDetails(Long presentationId) {

        Transcription transcription = transcriptionRepository.findByPresentationId(presentationId).get();
        return transcription;
    }

    private TranscriptionResult GetTranscription(String orderId){

        HttpHeaders headers = new HttpHeaders();
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(downloadUrl)
                .queryParam("appkey", apiKey)
                .queryParam("orderid", orderId);

        HttpEntity<?> entity = new HttpEntity<>(headers);

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<ListenApiResponse> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, ListenApiResponse.class);

        return response.getBody().getResult();
    }
}

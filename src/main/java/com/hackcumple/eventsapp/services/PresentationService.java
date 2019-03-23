package com.hackcumple.eventsapp.services;

import com.hackcumple.eventsapp.data.Presentation;
import com.hackcumple.eventsapp.data.SpeakerRate;
import com.hackcumple.eventsapp.repository.PresentationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;

@Service
@RequiredArgsConstructor
public class PresentationService {

    private final PresentationRepository presentationRepository;

    public List<Presentation> getFavoriteTrack(Long eventId, String tagsText) {
        List<String> tags = Arrays.asList(tagsText.split("\\s*,\\s*"));
        List<Presentation> favourite = new ArrayList<>();
        for (Long startHour = 9L; startHour < 18; startHour++) {
            List<Presentation> presentations = presentationRepository.findPresentationsByEventIdAndStartHour(eventId, startHour);

            List<Presentation> presentationsByTags = presentations.stream()
                    .filter(presentation -> tags.contains(presentation.getTag())).collect(Collectors.toList());

            if (presentationsByTags.size() == 1) {
                favourite.add(presentationsByTags.get(0));
                continue;
            } else if (presentationsByTags.isEmpty()) {
                presentationsByTags = presentations;
            }
            Map<String, Double> theBestSpeaker = getTheBestSpeaker();
            for (Presentation presentationsByTag : presentationsByTags) {
                if (theBestSpeaker.get(presentationsByTag.getSpeaker()) != null) {
                    favourite.add(presentationsByTag);
                    break;
                }
            }
        }
        return favourite;
    }

    public Map<String, Double> getTheBestSpeaker() {
        Iterable<Presentation> presentations = presentationRepository.findAll();
        List<SpeakerRate> speakerRates = new ArrayList<>();
        for (Presentation presentation : presentations) {
            Optional<SpeakerRate> first = speakerRates.stream().filter(speakerRate -> speakerRate.equals(presentation.getSpeaker())).findFirst();
            if (first.isPresent()) {
                first.get().incrementAmountRates();
            } else {
                speakerRates.add(new SpeakerRate(presentation.getSpeaker(), presentation.getRate()));
            }
        }
        return speakerRates.stream().collect(
                toMap(SpeakerRate::getSpeaker, o -> o.getRates().stream().mapToDouble(Double::doubleValue).sum() / o.getAmountRates(), (e1, e2) -> e2,
                        LinkedHashMap::new))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(
                        toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                                LinkedHashMap::new));
    }
}

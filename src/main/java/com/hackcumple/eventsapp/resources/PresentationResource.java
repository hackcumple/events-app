package com.hackcumple.eventsapp.resources;

import com.hackcumple.eventsapp.data.Presentation;
import com.hackcumple.eventsapp.data.Question;
import com.hackcumple.eventsapp.data.Rate;
import com.hackcumple.eventsapp.data.RateDTO;
import com.hackcumple.eventsapp.repository.QuestionRepository;
import com.hackcumple.eventsapp.repository.RateRepository;
import com.hackcumple.eventsapp.services.PresentationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/presentation")
@RequiredArgsConstructor
public class PresentationResource {


    private final PresentationService presentationService;

    private final RateRepository rateRepository;

    private final QuestionRepository questionRepository;

    @GetMapping(path = "favouriteTrack/{eventId}/{tags}")
    public ResponseEntity getFavoriteTrack(@PathVariable("eventId") Long eventId, @PathVariable("tags") String tags) {
        return new ResponseEntity<>(presentationService.getFavoriteTrack(eventId, tags), HttpStatus.OK);
    }

    @PostMapping(path = "{id}/rate")
    public ResponseEntity createRate(@PathVariable("id") Long id, @RequestBody RateDTO rateDTO) {
        Presentation presentation = presentationService.getPresentation(id);
        Rate rate = Rate.builder()
                .rate(rateDTO.getRate())
                .date(rateDTO.getDate())
                .presentationId(id)
                .speakerName(presentation.getSpeaker())
                .build();
        rateRepository.save(rate);
        return ResponseEntity.ok(rate);
    }

    @PostMapping(path = "{id}/question/{que}")
    public ResponseEntity createQuestion(@PathVariable("id") Long id, @PathVariable String que) {
        Presentation presentation = presentationService.getPresentation(id);
        Optional<Question> byPresentationId = questionRepository.findByPresentationId(id);
        Question question;
        if (byPresentationId.isPresent()) {
            question = byPresentationId.get();
            question.incrementRating();
            questionRepository.save(question);
        } else {
            question = Question.builder()
                    .question(que)
                    .presentationId(id)
                    .speaker(presentation.getSpeaker())
                    .build();
        }
        questionRepository.save(question);
        return ResponseEntity.ok(question);
    }
}

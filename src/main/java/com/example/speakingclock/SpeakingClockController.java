package com.example.speakingclock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class SpeakingClockController {

    private final SpeakingClockService speakingClockService;

    @Autowired
    public SpeakingClockController(SpeakingClockService speakingClockService) {
        this.speakingClockService = speakingClockService;
    }

    @PostMapping("/convert-time")
    public ResponseEntity<String> convertTimeToWords(@RequestBody String time) {
        try {
            String convertedTime = speakingClockService.convertTimeToWords(time);
            return ResponseEntity.ok(convertedTime);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error converting time to words");
        }
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidationException(MethodArgumentNotValidException ex) {
        String errorMessage = Objects.requireNonNull(ex.getBindingResult().getFieldError()).getDefaultMessage();
        return ResponseEntity.badRequest().body(errorMessage);
    }
}


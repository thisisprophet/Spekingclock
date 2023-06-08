package org.example.spekingclock;

import com.example.speakingclock.SpeakingClockController;
import com.example.speakingclock.SpeakingClockService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class SpeakingClockControllerTest {

    private SpeakingClockController speakingClockController;

    @BeforeEach
    public void setUp() {
        SpeakingClockService speakingClockService = new SpeakingClockService();
        speakingClockController = new SpeakingClockController(speakingClockService);
    }

    @Test
    public void testConvertTimeToWords_Success() {
        ResponseEntity<String> response = speakingClockController.convertTimeToWords("08:34");
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals("It's Eight Thirty Four", response.getBody());
    }

    @Test
    public void testConvertTimeToWords_InvalidFormat() {
        ResponseEntity<String> response = speakingClockController.convertTimeToWords("8:34");
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        Assertions.assertTrue(response.getBody().contains("Invalid time format"));
    }

    // Add more test methods to cover various scenarios
}

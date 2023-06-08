package org.example.spekingclock;

import com.example.speakingclock.SpeakingClockService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class SpeakingClockServiceTest {

    private SpeakingClockService speakingClockService;

    @BeforeEach
    public void setUp() {
        speakingClockService = new SpeakingClockService();
    }

    @Test
    public void testConvertTimeToWords_Midnight() {
        String convertedTime = speakingClockService.convertTimeToWords("00:00");
        Assertions.assertEquals("It's Midnight", convertedTime);
    }

    @Test
    public void testConvertTimeToWords_Midday() {
        String convertedTime = speakingClockService.convertTimeToWords("12:00");
        Assertions.assertEquals("It's Midday", convertedTime);
    }

    @Test
    public void testConvertTimeToWords_NormalTime() {
        String convertedTime = speakingClockService.convertTimeToWords("08:34");
        Assertions.assertEquals("It's Eight Thirty Four", convertedTime);
    }

    @Test
    public void testConvertTimeToWords_InvalidFormat() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> speakingClockService.convertTimeToWords("8:34"));
    }


}

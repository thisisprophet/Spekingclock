package com.example.speakingclock;

import org.springframework.stereotype.Service;

@Service
public class SpeakingClockService {
    private static final String[] HOURS = {
            "Midnight", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
            "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen",
            "Twenty", "Twenty One", "Twenty Two", "Twenty Three"
    };

    private static final String[] MINUTES = {
            "O'Clock", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
            "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen",
            "Twenty", "Twenty One", "Twenty Two", "Twenty Three", "Twenty Four", "Twenty Five", "Twenty Six", "Twenty Seven", "Twenty Eight", "Twenty Nine",
            "Thirty", "Thirty One", "Thirty Two", "Thirty Three", "Thirty Four", "Thirty Five", "Thirty Six", "Thirty Seven", "Thirty Eight", "Thirty Nine",
            "Forty", "Forty One", "Forty Two", "Forty Three", "Forty Four", "Forty Five", "Forty Six", "Forty Seven", "Forty Eight", "Forty Nine",
            "Fifty", "Fifty One", "Fifty Two", "Fifty Three", "Fifty Four", "Fifty Five", "Fifty Six", "Fifty Seven", "Fifty Eight", "Fifty Nine"
    };

    public String convertTimeToWords(String time) {
        String[] parts = time.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);

        if (hours == 0 && minutes == 0) {
            return "It's Midnight";
        } else if (hours == 12 && minutes == 0) {
            return "It's Midday";
        } else {
            String hourWord = HOURS[hours % 24];
            String minuteWord = MINUTES[minutes % 60];
            return "It's " + hourWord + " " + minuteWord;
        }
    }
}

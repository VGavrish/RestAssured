package utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class RandomUtils {

    public static final Random RANDOM = new Random();
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ISO_DATE_TIME;

    public static int generateRandomInt(int min, int max) {
        return RANDOM.nextInt(max - min + 1) + min;
    }

    public static String generateRandomDate(String startDateString) {
        LocalDateTime startDateTime = LocalDateTime.parse(startDateString, DATE_TIME_FORMATTER);
        LocalDateTime endDateTime = LocalDateTime.now();

        long daysBetween = startDateTime.toLocalDate().until(endDateTime.toLocalDate()).getDays();
        LocalDate randomDate = startDateTime.toLocalDate().plusDays(RANDOM.nextInt((int)daysBetween + 1));

        return randomDate.format(DateTimeFormatter.ISO_LOCAL_DATE);
    }
}

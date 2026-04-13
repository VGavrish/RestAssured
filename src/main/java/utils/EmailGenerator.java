package utils;


import static utils.RandomUtils.RANDOM;

public class EmailGenerator {

    private static final int EMAIL_LENGTH = 15;

    public static String generateRandomEmail() {
        StringBuilder localPart = new StringBuilder(EMAIL_LENGTH);

        for (int i = 0; i < EMAIL_LENGTH; i++) {
            char randomChar = (char) ('a' + RANDOM.nextInt(26));
            localPart.append(randomChar);
        }

        return localPart.toString() + "@example.com";
    }
}
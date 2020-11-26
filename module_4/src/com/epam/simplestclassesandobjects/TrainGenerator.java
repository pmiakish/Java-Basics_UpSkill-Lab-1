package com.epam.simplestclassesandobjects;

import java.util.GregorianCalendar;

public class TrainGenerator {

    private static final String[] DESTINATIONS = {"Kukuevo", "Zhabinka", "Glubokoe", "Khoyniki", "Gibulichi"};
    private static final int START_HOUR = 0;
    private static final int LAST_HOUR = 23;
    private static final int START_MINUTE = 0;
    private static final int LAST_MINUTE = 59;

    public static Train[] generateTrainArray(int numberOfTrains) {
        Train[] trains = (numberOfTrains > 0) ? new Train[numberOfTrains] : null;
        for (int i = 0; i < numberOfTrains; i++) {
            GregorianCalendar departureTime = new GregorianCalendar();
            final int randomHour = generateRandomNumber(START_HOUR, LAST_HOUR);
            final int randomMinute = generateRandomNumber(START_MINUTE, LAST_MINUTE);
            departureTime.set(GregorianCalendar.HOUR_OF_DAY, randomHour);
            departureTime.set(GregorianCalendar.MINUTE, randomMinute);
            trains[i] = new Train(DESTINATIONS[generateRandomNumber(0, DESTINATIONS.length - 1)], (numberOfTrains - i),
                    departureTime);
        }
        return trains;
    }

    private static int generateRandomNumber(int minValue, int maxValue) {
        return (int) (Math.random() * (maxValue - minValue + 1) + minValue);
    }

}

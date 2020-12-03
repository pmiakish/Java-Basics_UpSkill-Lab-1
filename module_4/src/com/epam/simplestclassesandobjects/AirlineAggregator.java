package com.epam.simplestclassesandobjects;

import java.time.LocalTime;

public class AirlineAggregator {

    private static final String[] DESTINATIONS = {"MSQ", "BQT", "VTB", "GME", "GNA", "MVQ"};
    private static final String[] AIRPLANE_TYPES = {"passenger", "cargo"};
    private static final String[] DAYS_OF_WEEK = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
    private static final int MAX_HOUR = 23;
    private static final int MAX_MINUTE = 59;
    private static final int MIN_FLIGHT_NUMBER = 1000;
    private static final int MAX_FLIGHT_NUMBER = 9999;

    public static Airline[] generateAirlineArray(int numberOfAirlines) {
        Airline[] airlines = (numberOfAirlines > 0) ? new Airline[numberOfAirlines] : null;
        for (int i = 0; i < numberOfAirlines; i++) {
            String randomDestination = DESTINATIONS[generateRandomNumber(0, DESTINATIONS.length - 1)];
            String randomAirplaneType = AIRPLANE_TYPES[generateRandomNumber(0, AIRPLANE_TYPES.length - 1)];
            String randomDayOfWeek = DAYS_OF_WEEK[generateRandomNumber(0, DAYS_OF_WEEK.length - 1)];
            LocalTime randomTime = LocalTime.of(generateRandomNumber(0, MAX_HOUR), generateRandomNumber(0, MAX_MINUTE));
            int randomFlightNumber = generateRandomNumber(MIN_FLIGHT_NUMBER, MAX_FLIGHT_NUMBER);

            try {
                airlines[i] = new Airline(randomDestination, randomAirplaneType, randomDayOfWeek, randomTime,
                        randomFlightNumber);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
                airlines = null;
                break;
            }
        }
        return airlines;
    }

    public static void printAirlines(Airline[] airlines) {
        for (Airline airline : airlines) {
            System.out.println(airline);
        }
    }

    public static void printAirlinesByDestination(Airline[] airlines, String specifiedDestination) {
        boolean areFlights = false;
        for (Airline airline : airlines) {
            if (airline.getDestination().equalsIgnoreCase(specifiedDestination)) {
                areFlights = true;
                System.out.println(airline);
            }
        }
        if (!areFlights) {
            System.out.println("There are no flights by specified destination!");
        }
    }

    public static void printAirlinesByDayOfWeek(Airline[] airlines, String specifiedDayOfWeek) {
        boolean areFlights = false;
        for (Airline airline : airlines) {
            if (airline.getDayOfWeek().equalsIgnoreCase(specifiedDayOfWeek)) {
                areFlights = true;
                System.out.println(airline);
            }
        }
        if (!areFlights) {
            System.out.println("There are no flights by specified day of the week!");
        }
    }

    public static void printAirlinesByDayOfWeek(Airline[] airlines, String specifiedDayOfWeek, LocalTime time) {
        boolean areFlights = false;
        for (Airline airline : airlines) {
            if (airline.getDayOfWeek().equalsIgnoreCase(specifiedDayOfWeek) &&
                    airline.getTimeOfDeparture().isAfter(time)) {
                areFlights = true;
                System.out.println(airline);
            }
        }
        if (!areFlights) {
            System.out.println("There are no flights by specified day of the week and time!");
        }
    }

    private static int generateRandomNumber(int minValue, int maxValue) {
        return (int) (Math.random() * (maxValue - minValue + 1) + minValue);
    }

}

package com.epam.simplestclassesandobjects.entity;

import java.time.LocalTime;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Airline {

    private final int id;
    private static int counterId = 1;
    private String destination;
    private String airplaneType;
    private String dayOfWeek;
    private LocalTime timeOfDeparture;
    private int flightNumber;


    public Airline(String destination, String airplaneType, String dayOfWeek, LocalTime timeOfDeparture,
                   int flightNumber) {
        if (isCorrectDestination(destination) &&
                (airplaneType.equalsIgnoreCase("passenger") || airplaneType.equalsIgnoreCase("cargo")) &&
                isCorrectDayOfWeek(dayOfWeek) &&
                timeOfDeparture != null &&
                flightNumber > 0) {
            id = counterId++;
            this.destination = destination;
            this.airplaneType = airplaneType;
            this.dayOfWeek = dayOfWeek;
            this.timeOfDeparture = timeOfDeparture;
            this.flightNumber = flightNumber;
        } else {
            throw new IllegalArgumentException("Wrong values of airline fields! The airline wasn't create!");
        }
    }

    public int getId() {
        return id;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) throws IllegalArgumentException {
        if (isCorrectDestination(destination)) {
            this.destination = destination;
        } else {
            throw new IllegalArgumentException("Incorrect destination! Can't change the field!");
        }
    }

    public String getAirplaneType() {
        return airplaneType;
    }

    public void setAirplaneType(String airplaneType) throws IllegalArgumentException {
        if (airplaneType.equalsIgnoreCase("passenger") || airplaneType.equalsIgnoreCase("cargo")) {
            this.airplaneType = airplaneType;
        } else {
            throw new IllegalArgumentException("Incorrect type of airplane! Can't change the field!");
        }
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) throws IllegalArgumentException {
        if (isCorrectDayOfWeek(dayOfWeek)) {
            this.dayOfWeek = dayOfWeek;
        } else {
            throw new IllegalArgumentException("Incorrect day of the week! Can't change the field!");
        }
    }

    public LocalTime getTimeOfDeparture() {
        return timeOfDeparture;
    }

    public void setTimeOfDeparture(LocalTime timeOfDeparture) throws IllegalArgumentException {
        if (timeOfDeparture != null) {
            this.timeOfDeparture = timeOfDeparture;
        } else {
            throw new IllegalArgumentException("Incorrect time of departure! Can't change the field!");
        }
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        if (flightNumber > 0) {
            this.flightNumber = flightNumber;
        } else {
            throw new IllegalArgumentException("Incorrect flight number! Can't change the field!");
        }
    }

    // checking of arguments

    private boolean isCorrectDestination(String destination) {
        Pattern destPattern = Pattern.compile("^[A-Z]{3}$");
        Matcher destMatcher = destPattern.matcher(destination);
        return destMatcher.matches();
    }
    private boolean isCorrectDayOfWeek(String day) {
        Pattern dayPattern = Pattern.compile("^(?:SUN|MON|TUE|WED|THU|FRI|SAT)$");
        Matcher dayMatcher = dayPattern.matcher(day);
        return dayMatcher.matches();
    }

    @Override
    public String toString() {
        return "Airline [" +
                "id: " + id +
                "; destination: " + destination +
                "; airplane type: " + airplaneType +
                "; day of the week: " + dayOfWeek +
                "; time of departure: " + timeOfDeparture +
                "; flight number: " + flightNumber +
                "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Airline other = (Airline) obj;
        return id == other.id &&
                flightNumber == other.flightNumber &&
                destination.equals(other.destination) &&
                airplaneType.equals(other.airplaneType) &&
                dayOfWeek.equals(other.dayOfWeek) &&
                timeOfDeparture.equals(other.timeOfDeparture);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, destination, airplaneType, dayOfWeek, timeOfDeparture, flightNumber);
    }

}


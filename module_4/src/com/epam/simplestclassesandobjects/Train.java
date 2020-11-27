package com.epam.simplestclassesandobjects;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Train implements Comparable<Train>{

    private final String destination;
    private final int trainNumber;
    private final GregorianCalendar departureTime;

    public Train(String destination, int trainNumber, GregorianCalendar departureTime) {
        this.destination = destination;
        this.trainNumber = trainNumber;
        this.departureTime = departureTime;
    }

    public String getDestination() {
        return destination;
    }

    public GregorianCalendar getDepartureTime() {
        return departureTime;
    }

    @Override
    public String toString() {
        SimpleDateFormat time = new SimpleDateFormat("HH:mm");
        return "Train [number: " + trainNumber + ", destination: " + destination + "; departure time: " +
                time.format(departureTime.getTime()) + "]";
    }

    @Override
    public int compareTo(Train train) {
        return Integer.compare(this.trainNumber, train.trainNumber);
    }

}

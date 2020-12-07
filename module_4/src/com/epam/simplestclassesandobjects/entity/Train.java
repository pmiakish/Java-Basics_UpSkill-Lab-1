package com.epam.simplestclassesandobjects.entity;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Objects;

public class Train {

    private String destination;
    private int trainNumber;
    private GregorianCalendar departureTime;

    public Train(String destination, int trainNumber, GregorianCalendar departureTime) {
        this.destination = destination;
        this.trainNumber = trainNumber;
        this.departureTime = departureTime;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setTrainNumber(int trainNumber) {
        this.trainNumber = trainNumber;
    }

    public void setDepartureTime(GregorianCalendar departureTime) {
        this.departureTime = departureTime;
    }

    public String getDestination() {
        return destination;
    }

    public int getTrainNumber() {
        return trainNumber;
    }

    public GregorianCalendar getDepartureTime() {
        return departureTime;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Train train = (Train) obj;
        return trainNumber == train.trainNumber &&
                destination.equals(train.destination) &&
                departureTime.equals(train.departureTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(destination, trainNumber, departureTime);
    }

    @Override
    public String toString() {
        SimpleDateFormat time = new SimpleDateFormat("HH:mm");
        return "Train [number: " + trainNumber + ", destination: " + destination + "; departure time: " +
                time.format(departureTime.getTime()) + "]";
    }

}

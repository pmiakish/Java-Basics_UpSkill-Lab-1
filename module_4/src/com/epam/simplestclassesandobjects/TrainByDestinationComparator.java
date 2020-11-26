package com.epam.simplestclassesandobjects;

import java.util.Comparator;

public class TrainByDestinationComparator implements Comparator<Train> {
    public int compare(Train train1, Train train2) {
        final int comparisonByDestination = train1.getDestination().compareTo(train2.getDestination());
        return (comparisonByDestination != 0) ? comparisonByDestination : train1.getDepartureTime().compareTo(train2.
                getDepartureTime());
    }

}

package com.epam.simplestclassesandobjects.service;

import com.epam.simplestclassesandobjects.entity.Train;

import java.util.Comparator;

public class TrainByNumberComparator implements Comparator<Train> {
    public int compare(Train train1, Train train2) {
        return Integer.compare(train1.getTrainNumber(), train2.getTrainNumber());
    }

}

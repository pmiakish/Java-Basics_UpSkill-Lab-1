package com.epam.simplestclassesandobjects;

import java.util.GregorianCalendar;

public class TrainWorker {

    public static void printTrains(Train[] trains) {
        for (Train train : trains) {
            System.out.println(train);
        }
    }

    public static void printTrainInfoByNumber(Train[] trains, int trainNumber) {
        boolean isTrainWithSpecifiedNumber = false;
        for (Train train : trains) {
            if (train.getTrainNumber() == trainNumber) {
                isTrainWithSpecifiedNumber = true;
                System.out.println(train);
                break;
            }
        }
        if (!isTrainWithSpecifiedNumber) {
            System.out.println("There are no trains with specified number!");
        }
    }

}

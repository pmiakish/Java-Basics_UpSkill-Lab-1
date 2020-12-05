package com.epam.simplestclassesandobjects;

import com.epam.simplestclassesandobjects.entity.*;
import com.epam.simplestclassesandobjects.service.*;

import java.time.LocalTime;
import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class TaskLauncher {

    // tasks 01, 02
    private static final double A_VALUE = -1.0;
    private static final double B_VALUE = 23.2;

    // task 03
    private static final int NUMBER_OF_STUDENTS = 10;
    private static final int NUMBER_OF_EXCELLENT_STUDENTS = 3;

    // task 04
    private static final int NUMBER_OF_TRAINS = 5;
    private static final int SPECIFIED_TRAIN_NUMBER = 3;

    // task 05
    private static final int START_COUNTER_VALUE = 10;
    private static final int END_COUNTER_VALUE = -5;

    // task 06
    private static final int HOUR = 18;
    private static final int MINUTE = 35;
    private static final int INCORRECT_MINUTE_VALUE = 61;
    private static final int SECOND = 57;
    private static final int ADDITIONAL_HOURS = -8;
    private static final int ADDITIONAL_MINUTES = 123;
    private static final int ADDITIONAL_SECONDS = -4951;
    private static final int CORRECTING_NUMBER = 3;

    // task 07
    private static final double[][] COORDINATES = {
            {2.0, 5.0},
            {4.5, -3.5},
            {-7.1, -2.8}
    };

    // task 08
    private static final String MIN_CHECKING_POSTFIX = "0050"; // last four digits of a card number
    private static final String MAX_CHECKING_POSTFIX = "4050";

    // task 09
    private static final String AUTHOR_NAME = "Sierra K.";
    private static final String PUBLISHER = "Pearson";
    private static final Year YEAR = Year.of(2007);

    // task 10
    private static final String DESTINATION = "MSQ";
    private static final String DAY_OF_WEEK = "FRI";
    private static final LocalTime TIME = LocalTime.of(12, 0);

    public static void main(String[] args) {

        // task 01
        System.out.println("--- TASK 01 ---");
        Test1 test1 = new Test1();
        test1.setA(A_VALUE);
        test1.setB(B_VALUE);
        System.out.println(test1);
        System.out.print("The sum of variables is: " + test1.sumOfVariables() + "\n");
        System.out.print("The max value of variables is: " + test1.findMaxValueOfVariables() + "\n");

        // task 02
        System.out.println("\n--- TASK 02 ---");
        Test2 test21 = new Test2();
        test21.setA(A_VALUE);
        test21.setB(B_VALUE);
        System.out.print("A-value of test21 is: " + test21.getA() + "\n");
        System.out.print("B-value of test21 is: " + test21.getB() + "\n");
        Test2 test22 = new Test2(A_VALUE);
        System.out.print("A-value of test22 is: " + test22.getA() + "\n");
        System.out.print("B-value of test22 is: " + test22.getB() + "\n");

        // task 03
        System.out.println("\n--- TASK 03 ---");
        System.out.println("Excellent students:");
        Student[] students = StudentAggregator.generateStudentArray(NUMBER_OF_STUDENTS, NUMBER_OF_EXCELLENT_STUDENTS);
        for (Student student : students) {
            if (student.isExcellentStudent()) {
                System.out.println(student);
            }
        }

        // task 04
        System.out.println("\n--- TASK 04 ---");
        Train[] trains = TrainAggregator.generateTrainArray(NUMBER_OF_TRAINS);
        System.out.println("Trains sorted by numbers:");
        Arrays.sort(trains, new TrainByNumberComparator());
        TrainAggregator.printTrains(trains);
        System.out.println("\nTrains sorted by destination (considering departure time):");
        Arrays.sort(trains, new TrainByDestinationComparator());
        TrainAggregator.printTrains(trains);
        System.out.println("\nInfo about the train with the specified number (" + SPECIFIED_TRAIN_NUMBER + "):");
        String trainInfo = TrainAggregator.findTrainInfoByNumber(trains, SPECIFIED_TRAIN_NUMBER);
        System.out.println(Objects.requireNonNullElse(trainInfo, "The train with specified number is not found!"));

        // task 05
        System.out.println("\n--- TASK 05 ---");
        Counter counter;
        Counter counterWithSpecifiedBoundaries;
        try {
            counter = new Counter();
            System.out.println("Incrementing of the counter initialized with default bounds:");
            for (int i = 0; i < 20; i++) {
                System.out.println(counter);
                counter.increaseCounter();
            }

            counterWithSpecifiedBoundaries = new Counter(START_COUNTER_VALUE, END_COUNTER_VALUE);
            System.out.println("\nDecrementing of the counter initialized with specified bounds:");
            for (int i = 0; i < 20; i++) {
                System.out.println(counterWithSpecifiedBoundaries);
                counterWithSpecifiedBoundaries.decreaseCounter();
            }
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }

        // task 06
        System.out.println("\n--- TASK 06 ---\nInitial time:");
        Time time = new Time(HOUR, MINUTE, SECOND);
        System.out.println(time + "\n");
        time.setTime(HOUR + CORRECTING_NUMBER, MINUTE + CORRECTING_NUMBER, SECOND + CORRECTING_NUMBER);
        System.out.println("Time after total correction:\n" + time + "\n");
        time.setHour(HOUR);
        System.out.println("Time after correction only hours:\n" + time + "\n");
        time.setMinute(INCORRECT_MINUTE_VALUE);
        System.out.println("Time after correction only minutes:\n" + time + "\n");
        time.setSecond(SECOND);
        System.out.println("Time after correction only seconds:\n" + time + "\n");
        time.changeSecond(ADDITIONAL_SECONDS);
        System.out.println("Time after addition of " + ADDITIONAL_SECONDS + " seconds:\n" + time + "\n");
        time.changeMinute(ADDITIONAL_MINUTES);
        System.out.println("Time after addition of " + ADDITIONAL_MINUTES + " minutes:\n" + time + "\n");
        time.changeHour(ADDITIONAL_HOURS);
        System.out.println("Time after addition of " + ADDITIONAL_HOURS + " hours:\n" + time + "\n");

        // task 07
        System.out.println("--- TASK 07 ---");
        try {
            Triangle triangle = new Triangle(COORDINATES);
            System.out.println(triangle);
            System.out.println("The perimeter of the specified triangle is " + triangle.calculatePerimeter());
            System.out.println("The area of the specified triangle is " + triangle.calculateArea());
            System.out.println("The centroid coordinates of the triangle are " + Arrays.toString(triangle.
                    findCentroidLocation()));
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }

        // task 08
        System.out.println("\n--- TASK 08 ---");
        Customer[] customers = CustomerAggregator.generateCustomerArray(5);
        if (customers != null) {
            System.out.println("The unsorted array of customers:");
            CustomerAggregator.printCustomers(customers);
            Arrays.sort(customers);
            System.out.println("\nThe array of customers sorted by names:");
            CustomerAggregator.printCustomers(customers);

            System.out.println("\nThe customers which have cards with postfixes from '" + MIN_CHECKING_POSTFIX +
                    "' to '" + MAX_CHECKING_POSTFIX + "':");
            try {
                ArrayList<Customer> customersWithSpecifiedCardNumberPostfix = CustomerAggregator.
                        findCustomersWithSpecifiedCardNumberPostfix(customers, MIN_CHECKING_POSTFIX,
                        MAX_CHECKING_POSTFIX);
                if (customersWithSpecifiedCardNumberPostfix.size() != 0) {
                    System.out.println(customersWithSpecifiedCardNumberPostfix.toString());
                } else {
                    System.out.println("There are no customers which have the card number with specified postfix!");
                }


            } catch (NumberFormatException ex) {
                System.out.println("Incorrect postfix values!");
            }
        } else {
            System.out.println("Can't generate a customer array.");
        }

        // task 09
        System.out.println("\n--- TASK 09 ---");
        Book[] books = BookAggregator.generateBookArray(10);
        if (books != null) {

            System.out.println("The array of books:");
            BookAggregator.printBooks(books);

            System.out.println("\nThe books by the author - " + AUTHOR_NAME + ":");
            ArrayList<Book> booksByAuthor = BookAggregator.findBooksByAuthor(books, AUTHOR_NAME);
            if (booksByAuthor.size() != 0) {
                System.out.println(booksByAuthor.toString());
            } else {
                System.out.println("There are no books by specified author name!");
            }

            System.out.println("\nThe books by the publisher - " + PUBLISHER + ":");
            ArrayList<Book> booksByPublisher = BookAggregator.findBooksByPublisher(books, PUBLISHER);
            if (booksByPublisher.size() != 0) {
                System.out.println(booksByPublisher.toString());
            } else {
                System.out.println("There are no books by specified publisher!");
            }

            System.out.println("\nThe books published after " + YEAR + ":");
            ArrayList<Book> booksPublishedAfterSpecifiedYear = BookAggregator.
                    findBooksPublishedAfterSpecifiedYear(books, YEAR);
            if (booksPublishedAfterSpecifiedYear.size() != 0) {
                System.out.println(booksPublishedAfterSpecifiedYear.toString());
            } else {
                System.out.println("There are no books publishing after specified year!");
            }

        } else {
            System.out.println("Can't generate a book array.");
        }

        // task 10
        System.out.println("\n--- TASK 10 ---");
        Airline[] airlines = AirlineAggregator.generateAirlineArray(10);
        if (airlines != null) {

            System.out.println("The array of airlines:");
            AirlineAggregator.printAirlines(airlines);

            System.out.println("\nThe flights by the destination - " + DESTINATION + ":");
            ArrayList<Airline> airlinesByDestination = AirlineAggregator.findAirlinesByDestination(airlines,
                    DESTINATION);
            if (airlinesByDestination.size() != 0) {
                System.out.println(airlinesByDestination.toString());
            } else {
                System.out.println("The flights are not found!");
            }

            System.out.println("\nThe flights by the day of the week - " + DAY_OF_WEEK + ":");
            ArrayList<Airline> airlinesByDayOfWeek = AirlineAggregator.findAirlinesByDayOfWeek(airlines,
                    DAY_OF_WEEK);
            if (airlinesByDayOfWeek.size() != 0) {
                System.out.println(airlinesByDayOfWeek.toString());
            } else {
                System.out.println("The flights are not found!");
            }

            System.out.println("\nThe flights by the day of the week - " + DAY_OF_WEEK + ", after " + TIME + ":");
            ArrayList<Airline> airlinesByDayOfWeekAndTime = AirlineAggregator.findAirlinesByDayOfWeek(airlines,
                    DAY_OF_WEEK, TIME);
            if (airlinesByDayOfWeekAndTime.size() != 0) {
                System.out.println(airlinesByDayOfWeekAndTime.toString());
            } else {
                System.out.println("The flights are not found!");
            }

        } else {
            System.out.println("Can't generate an airline array.");
        }

    }
}

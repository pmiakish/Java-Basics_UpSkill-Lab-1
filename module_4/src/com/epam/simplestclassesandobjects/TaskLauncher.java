package com.epam.simplestclassesandobjects;

import java.util.Arrays;

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
        Student[] students = StudentGenerator.generateStudentArray(NUMBER_OF_STUDENTS, NUMBER_OF_EXCELLENT_STUDENTS);
        for (Student student : students) {
            if (student.isExcellentStudent()) {
                System.out.println(student);
            }
        }

        // task 04
        System.out.println("\n--- TASK 04 ---");
        Train[] trains = TrainGenerator.generateTrainArray(NUMBER_OF_TRAINS);
        System.out.println("Trains sorted by numbers:");
        Arrays.sort(trains, new TrainByNumberComparator());
        TrainWorker.printTrains(trains);
        System.out.println("\nTrains sorted by destination (considering departure time):");
        Arrays.sort(trains, new TrainByDestinationComparator());
        TrainWorker.printTrains(trains);
        System.out.println("\nInfo about the train with the specified number (" + SPECIFIED_TRAIN_NUMBER + "):");
        TrainWorker.printTrainInfoByNumber(trains, SPECIFIED_TRAIN_NUMBER);

        // task 05
        System.out.println("\n--- TASK 05 ---");
        Counter counter;
        try {
            counter = new Counter();
            System.out.println("Incrementing of the counter initialized with default bounds:");
            for (int i = 0; i < 20; i++) {
                System.out.println(counter);
                counter.increaseCounter();
            }
        } catch (IllegalAccessException ex) {
            System.out.println(ex.getMessage());
        }
        Counter counterWithSpecifiedBoundaries;
        try {
             counterWithSpecifiedBoundaries = new Counter(START_COUNTER_VALUE, END_COUNTER_VALUE);
             System.out.println("\nDecrementing of the counter initialized with specified bounds:");
            for (int i = 0; i < 20; i++) {
                System.out.println(counterWithSpecifiedBoundaries);
                counterWithSpecifiedBoundaries.decreaseCounter();
            }
        } catch (IllegalAccessException ex) {
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
            Arrays.sort(customers, new CustomerByNameComparator());
            System.out.println("\nThe array of customers sorted by names:");
            CustomerAggregator.printCustomers(customers);
            System.out.println("\nThe customers which have cards with postfixes from '" + MIN_CHECKING_POSTFIX + "' to " +
                    "'" + MAX_CHECKING_POSTFIX + "':");
            try {
                CustomerAggregator.printCustomersWithSpecifiedCardNumberPostfix(customers, MIN_CHECKING_POSTFIX,
                        MAX_CHECKING_POSTFIX);
            } catch (NumberFormatException ex) {
                System.out.println("Incorrect postfix values!");
            }
        } else {
            System.out.println("Can't generate a customer array.");
        }

    }
}

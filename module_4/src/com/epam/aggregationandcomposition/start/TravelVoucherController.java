package com.epam.aggregationandcomposition.start;

import com.epam.aggregationandcomposition.entity.travelvoucher.*;
import com.epam.aggregationandcomposition.exceptions.TourLogicalException;
import com.epam.aggregationandcomposition.exceptions.TravelVoucherLogicalException;
import com.epam.aggregationandcomposition.service.RandomNumberGenerator;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TravelVoucherController {

    private static final String[][] LOCATIONS = {
        {"Odessa", "Berlin", "Bruges", "Florence", "Prague", "Santorini", "Venice", "Budapest", "Kyiv", "Istanbul"},
        {"1005", "1110", "1665", "1634", "993", "2250", "1439", "930", "432", "1437"}, // distance
        {"85.5", "186.2", "115.55", "123.6", "105.0", "150.2", "113.85", "131.1", "97.9", "116.35"} // price per day
    };
    private static final double[] PRICE_CORRECTION_COEFFICIENTS_DEPENDING_ON_TOUR_TYPE = {
            1.1, // shopping
            1.2, // treatment
            1.3, // excursion
            1.4, // cruise
            1.5  // resort
    };
    private static final int NUMBER_OF_TOURS_OF_EACH_TYPE = 3;
    private static final int MIN_NUMBER_OF_DAYS = 5;
    private static final int MAX_NUMBER_OF_DAYS = 14;
    private static final int NUMBER_OF_DAYS_FOR_FILTER = 10;

    public static void main(String[] args) {
        try {
            List<Tour> tours = new ArrayList<>();
            Meal[] meals = Meal.values();
            for (int i = 0; i < NUMBER_OF_TOURS_OF_EACH_TYPE; i++) {
                int j = RandomNumberGenerator.generate(0, LOCATIONS[0].length - 1);
                tours.add(new Shopping(LOCATIONS[0][j], Integer.parseInt(LOCATIONS[1][j]),
                        new BigDecimal(LOCATIONS[2][j]).multiply(BigDecimal.
                        valueOf(PRICE_CORRECTION_COEFFICIENTS_DEPENDING_ON_TOUR_TYPE[0])),
                        meals[RandomNumberGenerator.generate(0, meals.length - 1)]));
            }
            for (int i = 0; i < NUMBER_OF_TOURS_OF_EACH_TYPE; i++) {
                int j = RandomNumberGenerator.generate(0, LOCATIONS[0].length - 1);
                tours.add(new Treatment(LOCATIONS[0][j], Integer.parseInt(LOCATIONS[1][j]),
                        new BigDecimal(LOCATIONS[2][j]).multiply(BigDecimal.
                                valueOf(PRICE_CORRECTION_COEFFICIENTS_DEPENDING_ON_TOUR_TYPE[1])),
                        meals[RandomNumberGenerator.generate(0, meals.length - 1)]));
            }
            for (int i = 0; i < NUMBER_OF_TOURS_OF_EACH_TYPE; i++) {
                int j = RandomNumberGenerator.generate(0, LOCATIONS[0].length - 1);
                tours.add(new Excursion(LOCATIONS[0][j], Integer.parseInt(LOCATIONS[1][j]),
                        new BigDecimal(LOCATIONS[2][j]).multiply(BigDecimal.
                                valueOf(PRICE_CORRECTION_COEFFICIENTS_DEPENDING_ON_TOUR_TYPE[2])),
                        meals[RandomNumberGenerator.generate(0, meals.length - 1)]));
            }
            for (int i = 0; i < NUMBER_OF_TOURS_OF_EACH_TYPE; i++) {
                int j = RandomNumberGenerator.generate(0, LOCATIONS[0].length - 1);
                tours.add(new Cruise(LOCATIONS[0][j], Integer.parseInt(LOCATIONS[1][j]),
                        new BigDecimal(LOCATIONS[2][j]).multiply(BigDecimal.
                                valueOf(PRICE_CORRECTION_COEFFICIENTS_DEPENDING_ON_TOUR_TYPE[3])),
                        meals[RandomNumberGenerator.generate(0, meals.length - 1)]));
            }
            for (int i = 0; i < NUMBER_OF_TOURS_OF_EACH_TYPE; i++) {
                int j = RandomNumberGenerator.generate(0, LOCATIONS[0].length - 1);
                tours.add(new Resort(LOCATIONS[0][j], Integer.parseInt(LOCATIONS[1][j]),
                        new BigDecimal(LOCATIONS[2][j]).multiply(BigDecimal.
                                valueOf(PRICE_CORRECTION_COEFFICIENTS_DEPENDING_ON_TOUR_TYPE[4])),
                        meals[RandomNumberGenerator.generate(0, meals.length - 1)]));
            }

            List<TravelVoucher> travelVouchers = new ArrayList<>();
            Transport[] transport = Transport.values();
            for (Tour tour : tours) {
                travelVouchers.add(new TravelVoucher(tour, RandomNumberGenerator.generate(MIN_NUMBER_OF_DAYS,
                        MAX_NUMBER_OF_DAYS), transport[RandomNumberGenerator.generate(0, transport.length - 1)]));
            }
            System.out.println("\n--------\nGenerated travel vouchers:\n");
            travelVouchers.forEach(System.out::println);

            System.out.println("\n--------\nSorting of travel vouchers by price:\n");
            travelVouchers.sort(Comparator.comparing(TravelVoucher::calculateTotalPrice));
            travelVouchers.forEach(System.out::println);

            System.out.println("\n--------\nSorting of travel vouchers by destination:\n");
            travelVouchers.sort(Comparator.comparing(travelVoucher -> travelVoucher.getTour().getLocation()));
            travelVouchers.forEach(System.out::println);

            System.out.println("\n--------\nSearching for travel vouchers with transport type 'airplane':\n");
            travelVouchers.stream().filter(travelVoucher -> travelVoucher.getTransport().equals(Transport.AIRPLANE)).
                    forEachOrdered(System.out::println);

            System.out.println("\n--------\nSearching for travel vouchers with the number of days greater than " +
                    NUMBER_OF_DAYS_FOR_FILTER + ":\n");
            travelVouchers.stream().filter(travelVoucher -> travelVoucher.getNumberOfDays() >
                    NUMBER_OF_DAYS_FOR_FILTER).forEachOrdered(System.out::println);

            System.out.println("\n--------\nChanging the parameters (transport type, meals) of travel vouchers from " +
                    "previous searching result:\n");
            travelVouchers.stream()
                    .filter(travelVoucher -> travelVoucher.getNumberOfDays() > NUMBER_OF_DAYS_FOR_FILTER)
                    .forEach(travelVoucher -> {
                        try {
                            travelVoucher.setTransport(Transport.TRAIN);
                            travelVoucher.getTour().setIncludedMeals(Meal.ALL_INCLUSIVE);
                            System.out.println(travelVoucher);
                        } catch (TravelVoucherLogicalException | TourLogicalException e) {
                            e.printStackTrace();
                        }
                    });

        } catch (TourLogicalException | TravelVoucherLogicalException | NumberFormatException e) {
            e.printStackTrace();
        }


    }
}

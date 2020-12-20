package com.epam.aggregationandcomposition.util.init.travelvoucher;

import com.epam.aggregationandcomposition.entity.travelvoucher.*;
import com.epam.aggregationandcomposition.exceptions.TourLogicalException;
import com.epam.aggregationandcomposition.exceptions.TravelVoucherLogicalException;
import com.epam.aggregationandcomposition.util.init.RandomNumberGenerator;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TravelInitializer {

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
    private static final int MIN_NUMBER_OF_DAYS = 5;
    private static final int MAX_NUMBER_OF_DAYS = 14;
    private static final int MIN_LENGTH_OF_ROUTE = 300;
    private static final int MAX_LENGTH_OF_ROUTE = 1000;
    private static final int MIN_HOTEL_RATING = 1;
    private static final int MAX_HOTEL_RATING = 5;
    private static final int MIN_NUMBER_OF_STORES = 5;
    private static final int MAX_NUMBER_OF_STORES = 20;
    private static final int MIN_NUMBER_OF_MEDICAL_PROCEDURES = 3;
    private static final int MAX_NUMBER_OF_MEDICAL_PROCEDURES = 8;

    public static List<TravelVoucher> generateTravelVouchers(int numberOfEachTypeTours) throws TourLogicalException,
            TravelVoucherLogicalException {
        List<TravelVoucher> travelVouchers;
        if (numberOfEachTypeTours > 0) {
            List<Tour> tours = new ArrayList<>();
            Meal[] meals = Meal.values();
            for (int i = 0; i < numberOfEachTypeTours; i++) {
                int j = RandomNumberGenerator.generate(0, LOCATIONS[0].length - 1);
                tours.add(new Shopping(LOCATIONS[0][j], Integer.parseInt(LOCATIONS[1][j]),
                        new BigDecimal(LOCATIONS[2][j]).multiply(BigDecimal.
                                valueOf(PRICE_CORRECTION_COEFFICIENTS_DEPENDING_ON_TOUR_TYPE[0])),
                        RandomNumberGenerator.generate(MIN_NUMBER_OF_STORES, MAX_NUMBER_OF_STORES),
                        meals[RandomNumberGenerator.generate(0, meals.length - 1)]));
            }
            for (int i = 0; i < numberOfEachTypeTours; i++) {
                int j = RandomNumberGenerator.generate(0, LOCATIONS[0].length - 1);
                tours.add(new Treatment(LOCATIONS[0][j], Integer.parseInt(LOCATIONS[1][j]),
                        new BigDecimal(LOCATIONS[2][j]).multiply(BigDecimal.
                                valueOf(PRICE_CORRECTION_COEFFICIENTS_DEPENDING_ON_TOUR_TYPE[1])),
                        RandomNumberGenerator.generate(MIN_NUMBER_OF_MEDICAL_PROCEDURES,
                                MAX_NUMBER_OF_MEDICAL_PROCEDURES),
                        meals[RandomNumberGenerator.generate(0, meals.length - 1)]));
            }
            for (int i = 0; i < numberOfEachTypeTours; i++) {
                int j = RandomNumberGenerator.generate(0, LOCATIONS[0].length - 1);
                tours.add(new Excursion(LOCATIONS[0][j], Integer.parseInt(LOCATIONS[1][j]),
                        new BigDecimal(LOCATIONS[2][j]).multiply(BigDecimal.
                                valueOf(PRICE_CORRECTION_COEFFICIENTS_DEPENDING_ON_TOUR_TYPE[2])),
                        (RandomNumberGenerator.generate(0, 1) == 0),
                        meals[RandomNumberGenerator.generate(0, meals.length - 1)]));
            }
            for (int i = 0; i < numberOfEachTypeTours; i++) {
                int j = RandomNumberGenerator.generate(0, LOCATIONS[0].length - 1);
                tours.add(new Cruise(LOCATIONS[0][j], Integer.parseInt(LOCATIONS[1][j]),
                        new BigDecimal(LOCATIONS[2][j]).multiply(BigDecimal.
                                valueOf(PRICE_CORRECTION_COEFFICIENTS_DEPENDING_ON_TOUR_TYPE[3])),
                        RandomNumberGenerator.generate(MIN_LENGTH_OF_ROUTE, MAX_LENGTH_OF_ROUTE),
                        meals[RandomNumberGenerator.generate(0, meals.length - 1)]));
            }
            for (int i = 0; i < numberOfEachTypeTours; i++) {
                int j = RandomNumberGenerator.generate(0, LOCATIONS[0].length - 1);
                tours.add(new Resort(LOCATIONS[0][j], Integer.parseInt(LOCATIONS[1][j]),
                        new BigDecimal(LOCATIONS[2][j]).multiply(BigDecimal.
                                valueOf(PRICE_CORRECTION_COEFFICIENTS_DEPENDING_ON_TOUR_TYPE[4])),
                        RandomNumberGenerator.generate(MIN_HOTEL_RATING, MAX_HOTEL_RATING),
                        meals[RandomNumberGenerator.generate(0, meals.length - 1)]));
            }

            travelVouchers = new ArrayList<>();
            Transport[] transport = Transport.values();
            for (Tour tour : tours) {
                travelVouchers.add(new TravelVoucher(tour, RandomNumberGenerator.generate(MIN_NUMBER_OF_DAYS,
                        MAX_NUMBER_OF_DAYS), transport[RandomNumberGenerator.generate(0, transport.length - 1)]));
            }
        } else {
            throw new TourLogicalException("Incorrect number of tours!");
        }
        return travelVouchers;
    }
}

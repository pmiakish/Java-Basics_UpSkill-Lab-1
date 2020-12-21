package com.epam.aggregationandcomposition.service.travelvoucher;

import com.epam.aggregationandcomposition.entity.travelvoucher.Meal;
import com.epam.aggregationandcomposition.entity.travelvoucher.Transport;
import com.epam.aggregationandcomposition.entity.travelvoucher.TravelVoucher;
import com.epam.aggregationandcomposition.exceptions.TourLogicalException;
import com.epam.aggregationandcomposition.exceptions.TravelVoucherLogicalException;
import com.epam.aggregationandcomposition.exceptions.TravelVoucherSystematizationException;
import com.epam.aggregationandcomposition.util.init.travelvoucher.TravelInitializer;
import java.util.List;

public class TravelVoucherController {

    private static final int NUMBER_OF_TOURS_OF_EACH_TYPE = 3;
    private static final int NUMBER_OF_DAYS_FOR_FILTER = 10;

    public static void main(String[] args) {
        try {
            List<TravelVoucher> travelVouchers = TravelInitializer.generateTravelVouchers(NUMBER_OF_TOURS_OF_EACH_TYPE);

            System.out.println("\n--------\nGenerated travel vouchers:\n");
            travelVouchers.forEach(System.out::println);

            System.out.println("\n--------\nSorting of travel vouchers by price:\n");
            TravelVoucherClassifier.sortByPrice(travelVouchers);
            travelVouchers.forEach(System.out::println);

            System.out.println("\n--------\nSorting of travel vouchers by location:\n");
            TravelVoucherClassifier.sortByLocation(travelVouchers);
            travelVouchers.forEach(System.out::println);

            System.out.println("\n--------\nSearching for travel vouchers with the number of days " +
                    NUMBER_OF_DAYS_FOR_FILTER + ":\n");
            List<TravelVoucher> travelVouchersByDuration = TravelVoucherClassifier.findByDuration(travelVouchers,
                    NUMBER_OF_DAYS_FOR_FILTER);
            if (travelVouchersByDuration.size() > 0) {
                travelVouchersByDuration.forEach(System.out::println);
            } else {
                System.out.println("Travel vouchers with specified number of days not found.");
            }

            System.out.println("\n--------\nSearching for travel vouchers with transport type " + Transport.AIRPLANE +
                    ":\n");
            List<TravelVoucher> travelVouchersByTransport = TravelVoucherClassifier.findByTransport(travelVouchers,
                    Transport.AIRPLANE);
            if (travelVouchersByTransport.size() > 0) {
                travelVouchersByTransport.forEach(System.out::println);
            } else {
                System.out.println("Travel vouchers with specified transport not found.");
            }

            System.out.println("\n--------\nChanging the parameters (transport type, meals) of travel vouchers from " +
                    "previous searching result:\n");
            travelVouchersByTransport.stream()
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

        } catch (TourLogicalException | TravelVoucherLogicalException | TravelVoucherSystematizationException |
                NumberFormatException e) {
            e.printStackTrace();
        }


    }
}

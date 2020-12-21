package com.epam.aggregationandcomposition.service.travelvoucher;

import com.epam.aggregationandcomposition.entity.travelvoucher.Transport;
import com.epam.aggregationandcomposition.entity.travelvoucher.TravelVoucher;
import com.epam.aggregationandcomposition.exceptions.TravelVoucherSystematizationException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TravelVoucherClassifier {

    public static void sortByPrice(List<TravelVoucher> unsortedTravelVouchers) throws
            TravelVoucherSystematizationException {
        if (unsortedTravelVouchers != null && unsortedTravelVouchers.size() != 0) {
            unsortedTravelVouchers.sort(Comparator.comparing(TravelVoucher::calculateTotalPrice));
        } else {
            throw new TravelVoucherSystematizationException("Incorrect parameter. Can't sort the travel vouchers!");
        }
    }

    public static void sortByLocation(List<TravelVoucher> unsortedTravelVouchers) throws
            TravelVoucherSystematizationException{
        if (unsortedTravelVouchers != null && unsortedTravelVouchers.size() != 0) {
            unsortedTravelVouchers.sort(Comparator.comparing(travelVoucher -> travelVoucher.getTour().getLocation()));
        } else {
            throw new TravelVoucherSystematizationException("Incorrect parameter. Can't sort the travel vouchers!");
        }
    }

    public static List<TravelVoucher> findByTransport(List<TravelVoucher> unsortedTravelVouchers, Transport transport)
            throws TravelVoucherSystematizationException {
        if (unsortedTravelVouchers != null && unsortedTravelVouchers.size() != 0 && transport != null) {
            return unsortedTravelVouchers.stream().filter(travelVoucher -> travelVoucher.getTransport().
                    equals(transport)).collect(Collectors.toList());
        } else {
            throw new TravelVoucherSystematizationException("Incorrect parameter. Can't find the travel vouchers!");
        }
    }

    public static List<TravelVoucher> findByDuration(List<TravelVoucher> unsortedTravelVouchers, int numberOfDays)
            throws TravelVoucherSystematizationException {
        if (unsortedTravelVouchers != null && unsortedTravelVouchers.size() != 0 && numberOfDays > 0) {
            return unsortedTravelVouchers.stream().filter(travelVoucher -> travelVoucher.getNumberOfDays() ==
                    numberOfDays).collect(Collectors.toList());
        } else {
            throw new TravelVoucherSystematizationException("Incorrect parameter. Can't find the travel vouchers!");
        }
    }

}

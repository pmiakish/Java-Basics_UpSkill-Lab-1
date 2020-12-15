package com.epam.aggregationandcomposition.entity.travelvoucher;

import com.epam.aggregationandcomposition.exceptions.TourLogicalException;

import java.math.BigDecimal;

public class Excursion extends Tour {
    public Excursion(String location, int distance, BigDecimal priceForOneDay) throws TourLogicalException {
        super(location, distance, priceForOneDay);
    }

    public Excursion(String location, int distance, BigDecimal priceForOneDay, Meal includedMeal) throws
            TourLogicalException {
        super(location, distance, priceForOneDay, includedMeal);
    }
}

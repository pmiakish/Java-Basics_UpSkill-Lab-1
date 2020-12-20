package com.epam.aggregationandcomposition.entity.travelvoucher;

import com.epam.aggregationandcomposition.exceptions.TourLogicalException;
import java.math.BigDecimal;
import java.util.Objects;

public class Resort extends Tour {

    private static final int MIN_RATING = 1;
    private static final int MAX_RATING = 5;

    private int hotelRating;

    public Resort(String location, int distance, BigDecimal priceForOneDay, int hotelRating) throws
            TourLogicalException {
        super(location, distance, priceForOneDay);
        if (hotelRating >= MIN_RATING && hotelRating <= MAX_RATING) {
            this.hotelRating = hotelRating;
        } else {
            throw new TourLogicalException("Incorrect hotel rating!");
        }
    }

    public Resort(String location, int distance, BigDecimal priceForOneDay, int hotelRating, Meal includedMeal)
            throws TourLogicalException {
        super(location, distance, priceForOneDay, includedMeal);
        if (hotelRating >= MIN_RATING && hotelRating <= MAX_RATING) {
            this.hotelRating = hotelRating;
        } else {
            throw new TourLogicalException("Incorrect hotel rating!");
        }
    }

    public int getHotelRating() {
        return hotelRating;
    }

    public void setHotelRating(int hotelRating) throws TourLogicalException{
        if (hotelRating >= MIN_RATING && hotelRating <= MAX_RATING) {
            this.hotelRating = hotelRating;
        } else {
            throw new TourLogicalException("Incorrect parameter! Can't change the hotel rating!");
        }
    }

    @Override
    public String toString() {
        return  "(type: " + getClass().getSimpleName() +
                "; location: " + location +
                "; distance to destination: " + distance + " km" +
                "; price per day (depending on meals): " + pricePerDayDependingOnMeals +
                "; included meals: " + includedMeal +
                "; hotel rating: " + hotelRating +
                ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resort other = (Resort) o;
        return distance == other.distance &&
                Objects.equals(location, other.location) &&
                Objects.equals(pricePerDay, other.pricePerDay) &&
                Objects.equals(pricePerDayDependingOnMeals, other.pricePerDayDependingOnMeals) &&
                includedMeal == other.includedMeal &&
                hotelRating == other.hotelRating;
    }

    @Override
    public int hashCode() {
        return Objects.hash(location, distance, pricePerDay, pricePerDayDependingOnMeals, includedMeal, hotelRating);
    }
}

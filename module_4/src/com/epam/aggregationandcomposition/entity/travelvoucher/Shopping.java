package com.epam.aggregationandcomposition.entity.travelvoucher;

import com.epam.aggregationandcomposition.exceptions.TourLogicalException;
import java.math.BigDecimal;
import java.util.Objects;

public class Shopping extends Tour {

    private int numberOfStores;

    public Shopping(String location, int distance, BigDecimal priceForOneDay, int numberOfStores) throws
            TourLogicalException {
        super(location, distance, priceForOneDay);
        if (numberOfStores > 0) {
            this.numberOfStores = numberOfStores;
        } else {
            throw new TourLogicalException("Incorrect number of stores!");
        }
    }

    public Shopping(String location, int distance, BigDecimal priceForOneDay, int numberOfStores, Meal includedMeal)
            throws TourLogicalException {
        super(location, distance, priceForOneDay, includedMeal);
        if (numberOfStores > 0) {
            this.numberOfStores = numberOfStores;
        } else {
            throw new TourLogicalException("Incorrect number of stores!");
        }
    }

    public int getNumberOfStores() {
        return numberOfStores;
    }

    public void setNumberOfStores(int numberOfStores) throws TourLogicalException{
        if (numberOfStores > 0) {
            this.numberOfStores = numberOfStores;
        } else {
            throw new TourLogicalException("Incorrect parameter! Can't change the number of stores!");
        }
    }

    @Override
    public String toString() {
        return  "(type: " + getClass().getSimpleName() +
                "; location: " + location +
                "; distance to destination: " + distance + " km" +
                "; price per day (depending on meals): " + pricePerDayDependingOnMeals +
                "; included meals: " + includedMeal +
                "; number of stores: " + numberOfStores +
                ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shopping other = (Shopping) o;
        return distance == other.distance &&
                Objects.equals(location, other.location) &&
                Objects.equals(pricePerDay, other.pricePerDay) &&
                Objects.equals(pricePerDayDependingOnMeals, other.pricePerDayDependingOnMeals) &&
                includedMeal == other.includedMeal &&
                numberOfStores == other.numberOfStores;
    }

    @Override
    public int hashCode() {
        return Objects.hash(location, distance, pricePerDay, pricePerDayDependingOnMeals, includedMeal, numberOfStores);
    }
}
